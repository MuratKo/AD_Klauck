package Algorithmus;

import adtarray.ADTArray;

public class Insertionsort {
	
	public static ADTArray insertionsort(ADTArray a, int start, int end){
		ADTArray array = a;
		
		int j, k;
		for(int i = start; i < end; i++){
			j = i;
			k = array.getA(i);
			while(array.getA(j-1) > k){
				
				
				array = array.setA(j, array.getA(j-1));
				j--;
			}
			//System.out.println(k);
			array = array.setA(j, k);
		}
		
		return array;
	}

}
