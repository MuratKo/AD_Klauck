package Helper;

import java.io.IOException;

public class TreePNG {

	

//	public static void treeToPNG(String pathOfFile, String pathOfDestination){
//			
//		String command = "dot -Tpng " + pathOfFile + " -o  " + pathOfDestination;
//			try {
//				Runtime rt = Runtime.getRuntime();
//				rt.exec(command);
//			} catch (IOException e) {
//				System.out.println("f");
//			}
//		}
	
	public static void treeToPNG(String pathOfFile, String pathOfDestination){
		
		String command = "C:/Users/abp516.INFORMATIK/Documents/Graphviz/release/bin/dot -Tpng " + pathOfFile + " -o  " + pathOfDestination;
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec(command);
		} catch (IOException e) {
			System.out.println("f");
		}
	}

}
