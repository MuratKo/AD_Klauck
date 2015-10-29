/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTestTeam08;
import static adtarray.ADTArray.*;
import adtarray.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

/**
 *
 * @author Jerom
 */
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
        ADTArray expResult = initA();
        ADTArray result = initA();
        assertEquals(expResult, result);
    }

    /**
     * Test of setA method, of class ADTArray.
     */
    @Test
    public void testSetA() {
        System.out.println("setA");
        ADTArray instance = initA();
        ADTArray expResult = initA().setA(0, 1);
        ADTArray result = instance.setA(0, 1);
        assertEquals(expResult, result);
        
        ADTArray instance2 = initA();
        ADTArray expResult2 = initA().setA(0, 0).setA(1, 0).setA(2, 0).setA(3, 0).setA(4, 0).setA(5, 1);
        ADTArray result2 = instance2.setA(5, 1);
        assertEquals(expResult2, result2);
        
        ADTArray instance3 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
//        System.out.println("instance"+Arrays.toString(instance3.getValues().getElems()));
        ADTArray expResult3 = initA().setA(0, 1).setA(1, 5).setA(2, 3);
//        System.out.println("expREsult"+Arrays.toString(expResult3.getValues().getElems()));
        ADTArray result3 = instance3.setA(1, 5);
//        System.out.println("result"+Arrays.toString(result3.getValues().getElems()));
        assertEquals(expResult3, result3);
        
        ADTArray instance4 = initA().setA(1, 1).setA(2, 2).setA(3, 3);
        ADTArray expResult4 = initA().setA(1, 1).setA(2, 2).setA(3, 3);
        ADTArray result4 = instance4.setA(-1, 5);
        assertEquals(expResult4, result4);
        
    }

    /**
     * Test of getA method, of class ADTArray.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        int pos = 0; // --
        ADTArray instance = initA();
        int expResult = 0;
        int result = instance.getA(pos);
        assertEquals(expResult, result);
        
        int pos2 = -1;
        ADTArray instance2 = initA().setA(1, 1).setA(2, 2).setA(3, 3);
        int expResult2 = -1;
        int result2 = instance2.getA(pos2);
        assertEquals(expResult2, result2);
        
        int pos3 = 0;
        ADTArray instance3 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        int expResult3 = 1;
        int result3 = instance3.getA(pos3);
        assertEquals(expResult3, result3); 
    }

    /**
     * Test of lengthA method, of class ADTArray.
     */
    @Test
    public void testLengthA() {
        System.out.println("lengthA");
        ADTArray instance = initA();
        int expResult = 0; // --
        int result = instance.lengthA();
        assertEquals(expResult, result);
        
        ADTArray instance2 = initA().setA(0, 1).setA(1, 2).setA(2, 3);
        int expResult2 = 3;
        int result2 = instance2.lengthA();
        assertEquals(expResult2, result2);
    }
}