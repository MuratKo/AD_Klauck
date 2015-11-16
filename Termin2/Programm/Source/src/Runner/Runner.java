package Runner;

import Algorithmus.Insertionsort;
import Algorithmus.InsertionsortMeasurement;
import Exceptions.NoFileSelectedException;
import Helper.Reader;
import Helper.SortNum;
import adtarray.ADTArray;
import adtliste.ADTList;


public class Runner {

	
	public static void main(String[] args) {
		
		try {
			
			SortNum.sortNum(3, true);
			
			
			ADTArray array = Reader.reader();
			
			InsertionsortMeasurement.insertionsort(array, 0, array.lengthA());
			
			System.out.println("read: " + InsertionsortMeasurement.getRead());
			System.out.println("write: " + InsertionsortMeasurement.getWrite());
			System.out.println("time: " + InsertionsortMeasurement.getTime() + "ms");
			
		} catch (NoFileSelectedException e) {
			System.out.println("Es wurde keine Datei ausgewählt!");
		} 
		
	}

}
