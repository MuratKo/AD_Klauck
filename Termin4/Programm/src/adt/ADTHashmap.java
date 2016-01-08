package adt;

import exception.PrimeNumberNotFoundException;

public class ADTHashmap implements ADTHashmapInterface {
	private Integer size;
	private Strategy strategy;
	private StringInteger[] map;
	private Integer m;

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

	public Integer getM(){
		return m;
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
		ADTHashmap result = this.copy();
		Integer address = hashfunktion(word);
		Integer addressOhneSondierung = address;
		// 1. Fall: Speicheradresse ist bereits belegt
		if (map[address] != null) {
			// a. mit dem gleichen Schluessel belegt
			if (map[address].getKey().equals(word)) {
				// value wird um eins erhoeht
				map[address].setValue(map[address].getValue() + 1);
			}
			// b. mit anderem Schluessel belegt
			else {
				// adresse "h(k)" wird mittels Sondierungsfunktion neu berechnet
				// Integer[] j_addressVerschiebung =
				// sondierungsfunktion(0,word);
				// Integer j = j_addressVerschiebung[0];
				// Integer adressVerschiebung = j_addressVerschiebung[1];
				// address = address + adressVerschiebung;
				for (int j = 0; j <= size; j++) {
					address = address - sondierungsfunktion(j, word);
					// keine adresse gefunden
					if (j == size) {
						return result;
					}
					// neue leere Speicheradresse gefunden
					if (map[address] == null)
						break;
					// speicheradresse mit selben key gefunden
					if (map[address].getKey().equals(word))
						break;
					// zuruecksetzen
					address = addressOhneSondierung;
				}
				if (address > -1) {
					// freie Speicheradresse
					if (map[address] == null) {
						map[address] = new StringInteger(word, 1);
					}
					// mit dem selben Schluessel belegte Speicheradresse
					else {
						map[address].setValue(map[address].getValue() + 1);
					}
				}
			}
		}
		// 2. Fall: Speicheradresse ist frei
		else {
			map[address] = new StringInteger(word, 1);
		}
		System.out.println("Speicheradresse: " + address);
		return this;
	}

	private Integer sondierungsfunktion(Integer j, String word) {
		switch (strategy) {
		case L:
			return j;
		case Q:
			// hj(k) = (h(k) - s(j,k)) mod m mit s(j,k) = (-1)j * j2

			return (int) (Math.pow(-1, j) * Math.pow(j, 2));
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
			h = (h * 128 + (int) word.charAt(i)) % m - 2;
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