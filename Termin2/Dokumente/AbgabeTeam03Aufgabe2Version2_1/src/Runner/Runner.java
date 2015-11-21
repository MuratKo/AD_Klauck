package Runner;


import adtarray.ADTArray;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Random;

import Algorithmus.Quicksort;
import Algorithmus.QuicksortOnlyLaufzeit;
import Algorithmus.QuicksortOnly;
import Algorithmus.Insertionsort;
import Algorithmus.InsertionsortMeasurement;
import Exceptions.NoFileSelectedException;
import Helper.EinleserTeam09;
import Helper.Reader;
import Helper.SortNum;

public class Runner {

	static EinleserTeam09 ein;

	public static void main(String[] args) {

		ein = new EinleserTeam09("C:/Users/abp516/Documents/AD_Klauck/Termin2/Programm/zahlen/zahlenKlauck.htm");
//		
		ADTArray arrayLinks = ADTArray.initA();
		ADTArray arrayRechts = ADTArray.initA();
		ADTArray arrayRandom = ADTArray.initA();
		ADTArray arrayMedian = ADTArray.initA();
//		
		
//		arrayLinks = ein.parse(arrayLinks);
//		arrayRechts = ein.parse(arrayRechts);
//		arrayRandom = ein.parse(arrayRandom);
//		arrayMedian = ein.parse(arrayMedian);
		
		for(int i = 0; i < 10000; i++){
			arrayLinks = arrayLinks.setA(i, 10000-i);
			arrayRechts = arrayRechts.setA(i, 10000-i);
			arrayRandom = arrayRandom.setA(i, 10000-i);
			arrayMedian = arrayMedian.setA(i, 10000-i);
		}
		
		
		arrayLinks = QuicksortOnlyLaufzeit.quicksort(arrayLinks, Algorithmus.QuicksortOnlyLaufzeit.Pivotauswahl.LINKS);
		
		System.out.println("Pivot ganz Links in: " + Statistik.Laufzeit.getRuntimeInMS() + " ms");
		
		arrayRechts = QuicksortOnlyLaufzeit.quicksort(arrayRechts, Algorithmus.QuicksortOnlyLaufzeit.Pivotauswahl.RECHTS);
		
		System.out.println("Pivot ganz Rechts in: " + Statistik.Laufzeit.getRuntimeInMS() + " ms");
		
		arrayRandom = QuicksortOnlyLaufzeit.quicksort(arrayRandom, Algorithmus.QuicksortOnlyLaufzeit.Pivotauswahl.RANDOM);
		
		
		System.out.println("Pivot Random in: " + Statistik.Laufzeit.getRuntimeInMS() + " ms");
		
		arrayMedian = QuicksortOnlyLaufzeit.quicksort(arrayMedian, Algorithmus.QuicksortOnlyLaufzeit.Pivotauswahl.MEDIANOF3);
		
		System.out.println("Pivot Median of 3 in: " + Statistik.Laufzeit.getRuntimeInMS() + " ms");
//		
		/*File file = new File(
				"C:/Users/abp516/Documents/AD_Klauck/Termin2/Programm/zahlen/csv/quicksortZahlenKlauck.csv");

		try {
			file.createNewFile();

			PrintWriter writer;

			writer = new PrintWriter(file);
			writer.write("Quicksort;500;1000;2000;4000;8000;16000;32000;64000;128000\n");
			writer.write("Laufzeit;");

			int anzahl = 128000;
			
			for (int i = 500; i <= anzahl; i = i * 2) {

				ein = new Einleser("C:/Users/abp516/Documents/AD_Klauck/Termin2/Programm/zahlen/"+ i + ".dat");

				ADTArray array = ADTArray.initA();

				array = ein.parse(array);

				array = quicksortLaufzeit.QuicksortOnlyLaufzeit.quicksort(array,quicksortLaufzeit.QuicksortOnlyLaufzeit.Pivotauswahl.LINKS);

				writer.write(statistik.Laufzeit.getRuntimeInMS() + ";");
				System.out.println(i + " ist fertig");
			}
			
			writer.write("\nLesezugriffe;");
			
			for (int i = 500; i <= anzahl; i = i * 2) {

				ein = new Einleser("C:/Users/abp516/Documents/AD_Klauck/Termin2/Programm/zahlen/"+ i + ".dat");

				ADTArray array = ADTArray.initA();

				array = ein.parse(array);

				array = QuicksortOnlyReadWriteCount.quicksort(array,quicksortReadWriteCount.QuicksortOnlyReadWriteCount.Pivotauswahl.LINKS);

				writer.write(QuicksortOnlyReadWriteCount.getReadCounts() + ";");
				System.out.println(i + " ist fertig");
			}
			
			writer.write("\nSchreibzugriffe;");
			
			for (int i = 500; i <= anzahl; i = i * 2) {

				ein = new Einleser("C:/Users/abp516/Documents/AD_Klauck/Termin2/Programm/zahlen/"+ i + ".dat");

				ADTArray array = ADTArray.initA();

				array = ein.parse(array);

				array = QuicksortOnlyReadWriteCount.quicksort(array,quicksortReadWriteCount.QuicksortOnlyReadWriteCount.Pivotauswahl.LINKS);

				writer.write(QuicksortOnlyReadWriteCount.getWriteCounts() + ";");
				System.out.println(i + " ist fertig");
			}
			
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
