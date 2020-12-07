////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.*;


import org.junit.Test;

public class OrarioTest {
    private static Orario Orario;
    @Test
    public void testOrarioNonValidoNumeriPositivi() {
        Orario=new Orario(33, 70, 80);
        assertEquals(0, Orario.getOre());
        assertEquals(0, Orario.getMinuti());
        assertEquals(0, Orario.getSecondi());
    }
    @Test
    public void testOrarioNonValidoNumeriNegativi() {
        Orario=new Orario(-1, -8, -80);
        assertEquals(0, Orario.getOre());
        assertEquals(0, Orario.getMinuti());
        assertEquals(0, Orario.getSecondi());
    }
    @Test
    public void testOrarioValido() {
        Orario=new Orario(23, 59, 59);
        assertEquals(23, Orario.getOre());
        assertEquals(59, Orario.getMinuti());
        assertEquals(59, Orario.getSecondi());
    }
    @Test
    public void testSetOre() {
        Orario.setOre(22);
        assertEquals(22, 22);
        Orario.setOre(-1);
        assertEquals(0, 0);
        Orario.setOre(38);
        assertEquals(0, 0);
    }
}
