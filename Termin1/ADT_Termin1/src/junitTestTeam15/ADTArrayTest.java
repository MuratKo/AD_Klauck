/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTestTeam15;

import adtarray.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lance
 */
public class ADTArrayTest {
    
    public ADTArrayTest() {
    }

    @Test
    public void testInitA() {
        System.out.print("Test: initA");
        
        //initA() -> [ ]
        ADTArray expResult = ADTArray.initA();
        ADTArray result = ADTArray.initA();
        assertEquals(expResult, result);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testSetA() {
        System.out.print("Test: setA");
        
//        //[ ].setA(0,1)	-> [1]
//        int pos = 0;
//        int elem = 0;
//        ADTArray instance = null;
//        ADTArray expResult = null;
//        ADTArray result = instance.setA(pos, elem);
//        assertEquals(expResult, result);
        
 	//[ ].setA(5,1)	-> [0, 0, 0, 0, 0, 1]
        int pos2 = 5;
        int elem2 = 1;
        ADTArray instance2 = ADTArray.initA();
        ADTArray expResult2 = ADTArray.initA().setA(0,0).setA(1,0).setA(2,0).setA(3,0).setA(4,0).setA(5,1);
        ADTArray result2 = instance2.setA(pos2, elem2);
        assertEquals(expResult2, result2);
        
 	//[1,2,3].setA(1,5) -> [1, 5, 3]
        int pos3 = 1;
        int elem3 = 5;
        ADTArray instance3 = ADTArray.initA().setA(0,1).setA(1,2).setA(2,3);
        ADTArray expResult3 = ADTArray.initA().setA(0,1).setA(1,5).setA(2,3);
        ADTArray result3 = instance3.setA(pos3, elem3);
        assertEquals(expResult3, result3);
        
 	//[0,1,2,3].setA(-1,5) -> [0,1,2,3]
        int pos4 = -1;
        int elem4 = 5;
        ADTArray instance4 = ADTArray.initA().setA(1,1).setA(2,2).setA(3,3);
        ADTArray expResult4 = ADTArray.initA().setA(1,1).setA(2,2).setA(3,3);
        ADTArray result4 = instance4.setA(pos4, elem4);
        assertEquals(expResult4, result4);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testGetA() {
        System.out.print("Test: getA");
        
        //[ ].getA(0) -> „0“
        int pos = 0;
        ADTArray instance = ADTArray.initA();
        int expResult = 0;
        int result = instance.getA(pos);
        assertEquals(expResult, result);
        
 	//[0,1,2,3].getA(-1) -> „-1“
        int pos2 = -1;
        ADTArray instance2 = ADTArray.initA().setA(1,1).setA(2,2).setA(3,3);
        int expResult2 = -1;
        int result2 = instance2.getA(pos2);
        assertEquals(expResult2, result2);
        
 	//[1,2,3].getA(0) -> „1“
        int pos3 = 0;
        ADTArray instance3 = ADTArray.initA().setA(0,1).setA(1,2).setA(2,3);
        int expResult3 = 1;
        int result3 = instance3.getA(pos3);
        assertEquals(expResult3, result3);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testLengthA() {
        System.out.print("Test: lengthA");
        
        //[ ].lengthA()	-> „-1“
        ADTArray instance = ADTArray.initA();
        int expResult = -1;
        int result = instance.lengthA();
        assertEquals(expResult, result);
        
 	//[1,2,3].lengthA() -> „3“
        ADTArray instance2 = ADTArray.initA().setA(0,1).setA(1,2).setA(2,3);
        int expResult2 = 3;
        int result2 = instance2.lengthA();
        assertEquals(expResult2, result2);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }
    
}
