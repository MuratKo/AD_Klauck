package adt;

import helper.TextUmwandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		
		
		try{
			String[] text = TextUmwandler.umwandeln("C:/Users/abp516.INFORMATIK/Desktop/GitHub/AD_Klauck/Termin4/Text/texta.txt");
			ADTHashmap map = ADTHashmap.create(text.length, Strategy.L);
			System.out.println(map.getM());
			
			
			
		}catch(FileNotFoundException e){
			System.err.println("File wurde nicht gefunden");
		} catch (Exception e) {
			System.err.println("Text konnte nicht gesplittet werden!");
		} 
		
		
		
	}

}
