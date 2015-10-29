package junitTestTeam13;

import adtliste.ADTList;
import static adtliste.ADTList.create;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Test of create method, of class ADTList.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        //create() -> [ ]
        ADTList adtl_crt_e = create();
        assertEquals("[]", adtl_crt_e.toString());
    }

    /**
     * Test of isEmpty method, of class ADTList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        //[ ].isEmpty() -> true
        ADTList adtl_ise_e = create();
        assertEquals(true, adtl_ise_e.isEmpty());
        //[1].isEmpty() -> false ZUSAETZLICH
        ADTList adtl_ise_1 = create().insert(1, 1);
        assertEquals(false, adtl_ise_1.isEmpty());
        //[1,2].isEmpty() -> false
        ADTList adtl_ise_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(false, adtl_ise_12.isEmpty());
    }

    /**
     * Test of laenge method, of class ADTList.
     */
    @Test
    public void testLaenge() {
        System.out.println("laenge");
        //[ ].laenge() -> 0
        ADTList adlt_lng_e = create();
        assertEquals(0, adlt_lng_e.laenge());
        //[1,2].laenge() -> 2
        ADTList adlt_lng_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(2, adlt_lng_12.laenge());
        //[9,3,6,1,12].laenge() -> 5 ZUSAETZLICH
        ADTList adlt_lng_936112 = create().insert(9, 1).insert(3, 2).insert(6, 3).insert(1, 4).insert(12, 5);
        assertEquals(5, adlt_lng_936112.laenge());
        ADTList adlt_lng_big = create();
        int big = 10000;
        for (int i = 1; i <= big; i++) {
            adlt_lng_big.insert(i, i);
        }
        assertEquals(big, adlt_lng_big.laenge());
    }

    /**
     * Test of insert method, of class ADTList.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        //[ ].insert(1,1) -> [1]
        ADTList adtl_ins_e = create();
        ADTList adtl_ins_1 = create().insert(1, 1);
        assertEquals(adtl_ins_1.toString(), adtl_ins_e.insert(1, 1).toString());
        //[ ].insert(1,5) -> [ ]
        adtl_ins_e = create();
        assertEquals(adtl_ins_e.toString(), adtl_ins_e.insert(1, 5).toString());
        //[1,2].insert(3,2) -> [1,3,2]
        ADTList adtl_ins_12 = create().insert(1, 1).insert(2, 2);
        ADTList adtl_ins_132 = create().insert(1, 1).insert(3, 2).insert(2, 3);
        assertEquals(adtl_ins_132.toString(), adtl_ins_12.insert(3, 2).toString());
        //[1,2].insert(3,3) -> [1,2,3] ZUSAETZLICH
        adtl_ins_12 = create().insert(1, 1).insert(2, 2);
        ADTList adtl_ins_123 = create().insert(1, 1).insert(2, 2).insert(3, 3);
        assertEquals(adtl_ins_123.toString(), adtl_ins_12.insert(3, 3).toString());
        //[1,2].insert(4,4) -> [1,2] ZUSAETZLICH
        adtl_ins_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(adtl_ins_12.toString(), adtl_ins_12.insert(4, 4).toString());
        //[1,2].insert(-1,4) -> [1,2] ZUSAETZLICH
        adtl_ins_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(adtl_ins_12.toString(), adtl_ins_12.insert(4, -1).toString());
        //[1,2].insert(0,4) -> [1,2] ZUSAETZLICH
        adtl_ins_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(adtl_ins_12.toString(), adtl_ins_12.insert(4, 0).toString());
    }

    /**
     * Test of delete method, of class ADTList.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        // [ ].delete(1)     ->  [ ]
        ADTList adtl_del_e = create();
        assertEquals(adtl_del_e.toString(), adtl_del_e.delete(1).toString());
        // [1,2].delete(0)  ->  [1,2]
        ADTList adtl_del_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(adtl_del_12.toString(), adtl_del_12.delete(0).toString());
        // [1,2].delete(1)  ->  [2]
        adtl_del_12 = create().insert(1, 1).insert(2, 2);
        ADTList adtl_del_2 = create().insert(2, 1);
        assertEquals(adtl_del_2.toString(), adtl_del_12.delete(1).toString());
        // [2].delete(1)  ->  [ ] ZUSAETZLICH
        assertEquals(adtl_del_e.toString(), adtl_del_2.delete(1).toString());
    }

    /**
     * Test of find method, of class ADTList.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        // [ ].find(1)       ->  -1
        ADTList adtl_fnd_e = create();
        assertEquals(-1, adtl_fnd_e.find(1));
        // [1,2].find(2)    ->  2
        ADTList adtl_fnd_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(2, adtl_fnd_12.find(2));
        // [1,2,2].find(2)  ->  2
        ADTList adtl_fnd_122 = create().insert(1, 1).insert(2, 2).insert(2, 3);
        assertEquals(2, adtl_fnd_122.find(2));
        // [1,3,2].find(2)  ->  3 ZUSAETZLICH
        ADTList adtl_fnd_132 = create().insert(1, 1).insert(3, 2).insert(2, 3);
        assertEquals(3, adtl_fnd_132.find(2));
    }

    /**
     * Test of retrieve method, of class ADTList.
     */
    @Test
    public void testRetrieve() {
        System.out.println("retrieve");
        // [ ].retrieve(0)       ->  -1
        ADTList adtl_rtr_e = create();
        assertEquals(-1, adtl_rtr_e.retrieve(0));
        // [ ].retrieve(1)       ->  -1
        adtl_rtr_e = create();
        assertEquals(-1, adtl_rtr_e.retrieve(1));
        // [1,2].retrieve(3)    ->  -1
        ADTList adtl_rtr_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(-1, adtl_rtr_12.retrieve(3));
        // [1,2,3].retrieve(2)  ->  2
        ADTList adtl_rtr_123 = create().insert(1, 1).insert(2, 2).insert(3, 3);
        assertEquals(2, adtl_rtr_123.retrieve(2));
    }

    /**
     * Test of concat method, of class ADTList.
     */
    @Test
    public void testConcat() {
        System.out.println("concat");
        // [ ].concat([ ])        ->  [ ]
        ADTList adtl_cnc_e = create();
        assertEquals(adtl_cnc_e.toString(), adtl_cnc_e.concat(adtl_cnc_e).toString());
        // [ ].concat([1,2])     ->  [1,2]
        adtl_cnc_e = create();
        ADTList adtl_cnc_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(adtl_cnc_12.toString(), adtl_cnc_e.concat(adtl_cnc_12).toString());
        // [1,2].concat([ ])     ->  [1,2]
        adtl_cnc_e = create();
        adtl_cnc_12 = create().insert(1, 1).insert(2, 2);
        assertEquals(adtl_cnc_12.toString(), adtl_cnc_12.concat(adtl_cnc_e).toString());
        // [1,2].concat([3,4])  ->  [1,2,3,4]
        adtl_cnc_12 = create().insert(1, 1).insert(2, 2);
        ADTList adtl_cnc_34 = create().insert(3, 1).insert(4, 2);
        ADTList adtl_cnc_1234 = create().insert(1, 1).insert(2, 2).insert(3, 3).insert(4, 4);
        assertEquals(adtl_cnc_1234.toString(), adtl_cnc_12.concat(adtl_cnc_34).toString());
        ADTList big1 = create();
        ADTList big2 = create();
        ADTList big3 = create();
        int big = 10000;
        int small = 10;
        for (int i = 1; i <= small; i++) {
            big1.insert(1, i);
            big3.insert(1, i);
        }
        for (int i = 1; i <= big; i++) {
            big2.insert(2, i);
        }
        for (int i = small + 1; i <= big + small; i++) {
            big3.insert(2, i);
        }
        assertEquals(big3.toString(), big1.concat(big2).toString());
    }
}
