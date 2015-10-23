package junitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adtarray.ADTArray;


public class ADTArrayTest {


	ADTArray array;
	ADTArray array2;
	
	@Before
	public void setUp() throws Exception {
		array = ADTArray.initA();
		array2 = ADTArray.initA();
	}

	@Test
	public void setATest() {
		array.setA(0, 8);
		array.setA(10, 9);
		
		array2.setA(6, 6);
		
		array.setA(1000, 4);
		assertEquals(8, array.getA(0));
		assertEquals(9, array.getA(10));
		assertEquals(4, array.getA(1000));
		assertEquals(0, array.getA(30000));
		assertEquals(9, array.getA(10));
		
		assertEquals(6, array2.getA(6));
		
		for(int i = 0; i < 10000; i++){
			array.setA(i, i);
		}
		
		for(int i = 0; i < 10000; i++){
			assertEquals(i, array.getA(i));
		}
		
	}
	
	@Test
	public void lengthATest() {
		assertEquals(-1, array.lengthA());//leeres array
		
		array.setA(0, 8);
		assertEquals(0, array.lengthA());
		
		array.setA(1, 8);
		assertEquals(1, array.lengthA());
		
		array.setA(10, 9);
		assertEquals(10, array.lengthA());
		
		array.setA(1000, 4);
		assertEquals(1000, array.lengthA());
		
		array.setA(1001, 5);
		array.getA(5000);
		assertEquals(1001, array.lengthA());
		
		
	}
	
	@Test
	public void getATest() {
		
		array.setA(0, 8);
		assertEquals(0, array.getA(-1));
		assertEquals(0, array.getA(-100));
	}
	
	
	

}
