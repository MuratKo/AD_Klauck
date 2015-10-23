package adtarray;

import adtliste.ADTList;

public class ADTArray {

	private final int ARRAY_SIZE = 100;
	
	private int oldArraySize = ARRAY_SIZE;
	
	ADTList list;
	private int length;
	
	private ADTArray(){
		list = ADTList.create();
		length = -1;
		
		for(int i = 0; i <= ARRAY_SIZE; i++){
			list.insert(0, i);
		}
	}
	
	public static ADTArray initA(){
		return new ADTArray();
	}
	
	//Setzt ein Element an gegebener Position in das Array
	public ADTArray setA(int pos, int elem){
		ADTList copyOfList = list;
		arrayReachedLimit(copyOfList, pos);
		list = list.delete(pos+1);
		list = list.insert(elem, pos+1);
		//Länger nur erhöhen, wenn pos größer ist als die Länge des Arrays
		if(length < pos){
			length = pos;
		}
		return this;
	}
	
		//Array vergrößern
		private void arrayReachedLimit(ADTList copyOfList, int pos) {
			int nextElemPos = pos++;
			if(nextElemPos > oldArraySize -10 ){
				int newArraySize = oldArraySize + ARRAY_SIZE + nextElemPos;
				for(int i = list.laenge()+1; i <= newArraySize; i++){
					list = list.insert(0, i);
				}
				oldArraySize = newArraySize;
			}
		}

	public int getOldArraySize() {
			return oldArraySize;
		}

		public void setOldArraySize(int oldArraySize) {
			this.oldArraySize = oldArraySize;
		}

		public ADTList getList() {
			return list;
		}

		public void setList(ADTList list) {
			this.list = list;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
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
