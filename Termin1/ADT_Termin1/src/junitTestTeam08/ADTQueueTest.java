/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTestTeam08;
import static adtqueue.ADTQueue.*;
import adtqueue.*;

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
public class ADTQueueTest {
    
    public ADTQueueTest() {
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
     * Test of createQ method, of class ADTQueue.
     */
    @Test
    public void testCreateQ() {
        System.out.println("createQ");
        ADTQueue expResult = createQ();
        ADTQueue result = createQ();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmptyQ method, of class ADTQueue.
     */
    @Test
    public void testIsEmptyQ() {
        System.out.println("isEmptyQ");
        ADTQueue instance = createQ();
        boolean expResult = true;
        boolean result = instance.isEmptyQ();
        assertEquals(expResult, result);
        
        ADTQueue instance2 = createQ().enqueue(1);
        boolean expResult2 = false;
        boolean result2 = instance2.isEmptyQ();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of enqueue method, of class ADTQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        int elem = 1;
        ADTQueue instance = createQ();
        ADTQueue expResult = createQ().enqueue(1);
        ADTQueue result = instance.enqueue(elem);
        assertEquals(expResult, result);
        
        int elem2 = 2;
        ADTQueue instance2 = createQ().enqueue(1);
        ADTQueue expResult2 = createQ().enqueue(1).enqueue(2);
        ADTQueue result2 = instance2.enqueue(elem2);
        assertEquals(expResult2, result2);
        
        int leo3 = 3;
        ADTQueue instance3 = createQ().enqueue(1).enqueue(2);
        ADTQueue expResult3 = createQ().enqueue(1).enqueue(2).enqueue(3);
        ADTQueue result3 = instance3.enqueue(leo3);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of dequeue method, of class ADTQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        ADTQueue instance = createQ();
        ADTQueue expResult = createQ();
        ADTQueue result = instance.dequeue();
        assertEquals(expResult, result);
        
        ADTQueue instance2 = createQ().enqueue(1).enqueue(2).enqueue(3);
        ADTQueue expResult2 = createQ().enqueue(2).enqueue(3);
        ADTQueue result2 = instance2.dequeue();
//        System.out.println("expResult inStack"+Arrays.toString(expResult2.inStack.getStack().getElems()));
//        System.out.println("expResult outStack"+Arrays.toString(expResult2.outStack.getStack().getElems()));
//        System.out.println("Result inStack"+Arrays.toString(result2.inStack.getStack().getElems()));
//        System.out.println("Result outStack"+Arrays.toString(result2.outStack.getStack().getElems()));
        assertEquals(expResult2, result2);
    }

    /**
     * Test of front method, of class ADTQueue.
     */
    @Test
    public void testFront() {
        System.out.println("front");
        ADTQueue instance = createQ();
        int expResult = -1;
        int result = instance.front();
        assertEquals(expResult, result);
        
        ADTQueue instance2 = createQ().enqueue(1).enqueue(2).enqueue(3);
        int expResult2 = 1;
        int result2 = instance2.front();
        assertEquals(expResult2, result2);
    }
}