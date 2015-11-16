package Algorithmus;

import adtarray.ADTArray;

public class InsertionsortMeasurement {
	
	private static int read = 0, write = 0;
	private static long time = 0;
	
	
	public static ADTArray insertionsort(ADTArray a, int start, int end){
		time = System.currentTimeMillis();
		read = 0;
		write = 0;
		ADTArray array = a;
		
		int j, k;
		for(int i = start; i < end; i++){
			j = i;
			k = array.getA(i);
			read++;
			while(array.getA(j-1) > k){
				read++;
				
				array = array.setA(j, array.getA(j-1));
				read++;
				write++;
				j--;
			}
			read++;
			//System.out.println(k);
			array = array.setA(j, k);
			write++;
		}
		time = System.currentTimeMillis() - time;
		
		return array;
	}

	public static int getRead() {
		return read;
	}

	public static int getWrite() {
		return write;
	}

	public static long getTime() {
		//time = time / 1000; // millisecons to seconds
		return time;
	}

	
	

}
