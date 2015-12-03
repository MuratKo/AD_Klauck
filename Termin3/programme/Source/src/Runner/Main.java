package Runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import ADTTree.ADTTree;
import Helper.SortNum;
import Helper.TreePNG;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		
		ADTTree tree = ADTTree.create();
		
//		tree.insert(11);
//		tree.insert(10);
//		tree.insert(3);
//		tree.insert(11);
//		
//		tree.insert(12);
//		tree.insert(37);
//		tree.insert(8);
//		tree.insert(18);
//		tree.insert(23);
//		tree.insert(5);
//		tree.insert(28);
//		tree.insert(6);
//		tree.insert(32);
//		tree.insert(26);
//		tree.insert(16);
//		tree.insert(15);
//		tree.insert(22);
//		tree.insert(27);
//		tree.insert(38);
//		tree.insert(29);
//		tree.insert(34);
//		tree.insert(14);
//		tree.insert(36);
//		tree.insert(21);
//		tree.insert(39);
//		tree.insert(45);
//		tree.insert(46);
//		tree.insert(7);
//		tree.insert(9);
//		tree.insert(1);
//		tree.insert(2);
//		tree.insert(60);
//		tree.insert(50);
//		tree.insert(1);
//		tree.insert(4);
		
		ArrayList<Integer> l = new ArrayList<>();
		Random rand = new Random();
		int anzahl = 200;
		for(int i = 0 ; i < anzahl; i++){
			
			int n = rand.nextInt(anzahl) + 0;
			if(!l.contains(n)){
				
				l.add(n);
				
			}
		}
		
		for(int i : l){
			tree.insert(i);
		}
		
//		System.out.println(tree.high());
//		System.out.println(tree.biggerElement.high());
//		System.out.println(tree.smallerElement.high());
//		System.out.println(tree.smallerElement.smallerElement.high());
		
//		System.out.println(tree.high());
//		System.out.println(tree.getValue());
//		
//		System.out.println(tree.smallerElement.high());
//		System.out.println(tree.smallerElement.getValue());
//		
//		System.out.println(tree.biggerElement.high());
//		System.out.println(tree.biggerElement.getValue());
//		
//		System.out.println(tree.smallerElement.smallerElement.high());
//		System.out.println(tree.smallerElement.smallerElement.getValue());
//		
//		System.out.println(tree.smallerElement.biggerElement.high());
//		System.out.println(tree.smallerElement.biggerElement.getValue());
		
		tree.print("/home/murat/Dokumente/Uni/AD/Termin3/programme/Graphen/GraphDateien/", "m.gv");
		
	}



}
