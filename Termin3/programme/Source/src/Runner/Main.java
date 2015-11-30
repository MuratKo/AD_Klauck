package Runner;

import java.io.IOException;

import Helper.SortNum;
import Helper.TreePNG;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String path = "/home/murat/Dokumente/Uni/AD/Termin3/programme/zahlen/";
		
		//zufällige 1000 Zahlen ohne Duplikate
		SortNum.sortNum(1000, path + "ohneDuplikate.dat", false);
		
		//zufällige 1000 Zahlen mit Duplikaten
		SortNum.sortNum(1000, path + "mitDuplikaten.dat", true);
		
		//worsecase
		SortNum.sortNumWorstBaseCase(1000, path + "worseCase.dat", false);
		
		//bestcase
		SortNum.sortNumWorstBaseCase(1000, path + "bestCase.dat", true);
		
		//graphViz Beispiel
		String pathOfFile = "/home/murat/Dokumente/Uni/AD/Termin3/programme/Graphen/GraphDateien/";
		String graphFileName = "beispiel.gv";
		
		String pathOfDestination = "/home/murat/Dokumente/Uni/AD/Termin3/programme/Graphen/Bilder/";
		String pngFileName = "beispiel.png";
		
		TreePNG.treeToPNG(pathOfFile + graphFileName, pathOfDestination + pngFileName);
	}



}
