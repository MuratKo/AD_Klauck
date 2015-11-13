package junitTestTeam08;
import static adtliste.ADTList.*;
import adtliste.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ADTListTest {
    
    public ADTListTest() {
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
     * Test of getSize method, of class ADTList.
     */
    @Test
    public void testGetSize() {
//        System.out.println("getSize");
//        ADTList instance = create();
//        int expResult = 0;
//        int result = instance.getSize();
//        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class ADTList.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        ADTList expResult = create();
        ADTList result = create();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class ADTList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ADTList instance = create();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
        ADTList instance2 = create();
        boolean expResult2 = false;
        boolean result2 = instance2.insert(5, 1).isEmpty();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of laenge method, of class ADTList.
     */
    @Test
    public void testLaenge() {
        System.out.println("laenge");
        ADTList instance = create();
        int expResult = 0;
        int result = instance.laenge();
        assertEquals(expResult, result);
        
//        instance.insert(5, 1);
//        expResult = 1;
//        result = instance.laenge();
//        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class ADTList.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int elem = 1;
        int listPos = 1;
        ADTList instance = create();
        ADTList expResult = create().insert(1, 1);
        ADTList result = instance.insert(elem, listPos);
        assertEquals(expResult, result);
        
        ADTList instance2 = create();
        ADTList expResult2 = create();
        ADTList result2 = instance2.insert(1, 5);
        assertEquals(expResult2, result2);
        
        ADTList instance3 = create();
        ADTList expResult3 = create().insert(1, 1).insert(3, 2).insert(2, 3);
        ADTList result3= instance3.insert(1, 1).insert(2, 2).insert(3, 2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of delete method, of class ADTList.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int listPos = 1;
        ADTList instance = create();
        ADTList expResult = create();
        ADTList result = instance.delete(listPos);
        assertEquals(expResult.isEmpty(), result.isEmpty());
        
        int listPos2 = 0;
        ADTList instance2 = create();
        ADTList expResult2 = create().insert(1,1).insert(2, 2);
        ADTList result2 = instance2.insert(1, 1).insert(2,2).delete(listPos2);
        assertEquals(expResult2, result2);
        
        int listPos3 = 1;
        ADTList instance3 = create();
        ADTList expResult3 = create().insert(2, 1);
        ADTList result3 = instance3.insert(1, 1).insert(2, 2).delete(listPos3);
        assertEquals(expResult3, result3);
        
        int listPos4 = 3;
        ADTList instance4 = create();
        ADTList expResult4 = create().insert(1, 1).insert(2, 2).insert(4,3).insert(5,4);
        ADTList result4 = instance4.insert(1, 1).insert(2,2).insert(3, 3).insert(4, 4).insert(5, 5).delete(listPos4);
        assertEquals(expResult4, result4);
        
        int listPos5 = 3;
        ADTList instance5 = create();
        ADTList expResult5 = create().insert(1, 1).insert(2, 2);
        ADTList result5 = instance5.insert(1, 1).insert(2, 2).insert(3, 3).delete(listPos5);
        assertEquals(expResult5, result5);
    }

    
    /**
     * Test of find method, of class ADTList.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int elem = 1;
        ADTList instance = create();
        int expResult = -1;
        int result = instance.find(elem);
        assertEquals(expResult, result);
        
        ADTList instance2 = create().insert(1, 1).insert(2, 2);
        int expResult2 = 2;
        int result2 = instance2.find(2);
        assertEquals(expResult2, result2);
        
        ADTList instance3 = create().insert(1, 1).insert(2, 2).insert(2, 3);
        int expResult3 = 2;
        int result3 = instance3.find(2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of retrieve method, of class ADTList.
     */
    @Test
    public void testRetrieve() {
        System.out.println("retrieve");
        int listPos = 0;
        ADTList instance = create();
        int expResult = -1;
        int result = instance.retrieve(listPos);
        assertEquals(expResult, result);
        
        ADTList instance2 = create();
        int expResult2 = -1;
        int result2 = instance2.retrieve(1);
        assertEquals(expResult2, result2);
        
        ADTList instance3 = create().insert(1, 1).insert(2, 2);
        int expResult3 = -1;
        int result3 = instance3.retrieve(3);
        assertEquals(expResult3, result3);
        
        ADTList instance4 = create().insert(1, 1).insert(2, 2).insert(3, 3);
        int expResult4 = 2;
        int result4 = instance4.retrieve(2);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of concat method, of class ADTList.
     */
    @Test
    public void testConcat() {
        System.out.println("concat");
        ADTList otherList = create();
        ADTList instance = create();
        ADTList expResult = create();
        ADTList result = instance.concat(otherList);
        assertEquals(expResult, result);
        
        ADTList otherList2 = create().insert(1, 1).insert(2, 2);
        ADTList instance2 = create();
        ADTList expResult2 = create().insert(1, 1).insert(2, 2);
        ADTList result2 = instance2.concat(otherList2);
        assertEquals(expResult2, result2);
        
        ADTList otherList3 = create();
        ADTList instance3 = create().insert(1, 1).insert(2, 2);
        ADTList expResult3 = create().insert(1,1).insert(2, 2);
        ADTList result3 = instance3.concat(otherList3);
        assertEquals(expResult3, result3);
        
        ADTList otherList4 = create().insert(3, 1).insert(4, 2);
        ADTList instance4 = create().insert(1, 1).insert(2, 2);
        ADTList expResult4 = create().insert(1, 1).insert(2, 2).insert(3, 3).insert(4, 4);
        ADTList result4 = instance4.concat(otherList4);
        assertEquals(expResult4, result4);
    }
    
}
