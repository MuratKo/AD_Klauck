package Helper;

import java.io.*;
import adtarray.ADTArray;

public class EinleserTeam09 {
	
	public String dateiMitZahlen;
	private BufferedReader reader;
	
	public EinleserTeam09(String dateipfad) {
		dateiMitZahlen = dateipfad;
	}
	
	public void getReader(String filename) {
		try { 
			this.reader = new BufferedReader(new FileReader(new File(filename)));
		} catch (FileNotFoundException ex) {
			System.out.println(ex+"Leider keine Datei gefunden!");
		}
	
	}
	
	public ADTArray parse(ADTArray inArray) {
		try {
			if (new File(dateiMitZahlen).canRead()) {
				
				this.getReader(dateiMitZahlen);
			 
				String content = this.reader.readLine(); // Erste Zeile holen

					while (content != null) {
							String[] v = content.split(" ");
								for(String tmp:v){
									// String-Zahl in int umwandeln
									try {
										int tmp2 = Integer.parseInt(tmp);
										// Zahl in das Array einfuegen
										inArray = inArray.setA(inArray.lengthA(), tmp2);
										//System.out.println(tmp2+" wurde eingefügt");
										}
									catch (NumberFormatException e) {
										//System.out.println("Fehler");
										}
									
									}
							content = this.reader.readLine(); //Eine Zeile weiter
					}
			
					return inArray;
			}
	
			else {
				System.out.println("Fehler beim Einlesen");
				return inArray;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return inArray;
		}
    }

	

}
