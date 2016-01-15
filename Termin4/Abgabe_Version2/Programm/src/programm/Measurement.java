package programm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import adt.ADTHashmap;
import adt.ADTHashmapMeasurement;
import adt.Strategy;
import exception.TextNotSplittedException;
import helper.TextBuilder;
import helper.TextUmwandler;

public class Measurement {

	final static String PATH = "Z:/win7/Sem_3/AD/AD_Klauck/Termin4/Text/";

	
	public static void main(String[] args) throws TextNotSplittedException, IOException {
		int letzteMessung = 64000;
		
		//Messung mit Linearer Sondierung
//		File file = new File(PATH + "messungLOptimiert.csv");
//		file.createNewFile();
//		PrintWriter writer = new PrintWriter(file);
//		
//		writer.write("500;1000;2000;4000;8000;16000;32000;64000;\n");
//		
//		
//		for(int i = 500; i <= letzteMessung; i=i*2 ){
//			ADTHashmapMeasurement mapL;
//			messung(i, Strategy.L, writer, mapL = null);
//		}
//		
//		writer.close();
		
		//Messung mit Quadratischer Sondierung
		File file = new File(PATH + "messungQOptimiert.csv");
		file.createNewFile();
		PrintWriter writer = new PrintWriter(file);
		
		writer.write("500;1000;2000;4000;8000;16000;32000;64000;\n");
		
		for(int i = 500; i <= letzteMessung; i=i*2 ){
			ADTHashmapMeasurement mapQ = null;
			messung(i, Strategy.Q, writer, mapQ);
		}
		
		writer.close();
		
		//Messung mit Doublehashing Sondierung
//		File file = new File(PATH + "messungBOptimiert.csv");
//		file.createNewFile();
//		PrintWriter writer = new PrintWriter(file);
//		
//		writer.write("500;1000;2000;4000;8000;16000;32000;64000;\n");
//				
//		for(int i = 500; i <= letzteMessung; i=i*2 ){
//			ADTHashmapMeasurement mapB = null;
//			messung(i, Strategy.B, writer, mapB);
//		}
//				
//		writer.close();
	}

	private static void messung(int anzahl, Strategy strategy, PrintWriter writer, ADTHashmapMeasurement map) throws TextNotSplittedException, IOException {
		String filename = "test"+anzahl+".txt";
		String[] text = TextUmwandler.umwandeln(PATH + filename);
		long timeInsert = 0;
		long timeFind = 0;
		map = ADTHashmapMeasurement.create(anzahl, strategy);
		for(String word : text){
			map.insert(word);
			timeInsert += map.getTimeInsert();
		}
		DecimalFormat df = new DecimalFormat("#.00"); 
		String timeInMilli = df.format(Double.valueOf(timeInsert) / 1000000);
		writer.write(timeInMilli + ";");
	}

	
	

}
