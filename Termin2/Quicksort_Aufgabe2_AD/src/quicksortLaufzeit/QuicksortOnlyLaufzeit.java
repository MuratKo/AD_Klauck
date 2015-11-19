package quicksortLaufzeit;

import adtarray.ADTArray;
import statistik.*;

public class QuicksortOnlyLaufzeit {
	
	private static ADTArray array;
	
	public static ADTArray quicksort(ADTArray inArray, Pivotauswahl pivotAuswahl) {
		
		Laufzeit.setStart(System.nanoTime());
		
		array = inArray;
		int iLinks = 0; //Index vom Element ganz links
		//System.out.println("iLinks: "+iLinks);
		int iRechts = inArray.lengthA()-1; //Index vom letzten Element
		//System.out.println("iRechts: "+iRechts);
		quicksort_tmp(iLinks, iRechts, pivotAuswahl);
		
		Laufzeit.setEnde(System.nanoTime());
		return array;
	}
	
	public static void quicksort_tmp(int iLinks, int iRechts, Pivotauswahl pivotAuswahl) {
		
		//print(array);
		
		int pivotIndex;
		int pivotElement;
		int i = iLinks; 
		int j = iRechts;
		
		if (iRechts > iLinks) { //solange noch mindestens 2 Elemente da sind
		
			//Index vom Pivot bestimmen
			switch (pivotAuswahl) {
				case LINKS:
					//System.out.println("Pivot LINKS wurde gewaelt!");
						pivotIndex = i;
						break;
				case RECHTS:
						pivotIndex = j;
						break;
				case MEDIANOF3:
						pivotIndex = getMedianOf3(i, j);
						break;
				case RANDOM:
						pivotIndex = getRandomZahl(i, j);
						break;
				default:
						System.out.println("          default wurde gewaehlt!");
						pivotIndex= i;
						break;
			}
			
			//Pivot-Element speichern
			pivotElement = array.getA(pivotIndex);
			//System.out.println("Als Pivot ausgewaehlt: "+pivotElement);
			
			while(true)
			{
				while(array.getA(i) < pivotElement && i < iRechts) 
				{
					i++;
				}
				while(array.getA(j) >= pivotElement && j > iLinks) 
				{
					//System.out.println("array.getA(j): "+array.getA(j));
					//System.out.println("j wird verkleinert"+j);
					j--;
				}
				if(j <= i) {break;} //"CRASH of the Iterators"
				
				//Index-Pivot merken, wenn j <= i noch nicht erf�llt ist 
				if(pivotIndex == i) pivotIndex = j; 
				
				swap(i,j); //vertauschen
			}
			
			swap(i,pivotIndex); //Pivotelement in die Mitte tauschen 
			//System.out.println("Pivotelement wurde getauscht");
			//print(array);
			//System.out.println("iLinks="+iLinks+" i="+i+ " j="+j);
			quicksort_tmp(iLinks,i-1,pivotAuswahl); 
			quicksort_tmp(i+1,iRechts,pivotAuswahl); 
			
		} //END IF
	
	}
	
	private static void swap(int i, int jORpivotIndex) {
		int elementVonPosI = array.getA(i);
		int elementVonPosJ = array.getA(jORpivotIndex);
		array = array.setA(i, elementVonPosJ);
		array = array.setA(jORpivotIndex, elementVonPosI);
		
	}
	
	private static int getMedianOf3(int i, int j) {
		int pivotIndex;
		int inDerMitte = (int) (i+j)/2;
		
		if(i>=inDerMitte && i>= j) {
			if(inDerMitte >= j) {
				pivotIndex = j;
			}
			else {
				pivotIndex = inDerMitte;
			}
		}
		else if(j>= i && j>=inDerMitte) {
			if(inDerMitte >= i) {
				pivotIndex = i;
			}
			else {
				pivotIndex = inDerMitte;
			}
		}
		else if(inDerMitte>=i && inDerMitte>=j)
			if(i>j) {
				pivotIndex = j;
			}
			else {
				pivotIndex = i;
			}
		else {
			pivotIndex = i;
		}
		return pivotIndex;
	}
	
	private static int getRandomZahl(int i, int j) {
		int diff = j-i; //Differenz
		int number = (int) ((Math.random()*diff)+i); //+i !!!
		//System.out.println("Random: "+number);
		return number;
	}
	
	private static void print(ADTArray array){
		int k = 0;
		while(k < array.lengthA())
		{
			System.out.print(array.getA(k)+",");
			k++;
		}
		System.out.println("---");
	}
	
	
	public enum Pivotauswahl {
		LINKS, RECHTS, MEDIANOF3, RANDOM;
	}

}
