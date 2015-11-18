package Test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import Algorithmus.Insertionsort;
import Algorithmus.InsertionsortMeasurement;
import adtarray.ADTArray;

public class InsertionsortTest {
	
	static ADTArray array;
	
	@BeforeClass
	public static void setUp(){
		array = ADTArray.initA();
	}

	//Grenzfälle
	
	@Test
	public void test2Zahlen() {
		//sortiert
		array = array.setA(0, 1);
		array = array.setA(1, 2);
		
		array = Insertionsort.insertionsort(array, 0, 2);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		
		//unsortiert
		array = array.setA(0, 2);
		array = array.setA(1, 1);
		
		array = Insertionsort.insertionsort(array, 0, 2);
		
		assertEquals(1, array.getA(0));
		assertEquals(2, array.getA(1));
		
		//gleich
		array = array.setA(0, 1);
		array = array.setA(1, 1);
		
		array = Insertionsort.insertionsort(array, 0, 2);
		
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
		
		array = Insertionsort.insertionsort(array, 0, 1000);
		
		for(int i = 0; i < 1000; i++){
			assertEquals(i+1, array.getA(i));
		}
		
		//sortiert
		array = ADTArray.initA();
		
		for(int i = 0; i < 1000; i++){
			array = array.setA(i, i);
		}
		
		array = Insertionsort.insertionsort(array, 0, 1000);
		
		for(int i = 0; i < 1000; i++){
			assertEquals(i, array.getA(i));
		}
	}

	//Belastung dauert zu lange
	
//	@Test
//	public void testBelastung(){
//		
//		//Belastung mit 10.000
//		int belastung = 50000;
//		Random rand = new Random();
//		int elem = belastung;
//		for(int i = 0; i < belastung; i++){
////			if(i == 40){
////				array = array.setA(i, 99999);
////			}else if(i == 300){
////				array = array.setA(i, 99999);
////			}else{
////				array = array.setA(i, i);
////			}
//			array = array.setA(i, i);
//			
//			elem--;
//		}
////		
//		array = Insertionsort.insertionsort(array, 0, belastung);
////		
////		int pre = array.getA(0);
//		for(int i = 0; i < belastung; i++){
//			//System.out.println(array.getA(i));
////			assertTrue(pre < array.getA(i));
////			pre = array.getA(i);
//		}
//	}
}
