package junitTestTeam15;

import adtliste.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class ADTListTest {
    
    public ADTListTest() {
    }

    @Test
    public void testCreate() {
        System.out.print("Test: create");
        
        //create() -> [ ]
        ADTList instance = ADTList.create();
        ADTList expResult = ADTList.create();
        ADTList result = ADTList.create();
        assertEquals(expResult, result);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testLaenge() {
        System.out.print("Test: laenge");
        
        //[ ].laenge() -> „0“
        ADTList instance = ADTList.create();
        int expResult = 0;
        int result = instance.laenge();
        assertEquals(expResult, result);
        
        //[1,2].laenge() -> „2“
        ADTList instance2 = ADTList.create().insert(1,1).insert(2,2);
        int expResult2 = 2;
        int result2 = instance2.laenge();
        assertEquals(expResult2, result2);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testIsEmpty() {
        System.out.print("Test: isEmpty");
        
        //[ ].isEmpty() -> true
        ADTList instance = ADTList.create();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
        //[1,2].isEmpty() 	-> false
        ADTList instance2 = ADTList.create().insert(1,1);
        boolean expResult2 = false;
        boolean result2 = instance2.isEmpty();
        assertEquals(expResult2, result2);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testInsert() {
        System.out.print("Test: insert");
        
        //[ ].insert(1,1) -> [1]
        int element = 1;
        int position = 1;
        ADTList instance = ADTList.create();
        ADTList expResult = ADTList.create().insert(1,1);
        ADTList result = instance.insert(element,position);
        assertEquals(expResult, result);
        
        //[ ].insert(1,5) -> [ ]
        int element2 = 1;
        int position2 = 5;
        ADTList instance2 = ADTList.create();
        ADTList expResult2 = ADTList.create();
        ADTList result2 = instance2.insert(element2,position2);
        assertEquals(expResult2, result2);
        
        //[1,2].insert(3,2) -> [1, 3, 2]
        //Test, ob das Einschieben funktioniert und die 2 auf Position 3 rutscht
        int element3 = 3;
        int position3 = 2;
        ADTList instance3 = ADTList.create().insert(1,1).insert(2,2);
        ADTList expResult3 = ADTList.create().insert(1,1).insert(3,2).insert(2, 3);
        ADTList result3 = instance3.insert(element3,position3);
        assertEquals(expResult3, result3);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testDelete() {
        System.out.print("Test: delete");
        
        //[ ].delete(1)	-> [ ]
        int position = 1;
        ADTList instance = ADTList.create();
        ADTList expResult = ADTList.create();
        ADTList result = instance.delete(position);
        assertEquals(expResult, result);
        
        //[1,2].delete(0) -> [1,2]
        int position2 = 0;
        ADTList instance2 = ADTList.create().insert(1, 1).insert(2, 2);
        ADTList expResult2 = ADTList.create().insert(1, 1).insert(2, 2);
        ADTList result2 = instance2.delete(position2);
        assertEquals(expResult2, result2);
        
        //[1,2].delete(1) -> [2]
        //Testet ob 1 gelöscht wurde und die 2 aufrückt
        int position3 = 1;
        ADTList instance3 = ADTList.create().insert(1, 1).insert(2, 2);
        ADTList expResult3 = ADTList.create().insert(2, 1);
        ADTList result3 = instance3.delete(position3);
        assertEquals(expResult3, result3);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testFind() {
        System.out.print("Test: find");
        
        //[ ].find(1) -> „-1“
 	int element = 1;
        ADTList instance = ADTList.create();
        int expResult = -1;
        int result = instance.find(element);
        assertEquals(expResult, result);
        
        //[1,2].find(2) -> „2“
        int element2 = 2;
        ADTList instance2 = ADTList.create().insert(1, 1).insert(2, 2);
        int expResult2 = 2;
        int result2 = instance2.find(element2);
        assertEquals(expResult2, result2);
        
 	//[1,2,2].find(2) -> „2“
        int element3 = 2;
        ADTList instance3 = ADTList.create().insert(1,1).insert(2,2).insert(2,3);
        int expResult3 = 2;
        int result3 = instance3.find(element3);
        assertEquals(expResult3, result3);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testRetrieve() {
        System.out.print("Test: retrieve");
        //[ ].retrieve(0) -> „-1“
        int position = 0;
        ADTList instance = ADTList.create();
        int expResult = -1;
        int result = instance.retrieve(position);
        assertEquals(expResult, result);
        
 	//[ ].retrieve(1) -> „-1“
        int position2 = 1;
        ADTList instance2 = ADTList.create();
        int expResult2 = -1;
        int result2 = instance2.retrieve(position2);
        assertEquals(expResult2, result2);
        
 	//[1,2].retrieve(3) -> „-1“
        int position3 = 3;
        ADTList instance3 = ADTList.create().insert(1, 1).insert(2, 2);
        int expResult3 = -1;
        int result3 = instance3.retrieve(position3);
        assertEquals(expResult3, result3);
        
 	//[1,2,3].retrieve(2) -> „2“
        int position4 = 2;
        ADTList instance4 = ADTList.create().insert(1, 1).insert(2, 2).insert(3,3);
        int expResult4 = 2;
        int result4 = instance4.retrieve(position4);
        assertEquals(expResult4, result4);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }

    @Test
    public void testConcat() {
        System.out.print("Test: concat");
        
        //[ ].concat([ ])	-> [ ]
        ADTList inlist = ADTList.create();
        ADTList instance = ADTList.create();
        ADTList expResult = ADTList.create();
        ADTList result = instance.concat(inlist);
        assertEquals(expResult, result);
        
 	//[ ].concat([1,2]) -> [1,2]
        ADTList inlist2 = ADTList.create().insert(1,1).insert(2,2);
        ADTList instance2 = ADTList.create();
        ADTList expResult2 = ADTList.create().insert(1,1).insert(2,2);
        ADTList result2 = instance2.concat(inlist2);
        assertEquals(expResult2, result2);
        
       
        
 	//[1,2].concat([ ]) -> [1,2]
        ADTList inlist3 = ADTList.create();
        ADTList instance3 = ADTList.create().insert(1,1).insert(2,2);
        ADTList expResult3 = ADTList.create().insert(1,1).insert(2,2);
        ADTList result3 = instance3.concat(inlist3);
        assertEquals(expResult3, result3);
        
 	//[1,2].concat([3,4]) -> [1,2,3,4]
        ADTList inlist4 = ADTList.create().insert(3,1).insert(4,2);
        ADTList instance4 = ADTList.create().insert(1,1).insert(2,2);
        ADTList expResult4 = ADTList.create().insert(1,1).insert(2,2).insert(3,3).insert(4,4);
        ADTList result4 = instance4.concat(inlist4);
        assertEquals(expResult4, result4);
        
        //fail("The test case is a prototype.");
        System.out.println("...ok");
    }
    
}
