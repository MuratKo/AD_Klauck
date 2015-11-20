package quicksort;

import quicksortLaufzeit.QuicksortOnlyLaufzeit;
import quicksortOhneInsertionsort.QuicksortOnly;
import quicksortReadWriteCount.QuicksortOnlyReadWriteCount;
import statistik.CountReadWrite;
import statistik.Laufzeit;
import adtarray.ADTArray;
import einleser.Einleser;
import Algorithmus.Insertionsort;

public class Main {

	public static void main(String[] args) {
		
		
		//ADTArray a = ADTArray.initA();
		ADTArray b = ADTArray.initA();
		
		//100 Zahlen, umgekehrt sortiert 100,99,..,1
		//Einleser ein = new Einleser("C:/Users/VAIO PRO/Documents/SortNumOf100_false.txt");
		//Einleser ein2 = new Einleser("C:/Users/VAIO PRO/Documents/GitHub/AD_Klauck/Termin2/Programm/zahlen.dat");
		//Einleser ein3 = new Einleser("C:/Users/VAIO PRO/Desktop/zahlen.htm");
		Einleser ein2 = new Einleser("C:/Users/VAIO PRO/Documents/GitHub/AD_Klauck/Termin2/Programm/zahlen/8000.dat");
		//64.000 -> ca. 38,7 s
		//a = ein.parse(a);
		//a = ein2.parse(a);
		b = ein2.parse(b);
		/*
		a = a.setA(0, 5);
		a = a.setA(1, 4);
		a = a.setA(2, 3);
		a = a.setA(3, 2);
		a = a.setA(4, 1);
		System.out.println("Laenge: "+a.lengthA());
		*/
		
		/*
		int p = 0;
		int anzahlZahlen = 10000;
		while(p < anzahlZahlen){
			b = b.setA(p, anzahlZahlen-p); //umgekehrt sortiert
			//b = b.setA(p, p+1); //sortiert
			p++;
		}
		*/
		
		System.out.println("Länge: "+b.lengthA());
		/*
		int o = 0;
		while(o < b.lengthA())
		{
			System.out.print(b.getA(o)+",");
			o++;
		}
		*/
		
		int i = 0;
		while(i < b.lengthA())
		{
			System.out.print(b.getA(i)+",");
			i++;
		}
		System.out.println();
		System.out.println("------------------------------------");
		//a = Quicksort.quicksort(a, quicksort.Quicksort.Pivotauswahl.LINKS);
		//a = Quicksort.quicksort(a, quicksort.Quicksort.Pivotauswahl.RECHTS);
		//a = Quicksort.quicksort(a, quicksort.Quicksort.Pivotauswahl.MEDIANOF3);
		
		//b = Quicksort.quicksort(b, quicksort.Quicksort.Pivotauswahl.RANDOM);
		//b = quicksortOhneInsertionsort.QuicksortOnly.quicksort(b, QuicksortOnly.Pivotauswahl.LINKS);
		
		b = quicksortLaufzeit.QuicksortOnlyLaufzeit.quicksort(b, QuicksortOnlyLaufzeit.Pivotauswahl.MEDIANOF3);
		
		//b = quicksortReadWriteCount.QuicksortOnlyReadWriteCount.quicksort(b, QuicksortOnlyReadWriteCount.Pivotauswahl.MEDIANOF3);
		
		int k = 0;
		while(k < b.lengthA())
		{
			System.out.print(b.getA(k)+",");
			k++;
		}
		System.out.println();
		System.out.println("Laufzeit :"+Laufzeit.getRuntimeInMS()+" ms");
		//System.out.println("Lesezugriffe :"+QuicksortOnlyReadWriteCount.getReadCounts());
		//System.out.println("Schreibzugriffe :"+QuicksortOnlyReadWriteCount.getWriteCounts());
		
		/*
		System.out.println("Position  0: "+a.getA(0));
		System.out.println("Position  1: "+a.getA(1));
		System.out.println("Position  2: "+a.getA(2));
		System.out.println("Position  3: "+a.getA(3));
		System.out.println("Position 99: "+a.getA(99));

		a = Insertionsort.insertionsort(a, 0, a.lengthA());
		
		System.out.println("-------------------------------");
		
		System.out.println("Position  0: "+a.getA(0));
		System.out.println("Position  1: "+a.getA(1));
		System.out.println("Position  2: "+a.getA(2));
		System.out.println("Position  3: "+a.getA(3));
		System.out.println("Position 97: "+a.getA(97));
		System.out.println("Position 98: "+a.getA(98));
		System.out.println("Position 99: "+a.getA(99));
		
		*/
	}

}
