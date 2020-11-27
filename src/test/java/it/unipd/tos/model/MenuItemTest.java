////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class MenuItemTest {

    private static MenuItem menuItem;

    @BeforeClass
    public static void beforeClass() {
        menuItem = new MenuItem(ItemType.Budini, "Biancaneve", 2.50);
    }

    @Test
    public void testGetItemType() {
        assertEquals(ItemType.Budini, menuItem.getItemType());
    }

    @Test
    public void testGetName() {
        assertEquals("Biancaneve", menuItem.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(2.50, menuItem.getPrice(), 0);
    }

}