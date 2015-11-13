package adtarray;

import adtliste.ADTList;

public class ADTArray {

	ADTList internalViewOfArray;
	
	private int length;
	
	private int actualArraySize;
	
	//Array initialisieren
	public static ADTArray initA(){
		return new ADTArray();
	}

	private ADTArray(){
		internalViewOfArray = ADTList.create();
		length = 0;
		actualArraySize = 100;
		
		//Array zunaechst mit 0 befuellen (bis actualArraySize)
		//  -- Liste faengt bei Position 1 an Array bei 1 --
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
	
	//Element in Array einfuegen
	public ADTArray setA(int pos, int elem){
		//bei Ungueltiger Position, Array unveraendert zurueck geben
		if(pos < 0){
			return this;
		}
		ADTArray arrayToReturn = this.copy();
		
		//Testen ob pos ueber der befuellten Position der Liste liegt
		arrayReachedLimit(arrayToReturn, pos);
		
		//Attribute der Kopie intern Uebernehmen
		//Attribute werden mit dem prefix "array" deklariert
		ADTList arrayInternalViewOfArray = arrayToReturn.getInternalViewOfArray();
		int arrayLength = arrayToReturn.getLength();
		int arrayActualArraySize = arrayToReturn.getActualArraySize();
		
		//ACHTUNG!! 
		//ADTArray erste Position = 0
		//ADTList erste Position = 1
		int posInArray = pos;
		int posInList = pos + 1;
		
		//Array arbeitet destruktiv
		//1. Schritt: elem in der position posInList loeschen
		arrayInternalViewOfArray = arrayInternalViewOfArray.delete(posInList);
		
		//2. Schritt: elem in der position posInList einfaegen
		arrayInternalViewOfArray = arrayInternalViewOfArray.insert(elem, posInList);
		
		//laenge des Arrays erhoehen, falls pos groesser ist als length
		if(posInArray >= arrayLength){
			arrayLength = posInArray + 1;
		}
		
		//neue Werte array Uebergeben
		arrayToReturn.setActualArraySize(arrayActualArraySize);
		arrayToReturn.setInternalViewOfArray(arrayInternalViewOfArray);
		arrayToReturn.setLength(arrayLength);
		
		return arrayToReturn;
	}
	
	//Bei falscher Parametereingabe (Fehlerfall)
	public ADTArray setA(Object pos, Object elem){
		return this;
	}

	public int getA(int pos){
	
		if(this.lengthA() == 0 || pos >= this.lengthA()){
			return 0;
		}
		
		//arrayReachedLimit(this, pos);
		
		
		//ACHTUNG!! 
		//ADTArray erste Position = 0
		//ADTLis erste Position = 1
		int posInArray = pos;
		int posInList = pos + 1;
				
		//Attribute intern Uebernehmen
		//Attribute werden mit dem prefix "array" deklariert
		ADTList arrayInternalViewOfArray = this.getInternalViewOfArray();
		int arrayLength = this.getLength();
		int arrayActualArraySize = this.getActualArraySize();
		
		//Wenn position natuerliche zahl inkl. null ist, element aus der Liste zurueckgeben
		if(posInArray >= 0){
			return arrayInternalViewOfArray.retrieve(posInList);
		}
		
		//-1 bei falschem Parameter
		return -1;
	}

	public int lengthA(){
		
		if(this.getLength() >= 0){
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
		
		//Attribute der Kopie intern uebernehmen
		//Attribute werden mit dem prefix "array" deklariert
		ADTList arrayInternalViewOfArray = array.getInternalViewOfArray();
		int arrayLength = array.getLength();
		int arrayActualArraySize = array.getActualArraySize();
		
		//Falls position ueber der letzten befuellten position in der Liste liegt
		if(posInList > arrayInternalViewOfArray.laenge()){
			for(int i = arrayInternalViewOfArray.laenge(); i <= posInList; i++){
				//array bis zu dieser position mit 0 befuellen
				arrayInternalViewOfArray = arrayInternalViewOfArray.insert(0, i);
			}
			//arrayActualSize auf posInList erhoehen
			arrayActualArraySize = posInList;
			
			//neue Werte array uebergeben
			array.setActualArraySize(arrayActualArraySize);
			array.setInternalViewOfArray(arrayInternalViewOfArray);
		}
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
	
	 @Override
	    public boolean equals(Object o) {
	        if (o == this) return true;
	        if(o instanceof ADTArray){
	        	for(int i = 0; i < this.length; i++){
	        		//sobald ein Element nicht uebereinstimmt, return false
	        		if(!(((ADTArray) o).getA(i) == this.getA(i))) return false;
	        	}
	        }else{
	        	return false;
	        }
	        	
	        return true;
	    }
	
}
