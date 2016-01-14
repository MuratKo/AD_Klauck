package programm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import exception.TextNotSplittedException;
import helper.TextUmwandler;
import adt.ADTHashmap;
import adt.Strategy;

public class Programm {

	private String pfad;
	private String filename;
	private Strategy strategy;
	private String[] text;
	private File file;
	private ADTHashmap map;
	private ArrayList<String> listofWords;
	
	//Eigentlicher Aufruf des Programmes
	public Programm(String filename, Strategy strategy){
		pfad = filename.substring(0, filename.lastIndexOf('/') + 1);
		this.filename = filename.substring(filename.lastIndexOf('/') + 1);
		this.strategy = strategy;
		this.listofWords = new ArrayList<>();
		
		try {
			this.text = TextUmwandler.umwandeln(this.pfad + this.filename);
		} catch (TextNotSplittedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		insertDataIntoHashMap();
		createFile();
		writeFile();
	}

	
	private void insertDataIntoHashMap() {
		map = ADTHashmap.create(text.length, strategy);
		map.setZaehler(0);
		for(int i = 0; i < text.length; i++){
			map = map.insert(text[i]);
			if(!listofWords.contains(text[i])){
				listofWords.add(text[i]);
			}
		}
	}

	private void writeFile() {
		int x = 0;
		try {
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.write("Dieses ist die Log-Datei des Files: " + filename + "\n\n");
			
			for(String word : listofWords){
				x += map.find(word);
				writer.write(word + " -> " + map.find(word) + "\n");
				//System.out.println(word + " -> " + map.find(word) );
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createFile() {
		String filenameWithoutending = filename.substring(0, filename.lastIndexOf('.') );
		
		file = new File(this.pfad + filenameWithoutending + ".log" );
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getZaehler(){
		return map.getZaehler();
	}
	
}
