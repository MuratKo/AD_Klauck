package adtliste;

public class ADTListe {

	private final int INIT_ARRAY_SIZE = 100;

	private int elem;
	private int length;
	private int oldArraySize;
	private int[] list;

	private ADTListe() {
		list = new int[INIT_ARRAY_SIZE];
		length = 0;
		list[0] = 0;
		oldArraySize = INIT_ARRAY_SIZE;
	}

	public static ADTListe create() {
		return new ADTListe();
	}

	public boolean isEmpty() {
		if (length == 0) {
			return true;
		}
		return false;
	}

	public int laenge() {
		return this.length;
	}

	public void insert(int pos, int elem) {
		isFull();
		// Fehlerbehandlung
		if (pos > length + 1 || pos < 1) {
			//ignorieren
		} else {

			if(pos <= length){
				int tmp = 0, tmp2 = 0;
				for (int i = 1; i <= length; i++) {
					if (i == pos) {
						tmp = list[i];
						list[i] = elem;
					}
					if (i > pos) {
						tmp2 = list[i];
						list[i] = tmp;
						tmp = tmp2;
					}
				}
				//Liste wird um ein Element verlängert
				list[length+1] = tmp;
				length++;
			} else {
				list[pos] = elem;
				length++;
			}
		}
	}

	

	private void isFull() {
		if(length > oldArraySize-10){ // Buffer: 10
			int newArraySize = oldArraySize + INIT_ARRAY_SIZE;
			oldArraySize = newArraySize;
			int[] tmp = list;
			list = new int[newArraySize];
			list[0] = 0;
			for(int i = 1; i <= length; i++){
				list[i] = tmp[i];
			}
		}
	}

	public void delete(int pos){
		// Fehlerbehandlung
				if (pos > length || pos < 1) {
					//ignorieren
				} else {
					if(pos < length){
						//for-Schleife für den Fall: nicht letztes Element
						for(int i = 1; i < length-1; i++){
							if(i >= pos){
								list[i] = list[i+1]; //alle Elemente ab pos nach links verschieben
							}
						}
					}
					length--; //sollte letztes Element gelöscht werden, wird es nur "vergessen"
				}
	}
	
	public int find(int elem){
		int pos = 1; 
		
		for(int i = 1; i <= length; i++){
			if(elem == list[i]){
				return pos;
			}
			pos++;
		}
		
		return 0; //Fehlerbehandlung
	}
	
	public int retrieve(int pos){
		if(pos <= length && !(pos < 1)){
			return list[pos];
		}
		
		return 0;
	}
	
	public void concat(ADTListe list2){

		for (int i = 1; i <= list2.laenge() ; i++) {
			this.insert(this.laenge()+1, list2.retrieve(i));
		}
		
	}
}
