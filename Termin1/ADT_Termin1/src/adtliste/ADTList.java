package adtliste;

public class ADTList {

	private final int INIT_ARRAY_SIZE = 100;

	private int length;
	private int oldArraySize;
	private int[] list;

	private ADTList() {
		list = new int[INIT_ARRAY_SIZE];
		length = 0;
		oldArraySize = INIT_ARRAY_SIZE;
	}

	public static ADTList create() {
		return new ADTList();
	}

	//Gibt true zurück, wenn Liste leer ist
	public boolean isEmpty() {
		if (length == 0) {
			return true;
		}
		return false;
	}

	//Gibt die Anzahl der Elemente als Integer zurück
	public int laenge() {
		return this.length;
	}

//	public void insert(int elem, int pos) {
//		isFull(this);
//		// Fehlerbehandlung
//		if (pos > length + 1 || pos < 1) {
//			//ignorieren
//		} else {
//
//			if(pos <= length){
//				int tmp = 0, tmp2 = 0;
//				for (int i = 1; i <= length; i++) {
//					if (i == pos) {
//						tmp = list[i];
//						list[i] = elem;
//					}
//					if (i > pos) {
//						tmp2 = list[i];
//						list[i] = tmp;
//						tmp = tmp2;
//					}
//				}
//				//Liste wird um ein Element verlängert
//				list[length+1] = tmp;
//				length++;
//			} else {
//				list[pos] = elem;
//				length++;
//			}
//		}
//	}

	public ADTList insert(int elemToInsert, int pos) {
		ADTList copyOfList = copyToBeFunctional();
		isFull(copyOfList);
		// Fehlerbehandlung
		if (pos > copyOfList.getLength() + 1 || pos < 1) {
			//ignorieren
		} else {
			//Fall 1: Element verdrängt ein anderes Element
			if(pos <= copyOfList.getLength()){
				int tempElementToMove = 0, tempElementToMove2 = 0;
				for (int i = pos; i <= copyOfList.getLength(); i++) {
					if (i == pos) {
						//Altes Array wird umkopiert
						int[] copyOfArray = copyOfList.getListArray();
						//i-tes Element temporär speichern -> muss nach rechts verschoben werden
						tempElementToMove = copyOfArray[i];
						//Element wird eingefügt
						copyOfArray[i] = elemToInsert;
						copyOfList.setList(copyOfArray);
					}
					if (i > pos) {
						int[] copyOfArray = copyOfList.getListArray();
						tempElementToMove2 = copyOfArray[i];
						copyOfArray[i] = tempElementToMove;
						tempElementToMove = tempElementToMove2;
						copyOfList.setList(copyOfArray);
					}
				}
				//Liste wird um ein Element verlängert
				int[] copyOfArray = copyOfList.getListArray();
				int finalElementToMove = tempElementToMove;
				copyOfArray[copyOfList.getLength()+1] = finalElementToMove;
				copyOfList.setList(copyOfArray);
				copyOfList.setLength(copyOfList.getLength()+1);
			
			}
			//Fall 2: Element soll ganz hinten angefügt werden
			else {
				int[] copyOfArray = copyOfList.getListArray();
				copyOfArray[pos] = elemToInsert;
				copyOfList.setList(copyOfArray);
				copyOfList.setLength(copyOfList.getLength()+1);
			}
		}
		return copyOfList;
	}
	
	private ADTList copyToBeFunctional(){
		ADTList copyOfList = ADTList.create();
		copyOfList.setLength(this.getLength());
		copyOfList.setList(this.getListArray());
		copyOfList.setOldArraySize(this.getOldArraySize());
		return copyOfList;
		
	}

	private void isFull(ADTList in_list) {
		if(in_list.getLength() > in_list.getOldArraySize()-10){ // Buffer: 10
			//Grösse des neuen Arrays festlegen (+ INIT_ARRAY_SIZE)
			int newArraySize = in_list.getOldArraySize() + INIT_ARRAY_SIZE;
			//Alte Array-Size mit neuer überschreiben
			in_list.setOldArraySize(newArraySize);
			//Alte Array-Werte kopieren
			int[] copyOfValues = in_list.getListArray(); 
			//Neuen Array erstellen mit neuer ArraySize
			int[] temp = new int[newArraySize];
			//Alle Werte von copyOfValues nach temp kopieren
			for(int pos = 1; pos <= in_list.getLength(); pos++){
				temp[pos] = copyOfValues[pos];
			}
			//Neues, grösseres, mit Werten befülltes Array an in_list übergeben
			in_list.setList(temp);
		}
	}

//	public void delete(int pos){
//		// Fehlerbehandlung
//				if (pos > length || pos < 1) {
//					//ignorieren
//				} else {
//					if(pos < length){
//						//for-Schleife für den Fall: nicht letztes Element
//						for(int i = 1; i < length-1; i++){
//							if(i >= pos){
//								list[i] = list[i+1]; //alle Elemente ab pos nach links verschieben
//							}
//						}
//					}
//					length--; //sollte letztes Element gelöscht werden, wird es nur "vergessen"
//				}
//	}
	
//	public ADTList delete(int pos){
//		ADTList copyOfList = copyToBeFunctional();
//		// Fehlerbehandlung
//				if (pos > copyOfList.getLength() || pos < 1) {
//					//ignorieren
//				} else {
//					if(pos < copyOfList.getLength()){
//						//Werte des Alten Array kopieren
//						int[] copyOfArray = copyOfList.getListArray();
//						//for-Schleife für den Fall: nicht letztes Element
//						for(int i = pos; i <  copyOfList.getLength()-1; i++){
//							copyOfArray[i] = copyOfArray[i+1];//alle Elemente ab pos nach links verschieben
//						}
//						copyOfList.setList(copyOfArray);
//					}
//					copyOfList.setLength(copyOfList.getLength()-1);//sollte letztes Element gelöscht werden, wird es nur "vergessen"
//				}
//		return copyOfList;
//	}
	
	public ADTList delete(int pos) {
		ADTList copyOfList = copyToBeFunctional();
		if (!(pos > copyOfList.getLength()) && !(pos < 1)) {
			int[] copyOfArray = copyOfList.getListArray();
			
			
			for(int i = pos; i < copyOfList.getLength(); i++){
				copyOfArray[i] = copyOfArray[i+1];
			}
			copyOfList.setList(copyOfArray);
			copyOfList.setLength(copyOfList.getLength()-1);//Letztes Element wird "vergessen"
		}
		return copyOfList;
	}
	
	
	public int find(int elem){
		int posToStartFrom = 1; //Suche von li->re
		
		for(int i = posToStartFrom; i <= length; i++){
			if(elem == list[i]){
				return posToStartFrom;
			}
			posToStartFrom++;
		}
		
		return -1; //Fehlerbehandlung
	}
	
	public int retrieve(int pos){
		// Position darf nicht < 1 sein UND Position darf nicht ausserhalb der Liste liegen
		if(!(pos < 1) && !(pos > length)){
			return list[pos];
		}
		
		return -1;
	}
	
//	public void concat(ADTList list2){
//
//		for (int i = 1; i <= list2.laenge() ; i++) {
//			this.insert(this.laenge()+1, list2.retrieve(i));
//		}
//		
//	}
	
	public ADTList concat(ADTList list2){
		ADTList copyOfList = copyToBeFunctional();
		for (int i = 1; i <= list2.laenge() ; i++) {
			copyOfList = copyOfList.insert(copyOfList.laenge()+1, list2.retrieve(i));
		}
		return copyOfList;
	}
	
	//Getter, Setter-Methoden - um eine Copy zu erstellen (funktionale Programmierung)
	private int getLength() {
		return length;
	}

	private void setLength(int length) {
		this.length = length;
	}

	private int getOldArraySize() {
		return oldArraySize;
	}

	private void setOldArraySize(int oldArraySize) {
		this.oldArraySize = oldArraySize;
	}

	private int[] getListArray() {
		return list;
	}

	private void setList(int[] list) {
		this.list = list;
	}
	
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if(o instanceof ADTList){
        	for(int i = 1; i <= this.length; i++){
        		//sobald ein Element nicht uebereinstimmt, return false
        		if(!(((ADTList) o).retrieve(i) == this.retrieve(i))) return false;
        	}
        }else{
        	return false;
        }
        	
        return true;
    }
}
