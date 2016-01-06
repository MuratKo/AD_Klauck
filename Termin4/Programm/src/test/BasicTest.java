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
		hashmap = ADTHashmap.create(10, Strategy.L);
	}

	@Test
	public void test() {
		hashmap.insert("123");
		System.out.println(hashmap);
	}

}
