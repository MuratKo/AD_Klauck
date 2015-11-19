package quicksortReadWriteCount;

import adtarray.ADTArray;

public class QuicksortOnlyReadWriteCount {
	
	private static ADTArray array;
	private static int read;
	private static int write;
	
	public static ADTArray quicksort(ADTArray inArray, Pivotauswahl pivotAuswahl) {
		array = inArray;
		int iLinks = 0; //Index vom Element ganz links
		//System.out.println("iLinks: "+iLinks);
		int iRechts = inArray.lengthA()-1; //Index vom letzten Element
			readPlusOne();
		//System.out.println("iRechts: "+iRechts);
		quicksort_tmp(iLinks, iRechts, pivotAuswahl);
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
				readPlusOne();
			//System.out.println("Als Pivot ausgewaehlt: "+pivotElement);
			
			while(true)
			{
				while(array.getA(i) < pivotElement && i < iRechts) 
				{
					readPlusOne();
					i++;
				}
					readPlusOne();
				while(array.getA(j) >= pivotElement && j > iLinks) 
				{
					readPlusOne();
					j--;
				}
					readPlusOne();
				if(j <= i) {break;} //"CRASH of the Iterators"
				
				//Index-Pivot merken, wenn j <= i noch nicht erfüllt ist 
				if(pivotIndex == i) pivotIndex = j; 
				
				swap(i,j); //vertauschen
			}
			
			swap(i,pivotIndex); //Pivotelement in die Mitte tauschen 
				
			quicksort_tmp(iLinks,i-1,pivotAuswahl); 
			quicksort_tmp(i+1,iRechts,pivotAuswahl); 
			
		} //END IF
		
	}
	
	private static void swap(int i, int jORpivotIndex) {
		int elementVonPosI = array.getA(i);
			readPlusOne();
		int elementVonPosJ = array.getA(jORpivotIndex);
			readPlusOne();
		array = array.setA(i, elementVonPosJ);
			writePlusOne();
		array = array.setA(jORpivotIndex, elementVonPosI);
			writePlusOne();
		
	}
	
	private static int getMedianOf3(int iIndex, int jIndex) {

		int pivotIndex;
		int i = array.getA(iIndex);
		int j = array.getA(jIndex);
		int inDerMitteIndex = (int) (iIndex+jIndex)/2;
		int inDerMitte = array.getA(inDerMitteIndex);
		
		if(i>=inDerMitte && i>= j) {
			if(inDerMitte <= j) {
				pivotIndex = jIndex;
			}
			else {
				pivotIndex = inDerMitteIndex;
			}
		}
		else if(j>= i && j>=inDerMitte) {
			if(inDerMitte <= i) {
				pivotIndex = iIndex;
			}
			else {
				pivotIndex = inDerMitteIndex;
			}
		}
		else if(inDerMitte >=i && inDerMitte >=j)
			if(i <= j) {
				pivotIndex = jIndex;
			}
			else {
				pivotIndex = iIndex;
			}
		else {
			pivotIndex = iIndex;
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
	
	public static void readPlusOne() {
		read++;
	}
	
	public static void writePlusOne() {
		write++;
	}
	
	public static int getReadCounts() {
		return read;
	}
	
	public static int getWriteCounts() {
		return write;
	}

}
