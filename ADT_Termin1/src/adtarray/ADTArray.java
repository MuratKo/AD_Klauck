package adtarray;

import adtliste.ADTListe;

public class ADTArray {

	private final int ARRAY_SIZE = 100;
	
	private int oldArraySize = ARRAY_SIZE;
	
	ADTListe list;
	private int length;
	
	private ADTArray(){
		list = ADTListe.create();
		length = -1;
		
		for(int i = 1; i <= ARRAY_SIZE; i++){
			list.insert(i, 0);
		}
	}
	
	public static ADTArray initA(){
		return new ADTArray();
	}
	
	public void setA(int pos, int elem){
		arrayReachedLimit(pos);
		list.delete(pos+1);
		list.insert(pos+1, elem);
		if(length < pos){
			length = pos;
		}
	}
	
	private void arrayReachedLimit(int pos) {
		pos++;
		if(pos > oldArraySize -10 ){
			int newArraySize = oldArraySize + ARRAY_SIZE + pos;
			for(int i = list.laenge()+1; i <= newArraySize; i++){
				list.insert(i, 0);
			}
			oldArraySize = newArraySize;
		}
	}

	public int getA(int pos){
		
		if(pos < 0){
			return 0;
		}
		
		pos++;
		arrayReachedLimit(pos);
		return list.retrieve(pos);
	}
	
	public int lengthA(){
		return length;
	}

	
}
