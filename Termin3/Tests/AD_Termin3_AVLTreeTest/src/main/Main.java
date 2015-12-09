package main;

import adt.AVLTreeRotation;
import adt.AVLTreeTime;
import adtarray.ADTArray;
import einleser.Einleser;

public class Main {

	public static void main(String[] args) {
//		//500 without duplicates
//		SortNum.sortNum(500, "C:/Test/500WithoutDublicates.dat", false);
//		//1000 without duplicates
//		SortNum.sortNum(1000, "C:/Test/1000WithoutDublicates.dat", false);
//		//2000 without duplicates
//		SortNum.sortNum(2000, "C:/Test/2000WithoutDublicates.dat", false);
//		//4000 without duplicates
//		SortNum.sortNum(4000, "C:/Test/4000WithoutDublicates.dat", false);
//		//8000 without duplicates
//		SortNum.sortNum(8000, "C:/Test/8000WithoutDublicates.dat", false);
//		//16000 without duplicates
//		SortNum.sortNum(16000, "C:/Test/16000WithoutDublicates.dat", false);
//		//32000 without duplicates
//		SortNum.sortNum(32000, "C:/Test/32000WithoutDublicates.dat", false);
//		//64000 without duplicates
//		SortNum.sortNum(64000, "C:/Test/64000WithoutDublicates.dat", false);
//		//128000 without duplicates
//		SortNum.sortNum(128000, "C:/Test/128000WithoutDublicates.dat", false);
		
		Main.time();
//		Main.rotationLeft();
//		Main.rotationRight();
	}
	
	public static void time() {
		//Messung Zeit
		String pathStart = "C:/Users/VAIO PRO/Documents/GitHub/AD_Klauck/Termin3/Tests/";
		Integer filename = 500;
		String pathEnde = "WithoutDublicates.dat";
		
		adtarray.ADTArray array = ADTArray.initA();
		
		int letzteMessung = 128000;
			for(int i=filename; i<=letzteMessung ;i=i*2) {
				
				AVLTreeTime avl = AVLTreeTime.create();
				
				einleser.Einleser ein = new Einleser(pathStart+filename.toString()+pathEnde);
				array = ein.parse(array);
				
				//Zahlen vom Array in den AVLTree schreiben
				int anzahl = filename;
				for(int j=0;j<anzahl;j++) {
					avl.insert(array.getA(j));
				}
				//Zahlen verdoppeln
				//System.out.println(filename+" "+avl.getTime()+" ms");
				System.out.print(avl.getTime()+";");
				filename += filename;	
			}
		}
	
	public static void rotationLeft() {
		//Messung Rotationen (links)
		String pathStart = "C:/Users/VAIO PRO/Documents/GitHub/AD_Klauck/Termin3/Tests/";
		Integer filename = 500;
		String pathEnde = "WithoutDublicates.dat";
		
		adtarray.ADTArray array = ADTArray.initA();
		
		int letzteMessung = 128000;
			for(int i=filename; i<=letzteMessung ;i=i*2) {
				
				AVLTreeRotation avl = AVLTreeRotation.create();
				
				einleser.Einleser ein = new Einleser(pathStart+filename.toString()+pathEnde);
				array = ein.parse(array);
				
				//Zahlen vom Array in den AVLTree schreiben
				int anzahl = filename;
				for(int j=0;j<anzahl;j++) {
					avl.insert(array.getA(j));
				}
				//Zahlen verdoppeln
				//System.out.println(filename+" "+avl.getRotationLeft());
				System.out.print(avl.getRotationLeft()+";");
				filename += filename;
			}
		}
	
	public static void rotationRight() {
		//Messung Rotationen (rechts)
		String pathStart = "C:/Users/VAIO PRO/Documents/GitHub/AD_Klauck/Termin3/Tests/";
		Integer filename = 500;
		String pathEnde = "WithoutDublicates.dat";
		
		adtarray.ADTArray array = ADTArray.initA();
		
		int letzteMessung = 128000;
			for(int i=filename; i<=letzteMessung ;i=i*2) {
				
				AVLTreeRotation avl = AVLTreeRotation.create();
				
				einleser.Einleser ein = new Einleser(pathStart+filename.toString()+pathEnde);
				array = ein.parse(array);
				
				//Zahlen vom Array in den AVLTree schreiben
				int anzahl = filename;
				for(int j=0;j<anzahl;j++) {
					avl.insert(array.getA(j));
				}
				//Zahlen verdoppeln
				//System.out.println(filename+" "+avl.getRotationRight());
				System.out.print(avl.getRotationRight()+";");
				filename += filename;
				
			}
	}

}
