////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.builders.NullBuilder;

public class TakeAwayBillClassTest {
    private static TakeAwayBillClass takeAwayBillClass;
    private static double price;
    

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        takeAwayBillClass=new TakeAwayBillClass();
        price=0.0D;
    }
    @Test
    public void testTotal() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        for(int i=0;i<4;i++)
            itemsOrdered.add(new MenuItem(ItemType.Bevande,"Birra",2.50));
            assertEquals(10.0, takeAwayBillClass.getOrderPrice(itemsOrdered,null),0);

    }
    @Test(expected = TakeAwayBillException.class) 
    public void testCalcoloDelTotaleConListaNonInizializzata() throws TakeAwayBillException {
        price=takeAwayBillClass.getOrderPrice(null,new User(1,18)); 
    }

    @Test(expected = TakeAwayBillException.class)    
    public void testListaConValoriNulli() throws TakeAwayBillException{
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>(); 
        itemsOrdered.add(new MenuItem(ItemType.Gelati, "pistacchio", 2.5D));
        itemsOrdered.add(null);
        price=takeAwayBillClass.getOrderPrice(itemsOrdered,new User(1, 19));
        
    }
}
