package junitTestTeam13;

import adtarray.ADTArray;

import static adtarray.ADTArray.initA;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ADTArrayTest {

    public ADTArrayTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of initA method, of class ADTArray.
     */
    @Test
    public void testInitA() {
        System.out.println("initA");
        // initA() -> [ ]
        ADTArray ae = initA();
        assertEquals("[]", ae.toString());
    }

    /**
     * Test of setA method, of class ADTArray.
     */
    @Test
    public void testSetA() {
        System.out.println("setA");
        // [ ].setA(0,1)    ->  [1]
        ADTArray a_sta_e = initA();
        ADTArray a_sta_1 = initA().setA(0, 1);
        assertEquals("[1]", a_sta_e.setA(0, 1).toString());
        // [ ].setA(5,1)   ->  [0,0,0,0,0,1]
        a_sta_e = initA();
        assertEquals("[0,0,0,0,0,1]", a_sta_e.setA(5, 1).toString());
        // [3].setA(5,1)   ->  [3,0,0,0,0,1]    ZUSATZ
        ADTArray a_sta_3 = initA().setA(0, 3);
        assertEquals("[3,0,0,0,0,1]", a_sta_3.setA(5, 1).toString());
        // [1,2,3].setA(1,5) ->  [1,5,3]
        ADTArray a_sta_123 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        ADTArray a_sta_153 = initA().setA(0, 1).setA(1, 5).setA(2, 3);
        assertEquals(a_sta_153.toString(), a_sta_123.setA(1, 5).toString());
        // [1,2,3].setA(-1,5)   ->  [1,2,3]
        a_sta_123 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        assertEquals(a_sta_123, a_sta_123.setA(-1, 5));
        // [1,2,3].setA(0,3.25) ->  [1,2,3]
        a_sta_123 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        //assertEquals(a_sta_123.toString(), a_sta_123.setA(0, 3.25));
        //!!!!!!!!!!!!!!!!decimal geht nicht - kann ja auch nicht gehen
    }

    /**
     * Test of getA method, of class ADTArray.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        // [ ].getA(0)    ->  -1
        ADTArray a_gta_e = initA();
        assertEquals(-1, a_gta_e.getA(0));
        // [1,2,3].getA(-1)   ->  -1
        ADTArray a_gta_123 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        assertEquals(-1, a_gta_123.getA(-1));
        // [1,2,3].getA(5)   ->  -1 ZUSAETZLICH
        a_gta_123 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        assertEquals(-1, a_gta_123.getA(5));
        // [1,2,3].getA(0)   ->  1
        a_gta_123 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        assertEquals(1, a_gta_123.getA(0));
        // [1,2,3].getA(1)   ->  2 ZUSAETZLICH
        a_gta_123 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        assertEquals(2, a_gta_123.getA(1));
    }

    /**
     * Test of lengthA method, of class ADTArray.
     */
    @Test
    public void testLengthA() {
        System.out.println("lengthA");
        // [ ].lengthA()   ->  -1
        ADTArray a_lna_e = initA();
        assertEquals(-1, a_lna_e.lengthA());
        // [1,2,3].lengthA()   ->  3
        ADTArray a_lna_123 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        assertEquals(3, a_lna_123.lengthA());
    }
}
