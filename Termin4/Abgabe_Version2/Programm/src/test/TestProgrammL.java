package test;

import static org.junit.Assert.*;
import helper.TextBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import adt.Strategy;
import programm.Programm;

public class TestProgrammL {

	static Programm prog;
	 BufferedReader reader;
	final static String PATH = "Z:/win7/Sem_3/AD/AD_Klauck/Termin4/Text/";
	static int amaountOfWordsIn500 = 0;
	static int amaountOfWordsIn1000 = 0;
	static int amaountOfWordsIn2000 = 0;
	static int amaountOfWordsIn4000 = 0;
	static int amaountOfWordsIn8000 = 0;
	static int amaountOfWordsIn16000 = 0;
	static int amaountOfWordsIn32000 = 0;
	static int amaountOfWordsIn64000 = 0;

	
	@BeforeClass
	public static void setUp(){
		
		TextBuilder tbuilder = new TextBuilder(PATH, 500);
		tbuilder.createFile("test500.txt", 500);
		amaountOfWordsIn500 = tbuilder.getAmountOfDifferentWords();
		tbuilder.createFile("test1000.txt", 1000);
		amaountOfWordsIn1000 = tbuilder.getAmountOfDifferentWords();
		tbuilder.createFile("test2000.txt", 2000);
		amaountOfWordsIn2000 = tbuilder.getAmountOfDifferentWords();
		tbuilder.createFile("test4000.txt", 4000);
		amaountOfWordsIn4000 = tbuilder.getAmountOfDifferentWords();
		tbuilder.createFile("test8000.txt", 8000);
		amaountOfWordsIn8000 = tbuilder.getAmountOfDifferentWords();
		tbuilder.createFile("test16000.txt", 16000);
		amaountOfWordsIn16000 = tbuilder.getAmountOfDifferentWords();
		tbuilder.createFile("test32000.txt", 32000);
		amaountOfWordsIn32000 = tbuilder.getAmountOfDifferentWords();
		
		prog = new Programm(PATH + "test500.txt", Strategy.L);
		prog = new Programm(PATH + "test1000.txt", Strategy.L);
		prog = new Programm(PATH + "test2000.txt", Strategy.L);
		prog = new Programm(PATH + "test4000.txt", Strategy.L);
		prog = new Programm(PATH + "test8000.txt", Strategy.L);
		prog = new Programm(PATH + "test16000.txt", Strategy.L);
		prog = new Programm(PATH + "test32000.txt", Strategy.L);
		
	}
	
	@Test
	public void testLog500() {
		
		
		try {
			File file = new File(PATH + "test500.log");
			reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while(reader.readLine() != null){
				lines++;
			}
			assertEquals((lines - 2), amaountOfWordsIn500);
		} catch (FileNotFoundException e) {
			System.out.println("File konnte nicht gelesen werden");
		} catch (IOException e) {
			System.out.println("Reader fehler");
		}
	}
	
	@Test
	public void testLog1000() {
		
		
		try {
			File file = new File(PATH + "test1000.log");
			reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while(reader.readLine() != null){
				lines++;
			}
			assertEquals((lines - 2), amaountOfWordsIn1000);
		} catch (FileNotFoundException e) {
			System.out.println("File konnte nicht gelesen werden");
		} catch (IOException e) {
			System.out.println("Reader fehler");
		}
	}
	
	@Test
	public void testLog2000() {
		
		
		try {
			File file = new File(PATH + "test2000.log");
			reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while(reader.readLine() != null){
				lines++;
			}
			assertEquals((lines - 2), amaountOfWordsIn2000);
		} catch (FileNotFoundException e) {
			System.out.println("File konnte nicht gelesen werden");
		} catch (IOException e) {
			System.out.println("Reader fehler");
		}
	}
	
	@Test
	public void testLog4000() {
		
		
		try {
			File file = new File(PATH + "test4000.log");
			reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while(reader.readLine() != null){
				lines++;
			}
			assertEquals((lines - 2), amaountOfWordsIn4000);
		} catch (FileNotFoundException e) {
			System.out.println("File konnte nicht gelesen werden");
		} catch (IOException e) {
			System.out.println("Reader fehler");
		}
	}
	
	@Test
	public void testLog8000() {
		
		
		try {
			File file = new File(PATH + "test8000.log");
			reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while(reader.readLine() != null){
				lines++;
			}
			assertEquals((lines - 2), amaountOfWordsIn8000);
		} catch (FileNotFoundException e) {
			System.out.println("File konnte nicht gelesen werden");
		} catch (IOException e) {
			System.out.println("Reader fehler");
		}
	}
	
	@Test
	public void testLog16000() {
		
		
		try {
			File file = new File(PATH + "test16000.log");
			reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while(reader.readLine() != null){
				lines++;
			}
			assertEquals((lines - 2), amaountOfWordsIn16000);
		} catch (FileNotFoundException e) {
			System.out.println("File konnte nicht gelesen werden");
		} catch (IOException e) {
			System.out.println("Reader fehler");
		}
	}
	
	@Test
	public void testLog32000() {
		
		
		try {
			File file = new File(PATH + "test32000.log");
			reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while(reader.readLine() != null){
				lines++;
			}
			assertEquals((lines - 2), amaountOfWordsIn32000);
		} catch (FileNotFoundException e) {
			System.out.println("File konnte nicht gelesen werden");
		} catch (IOException e) {
			System.out.println("Reader fehler");
		}
	}
	


}
