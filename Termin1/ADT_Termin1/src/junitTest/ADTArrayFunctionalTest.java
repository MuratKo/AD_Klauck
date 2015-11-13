package junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import adtarray.ADTArray;
import adtliste.ADTList;

public class ADTArrayFunctionalTest {

	ADTArray array;
	
	@Before
	public void setUp() throws Exception {
		array = ADTArray.initA();
	}
	
	@Test
	public void initATest() {
		assertEquals(0, array.lengthA());
	}
	
	@Test
	public void setATest(){
		array = array.setA(0, 1);
		assertEquals(1, array.getA(0));
		
		array = ADTArray.initA();
		assertEquals(0, array.lengthA());
		
		array = array.setA(5, 1);
		assertEquals(0, array.getA(0));
		assertEquals(0, array.getA(1));
		assertEquals(0, array.getA(2));
		assertEquals(0, array.getA(3));
		assertEquals(0, array.getA(4));
		assertEquals(1, array.getA(5));
		
		array = ADTArray.initA();
		assertEquals(0, array.lengthA());
		
		array = array.setA(0, 1);
		array = array.setA(1, 2);
		array = array.setA(2, 3);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		assertEquals(3, array.getA(2));
		
		array = array.setA(1, 5);
		
		assertEquals(1, array.getA(0));
		assertEquals(5, array.getA(1));
		assertEquals(3, array.getA(2));
		
		array = ADTArray.initA();
		assertEquals(0, array.lengthA());
		
		array = array.setA(0, 1);
		array = array.setA(1, 2);
		array = array.setA(2, 3);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		assertEquals(3, array.getA(2));
		
		array = array.setA(-1, 5);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		assertEquals(3, array.getA(2));
		
		array = array.setA(1, 5.4);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		assertEquals(3, array.getA(2));
		
		array = array.setA("h", 1.2);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		assertEquals(3, array.getA(2));
		
		
		array = ADTArray.initA();
		assertEquals(0, array.lengthA());
		
		for(int i = 0; i <= 10000; i++){
			array = array.setA(i, i);
		}
		
		array = array.setA(500, 9999);
		
		assertEquals(9999, array.getA(500));
		
		assertEquals(499, array.getA(499));
		assertEquals(501, array.getA(501));
		
		assertEquals(10000, array.getA(10000));
		
		assertEquals(0, array.getA(10001));
		
	}
	
	@Test
	public void getATest(){
		
		assertEquals(0, array.getA(0));
		
		array = array.setA(0, 1);
		array = array.setA(1, 2);
		array = array.setA(2, 3);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		assertEquals(3, array.getA(2));
		
		assertEquals(-1, array.getA(-1));
	}
	
	@Test
	public void lengthATest(){
		assertEquals(0, array.lengthA());
		
		array = array.setA(0, 1);
		array = array.setA(1, 2);
		array = array.setA(2, 3);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		assertEquals(3, array.getA(2));
		
		assertEquals(3, array.lengthA());
	}
}
