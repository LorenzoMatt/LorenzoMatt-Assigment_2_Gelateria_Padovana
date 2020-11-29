////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.ArrayList;
import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillClass implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
            throws TakeAwayBillException {
        double total=0;
        int gelati=0;
        double gelati_budini=0;
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
        return total;
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

