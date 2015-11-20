package Helper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SortNum {
	
	public static void sortNum(int anzahlZahlen){
		JFileChooser chooser = new JFileChooser("C:/Users/abp516/Documents/AD_Klauck/Termin2/Programm/zahlen");
		//File file = new File("/home/murat/Dokumente/Uni/AD/zahlen/z.dat");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("ONLY .dat", "dat");
		chooser.setFileFilter(filter);
		
		chooser.showSaveDialog(null);
		
		File file = new File(chooser.getSelectedFile().getAbsolutePath());
		
		try {
			file.createNewFile();
			
			PrintWriter writer = new PrintWriter(file);
			
			Random rand = new Random();
			int number;
			for(int i = 1; i <= anzahlZahlen; i++){
				number = rand.nextInt(1000) + 0;
				writer.write(number + " ");
			}
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sortNum(int anzahlZahlen, boolean bool){
		JFileChooser chooser = new JFileChooser("/home/murat/Dokumente/Uni/AD/Termin2/Programm");
		//File file = new File("/home/murat/Dokumente/Uni/AD/zahlen/z.dat");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("ONLY .dat", "dat");
		chooser.setFileFilter(filter);
		
		chooser.showSaveDialog(null);
		
		File file = new File(chooser.getSelectedFile().getAbsolutePath());
		
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
	}

}
