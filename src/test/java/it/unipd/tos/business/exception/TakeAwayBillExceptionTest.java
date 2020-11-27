////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TakeAwayBillExceptionTest {

    private static TakeAwayBillException takeAwayBillException;

    @BeforeClass
    public static void beforeClass() {
        takeAwayBillException = new TakeAwayBillException("test");
    }

    @Test
    public void testGetMessage() {
        assertEquals("test", takeAwayBillException.getMessage());
    }

}