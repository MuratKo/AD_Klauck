package de.team.ast;

public class ADTListe {
	
	private int[] adtListe = {};
	private int lenght;

	private ADTListe(){
		
	}
	
	public static ADTListe create(){
		return new ADTListe();
	}
	
	public int laenge(){
		lenght = adtListe.length;
		return lenght;
	}

}
