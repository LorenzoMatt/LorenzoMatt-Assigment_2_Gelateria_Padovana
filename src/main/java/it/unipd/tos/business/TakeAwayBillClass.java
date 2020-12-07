////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillClass implements TakeAwayBill {
    private Orario orario;
    private static boolean b=false;
    public static int count=0;
    private static Map<Integer, Integer> utentiRegaloMap=new HashMap<>();
    public TakeAwayBillClass(Orario orario) {
        this.orario=new Orario(orario);
    }
    public static void reset() {// resetta i campi statici 
        TakeAwayBillClass.count=0;
        TakeAwayBillClass.b=false;
    }
    public void setOre(int i) {
        orario.setOre(i);
    }
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
            throws TakeAwayBillException {
        double total=0;
        int gelati=0;
        double gelati_budini=0; // 
        if(itemsOrdered == null) {
            throw new TakeAwayBillException("La lista inserita è nulla."); 
        }
        if(itemsOrdered.contains(null)) {
          throw new TakeAwayBillException("La lista contiene elementi nulli"); 
        }
        max30ordini(itemsOrdered.size());
        
        for(MenuItem item:itemsOrdered){
            total+=item.getPrice();
            if(item.getItemType()==ItemType.Gelati)
            {
                gelati++;
                gelati_budini+=item.getPrice();
            }
            if (item.getItemType()==ItemType.Budini) {
                gelati_budini+=item.getPrice();
            }
        }
        total=scontogelati(gelati,total,itemsOrdered);
        total=scontogelati_budini(gelati_budini,total);
        return regaloMinorenni(commissioni(total),user,orario);
    }
/*
 * controlla se i requisiti sono soddisfatti e se lo sono allora un minorenne ogni 2 riceve 
 * un ordine in regalo, con un limite di 10 ordini regalati
 */
    private double regaloMinorenni(double totale,User user,Orario orario) {
        if(user.getanni()<=18 && OrarioBuonoOrario(orario)) {
            if(count<=10 && b  &&  !(utentiRegaloMap.containsKey(user.getid()))) // utenti che hanno già avuto un ordine in regalo non lo avranno una seconda volta
            {
           utentiRegaloMap.put(user.getid(), 0); //aggiunto utente che ha ottenuto il regalo
           count++;
           totale=0;
        }
        b=!b;
        }
        return totale;
    }
    private boolean OrarioBuonoOrario(Orario orario) {
        return orario.getOre()==18;
    }
    private double commissioni(double total) {
        return total + ((total>=10.0D) ? 0 : 0.5D);
    }

    private double scontogelati_budini(double gelati_budini,double total) {
        if(gelati_budini>50.0D)
        {
            total-=(gelati_budini*0.1);
        }
        return total;
    }


    private double scontogelati(int gelati,double total, List<MenuItem> itemsOrdered){
        if(gelati>=5)
        {
            double min=Integer.MAX_VALUE;
            for(MenuItem item:itemsOrdered) {
                if(item.getItemType()==ItemType.Gelati) {
                min=item.getPrice()<min ? item.getPrice():min;
                }
            }
            total-=(min/2);
        }
        return total;
    }
    private Throwable max30ordini(int size) throws TakeAwayBillException {
        if(size>30)
        {
             throw new TakeAwayBillException("numero di ordini consentito di 30 è stato superato");
        }
        return null;
    }
}

