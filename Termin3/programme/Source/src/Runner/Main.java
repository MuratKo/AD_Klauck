package Runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import einleser.Einleser;

import adtarray.ADTArray;

import adt.AVLTree;
import adt.AVLTreeRotation;
import adt.AVLTreeTime;
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
		
		//AVLTree tree = AVLTree.create();
		
//		tree.insert(15);
//		tree.insert(17);
//		tree.insert(10);
//		tree.insert(12);
//		tree.insert(18);
//		tree.insert(13);
//		tree.insert(14);
//		tree.insert(9);
//		
////		tree.delete(17);
//////		tree.delete(18);
////		tree.delete(9);
//////		tree.delete(10);
////		tree.delete(15);
////		tree.delete(13);
////		tree.delete(12);
//		
		
		
		
//		tree.insert(11);
//		tree.insert(10);
//		tree.insert(3);
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
//		
//		tree.delete(9);
//		tree.delete(1);
//		tree.delete(2);
//		tree.delete(3);
//		tree.delete(4);
//		tree.delete(8);
//		tree.delete(38);
//		tree.delete(1);
		
		
//		
//		tree.delete(8);
//		ArrayList<Integer> l = new ArrayList<>();
//		Random rand = new Random();
//		int anzahl = 200;
//		for(int i = 0 ; i < anzahl; i++){
//			
//			int n = rand.nextInt(anzahl) + 0;
//			if(!l.contains(n)){
//				
//				l.add(n);
//				
//			}
//		}
//		
//		for(int i : l){
//			tree.insert(i);
//		}
		
		AVLTree t = AVLTree.create();
		
		t.insert(1);
		t.print("/home/murat/Dokumente/Uni/AD/Termin3/programme/Graphen/GraphDateien/", "1.gv");
		
		AVLTreeRotation tree = AVLTreeRotation.create();
		
		ADTArray array = ADTArray.initA();
		Einleser ein = new Einleser("/home/murat/Dokumente/Uni/AD/Termin3/programme/zahlen/ohneDuplikate.dat");
		array = ein.parse(array);
		
		for(int i = 0; i < array.lengthA(); i++){
			tree.insert(array.getA(i));
		}
		
		System.out.println(tree.getRotationRight());
		System.out.println(tree.getRotationLeft());
		System.out.println(tree.getRotationAll());
		tree.print("/home/murat/Dokumente/Uni/AD/Termin3/programme/Graphen/GraphDateien/", "ohneDuplikate.gv");
		
		
	}



}
