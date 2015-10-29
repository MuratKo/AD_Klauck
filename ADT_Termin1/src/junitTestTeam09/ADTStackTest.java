//package interfaceImpl;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author damde_000
// */
//public class ADTStackTest {
//    
//    public ADTStackTest() {
//    }
//
//    
//    //Creating a new Stack with 3 pushed elements without using the push-method.
//    private ADTStack createTestADTStackBas(int elem1, int elem2, int elem3){
//        ADTStack newStack = ADTStack.createS();
//        ADTList Stacklist = newStack.getStackList();
//        Stacklist.insert(elem1, 1);
//        Stacklist.insert(elem2, 2);
//        Stacklist.insert(elem3, 3);
//        return newStack;
//    }
//    
//    //creating a Stack with n elements pushed.
//    private ADTStack createTestADTStack(int elems){
//        ADTStack newStack = ADTStack.createS();
//        for(int i = 1; i <= elems; i++){
//            newStack.push(i);
//        }
//        return newStack;
//    }
//    
//    @Test
//    public void testCreateS() {
//        System.out.println("---createS---");
//        //Test1: Tests whether the created Stack is empty.
//        ADTStack instance = ADTStack.createS();
//        assertTrue(instance.isEmptyS());
//        System.out.println("Test1 OK");
//    }
//
//    @Test
//    public void testIsEmptyS() {
//        System.out.println("---isEmptyS---");
//        //Test1: Tests whether a Stack is empty after pushing and popping one element
//        ADTStack instance = ADTStack.createS();
//        instance.push(1);
//        instance.pop();
//        ADTStack expResult = ADTStack.createS();
//        assertEquals(expResult, instance);
//        System.out.println("Test1 OK");
//        
//        //Test2: Tests whether the method returns false on an non-empty Stack
//        ADTStack instance1 = ADTStack.createS();
//        instance1.push(1);
//        assertFalse(instance1.isEmptyS());
//        System.out.println("Test2 OK");
//    }
//
//    @Test
//    public void testPush() {
//        System.out.println("---push---");
//        //Test1: The pushed element is on the first position of the internally used ADTList if the Stack, the element was pushed on, was empty before
//        ADTStack instance = ADTStack.createS();
//        ADTStack expResult = ADTStack.createS();
//        expResult.getStackList().insert(1, 1);
//        ADTStack result = instance.push(1);
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//        
//        //Test2: Testing the result of pushing three elements.
//        ADTStack instance2 = createTestADTStackBas(1,2,3);
//        ADTStack expResult2 = createTestADTStack(3);
//        assertEquals(expResult2, instance2);
//        System.out.println("Test2 OK");
//        
//        //Test3? unveränderter Stack bei falscher Eingabe? --> Java statische Typisierung
//    }
//
//    @Test
//    public void testPop() {
//        System.out.println("---pop---");
//        //Test1: If the Stack is empty, pop() returns an empty Stack
//        ADTStack instance = ADTStack.createS();
//        ADTStack expResult = ADTStack.createS();
//        ADTStack result = instance.pop();
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//        
//        //Test2: Tests whether the method deletes the top-element
//        ADTStack instance2 = createTestADTStack(3);
//        ADTStack expResult2 = createTestADTStack(2);
//        ADTStack result2 = instance2.pop();
//        assertEquals(expResult2, result2);
//        System.out.println("Test2 OK");
//    }
//
//    @Test
//    public void testTop() {
//        //Test1: Tests whether the returning value for an empty stack is -1
//        System.out.println("---top---");
//        ADTStack instance = ADTStack.createS();
//        int expResult = -1;
//        int result = instance.top();
//        assertEquals(expResult, result);
//        System.out.println("Test1 OK");
//        
//        //Test2: If the top-element has the value 4, the top method returns 4
//        ADTStack instance2 = createTestADTStack(4);
//        int expResult2 = 4;
//        int result2 = instance2.top();
//        assertEquals(expResult2, result2);
//        System.out.println("Test2 OK");
//    }
//    
//}
