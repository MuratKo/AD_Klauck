package junitTestTeam09;
import static adtliste.ADTList.*;
import adtliste.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author abw033
 */
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
    
    //Creates an ADTList with 3 elements, without using the insert method.
    //It is necessary that pos1/2/3 are matched with the values 1,2 and 3.
//    private static ADTList createTestADTList(int elem1, int pos1, int elem2, int pos2, int elem3, int pos3){
//        ADTList testList = ADTList.create();
//        int[] newPosArray = {pos1,pos2,pos3,0,0};
//        int[] newElemArray = {elem1,elem2,elem3,0,0};
//        testList.setElemArray(newElemArray);
//        testList.setPosArray(newPosArray);
//        testList.setCurrentListSize(3);
//        return testList;
//    }
    
    //Creates an ADTList with n elements using the insert method. The values of position and element are the same.
    private static ADTList createTestADTListIns(int size){
        ADTList testList = ADTList.create();
        for(int i=1; i<=size; i++){
            testList.insert(i, i);
        }
        return testList;
    }
    
    /**
     * Test of create method, of class ADTList.
     */
    @Test
    public void testCreate() {
        System.out.println("---create---");
        //Test1: Tests whether the created ADTList is empty
        ADTList instance = ADTList.create();
        assertTrue(instance.isEmpty());
        System.out.println("Test1 OK");
    }

    /**
     * Test of isEmpty method, of class ADTList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("---isEmpty positive---");
        //Test1: Tests whether the ADTList is empty after deleting all elements by comparing it with a newly created empty ADTList
        ADTList instance = createTestADTListIns(6);
        instance.delete(6);
        instance.delete(5);
        instance.delete(4);
        instance.delete(3);
        instance.delete(2);
        instance.delete(1);
        ADTList expResult = ADTList.create();
        ADTList result = instance;
        assertEquals(expResult,result);
        System.out.println("Test1 OK");
        
        System.out.println("---isEmpty negative---");
        //Test2: Tests whether an ADTList with one element returns false.
        ADTList instance2 = ADTList.create();
        boolean result2 = instance2.insert(1,1).isEmpty();
        assertFalse(result2);
        System.out.println("Test2 OK");
    }

//    /**
//     * Test of laenge method, of class ADTList.
//     */
    @Test
    public void testLaenge() {
        System.out.println("---laenge---");
        //Test1: An empty ADTList has a length of 0
        ADTList instance = ADTList.create();
        int expResult = 0;
        int result = instance.laenge();
        assertEquals(expResult, result);
        System.out.println("Test1 OK");
        

        //Test2: An ADTList with 2 Elements has a length of 2
        ADTList instance2 = ADTList.create();
        instance2.insert(4,1);
        instance2.insert(3,2);
        int expResult2 = 2;
        int result2 = instance2.laenge();
        assertEquals(expResult2, result2);
        System.out.println("Test2 OK");
        
        //Test3: Method is working after expanding the internally used arrays (assuming an initial array size of 5)
        ADTList instance3 = createTestADTListIns(6);
        int expResult3 = 6;
        int result3 = instance3.laenge();
        assertEquals(expResult3, result3);
        System.out.println("Test3 OK");
    }

    /**
     * Test of insert method, of class ADTList.
     */
//    @Test
//    public void testInsert() {
//        System.out.println("---insert---");
//        //Test1: Tests whether the method is working as expected.
//        ADTList instance = ADTList.create();
//        ADTList expResult = createTestADTList(1,1,2,2,3,3);
//        ADTList result = instance.insert(1, 1);
//        result.insert(2, 2);
//        result.insert(3, 3);
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//        
//        //Test2: Elemnts must not be overwritten by inserting another element an their position
//        ADTList instance2 = ADTList.create();
//        ADTList expResult2 = createTestADTList(1,1,2,2,3,3);
//        ADTList result2 = instance2.insert(3, 1);
//        result2.insert(2, 1);
//        result2.insert(1, 1);
//        assertEquals(expResult2, result2);
//        System.out.println("Test2 OK");
//        
//        
//        //Test3: Inserting an element at an illegal position returns the original list
//        ADTList instance3 = ADTList.create();
//        ADTList expResult3 = ADTList.create();
//        ADTList result3 = instance3.insert(1, 5);
//        assertEquals(expResult3, result3);
//        System.out.println("Test3 OK");
//    }

    /**
     * Test of delete method, of class ADTList.
     */
    @Test
    public void testDelete() {
        System.out.println("---delete---");
        //Test1: Deleting all elements returns an empty ADTList
        ADTList instance = createTestADTListIns(6);
        ADTList expResult = ADTList.create();
        ADTList result = instance;
            for(int i=6; instance.laenge()>0;i--){
                instance.delete(i);}
        assertEquals(expResult, result);
        System.out.println("Test1 OK");
        
        //Test2: Testing the deletion of one element
        ADTList instance2 = createTestADTListIns(2);
        ADTList expResult2 = ADTList.create();
        expResult2.insert(2, 1);
        ADTList result2 = instance2.delete(1);
        assertEquals(expResult2, result2);
        System.out.println("Test2 OK");
        
        //Test3: Trying to delete an element with an illegal position returns the original list
        ADTList instance3 = createTestADTListIns(2);
        ADTList expResult3 = createTestADTListIns(2);
        ADTList result3 = instance3.delete(99);
        assertEquals(expResult3, result3);
        System.out.println("Test3 OK");
    }

    /**
     * Test of find method, of class ADTList.
     */
    @Test
    public void testFind() {
//        System.out.println("---find---");
//        //Test1: Trying to find an element in an empty list returns -1.
//        ADTList instance = ADTList.create();
//        int expResult = -1;
//        int result = instance.find(8);
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//        
//        //Test2: Method returns the position of an element in a list
//        ADTList instance2 = createTestADTListIns(3);
//        int expResult2 = 2;
//        int result2 = instance2.find(2);
//        assertEquals(expResult2, result2);
//        System.out.println("Test2 OK");
//        
//        //Test3: Method returns the position of the first occurence(lowest position) of the specified element.
//        ADTList instance3 = createTestADTList(2,1,2,2,2,3);
//        int expResult3 = 1;
//        int result3 = instance3.find(2);
//        assertEquals(expResult3, result3);
//        System.out.println("Test3 OK");
    }

    /**
     * Test of retrieve method, of class ADTList.
     */
    @Test
    public void testRetrieve() {
        System.out.println("---retrieve---");
        //Test1: Method returns -1 if the list is empty
        ADTList instance = ADTList.create();
        int expResult = -1;
        int result = instance.retrieve(3);
        assertEquals(expResult, result);
        System.out.println("Test1 OK");
        
        //Test2: Method returns -1 if the specified position is not valid
        ADTList instance2 = createTestADTListIns(3);
        int expResult2 = -1;
        int result2 = instance2.retrieve(4);
        assertEquals(expResult2, result2);
        System.out.println("Test2 OK");
        
        //Test3: Method returns the element at the specified position
        ADTList instance3 = createTestADTListIns(3);
        int expResult3 = 2;
        int result3 = instance3.retrieve(2);
        assertEquals(expResult3, result3);
        System.out.println("Test3 OK");
    }

    /**
     * Test of concat method, of class ADTList.
     */
    @Test
    public void testConcat() {
//        System.out.println("---concat---");
//        //Test1: concatenating two empty lists returns an empty list
//        ADTList instance = ADTList.create();
//        ADTList list = ADTList.create();
//        ADTList expResult = ADTList.create();
//        ADTList result = instance.concat(list);
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//        
//        //Test2.1: concatenating an empty list with a non-empty list returns the non-empty list
//        ADTList instance2 = ADTList.create();
//        ADTList list2 = createTestADTListIns(6);
//        ADTList expResult2 = list2;
//        ADTList result2 = instance2.concat(list2);
//        assertEquals(expResult2, result2);
//        System.out.println("Test2.1 OK");
//        
//        //Test2.2: concatenating a non-empty list with an empty list returns the non-empty list
//        ADTList instance3 = createTestADTListIns(6);
//        ADTList list3 = ADTList.create();
//        ADTList expResult3 = instance3;
//        ADTList result3 = instance3.concat(list3);
//        assertEquals(expResult3, result3);
//        System.out.println("Test2.2 OK");
//        
//        //Test3: concatenating two non-empty lists returns a new list in the form [list1 list2].
//        ADTList instance4 = createTestADTList(1,1,2,2,3,3);
//        ADTList list4 = createTestADTList(4,1,5,2,6,3);
//        ADTList expResult4 = createTestADTListIns(6);
//        ADTList result4 = instance4.concat(list4);
//        assertEquals(expResult4, result4);
//        System.out.println("Test3 OK");
        
    }
    
}
