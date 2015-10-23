package junitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adtliste.ADTList;

public class ADTListeTest {

	ADTList list;
	ADTList list2;
	
	@Before
	public void setUp() throws Exception {
		list = ADTList.create();
		list2 = ADTList.create();
	}

	@Test
	public void isEmptyTest() {
		assertTrue(list.isEmpty());	
		list.insert(1, 5);
		assertEquals(false,list.isEmpty());
	}
	
	@Test
	public void leangeTest() {
		
		for(int i = 1; i <= 900; i++){
			list.insert(i, 5);
		}
		list.insert(40, 6);
		assertEquals(901, list.laenge());
		
	}
	
	@Test
	public void insertTest() {
		
		for(int i = 1; i <= 90; i++){
			list.insert(i, i);
		}
		list.insert(40, 6);
		assertEquals(6, list.retrieve(40));
		assertEquals(39, list.retrieve(39));
		assertEquals(40, list.retrieve(41)); // elem 40 steht an pos 41 (nach rechts verschoben)
		
	}
	
	@Test
	public void deleteTest() {
		
		for(int i = 1; i <= 90; i++){
			list.insert(i, i);
		}
		list.insert(40, 6);
		assertEquals(6, list.retrieve(40));
		
		list.delete(95);//Fehler sollte ignoriert werden
		
		list.delete(35);
		assertEquals(6, list.retrieve(39));
		
		assertEquals(34, list.retrieve(34));
		assertEquals(36, list.retrieve(35)); // elem 36 steht an pos 35 (nach links verschoben)
		
	}
	
	@Test
	public void findTest() {
		
		for(int i = 1; i <= 90; i++){
			list.insert(i, i);
		}
		list.insert(40, 6);
		
		assertEquals(6, list.find(6));
		assertNotEquals(40, list.find(6)); //Das Erste Element wird zurückgegeben
		
		list.insert(50, 900);
		assertEquals(50, list.find(900));
		
	}
	
	@Test
	public void retrieveTest() {
		
		for(int i = 1; i <= 90; i++){
			list.insert(i, i);
		}
		list.insert(40, 6);
		
		assertEquals(6, list.retrieve(40));
		assertEquals(82, list.retrieve(83));
		
	}
	
	@Test
	public void concatTest() {
		
		for(int i = 1; i <= 500; i++){
			list.insert(i, i);
		}
		

		for(int i = 1; i <= 500; i++){
			list2.insert(i, 500+i);
		}
		list.concat(list2);
		
		assertEquals(501, list.retrieve(501));
		assertEquals(499, list.retrieve(499));
		assertEquals(1000, list.retrieve(1000));
		
		
	}
	
}
