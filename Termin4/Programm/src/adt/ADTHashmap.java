package adt;



public class ADTHashmap implements ADTHashmapInterface{

	private Integer size;
	private Strategy strategy;
	private StringInteger[] map;
	
	private ADTHashmap(Integer size, Strategy strategy) {
		this.size = size;
		this.strategy = strategy;
		map = new StringInteger[size];
	}
	
	public static ADTHashmap create(Integer size, Strategy strategy) {
		return new ADTHashmap(size, strategy);
	}
	

	@Override
	public ADTHashmap insert(String word) {
		
		ADTHashmap result = this.copy();
		
		Integer address = hashfunktion(word);
		
		Integer addressOhneSondierung = address;
		
		//1. Fall: Speicheradresse ist bereits belegt
		if(map[address] != null) {
			//a. mit dem gleichen Schluessel belegt
			if(map[address].getKey().equals(word)){
				//value wird um eins erhoeht
				map[address].setValue(map[address].getValue() + 1);
			}
			//b. mit anderem Schluessel belegt
			else{
				//adresse "h(k)" wird mittels Sondierungsfunktion neu berechnet
				
//				Integer[] j_addressVerschiebung = sondierungsfunktion(0,word);
//				Integer j = j_addressVerschiebung[0];
//				Integer adressVerschiebung = j_addressVerschiebung[1];
//				address = address + adressVerschiebung;
				
				for(int j = 0; j <= size; j++){
					address = address + sondierungsfunktion(j, word);
					
					//keine adresse gefunden
					if(j == size){
						return result;
					}
					
					//neue leere Speicheradresse gefunden  
					if(map[address] == null) break;
					
					//speicheradresse mit selben key gefunden
					if(map[address].getKey().equals(word)) break;
					
					//zuruecksetzen
					address = addressOhneSondierung;
				}
				
				if(address > -1) {
					//freie Speicheradresse 
					if(map[address] == null){
						map[address] = new StringInteger(word, 1);
					}
					//mit dem selben Schluessel belegte Speicheradresse
					else{
						map[address].setValue(map[address].getValue() + 1);
					}
				}
			}
		}
		//2. Fall: Speicheradresse ist frei
		else{
			map[address] = new StringInteger(word, 1);
			
		}
		
		System.out.println("Speicheradresse: " + address);
		
		
		return this;
	}
	
	private Integer sondierungsfunktion(Integer j, String word) {
		
		
		switch(strategy){
			case L:
				return j;
			case Q:
				return (int) (Math.pow(-1, j) * Math.pow(j, 2));
			case B:
				return -1;
			default:
				return -1;
		}
	}

	public Integer hashfunktion(String word){
		
		int h = 0;
		for(int i = 0; i < word.length(); i++){
			h = (h * 128 + (int) word.charAt(i)) % size;
		}
		return h;
	}

	@Override
	public Integer find(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/**
	 * Wird benutzt um Funktional zu arbeiten
	 * @return ADTHashmap
	 */
	private ADTHashmap copy(){
		ADTHashmap copy = ADTHashmap.create(this.getSize(), this.strategy);
		copy.setMap(this.getMap());
		return copy;
	}

	private Integer getSize() {
		return size;
	}

	private Strategy getStrategy() {
		return strategy;
	}


	public StringInteger[] getMap() {
		return map;
	}

	private void setSize(Integer size) {
		this.size = size;
	}

	private void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	private void setMap(StringInteger[] map) {
		this.map = map;
	}

	
	
	

}
