/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTestTeam08;
import static adtstack.ADTStack.*;
import adtstack.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jerom
 */
public class ADTStackTest {
    
    public ADTStackTest() {
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
     * Test of getStack method, of class ADTStack.
     */
    @Test
    public void testGetStack() {
//        System.out.println("getStack");
//        ADTStack instance = createS();
//        ADTList expResult = ADTList.create();
//        ADTList result = instance.getStack();
//        assertEquals(expResult, result);
    }

    /**
     * Test of createS method, of class ADTStack.
     */
    @Test
    public void testCreateS() {
        System.out.println("createS");
        ADTStack expResult = createS();
        ADTStack result = createS();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmptyS method, of class ADTStack.
     */
    @Test
    public void testIsEmptyS() {
        System.out.println("isEmptyS");
        ADTStack instance = createS();
        boolean expResult = true;
        boolean result = instance.isEmptyS();
        assertEquals(expResult, result);
        
        ADTStack instance2 = createS();
        boolean expResult2 = false;
        boolean result2 = instance2.push(1).isEmptyS();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of push method, of class ADTStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        int elem = 1;
        ADTStack instance = createS();
        ADTStack expResult = createS().push(1);
        ADTStack result = instance.push(elem);
        assertEquals(expResult, result);
        
        int elem2 = 3;
        ADTStack instance2 = createS().push(1).push(2);
        ADTStack expResult2 = createS().push(1).push(2).push(3);
        ADTStack result2 = instance2.push(elem2);
        System.out.println();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of pop method, of class ADTStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        ADTStack instance = createS();
        ADTStack expResult = createS();
        ADTStack result = instance.pop();
        assertEquals(expResult, result);
        
        ADTStack instance2 = createS().push(1).push(2).push(3);
        ADTStack expResult2 = createS().push(1).push(2);
        ADTStack result2 = instance2.pop();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of top method, of class ADTStack.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        ADTStack instance = createS();
        int expResult = -1;
        int result = instance.top();
        assertEquals(expResult, result);
        
        ADTStack instance2 = createS().push(1).push(2).push(3);
        int expResult2 = 3;
        int result2 = instance2.top();
        assertEquals(expResult2, result2);
    }
    
}
