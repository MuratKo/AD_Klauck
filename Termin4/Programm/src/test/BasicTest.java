package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.ADTHashmap;
import adt.Strategy;

public class BasicTest {

	private ADTHashmap hashmap;
	@Before
	public void setUp() throws Exception {
		hashmap = ADTHashmap.create(101, Strategy.Q);
	}

	@Test
	public void test() {
//		hashmap.insert("hallo");
//		hashmap.insert("hallo");
//		System.out.println("Key: " + hashmap.getMap()[35].getKey());
//		System.out.println("Value: " + hashmap.getMap()[35].getValue());
//		
//		hashmap.insert("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		hashmap.insert("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		System.out.println("Key: " + hashmap.getMap()[34].getKey());
//		System.out.println("Value: " + hashmap.getMap()[34].getValue());
//		
//		hashmap.insert("abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
//		hashmap.insert("abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
//		System.out.println("Key: " + hashmap.getMap()[39].getKey());
//		System.out.println("Value: " + hashmap.getMap()[39].getValue());
//		
//		hashmap.insert("acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
//		hashmap.insert("acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
//		hashmap.insert("acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
//		hashmap.insert("acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
//		hashmap.insert("acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
//		hashmap.insert("acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
//		hashmap.insert("acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
//		hashmap.insert("acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
//		System.out.println("Key: " + hashmap.getMap()[26].getKey());
//		System.out.println("Value: " + hashmap.getMap()[26].getValue());
	}

}
