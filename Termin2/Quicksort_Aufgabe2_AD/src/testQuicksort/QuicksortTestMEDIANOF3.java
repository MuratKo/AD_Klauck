package testQuicksort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import quicksort.Quicksort;
import adtarray.ADTArray;

public class QuicksortTestMEDIANOF3 {
	
	ADTArray array;

	@Before
	public void setUp() throws Exception {
		array = ADTArray.initA();
	}

	//Grenzfaelle
	@Test
	public void test1Zahlen() {
		//sortiert
		array = array.setA(0, 1);
		array = array.setA(1, 2);
		array = Quicksort.quicksort(array, Quicksort.Pivotauswahl.MEDIANOF3);
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
	}
	@Test
	public void test2Zahlen() {

		//unsortiert
		array = array.setA(0, 2);
		array = array.setA(1, 1);
		array = Quicksort.quicksort(array, Quicksort.Pivotauswahl.MEDIANOF3);
		System.out.println(array.getA(0));
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
	}
	@Test
	public void test3Zahlen() {

		//gleich
		array = array.setA(0, 1);
		array = array.setA(1, 1);
		array = Quicksort.quicksort(array, Quicksort.Pivotauswahl.MEDIANOF3);
		assertEquals(1, array.getA(0));
		assertEquals(1, array.getA(1));
	}

	@Test
	public void test1000Zahlen(){
		
		//umgekehrt sortiert
		int elem = 1000;
		for(int i = 0; i < 1000; i++){
			array = array.setA(i, elem);
			elem--;
		}
		array = Quicksort.quicksort(array, Quicksort.Pivotauswahl.MEDIANOF3);
		
		for(int i = 0; i < 1000; i++){
			assertEquals(i+1, array.getA(i));
		}
		
		//sortiert
		array = ADTArray.initA();
		for(int i = 0; i < 1000; i++){
			array = array.setA(i, i);
		}
		array = Quicksort.quicksort(array, Quicksort.Pivotauswahl.MEDIANOF3);
		
		for(int i = 0; i < 1000; i++){
			assertEquals(i, array.getA(i));
		}
	}

	@Test
	public void testBelastung(){
		
		//Belastung mit 10.000
		int belastung = 10000;
		int elementMax = 1000;
		
		int p = 0;
		while(p < belastung){
			int element = (int) (Math.random()*elementMax);
			array = array.setA(p, element);
			p++;
		}

		array = Quicksort.quicksort(array, Quicksort.Pivotauswahl.MEDIANOF3);;

		for(int i = 0; i < array.lengthA()-1; i++){
			assertTrue(array.getA(i)<=array.getA(i+1));
		}
	}

}
