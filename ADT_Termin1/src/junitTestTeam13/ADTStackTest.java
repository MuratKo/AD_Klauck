package junitTestTeam13;

import adtstack.ADTStack;
import static adtstack.ADTStack.createS;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Test of createS method, of class ADTStack.
     */
    @Test
    public void testCreateS() {
        System.out.println("createS");
        // createS()    ->  [ ]
        ADTStack se = createS();
        assertEquals("[]", se.toString());
    }

    /**
     * Test of isEmpty method, of class ADTStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        // [ ].isEmptyS()    ->  true
        ADTStack s_ise = createS();
        assertEquals(true, s_ise.isEmptyS());
        // [1].isEmptyS()   ->  false
        s_ise = s_ise.push(1);
        assertEquals(false, s_ise.isEmptyS());
        // [1,2].isEmptyS() ->  false
        s_ise = s_ise.push(2);
        assertEquals(false, s_ise.isEmptyS());
    }

    /**
     * Test of push method, of class ADTStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        // [ ].push(1)    ->  [1]
        ADTStack s_psh_e = createS();
        assertEquals("[1]", s_psh_e.push(1).toString());
        // [1,2].push(3)    ->  [1,2,3]
        ADTStack s_psh_12 = createS().push(1).push(2);
        assertEquals("[1,2,3]", s_psh_12.push(3).toString());
        // [1,2].push(3.25)    ->  [1,2]
        s_psh_12 = createS().push(1).push(2);
        //assertEquals(s_psh_12, s_psh_12.push(3.25));
        //!!!!!!!!!geht nicht, weil kein int übergeben wird
        ADTStack s_big = createS();
        int big = 10000;
        for (int i = 1; i <= big; i++) {
            s_big.push(i);
        }
    }

    /**
     * Test of pop method, of class ADTStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        // [ ].pop()    ->  [ ]
        ADTStack s_pop_e = createS();
        assertEquals(s_pop_e, s_pop_e.pop());
        // [1,2,3].pop()    ->  [1,2]
        ADTStack s_pop_12 = createS().push(1).push(2);
        ADTStack s_pop_123 = createS().push(1).push(2).push(3);
        assertEquals(s_pop_12.toString(), s_pop_123.pop().toString());
        // [1].pop()    ->  [ ] ZUSAETZLICH
        s_pop_e = createS();
        ADTStack s_pop_1 = createS().push(1);
        assertEquals(s_pop_e.toString(), s_pop_1.pop().toString());
    }

    /**
     * Test of top method, of class ADTStack.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        // [ ].top()    ->  -1
        ADTStack s_top_e = createS();
        assertEquals(-1, s_top_e.top());
        // [1,2,3]top()    ->  3
        ADTStack s_top_123 = createS().push(1).push(2).push(3);
        assertEquals(3, s_top_123.top());
    }
}
