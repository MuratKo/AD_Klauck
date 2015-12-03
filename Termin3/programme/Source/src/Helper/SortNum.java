package Helper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class SortNum {
	
	private static int numberRange = 1000;
	
	public static File sortNum(int anzahlZahlen, String path, Parameter parameter){
		
		String defaultPath = "/home/murat/Dokumente/Uni/AD/Termin3/programme/zahlen/test.dat";
		
		if(path.isEmpty()) path = defaultPath;
		
		File file = new File(path);
		
		File newFile = null;
		switch(parameter){
			case RANDOM_WITH_DUPLICATES:
				newFile = createFileWithDoubleNumbers(file, anzahlZahlen);
			break;
			case RANDOM_WITHOUT_DUPLICATES:
				newFile = createFileWithoutDoubleNumbers(file, anzahlZahlen);
			break;
			case BEST_CASE:
				newFile = sortNumWorstBaseCase(anzahlZahlen, path ,true);
			break;
			case WORSE_CASE:
				newFile = sortNumWorstBaseCase(anzahlZahlen, path ,false);
			break;
		}
		
		return newFile;
		
	}
	
	private static File createFileWithoutDoubleNumbers(File file, int anzahlZahlen) {
		
		//falls anzahl der zufälligen zahlen ohne doppelte größer ist als numberrange muss numberrange angepasst werden
		if(anzahlZahlen > numberRange) numberRange = anzahlZahlen+500;
		
		ArrayList<Integer> l = new ArrayList<>();
		
		try {
			file.createNewFile();
			
			PrintWriter writer = new PrintWriter(file);
			
			Random rand = new Random();
			int number;
			for(int i = 1; i <= anzahlZahlen; i++){
				while(true){
				number = rand.nextInt(numberRange) + 0;
					if(!l.contains(number)){
						l.add(number);
						writer.write(number + " ");
						break;
					}
				}
			}
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	private static File createFileWithDoubleNumbers(File file, int anzahlZahlen) {
		
		try {
			file.createNewFile();
			
			PrintWriter writer = new PrintWriter(file);
			
			Random rand = new Random();
			int number;
			for(int i = 1; i <= anzahlZahlen; i++){
				number = rand.nextInt(numberRange) + 0;
				writer.write(number + " ");
			}
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	private static File sortNumWorstBaseCase(int anzahlZahlen, String path ,boolean bool){
		//File file = new File("/home/murat/Dokumente/Uni/AD/zahlen/z.dat");
		
		String defaultPath = "/home/murat/Dokumente/Uni/AD/Termin3/programme/zahlen/test.dat";
		
		if(path.isEmpty()) path = defaultPath;
		
		
		File file = new File(path);
		
		try {
			file.createNewFile();
			
			PrintWriter writer = new PrintWriter(file);
			
			if(bool){
				//Zahlen sortiert
				
				for(int i = 1; i <= anzahlZahlen; i++){
					writer.write(i + " ");
				}
				
			}else{
				//Zahlen umgekehrt sortiert
				
				for(int i = anzahlZahlen; i >= 1; i--){
					writer.write(i + " ");
				}
			}
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public enum Parameter{
		RANDOM_WITH_DUPLICATES, RANDOM_WITHOUT_DUPLICATES, BEST_CASE, WORSE_CASE;
	}

}
