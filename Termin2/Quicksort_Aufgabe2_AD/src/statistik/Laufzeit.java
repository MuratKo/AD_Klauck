package statistik;

public class Laufzeit {
	
	static long start;
	static long ende;
	static long ergebnis;
	
	public static void setStart(long inStart) {
		start = inStart;
	}
	
	public static void setEnde(long inEnde) {
		ende = inEnde;
	}
	
	public static long getRuntimeInMS() {
		ergebnis = (ende-start)/1000000; //ms
		return ergebnis;
	}

}
