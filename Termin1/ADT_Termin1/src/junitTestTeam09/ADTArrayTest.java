/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTestTeam09;
import static adtarray.ADTArray.*;
import adtarray.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio und Arne
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
        System.out.println("---initA---");
        //Test1: A newly created Array has to have a length of 0;
        ADTArray instance = ADTArray.initA();
        int result = instance.lengthA();
        int expResult = 0;
        assertEquals(expResult,result);
        System.out.println("Test1 OK");

    }

    /**
     * Test of setA method, of class ADTArray.
     */
    @Test
    public void testSetA() {
//        System.out.println("---setA---");
//        //Test1: Inserting an element at the position 0 of an empty Array returns a filled one.
//        int pos = 0;
//        int elem = 1;
//        ADTArray instance = ADTArray.initA();
//        ADTArray expResult = ADTArray.initA();
//        ADTList list = expResult.getList();
//        list.insert(1,1);
//        expResult.setList(list);
//        ADTArray result = instance.setA(pos, elem);
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
    }

    /**
     * Test of getA method, of class ADTArray.
     */
    @Test
    public void testGetA() {
        System.out.println("---getA---");
        //Test1: Method returns "-1" when used on an empty ADTArray
        int pos = 0;
        ADTArray instance = ADTArray.initA();
        int expResult = -1;
        int result = instance.getA(pos);
        assertEquals(expResult, result);
        System.out.println("Test1 OK");
        
        //Test2: Method returns "0" when used on a postion that is larger than the size of the internally used ADTList 
        int pos2 = 99;
        ADTArray instance2 = ADTArray.initA();
        instance2.setA(0, 1);
        instance2.setA(1, 2);
        int expResult2 = 0;
        int result2 = instance2.getA(pos2);
        assertEquals(expResult2, result2);
        System.out.println("Test2 OK");
        
        //Test3: Method returns the correct element 
        int pos3 = 1;
        ADTArray instance3 = ADTArray.initA();
        instance3.setA(0, 1);
        instance3.setA(1, 2);
        int expResult3 = 2;
        int result3 = instance3.getA(pos3);
        assertEquals(expResult3, result3);
        System.out.println("Test3 OK");
        
    }
    
    @Test
    public void testEquals() { 
        System.out.println("---equals---");
       //Test1: Two empty Arrays are equal
        ADTArray array1a = ADTArray.initA();
        ADTArray array1b = ADTArray.initA();
        assertEquals(array1a,array1b);
        System.out.println("Test1 OK");
        
        //Test2: 
        ADTArray array2a = ADTArray.initA();
        array2a.setA(5, 6);
        array2a.setA(5, 0);
        ADTArray array2b = ADTArray.initA();
        assertEquals(array2a,array2b);
        System.out.println("Test2 OK");
        
        //Test3:
        ADTArray array3a = ADTArray.initA();
        array3a.setA(5, 6);
        array3a.setA(5, 0);
        array3a.setA(0, 1);
        array3a.setA(1, 2);
        ADTArray array3b = ADTArray.initA();
        array3b.setA(0, 1);
        array3b.setA(1, 2);
        assertEquals(array3a,array3b);
        System.out.println("Test3 OK");
        
    }

    /**
     * Test of lengthA method, of class ADTArray.
     */
    @Test
    public void testLengthA() {
        System.out.println("---lengthA---");
        //Test1: 
        ADTArray instance = ADTArray.initA();
        instance.setA(5, 6);
        instance.setA(5, 0);
        instance.setA(0, 1);
        instance.setA(1, 2);
        int result = instance.lengthA();
        ADTArray array3b = ADTArray.initA();
        array3b.setA(0, 1);
        array3b.setA(1, 2);
        int expResult = instance.lengthA();
        assertEquals(expResult,result);
        System.out.println("Test1 OK");

    }
    
}
