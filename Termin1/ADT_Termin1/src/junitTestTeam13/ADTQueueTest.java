package junitTestTeam13;

import adtqueue.ADTQueue;
import static adtqueue.ADTQueue.createQ;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        // createQ()    ->  [ ]
        ADTQueue qe = createQ();
        assertEquals("[]", qe.toString());
    }

    /**
     * Test of isEmpty method, of class ADTQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        // [ ].isEmptyQ()    ->  true
        ADTQueue q_ise = createQ();
        assertEquals(true, q_ise.isEmptyQ());
        // [1].isEmptyQ()   ->  false
        q_ise.enqueue(1);
        assertEquals(false, q_ise.isEmptyQ());
        // [3,2,1].isEmptyQ()   ->  false
        q_ise.enqueue(2).enqueue(3);
        assertEquals(false, q_ise.isEmptyQ());
    }

    /**
     * Test of enqueue method, of class ADTQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        // [ ].enqueue(1)    ->  [1]
        ADTQueue q_enq_e = createQ();
        assertEquals("[1]", q_enq_e.enqueue(1).toString());
        // [ ].enqueue(3.25)   ->  [ ]
        q_enq_e = createQ();
        //assertEquals(q_enq_e, q_enq_e.enqueue(3.25));
        //!!!!!!!!!!!!!!!! geht nicht mit decimal
        // [1].enqueue(2)    ->  [2,1]
        ADTQueue q_enq_1 = createQ().enqueue(1);
        assertEquals("[2,1]", q_enq_1.enqueue(2).toString());
        // [2,1].enqueue(3)    ->  [3,2,1]
        ADTQueue q_enq_21 = createQ().enqueue(1).enqueue(2);
        assertEquals("[3,2,1]", q_enq_21.enqueue(3).toString());
        ADTQueue s_big = createQ();
        int big = 10000;
        for (int i = 1; i <= big; i++) {
            s_big.enqueue(i);
        }
    }

    /**
     * Test of dequeue method, of class ADTQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        // [ ].dequeue()    ->  [ ]
        ADTQueue q_deq_e = createQ();
        assertEquals(q_deq_e.toString(), q_deq_e.dequeue().toString());
        // [3,2,1].dequeue()   ->  [3,2]
        ADTQueue q_deq_321 = createQ().enqueue(1).enqueue(2).enqueue(3);
        ADTQueue q_deq_32 = createQ().enqueue(2).enqueue(3);
        assertEquals(q_deq_32.toString(), q_deq_321.dequeue().toString());
    }

    /**
     * Test of front method, of class ADTQueue.
     */
    @Test
    public void testFront() {
        System.out.println("front");
        // [ ].front()    ->  -1
        ADTQueue q_frt_e = createQ();
        assertEquals(-1, q_frt_e.front());
        // [3,2,1].front()   ->  1
        ADTQueue q_frt_321 = createQ().enqueue(1).enqueue(2).enqueue(3);
        assertEquals(1, q_frt_321.front());
    }
}
