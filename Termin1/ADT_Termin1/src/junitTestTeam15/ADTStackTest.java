/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTestTeam15;

import adtstack.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lance
 */
public class ADTStackTest {
    
    public ADTStackTest() {
    }

    @Test
    public void testCreateS() {
        System.out.print("Test: createS");
        
        //createS() -> [ ]
        ADTStack expResult = ADTStack.createS();
        ADTStack result = ADTStack.createS();
        assertEquals(expResult, result);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testIsEmptyS() {
        System.out.print("Test: isEmptyS");
        
        //[ ].isEmptyS() -> „true“
        ADTStack instance = ADTStack.createS();
        boolean expResult = true;
        boolean result = instance.isEmptyS();
        assertEquals(expResult, result);
        
 	//[1].isEmptyS() -> „false“
        ADTStack instance2 = ADTStack.createS().push(1);
        boolean expResult2 = false;
        boolean result2 = instance2.isEmptyS();
        assertEquals(expResult2, result2);
        
 	//[1,2].isEmptyS() -> „false“
        ADTStack instance3 = ADTStack.createS().push(1).push(2);
        boolean expResult3 = false;
        boolean result3 = instance3.isEmptyS();
        assertEquals(expResult3, result3);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testPush() {
        System.out.print("Test: push");
        
        //[ ].push(1) -> [1]
        int elem = 1;
        ADTStack instance = ADTStack.createS();
        ADTStack expResult = ADTStack.createS().push(1);
        ADTStack result = instance.push(elem);
        assertEquals(expResult, result);
        
 	//[1,2]push(3) ->	[1,2,3]
        int elem2 = 3;
        ADTStack instance2 = ADTStack.createS().push(1).push(2);
        ADTStack expResult2 = ADTStack.createS().push(1).push(2).push(3);
        ADTStack result2 = instance2.push(elem2);
        assertEquals(expResult2, result2);
        
// 	//[1,2]push(3.25)	-> [1,2]
//        Object elem3 = 3.25;
//        ADTStack instance3 = ADTStack.createS().push(1).push(2);
//        ADTStack expResult3 = instance3;
//        ADTStack result3 = instance3.push(elem3);
//        assertEquals(expResult3, result3);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testPop() {
        System.out.print("Test: pop");
        
        //[ ].pop() -> [ ]
        ADTStack instance = ADTStack.createS();
        ADTStack expResult = ADTStack.createS();
        ADTStack result = instance.pop();
        assertEquals(expResult, result);
        
 	//[1,2,3].pop() -> [1,2]
        ADTStack instance2 = ADTStack.createS().push(1).push(2).push(3);
        ADTStack expResult2 = ADTStack.createS().push(1).push(2);
        ADTStack result2 = instance2.pop();
        assertEquals(expResult2, result2);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testTop() {
        System.out.print("Test: top");
        
        //[ ].top() -> „-1“
        ADTStack instance = ADTStack.createS();
        int expResult = -1;
        int result = instance.top();
        assertEquals(expResult, result);
        
 	//[1,2,3].top() -> „3“
        ADTStack instance2 = ADTStack.createS().push(1).push(2).push(3);
        int expResult2 = 3;
        int result2 = instance2.top();
        assertEquals(expResult2, result2);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }
    
}
