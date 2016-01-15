package test;

import static org.junit.Assert.*;
import helper.TextUmwandler;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import adt.ADTHashmapMeasurement;
import adt.Strategy;

public class TestFilesKlauck {
	
	static ADTHashmapMeasurement hashTextB, hashTextA, hashText0Words, hashTextCa100000Words;
	static String[] textb, texta, text0Words, textCa100000Words;

	@BeforeClass
	public static void setUpTextB() throws Exception {
		textb = TextUmwandler.umwandeln("Z:/win7/Sem_3/AD/AD_Klauck/Termin4/Text/textb.txt");
		hashTextB = ADTHashmapMeasurement.create(textb.length, Strategy.L);
		for(int i = 0; i < textb.length; i++) {
			hashTextB = hashTextB.insert(textb[i]);
		}
	}
	
	@BeforeClass
	public static void setUpTextA() throws Exception {
		texta = TextUmwandler.umwandeln("Z:/win7/Sem_3/AD/AD_Klauck/Termin4/Text/texta.txt");
		hashTextA = ADTHashmapMeasurement.create(texta.length, Strategy.L);
		for(int i = 0; i < texta.length; i++) {
			hashTextA = hashTextA.insert(texta[i]);
		}
	}
	
	@BeforeClass
	public static void setUpText0Words() throws Exception {
		text0Words = TextUmwandler.umwandeln("Z:/win7/Sem_3/AD/AD_Klauck/Termin4/Text/text0Words.txt");
		hashText0Words = ADTHashmapMeasurement.create(text0Words.length, Strategy.L);
		for(int i = 0; i < text0Words.length; i++) {
			hashText0Words = hashText0Words.insert(text0Words[i]);
		}
	}
	
	@BeforeClass
	public static void setUpTextCa100000Words() throws Exception {
		textCa100000Words = TextUmwandler.umwandeln("Z:/win7/Sem_3/AD/AD_Klauck/Termin4/Text/testCa100000.txt");
		hashTextCa100000Words = ADTHashmapMeasurement.create(textCa100000Words.length, Strategy.L);
		for(int i = 0; i < textCa100000Words.length; i++) {
			hashTextCa100000Words = hashTextCa100000Words.insert(textCa100000Words[i]);
		}
	}

	@Test
	public void testLoremTextA() {
		int tmp = hashTextA.find("Lorem");
		assertEquals(4,tmp);
	}
	
	@Test
	public void testDoloresTextA() {
		int tmp = hashTextA.find("dolores");
		assertEquals(2,tmp);
	}
	
	@Test
	public void testLoremTextB() {
		int tmp = hashTextB.find("Lorem");
		assertEquals(275,tmp);
	}
	
	@Test
	public void testDoloresTextB() {
		int tmp = hashTextB.find("dolores");
		assertEquals(137,tmp);
	}
	
	@Test
	public void testLoremText0Words() {
		int tmp = hashText0Words.find("Lorem");
		assertEquals(0,tmp);
	}
	
	@Test
	public void testDoloresText0Words() {
		int tmp = hashText0Words.find("dolores");
		assertEquals(0,tmp);
	}
	
	@Test
	public void testLoremTextCa100000() {
		int tmp = hashTextCa100000Words.find("Lorem");
		assertEquals(275*10,tmp);
	}
	
	@Test
	public void testDoloresTextCa100000() {
		int tmp = hashTextCa100000Words.find("dolores");
		assertEquals(137*10,tmp);
	}

}
