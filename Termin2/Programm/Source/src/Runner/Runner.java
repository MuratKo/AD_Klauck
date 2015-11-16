package Runner;

import Algorithmus.Insertionsort;
import Exceptions.NoFileSelectedException;
import Helper.Reader;
import Helper.SortNum;
import adtarray.ADTArray;
import adtliste.ADTList;


public class Runner {

	
	public static void main(String[] args) {
		
		try {
			
			SortNum.sortNum(10);
			
			
			ADTArray array = Reader.reader();
			
			
			
			
			for(int i = 0; i < array.lengthA(); i++){
				System.out.println(array.getA(i));
			}
			
			System.out.println("\n");
			array = Insertionsort.insertionsort(array,0,array.lengthA());
			
			for(int i = 0; i < array.lengthA(); i++){
				System.out.println(array.getA(i));
			}
			
		} catch (NoFileSelectedException e) {
			System.out.println("Es wurde keine Datei ausgewählt!");
		} 
		
	}

}
