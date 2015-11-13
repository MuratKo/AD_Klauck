///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package interfaceImpl;
//
//import interfaceImpl.ADTQueue;
//import interfaceImpl.ADTStack;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Antonio
// */
//public class ADTQueueTest {
//    
//    public ADTQueueTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    // Creates a queue for testing pusposes by using the enqueue method. The Argument specifies 
//    // the number of elements in the queue. The elements will be numbers from 1 to n.
//    private static ADTQueue createTestQ(int n){
//        ADTQueue testQ = ADTQueue.createQ();
//        for(int i = 1; i <= n; i++){
//            testQ.enqueue(i);
//        }
//        return testQ;
//    }
//
//    // Creates a queue by directly setting the internally used ADTStacks.
//    // The first argument will be at the front of the queue, the second argument will be the element after the front element and so on.
//    // All elements will be placed on the "in-stack".
//    private static ADTQueue createTestQallIn(int front,int second, int third, int fourth){
//        ADTQueue testQ = ADTQueue.createQ();
//        ADTStack inStack = ADTStack.createS();
//        inStack.push(front);
//        inStack.push(second);
//        inStack.push(third);
//        inStack.push(fourth);
//        testQ.setInStack(inStack);
//        testQ.setQLength(4);
//        return testQ;
//    }
//    
//    // Creates a queue by directly setting the internally used ADTStacks.
//    // The first argument will be at the front of the queue, the second argument will be the element after the front element and so on.
//    // All elements will be placed on the "out-stack".
//    private static ADTQueue createTestQallOut(int front,int second, int third, int fourth){
//        ADTQueue testQ = ADTQueue.createQ();
//        ADTStack outStack = ADTStack.createS();
//        outStack.push(fourth);
//        outStack.push(third);
//        outStack.push(second);
//        outStack.push(front);
//        testQ.setOutStack(outStack);
//        testQ.setQLength(4);
//        return testQ;
//    }
//    
//    // Creates a queue by directly setting the internally used ADTStacks.
//    // The first argument will be at the front of the queue, the second argument will be the element after the front element and so on.
//    // Half oh the elements will be placed onto the "in-stack" and the other half onto the "out-stack".
//    private static ADTQueue createTestQInOut(int front,int second, int third, int fourth){
//        ADTQueue testQ = ADTQueue.createQ();
//        ADTStack inStack = ADTStack.createS();
//        ADTStack outStack = ADTStack.createS();
//        inStack.push(third);
//        inStack.push(fourth);
//        outStack.push(second);
//        outStack.push(front);
//        testQ.setInStack(inStack);
//        testQ.setOutStack(outStack);
//        testQ.setQLength(4);
//        return testQ;
//    }
//   
//    public void testEquals(){
//        //Test1: Comparison of two ADTQueues with a different distribution of their elements onto their internally used stacks
//        // Queue1: all elements on the "in-stack"
//        // Queue2: all elements on the "out-stack"
//        ADTQueue instance1a = createTestQallIn(1,2,3,4);
//        ADTQueue instance1b = createTestQallOut(1,2,3,4);
//        assertTrue(instance1a.equals(instance1b));
//        assertTrue(instance1b.equals(instance1a));
//        System.out.println("Test1 OK");
//        
//        //Test2: Comparison of two ADTQueues with a different distribution of their elements onto their internally used stacks
//        // Queue1: all elements on the "in-stack"
//        // Queue2: elements on both stacks
//        ADTQueue instance2a = createTestQallIn(1,2,3,4);
//        ADTQueue instance2b = createTestQInOut(1,2,3,4);
//        assertTrue(instance2a.equals(instance2b));
//        assertTrue(instance2b.equals(instance2a));
//        System.out.println("Test2 OK");
//        
//        //Test3: Comparison of two ADTQueues with a different distribution of their elements onto their internally used stacks
//        // Queue1: all elements on the "out-stack"
//        // Queue2: elements on both stacks
//        ADTQueue instance3a = createTestQallOut(1,2,3,4);
//        ADTQueue instance3b = createTestQInOut(1,2,3,4);
//        assertTrue(instance3a.equals(instance3b));
//        assertTrue(instance3b.equals(instance3a));
//        System.out.println("Test3 OK");
//    }
//    
//    
//    /**
//     * Test of createQ method, of class ADTQueue.
//     */
//    @Test
//    public void testCreateQ() {
//        System.out.println("---createQ---");
//        //Test1: Tests wheter a newly created ADTQueue is Empty by looking at its attributes.
//        ADTQueue instance = ADTQueue.createQ();
//        assertTrue(instance.getInStack().isEmptyS());
//        assertTrue(instance.getOutStack().isEmptyS());
//        assertTrue(instance.getQLength() == 0);
//         System.out.println("Test1 OK");
//    }
//
//    /**
//     * Test of isEmpty method, of class ADTQueue.
//     */
//    @Test
//    public void testIsEmpty() {
//        System.out.println("---isEmpty---");
//        //Test1: An empty queue returns true.
//        ADTQueue instance = ADTQueue.createQ();
//        assertTrue(instance.isEmpty());
//        System.out.println("Test1 OK");
//        
//        //Test2: A non-empty queue returns false.
//        ADTQueue instance2 = createTestQ(5);
//        assertFalse(instance2.isEmpty());
//        System.out.println("Test2 OK");
//    }
//
//    /**
//     * Test of enqueue method, of class ADTQueue.
//     */
//    @Test
//    public void testEnqueue() {
//        System.out.println("---enqueue---");
//        // Test1: Comparison of an ADTQueue that was filled by using the enqueue method to an ADTQueue that was created without the enqueue method.
//        ADTQueue instance = createTestQ(3);
//        ADTQueue expResult = createTestQallIn(1,2,3,4);
//        ADTQueue result = instance.enqueue(4);
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//    }
//
//    /**
//     * Test of dequeue method, of class ADTQueue.
//     */
//    @Test
//    public void testDequeue() {
//        System.out.println("---dequeue---");
//        // Test1: Using the dequeue method on an empty ADTQueue yields an empty ADTQueue
//        ADTQueue instance = ADTQueue.createQ();
//        ADTQueue expResult = ADTQueue.createQ();
//        ADTQueue result = instance.dequeue();
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//        
//        //Test2: Using the dequeue method on a non-empty ADTQueue where all elements are on the "in-stack"
//        ADTQueue instance2 = createTestQallIn(1,2,3,4);
//        ADTQueue expResult2 = ADTQueue.createQ();
//        expResult2.enqueue(2);
//        expResult2.enqueue(3);
//        expResult2.enqueue(4);
//        ADTQueue result2 = instance2.dequeue();
//        assertEquals(expResult2, result2);
//        System.out.println("Test2 OK");
//        
//        //Test3: Using the dequeue method on a non-empty ADTQueue where all elements are on the "out-stack"
//        ADTQueue instance3 = createTestQallOut(1,2,3,4);
//        ADTQueue expResult3 = ADTQueue.createQ();
//        expResult3.enqueue(2);
//        expResult3.enqueue(3);
//        expResult3.enqueue(4);
//        ADTQueue result3 = instance3.dequeue();
//        assertEquals(expResult3, result3);
//        System.out.println("Test3 OK");
//        
//        //Test4: Using the dequeue method on a non-empty ADTQueue whit elements are on both internally used stacks
//        ADTQueue instance4 = createTestQInOut(1,2,3,4);
//        ADTQueue expResult4 = ADTQueue.createQ();
//        expResult4.enqueue(2);
//        expResult4.enqueue(3);
//        expResult4.enqueue(4);
//        ADTQueue result4 = instance4.dequeue();
//        assertEquals(expResult4, result4);
//        System.out.println("Test4 OK");
//        
//        //Test5: Using the dequeue method on an ADTQueue with just one element returns an empty queue
//        ADTQueue instance5 = createTestQ(1);
//        ADTQueue expResult5 = ADTQueue.createQ();
//        ADTQueue result5 = instance5.dequeue();
//        assertEquals(expResult5, result5);
//        System.out.println("Test5 OK");
//    }
//
//    /**
//     * Test of front method, of class ADTQueue.
//     */
//    @Test
//    public void testFront() {
//        System.out.println("---front---");
//        //Test1: Using the front() method on an empty ADTList returns -1
//        ADTQueue instance = ADTQueue.createQ();
//        int expResult = -1;
//        int result = instance.front();
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//        
//        //Test2: Using the front() method on a non-empty ADTList returns the first element that was enqueued
//        ADTQueue instance2 = createTestQ(4);
//        int expResult2 = 1;
//        int result2 = instance2.front();
//        assertEquals(expResult2, result2);
//        System.out.println("Test2 OK");
//        
//        
//    }
//  
//}
