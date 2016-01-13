package test;

import static org.junit.Assert.*;
import helper.TextUmwandler;

import org.junit.Before;
import org.junit.Test;

import adt.ADTHashmap;
import adt.Strategy;

public class TestFilesKlauck {
	
	ADTHashmap hashL;
	String[] textb;

	@Before
	public void setUp() throws Exception {
		textb = TextUmwandler.umwandeln("Z:/win7/3_Sem/AD_Klauck/Termin4/Text/textb.txt");
		hashL = ADTHashmap.create(textb.length, Strategy.L);
		for(int i = 0; i < textb.length; i++) {
			hashL = hashL.insert(textb[i]);
		}
	}

	@Test
	public void testLorem() {
		int tmp = hashL.find("Lorem");
		assertEquals(275,tmp);
	}
	
	@Test
	public void testDolores() {
		int tmp = hashL.find("dolores");
		assertEquals(137,tmp);
	}

}
