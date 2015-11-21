package statistik;

public class CountReadWrite {
	
	static int read;
	static int write;
	
	public static void writePlusOne() {
		write++;
	}
	
	public static int getReadCounts() {
		return read;
	}
	
	public static int getWriteCounts() {
		return write;
	}

}
