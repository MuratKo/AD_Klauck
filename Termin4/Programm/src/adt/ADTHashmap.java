package adt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import exception.PrimeNumberNotFoundException;

public class ADTHashmap implements ADTHashmapInterface {
	
	private Integer size; 			// -> siehe primazahlNachKlauck()  
	private Strategy strategy;
	private StringInteger[] map; 	//Array mit Elementen vom Typ StringInteger (unsere eigene Klasse)
	private Integer m;				//Primzahl, die die Groesse des Arrays bestimmt
	private static int inserted = 0;//Wie viele Adressen bereits belegt sind

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

	//Suche nach einer geeigneten Primzahl (Methode aus VL-Folie Prof Klauck)
	private Integer primzahlNachKlauck() throws PrimeNumberNotFoundException {
		
		//Initalisierung 2^1
		int exponentMax = 1;
		
		//Suche nach einer zweierpotenz groesser size, um Exponenten zu ermitteln
		while ((int) Math.pow(2, exponentMax) < size) {
			exponentMax++;
		}
		
		//Exponent, der die naechstkleinere zweipotenz von size ermitteln
		int exponentMin = exponentMax - 1;

		//Ermittlung des start-Punktes, dafuer wird die Mitte beide gefundenen Zweierpotenzen genommen
		int max = (int) Math.pow(2, exponentMax);
		int min = (int) Math.pow(2, exponentMin);
		int start = (min + max) / 2; // Mitte der beiden zweierpotenzen
		
		//sollte die mitte der beiden zweierpotenzen kleiner als die gewuenschte size sein, nehmen wir die naechsten beiden 
		// zweierpotenzen -> um zu garantieren, dass m weit weg ist von einer zweierpotenz;
		// dafuer wird die groesse des array deutlich groesser
		if(start < size) {
			return primzahl(exponentMax);
		};

		//Sonst hier weiter:
		// beginnend bei start wird versucht eine primzahl zu finden aufsteigend
		for (int actualNumberToCheck = start; actualNumberToCheck < max; actualNumberToCheck++) {

			//Nehmen an, eien Primzahl gefunden zu haben
			boolean isPrimeNumber = true;

			// ueberpruefung ob die aktuelle Zahl auch wirklich eine Primzahl ist
			for (int teiler = 2; teiler < actualNumberToCheck; teiler++) {
				// falls if-Bedingung nur einmal true ist -> wird innere for-Schleife verlassen und es wird die naechste Zahl geprueft
				if (actualNumberToCheck % teiler == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			
			//Ist die gefundene Zahl (actualNumberToCheck) eine Primzahl, wird sie returned
			if (isPrimeNumber) {
				int primeNumber = actualNumberToCheck;
				return primeNumber;
			}
			
		}

		//bisher keine primzahl gefunden
		return primzahl(exponentMax); //-> Groesse der Hashmap waechst
		
	}
	
	private Integer primzahl(int exponentMin) throws PrimeNumberNotFoundException {
	
		//aus der obigen Funktion wird exponentMax uebergeben, dass hier exponentMin darstellt
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
		//Sollte immer noch keine gefunden werden, wird eine Exception geworfen
		throw new PrimeNumberNotFoundException();
	}

	//ADT-Hashmap erzeugen
	public static ADTHashmap create(Integer size, Strategy strategy) {
		return new ADTHashmap(size, strategy);
	}

	@Override
	public ADTHashmap insert(String word) {
		
		//Pruefen ob map schon voll ist -> Einfuegen nicht moeglich
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
				//Anzahl der Einfuegeversuche
				int j = 0;
				
				while(true) {
					
					//Frage: wann abrechen?
					// wird durch sondierungsfunktion(Q oder B) alle freien plaetze gefunden?
					if(j == m*100) break; //maximale versuche
					
		
							//Brent-Fall
							if(strategy == Strategy.B && find(word) == 0){ //find(word) -> soll nur verdraengen, falls wort nicht schon eingefuegt wurde
								//key-value(old) aus aktueller adresse auslesen
								StringInteger actual = result.getMap()[address];
								
								//Neue moegliche Adresse berechnen mittels: (h(k) - s(j,k)) mod m
								Integer newAddressOfOldKey = Math.floorMod((hashfunktion(actual.getKey()) - sondierungsfunktion(actual.getVersuche() + 1, actual.getKey())), m);
								
								//Wenn diese frei ist, kann der alte Schluessel mit EINEM sondierungsversuch verchoben werden
								if(result.getMap()[newAddressOfOldKey] == null){
									//versuche +1
									actual.setVersuche(actual.getVersuche() + 1);
									//"new key" an die Adresse von "old key" speichern
									result.getMap()[address] = new StringInteger(word, 1, j);
									//"old key" an neuer Adresse speichern 
									result.getMap()[newAddressOfOldKey] = actual;
										//System.out.println("Ich " + result.getMap()[newAddressOfOldKey].getKey() + " wurde von " + result.getMap()[address].getKey() + " verdrängt ");
									inserted++;
									break; //-> aus der while(true)-Schleife
								}
							}
					
					
					// zuruecksetzen
					address = addressOhneSondierung;
					
					//Neue moegliche Adresse berechnen mittels: (h(k) - s(j,k)) mod m
					address = Math.floorMod((address - sondierungsfunktion(j, word)), m);
					
					// Sollte eine neue leere Speicheradresse gefunden worden sein
					if (result.getMap()[address] == null){
						result.getMap()[address] = new StringInteger(word, 1, j);
						inserted++;
						break; //-> aus der while(true)-Schleife 
					}
					
					// speicheradresse mit selben key gefunden
					if (result.getMap()[address].getKey().equals(word)){
						result.getMap()[address].setValue(result.getMap()[address].getValue() + 1);
						break;
					}
					
					//neuer Versuch mit j=j+1 (while beginnt von vorne mit um 1 erhoetem j)
					j++;
				}
				
				//insert war erfolgreich ODER maximale Versuche wurden erreicht
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
	
	//Hash-Funktion um Adresse fuer einen Schluessel zu finden
	public Integer hashfunktion(String word) {
		//Initialsierung von h mit 0
		int h = 0;
		for (int i = 0; i < word.length(); i++) {
								//Naechsten Buchstaben vom String nehmen
			h = (h * 128 + (int) word.charAt(i)) % m;
		}
		return h;
	}

	//Sondierungsfunktion
	private Integer sondierungsfunktion(Integer j, String word) {
		//switch-case
		switch (strategy) {
		case L:
			return j;
		case Q:
			// hj(k) = (h(k) - s(j,k)) mod m mit s(j,k) = (-1)j * j2

			//return (int) (Math.pow(-1, j) * Math.pow(j, 2)); -> siehe Skizze
			return ((int) Math.pow((int) (j/2), 2)) * (int) (Math.pow(-1, j)); //siehe VL-Folie
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

	//Zweite Hash-Funktion fuer Double Hashing 
	public Integer hashfunktionDouble(String word) {
		//Initialsierung von h mit 0
		int h = 0;
		for (int i = 0; i < word.length(); i++) {
								 //Naechsten Buchstaben vom String nehmen
			h = (h * 128 + (int) word.charAt(i)) % (m - 2);
		}
		return h;
	}

	@Override
	public Integer find(String word) {
		
		//Init
		int addressOhneSondierungfunktion = hashfunktion(word);
		
		int address = addressOhneSondierungfunktion;
		int j = 1;

		
		try{
			//0. Versuch:
			while(!map[address].getKey().equals(word)){
				//ab 1. Versuch (j=1)
				if(j > m*100) return 0; //Frage -> gibt es eine bessere Abbruchbedingung
				
				address = addressOhneSondierungfunktion;
				//(h(k) - s(j,k)) mod m
				address = Math.floorMod((address - sondierungsfunktion(j, word)), m);
				//j um 1 erhoehen, while erneut ausfuehren
				j++;
			}
			
			//Key gefunden, Value wird ausgelesen und returned
			return map[address].getValue();
		}
		//Solle an der aktuellen Adresse kein Key vorhanden sein, wird 0 zurueckgegeben -> Abbruchbedingung
		catch (NullPointerException e){
			return 0;
		}
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

	private StringInteger[] getMap() {
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