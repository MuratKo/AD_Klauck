package programm;

import adt.ADTHashmap;
import adt.Strategy;

public class Main {

	final static String PATH = "Z:/win7/Sem_3/AD/AD_Klauck/Termin4/Text/";
	
	public static void main(String[] args){
		Programm p = new Programm(PATH + "test32000.txt", Strategy.B);
	}

	
}
