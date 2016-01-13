package adt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import exception.PrimeNumberNotFoundException;

public class ADTHashmap implements ADTHashmapInterface {
	
	private Integer size;
	private Strategy strategy;
	private StringInteger[] map;
	private Integer m;
	private static int inserted = 0;

	private ADTHashmap(Integer size, Strategy strategy) {
		this.size = size;
		this.strategy = strategy;
		try {
			m = primzahlNachKlauck();
			map = new StringInteger[m];
		} catch (PrimeNumberNotFoundException e) {
			System.err.println("Primzahl nicht gefunden!");
		}
		
	}

	
	private Integer primzahlNachKlauck() throws PrimeNumberNotFoundException {
		int exponentMax = 1;
		
		//Suche nach einer zweierpotenz groesser size
		while ((int) Math.pow(2, exponentMax) < size) {
			exponentMax++;
		}
		int exponentMin = exponentMax - 1;

		int max = (int) Math.pow(2, exponentMax);
		int min = (int) Math.pow(2, exponentMin);
		int start = (min + max) / 2; // Mitte der beiden zweierpotenzen
		
		//sollte die mitte der beiden zweierpotenzen kleiner als die gewuenschte size sein, nehmen wir die naechsten beiden 
		// zweierpotenzen -> um zu garantieren, dass m weit weg ist von einer zweierpotenz ist
		// dafuer wird die groesse des array deutlich groesser
		if(start < size) {
			return primzahl();
		};

		// beginnend bei start wird versucht eine primzahl zu finden aufsteigend
		for (int actualNumberToCheck = start; actualNumberToCheck < max; actualNumberToCheck++) {

			
			boolean isPrimeNumber = true;

			// ueberpruefung ob die zu pruefende Zahl eine Primzahl ist
			for (int teiler = 2; teiler < actualNumberToCheck; teiler++) {
				if (actualNumberToCheck % teiler == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			
			if (isPrimeNumber) {
				int primeNumber = actualNumberToCheck;
				return primeNumber;
			}
			
		}

		
		//bisher keine primzahl gefunden
		return primzahl();
		
	}
	
	private Integer primzahl() throws PrimeNumberNotFoundException {
		int exponentMin = 1;
		
		//Suche nach einer zweierpotenz groesser size
		while ((int) Math.pow(2, exponentMin) < size) {
			exponentMin++;
		}
		int exponentMax = exponentMin + 1;

		int max = (int) Math.pow(2, exponentMax);
		int min = (int) Math.pow(2, exponentMin);
		int start = (min + max) / 2; // Mitte der beiden zweierpotenzen

		// beginnend bei start wird versucht eine primzahl zu finden aufsteigend
		for (int actualNumberToCheck = start; actualNumberToCheck < max; actualNumberToCheck++) {

			
			boolean isPrimeNumber = true;

			// ueberpruefung ob die zu pruefende Zahl eine Primzahl ist
			for (int teiler = 2; teiler < actualNumberToCheck; teiler++) {
				if (actualNumberToCheck % teiler == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			
			if (isPrimeNumber) {
				int primeNumber = actualNumberToCheck;
				return primeNumber;
			}
			
		}

		// bisher keine primzahl gefunden

		

		// beginnend bei start wird versucht eine primzahl zu finden absteigend
		for (int actualNumberToCheck = start; actualNumberToCheck < min; actualNumberToCheck--) {

			boolean isPrimeNumber = true;

			// ueberpruefung ob die zu pruefende Zahl eine Primzahl ist
			for (int teiler = 2; teiler < actualNumberToCheck; teiler++) {
				if (actualNumberToCheck % teiler == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			
			if (isPrimeNumber) {
				int primeNumber = actualNumberToCheck;
				return primeNumber;
			}
			

		}

		throw new PrimeNumberNotFoundException();
	}

	public static ADTHashmap create(Integer size, Strategy strategy) {
		return new ADTHashmap(size, strategy);
	}

	@Override
	public ADTHashmap insert(String word) {
		
		//Pruefen ob map schon voll ist
		if(inserted == m){
			System.out.println("map ist voll");
			return this;
		}
		
		//hashmap fuer funktionale programmierung kopieren
		ADTHashmap result = this.copy();
		//adresse berechnen vom key(word)
		Integer address = hashfunktion(word);
		
		//Speichern der adresse, um sondierungfunktion immer wieder mit der ursprungsadresse aufrufen zu koennen
		Integer addressOhneSondierung = address;
		// 1. Fall: Speicheradresse ist bereits belegt
		if (result.getMap()[address] != null) {
			// a. mit dem gleichen Schluessel belegt
			if (result.getMap()[address].getKey().equals(word)) {
				// value wird um eins erhoeht
				result.getMap()[address].setValue(result.getMap()[address].getValue() + 1);
			}
			// b. mit anderem Schluessel belegt
			else {
				int j = 0;
				while(true) {
					
					//Frage: wann abrechen?
					// wird durch sondierungsfunktion(Q oder B) alle freien plaetze gefunden?
					if(j == m*100) break; //maximale versuche
					
					
					//Brent
					if(strategy == Strategy.B && find(word) == 0){ //find(word) -> soll nur verdraengen, falls wort nicht schon eingefuegt wurde
						//keyvalue(old) aus aktueller adresse auslesen
						StringInteger actual = result.getMap()[address];
						//(h(k) - s(j,k)) mod m
						Integer newAddressOfOldKey = Math.floorMod((hashfunktion(actual.getKey()) - sondierungsfunktion(actual.getVersuche() + 1, actual.getKey())), m);
						
						//key(old) kann mit EINEM weiteren sondierungsversuch verchoben werden
						if(result.getMap()[newAddressOfOldKey] == null){
							//versuche +1
							actual.setVersuche(actual.getVersuche() + 1);
							//new key an old key speichern
							result.getMap()[address] = new StringInteger(word, 1, j);
							result.getMap()[newAddressOfOldKey] = actual;
							//System.out.println("Ich " + result.getMap()[newAddressOfOldKey].getKey() + " wurde von " + result.getMap()[address].getKey() + " verdrängt ");
							inserted++;
							break;
						}
					}
					
					
					// zuruecksetzen
					address = addressOhneSondierung;
					
					//(h(k) - s(j,k)) mod m
					address = Math.floorMod((address - sondierungsfunktion(j, word)), m);
					
					
					
					// neue leere Speicheradresse gefunden
					if (result.getMap()[address] == null){
						result.getMap()[address] = new StringInteger(word, 1, j);
						inserted++;
						break; //aus der for-schleife 
					}
					
					// speicheradresse mit selben key gefunden
					if (result.getMap()[address].getKey().equals(word)){
						result.getMap()[address].setValue(result.getMap()[address].getValue() + 1);
						break;
					}
					
					j++;
				}
				
				
				
				return result;
				
			}
		}
		// 2. Fall: Speicheradresse ist frei
		else {
			
			map[address] = new StringInteger(word, 1,0);
			inserted++;
		}
		return this;
	}

	private Integer sondierungsfunktion(Integer j, String word) {
		switch (strategy) {
		case L:
			return j;
		case Q:
			// hj(k) = (h(k) - s(j,k)) mod m mit s(j,k) = (-1)j * j2

			//return (int) (Math.pow(-1, j) * Math.pow(j, 2));
			return ((int) Math.pow((int) (j/2), 2)) * (int) (Math.pow(-1, j));
		case B:
			/*
			 * hj(k) = (h(k) - s(j,k)) mod m mit s(j,k) = j * h’(k) h’(k) = 1+(k
			 * mod m’) // mittels Hornerschema neu berechnen m’ = m - 2
			 */

			return j * (1 + hashfunktionDouble(word));
		default:
			return -1;
		}
	}

	public Integer hashfunktion(String word) {
		int h = 0;
		for (int i = 0; i < word.length(); i++) {
			h = (h * 128 + (int) word.charAt(i)) % m;
		}
		return h;
	}

	public Integer hashfunktionDouble(String word) {
		int h = 0;
		for (int i = 0; i < word.length(); i++) {
			h = (h * 128 + (int) word.charAt(i)) % (m - 2);
		}
		return h;
	}

	@Override
	public Integer find(String word) {
		
		//Worst Case: alle Adressen belegt
		ArrayList<Integer> listForWorstCase = new ArrayList<Integer>();
		
		int addressOhneSondierungfunktion = hashfunktion(word);
		int address = addressOhneSondierungfunktion;
		int j = 1;
		
		listForWorstCase.add(address);
		
		try{
			while(!map[address].getKey().equals(word)){
				
				if( (listForWorstCase.size() == map.length) || j > m*100) return 0; //NOCHMAL UEBERPRUEFEN!!!
				
				address = addressOhneSondierungfunktion;
				//(h(k) - s(j,k)) mod m
				address = Math.floorMod((address - sondierungsfunktion(j, word)), m);
				if(!listForWorstCase.contains(address)){
					listForWorstCase.add(address);
				}
				j++;
			}
			
		
			return map[address].getValue();
		}catch (NullPointerException e){
			return 0;
		}
	}
	
	public Integer getM(){
		return m;
	}

	/**
	 * Wird benutzt um Funktional zu arbeiten
	 * 
	 * @return ADTHashmap
	 */
	private ADTHashmap copy() {
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