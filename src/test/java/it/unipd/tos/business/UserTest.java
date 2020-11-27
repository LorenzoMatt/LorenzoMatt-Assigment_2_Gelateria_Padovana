package it.unipd.tos.business;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
    private static User user;
    
    @BeforeClass
    public static void beforeClass() {
        user= new User(1,19);
    }
    

    @Test
    public void testGetId() {
        assertEquals(1,user.getid());
    }
    @Test
    public void testGetAnni() {
        assertEquals(19, user.getanni());
    }

}
