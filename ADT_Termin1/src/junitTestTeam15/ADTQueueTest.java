
package junitTestTeam15;

import adtqueue.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class ADTQueueTest {
    
    public ADTQueueTest() {
    }

    @Test
    public void testCreateQ() {
        System.out.println("createQ");
        
        //createQ() -> []
        ADTQueue expResult = ADTQueue.createQ();
        ADTQueue result = ADTQueue.createQ();
        assertEquals(expResult, result);
        
//        fail("The test case is a prototype.");
    }

    @Test
    public void testIsEmptyQ() {
        System.out.println("isEmptyQ");
        
        //[].isEmptyQ() -> true
        ADTQueue instance = ADTQueue.createQ();
        boolean expResult = true;
        boolean result = instance.isEmptyQ();
        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
        
        
        //[3,2,1].isEmptyQ -> false
        ADTQueue instance2 = ADTQueue.createQ().enqueue(1).enqueue(2).enqueue(3);
        boolean expResult2 = false;
        boolean result2 = instance2.isEmptyQ();
        assertEquals(expResult2, result2);
//        fail("The test case is a prototype.");
    }

    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        
        //[].enqueue(1) -> [1]
        int elem = 1;
        ADTQueue instance = ADTQueue.createQ();
        ADTQueue expResult = ADTQueue.createQ().enqueue(1);
        ADTQueue result = instance.enqueue(elem);
        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
        
        //[1].enqueue(2) -> [2,1]
        int elem2 = 2;
        ADTQueue instance2 = ADTQueue.createQ().enqueue(1);
        ADTQueue expResult2 = ADTQueue.createQ().enqueue(1).enqueue(2);
        ADTQueue result2 = instance2.enqueue(elem2);
        assertEquals(expResult2, result2);
        
        //[2,1].enqueue(3) -> [3,2,1]
        int elem3 = 3;
        ADTQueue instance3 = ADTQueue.createQ().enqueue(1).enqueue(2);
        ADTQueue expResult3 = ADTQueue.createQ().enqueue(1).enqueue(2).enqueue(3);
        ADTQueue result3 = instance3.enqueue(elem3);
        assertEquals(expResult3, result3);
    }

    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        
        //[].dequeue() -> []
        ADTQueue instance = ADTQueue.createQ();
        ADTQueue expResult = ADTQueue.createQ();
        ADTQueue result = instance.dequeue();
        assertEquals(expResult, result);
        
        
        //[3,2,1].dequeue() -> [3,2]
        ADTQueue instance2 = ADTQueue.createQ().enqueue(1).enqueue(2).enqueue(3);
        ADTQueue expResult2 = ADTQueue.createQ().enqueue(2).enqueue(3);
        ADTQueue result2 = instance2.dequeue();
        assertEquals(expResult2, result2);
    }

    @Test
    public void testFront() {
        System.out.println("front");
        
        //[].front() -> -1
        ADTQueue instance = ADTQueue.createQ();
        int expResult = -1;
        int result = instance.front();
        assertEquals(expResult, result);
        
        //[].front() -> -1
        ADTQueue instance2 = ADTQueue.createQ().enqueue(1).enqueue(2).enqueue(3);
        int expResult2 = 1;
        int result2 = instance2.front();
        assertEquals(expResult2, result2);
    }
    
}
