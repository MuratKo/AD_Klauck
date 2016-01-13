package test;

import static org.junit.Assert.*;
import helper.TextBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import adt.Strategy;
import programm.Programm;

public class TestProgram {

	// ASCII von 65 - 122 (A bis z)
	
	
	Programm prog;
	final String PATH = "Z:/win7/3_Sem/AD_Klauck/Termin4/Text/";
	int anzahlAffe, anzahlMaus, anzahlGiraffe;
	
	@Before
	public void setUp() throws Exception {
		prog = new Programm(PATH + "testProg.txt" , Strategy.Q);
		
		File file = new File(PATH + "testGen1.txt");
		file.createNewFile();
		PrintWriter writer = new PrintWriter(file, "UTF-8");
		
		anzahlAffe = (int) (Math.random()*50+1); //1-10 (0.5 x 50 +1) = 26
		anzahlMaus = (int) (Math.random()*50+1);
		anzahlGiraffe = (int) (Math.random()*50+1);
		
		for(int i = 0; i < anzahlAffe; i++){
			writer.write("affe ");
		}
		
		for(int i = 0; i < anzahlMaus; i++){
			writer.write("maus ");
		}
		
		for(int i = 0; i < anzahlGiraffe; i++){
			writer.write("giraffe ");
		}
		
		
		writer.close();
		
		prog = new Programm(PATH + "testGen1.txt" , Strategy.Q);
		
		
		
		//ASCII Random words
		//String[] words = {"a","b","c","d","e","f","g","h","i","h","A","B","C"};
		
//		TextBuilder tbuilder = new TextBuilder(PATH , 1000);
//		String[] words = tbuilder.createWordList();
//		
//		File fa = tbuilder.createFile("test64000_1.txt", 64000);
//		
//		
//		prog = new Programm(PATH + "test128000.txt", Strategy.B);
		
	}
	public TestProgram() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Test
	public void test() {
		
		try {
			File file = new File(PATH  + "testProg.log");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String[] lines = new String[10];
			int index = 0;
			
			while((lines[index] = reader.readLine()) != null) {
				index++;
			}
			
			assertEquals("Nasilsin -> 10", lines[2]);
			assertEquals("kardesim -> 10", lines[3]);
			assertEquals("Gueleguele -> 10", lines[4]);
			assertEquals("Bu -> 10", lines[5]);
			assertEquals("benim -> 10", lines[6]);
			assertEquals("abim -> 10", lines[7]);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	@Test
	public void testGen() {
		
		try {
			File file = new File(PATH  + "testGen1.log");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String[] lines = new String[10];
			int index = 0;
			
			while((lines[index] = reader.readLine()) != null) {
				index++;
			}
			
			assertEquals("affe -> " + anzahlAffe, lines[2]);
			assertEquals("maus -> " + anzahlMaus, lines[3]);
			assertEquals("giraffe -> " + anzahlGiraffe, lines[4]);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

}
