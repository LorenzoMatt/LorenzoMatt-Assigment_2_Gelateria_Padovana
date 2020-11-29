////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillClass implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
            throws TakeAwayBillException {
        double total=0;
        if(itemsOrdered == null) {
            throw new TakeAwayBillException("La lista inserita è nulla."); 
        }
        if(itemsOrdered.contains(null)) {
          throw new TakeAwayBillException("La lista contiene elementi nulli"); 
        }
        
        for(MenuItem item:itemsOrdered)
            {
            total+=item.getPrice();
            }
        return total;
        }
}
