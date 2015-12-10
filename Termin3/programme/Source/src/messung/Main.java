package messung;
import einleser.Einleser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import adt.AVLTreeRotation;
import adt.AVLTreeTime;
import adtarray.ADTArray;
import einleser.Einleser;

public class Main {

	public static final String PATH = "C:/Users/abp516.INFORMATIK/Documents/AD_Klauck/Termin3/Tests/";
	static Einleser ein;
	
	public static void main(String[] args) {
		
		
		File file = new File(
				"C:/Users/abp516/Documents/AD_Klauck/Termin3/Messung/avltree.csv");

		try {
			file.createNewFile();

			PrintWriter writer;

			writer = new PrintWriter(file);
			
			
			writer = Main.time(writer);
			
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static PrintWriter time(PrintWriter writer) {
		//Messung Zeit
		String pathStart = PATH;
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
				writer.write(avl.getTime()+";");
				filename += filename;	
			}
			return writer;
		}
	
	public static void rotationLeft() {
		//Messung Rotationen (links)
		String pathStart = PATH;
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
		String pathStart = PATH;
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
