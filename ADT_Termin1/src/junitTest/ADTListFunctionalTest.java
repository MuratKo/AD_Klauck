package junitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adtliste.ADTList;

public class ADTListFunctionalTest {

	ADTList list, list2;
	
	@Before
	public void setUp() throws Exception {
		list = ADTList.create();
		list2 = ADTList.create();
	}

	
	
	@Test
	public void isEmptyTest() {
		assertTrue(list.isEmpty());	
		list = list.insert(1, 1);
		list = list.insert(1, 2);
		assertEquals(false,list.isEmpty());
	}
	
	@Test
	public void leangeTest() {
		assertTrue(list.isEmpty());	
		
		list = list.insert(1, 1);
		list = list.insert(1, 2);
		
		assertEquals(2, list.laenge());
		
		for(int i = 3; i <= 900; i++){
			list = list.insert(5, i);
		}
		list = list.insert(40, 6);
		assertEquals(901, list.laenge());
		
	}
	
	@Test
	public void insertTest() {
		list = list.insert(1, 5);
		assertTrue(list.isEmpty());	
		
		list = list.insert(1, 1);
		assertEquals(1, list.retrieve(1));
		
		list = list.insert(2, 2);
		list = list.insert(3, 2);
		
		assertEquals(1, list.retrieve(1));
		assertEquals(2, list.retrieve(3));
		assertEquals(3, list.retrieve(2));
		
	}
	
	@Test
	public void bulkTest() {
		
		for(int i = 1; i <= 15000; i++){
			list = list.insert(i, i);
		}
		
		assertEquals(15000, list.laenge());
		list = list.insert(9999,50);
		assertEquals(9999, list.retrieve(50));
		assertEquals(49, list.retrieve(49));
		assertEquals(50, list.retrieve(51));
		assertEquals(15001, list.laenge());
		
		for(int i = 60; i <= 100; i++){
			list = list.delete(60);
		}
		
		assertEquals(14960, list.laenge());
		
		assertEquals(100, list.retrieve(60));
	}
	
	@Test
	public void deleteTest() {
		
		assertTrue(list.isEmpty());	
		list.delete(1);
		assertTrue(list.isEmpty());	
		
		list = list.insert(1, 1);
		list = list.insert(2, 2);
		list = list.delete(0);
		assertEquals(1, list.retrieve(1));
		assertEquals(2, list.retrieve(2));
		
		list = list.insert(3, 3);
		list = list.insert(4, 4);
		list = list.delete(2);

		assertEquals(1, list.retrieve(1));
		assertEquals(3, list.retrieve(2));
		assertEquals(4, list.retrieve(3));
		
	}
	
	@Test
	public void findTest() {
		assertEquals(-1, list.find(1));
		
		list = list.insert(1, 1);
		list = list.insert(2, 2);
		
		assertEquals(2, list.find(2));
		
		list = list.insert(2, 3);
		
		assertEquals(2, list.find(2));		
	}
	
	@Test
	public void retrieveTest() {
		assertEquals(-1, list.retrieve(0));
		assertEquals(-1, list.retrieve(1));
		
		list = list.insert(1, 1);
		list = list.insert(2, 2);
		
		assertEquals(-1, list.retrieve(3));
		
		list = list.insert(2, 3);
		
		assertEquals(2, list.retrieve(2));
	}
	
	@Test
	public void concatTest() {
		list = list.concat(list2);
		assertTrue(list.isEmpty());
		
		list2 = list2.insert(1, 1);
		list2 = list2.insert(2, 2);
		
		list = list.concat(list2);
		
		assertEquals(1, list.retrieve(1));
		assertEquals(2, list.retrieve(2));
	}
	
	@Test
	public void concatTest2() {
		list = list.concat(list2);
		assertTrue(list.isEmpty());
		
		list = list.insert(1, 1);
		list = list.insert(2, 2);
		
		list = list.concat(list2);
		
		assertEquals(1, list.retrieve(1));
		assertEquals(2, list.retrieve(2));
		
		list2 = list2.insert(3, 1);
		list2 = list2.insert(4, 2);
		
		list = list.concat(list2);
		
		assertEquals(1, list.retrieve(1));
		assertEquals(2, list.retrieve(2));
		assertEquals(3, list.retrieve(3));
		assertEquals(4, list.retrieve(4));
	}
	
	
}
