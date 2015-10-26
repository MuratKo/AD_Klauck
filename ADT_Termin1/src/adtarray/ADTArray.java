package adtarray;

import adtliste.ADTList;

public class ADTArray {
/*
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
		//L�nger nur erh�hen, wenn pos gr��er ist als die L�nge des Arrays
		if(length < pos){
			length = pos;
		}
		return this;
	}
	
		//Array vergr��ern
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
*/
	ADTList internalViewOfArray;
	
	private int length;
	
	private int actualArraySize;
	
	public static ADTArray initA(){
		return new ADTArray();
	}
	
	

	private ADTList getInternalViewOfArray() {
		return internalViewOfArray;
	}



	private void setInternalViewOfArray(ADTList internalViewOfArray) {
		this.internalViewOfArray = internalViewOfArray;
	}



	private int getLength() {
		return length;
	}



	private void setLength(int length) {
		this.length = length;
	}



	private int getActualArraySize() {
		return actualArraySize;
	}



	private void setActualArraySize(int actualArraySize) {
		this.actualArraySize = actualArraySize;
	}



	private ADTArray(){
		internalViewOfArray = ADTList.create();
		length = 0;
		actualArraySize = 100;
		
		//Array zunächst mit 0 befüllen (bis actualArraySize)
		//  -- Liste fängt bei Position 1 an Array bei 1 --
		for(int i = 1; i < actualArraySize; i++){
			internalViewOfArray = internalViewOfArray.insert(0, i);
			
		}
	}
	
	//ADTArray kopieren
	private ADTArray copy(){
		ADTArray arrayToReturn = ADTArray.initA();
		arrayToReturn.setActualArraySize(this.getActualArraySize());
		arrayToReturn.setInternalViewOfArray(this.getInternalViewOfArray());
		arrayToReturn.setLength(this.getLength());
		
		return arrayToReturn;
	}
	
	public ADTArray setA(int pos, int elem){
		//bei Ungültiger Position, Array unverändert zurück geben
		if(pos < 0){
			return this;
		}
		ADTArray arrayToReturn = this.copy();
		
		//Testen ob pos über der befüllten Position der Liste ligt
		arrayReachedLimit(arrayToReturn, pos);
		
		//Attribute der Kopie intern übernehmen
		//Attribute werden mit dem prefix "array" deklariert
		ADTList arrayInternalViewOfArray = arrayToReturn.getInternalViewOfArray();
		int arrayLength = arrayToReturn.getLength();
		int arrayActualArraySize = arrayToReturn.getActualArraySize();
		
		//ACHTUNG!! 
		//ADTArray erste Position = 0
		//ADTLis erste Position = 1
		int posInArray = pos;
		int posInList = pos + 1;
		
		//Array arbeitet destruktiv
		//1. Schritt: elem in der position posInList löschen
		arrayInternalViewOfArray = arrayInternalViewOfArray.delete(posInList);
		
		//2. Schritt: elem in der position posInList einfügen
		arrayInternalViewOfArray = arrayInternalViewOfArray.insert(elem, posInList);
		
		
		
		//länge des Arrays erhöhen, falls pos größer ist als length
		if(posInArray >= arrayLength){
			arrayLength = posInArray + 1;
		}
		
		
		//neue Werte array übergeben
		arrayToReturn.setActualArraySize(arrayActualArraySize);
		arrayToReturn.setInternalViewOfArray(arrayInternalViewOfArray);
		arrayToReturn.setLength(arrayLength);
		
		
		
		return arrayToReturn;
	}
	
	//Bei falscher Parameter eingabe
	public ADTArray setA(Object pos, Object elem){
		return this;
	}

	public int getA(int pos){
		arrayReachedLimit(this, pos);
		
		
		
		//ACHTUNG!! 
		//ADTArray erste Position = 0
		//ADTLis erste Position = 1
		int posInArray = pos;
		int posInList = pos + 1;
				
		//Attribute intern übernehmen
		//Attribute werden mit dem prefix "array" deklariert
		ADTList arrayInternalViewOfArray = this.getInternalViewOfArray();
		int arrayLength = this.getLength();
		int arrayActualArraySize = this.getActualArraySize();
		
		//Wenn position natürliche zahl inkl. null ist, element aus der Liste zurückgeben
		if(posInArray >= 0){
			return arrayInternalViewOfArray.retrieve(posInList);
		}
		
		//-1 bei falschem Parameter
		return -1;
	}

	public int lengthA(){
		
		if(this.getLength() > 0){
			return this.getLength();
		}
		
		return -1;
	}
	
	
	private void arrayReachedLimit(ADTArray array, int pos) {
		//ACHTUNG!! 
		//ADTArray erste Position = 0
		//ADTLis erste Position = 1
		int posInArray = pos;
		int posInList = pos + 1;
		
		//Attribute der Kopie intern übernehmen
		//Attribute werden mit dem prefix "array" deklariert
		ADTList arrayInternalViewOfArray = array.getInternalViewOfArray();
		int arrayLength = array.getLength();
		int arrayActualArraySize = array.getActualArraySize();
		
		//Falls position über der letzten befüllten position in der Liste liegt
		if(posInList > arrayInternalViewOfArray.laenge()){
			for(int i = arrayInternalViewOfArray.laenge(); i <= posInList; i++){
				//array bis zu dieser position mit 0 befüllen
				arrayInternalViewOfArray = arrayInternalViewOfArray.insert(0, i);
			}
			//arrayActualSize auf posInList erhöhen
			arrayActualArraySize = posInList;
			
			//neue Werte array übergeben
			array.setActualArraySize(arrayActualArraySize);
			array.setInternalViewOfArray(arrayInternalViewOfArray);
		}
	}
	
	
}
