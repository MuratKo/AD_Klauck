package adt;

public class Main {
	
	public static void main(String[] args) {
		
		ADTHashmap adt = ADTHashmap.create(101, Strategy.L);
		
		String s = "a";
		
		while(adt.hashfunktion(s) != 35) {
			s += "c";
		}
		
		System.out.println(s);
		
		System.out.println(adt.hashfunktion(s));
	}

}
