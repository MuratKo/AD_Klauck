package Runner;

import java.io.IOException;

import ADTTree.ADTTree;
import Helper.SortNum;
import Helper.TreePNG;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*String path = "/home/murat/Dokumente/Uni/AD/Termin3/programme/zahlen/";
		
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
		
		TreePNG.treeToPNG(pathOfFile + graphFileName, pathOfDestination + pngFileName);*/
		
		ADTTree tree = ADTTree.create(70);
		
		tree.insert(60);
		tree.insert(50);
		tree.insert(40);
		tree.insert(30);
		tree.insert(20);
		tree.insert(10);
	
		tree.insert(80);
		tree.insert(90);
		tree.insert(100);
		tree.insert(120);
		tree.insert(130);
		tree.insert(140);
		tree.insert(150);
		tree.insert(160);
		tree.insert(170);
		tree.insert(180);
		tree.insert(190);
		
		System.out.println(tree.getBiggerTreeHight());
		System.out.println(tree.getSmallerTreeHight());
		System.out.println(tree.getBiggerElement().getValue());
		
		
		tree.createPNG("/home/murat/Dokumente/Uni/AD/Termin3/programme/Graphen/GraphDateien/", "test.gv");
		System.out.println(tree.getGraph());
	}



}
