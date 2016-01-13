package adt;

import helper.TextBuilder;
import helper.TextUmwandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import exception.TextNotSplittedException;

public class Main {
	
	public static void main(String[] args) {
		
//		
//		try{
//			String[] text = TextUmwandler.umwandeln("C:/Users/abp516/Desktop/GitHubNEU/AD_Klauck/Termin4/Text/textb.txt");
//			//String[] text = { "hallo", "hallo", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"};
//			ADTHashmap map = ADTHashmap.create(text.length, Strategy.B);
//			for(int i = 0; i < text.length; i++){
//				map = map.insert(text[i]);
//			}
//			
////			for (int i = 0 ; i <= text.length; i++){
////				System.out.print("i: " + i);
////				System.out.println(" -> " +map.getMap()[i].getKey());
////			}
//			
//		System.out.println(map.find("elitr"));
//			
//		}catch(FileNotFoundException e){
//			System.err.println("File wurde nicht gefunden");
//		} catch (TextNotSplittedException e) {
//			System.err.println("Text konnte nicht gesplittet werden!");
//		} catch (IOException e) {
//			System.err.println("IO");
//		} 
		
		TextBuilder tbuilder = new TextBuilder("Z:/win7/3_Sem/AD_Klauck/Termin4/Text/", 500);
		
		tbuilder.createFile("test500.txt", 500);
		tbuilder.createFile("test1000.txt", 1000);
		tbuilder.createFile("test2000.txt", 2000);
		tbuilder.createFile("test4000.txt", 4000);
		tbuilder.createFile("test8000.txt", 8000);
		tbuilder.createFile("test16000.txt", 16000);
		tbuilder.createFile("test32000.txt", 32000);
		
	}

}
