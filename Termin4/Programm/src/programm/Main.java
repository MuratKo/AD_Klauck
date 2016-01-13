package programm;

import adt.Strategy;

public class Main {

	final static String PATH = "Z:/win7/3_Sem/AD_Klauck/Termin4/Text/";
	
	public static void main(String[] args){
		Programm p = new Programm(PATH + "washington.txt", Strategy.L);
	}
	
}
