package ADTTree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx.Snapshot;

import Helper.TreePNG;

public class ADTTree {
	
	/*
	 * Notwendinge static variablen für das erstellen der PNG-Datei
	 */
	private static boolean root = true;
	private static String graph = "";
	//-----------------
	
	
	//linkes sowie rechtes Knoten des aktuellen Knotens
	private ADTTree smallerElement, biggerElement;
	
	//der wert des Knotens
	private int value;
	
	//die höhe des knotens
	private int high;
	
	/*
	 * create: ein leeren ADT-AVLTree erstellen				
	 * („nichts“ -> avlTree)
	 */
	
	private ADTTree(){
		this.smallerElement = null;
		this.biggerElement = null;
		this.value = -1;
		this.high = 0;
	}
	
	public static ADTTree create(){
		return new ADTTree();
	}
	
	//--------------
	
	/*
	 * Abfrage, ob der ADT-AVLTree kein Knoten enthält
	 * (avlTree -> Wahrheitswert) 
	 * -1 -> kein knoten
	 */
	
	public boolean isEmpty(){
		return this.value == -1;
	}
	
	//------------------
	
	
	/*
	 * Höhe des Knotens
	 */
	public int high(){
		return this.high;
	}
	//---------------
	
	
	/*
	 * insert: Ein Knoten wird an richtiger Position an dem AVLTree eingehängt, wobei das Element dem value des neu erstelten Knotens darstellt.
	 * (avlTree x elem -> avlTree)
	 */
	
	public void insert(int elem){
		//falls knoten noch kein wert besitzt
		if(value == -1){
			this.value = elem;
			//knoten besitzt höhe 1
			this.high = 1;
		}
		//falls elem größer ist als value
		else if(elem > this.value){
			insertInBiggerTree(elem);
		}
		//fals elem kleiner ist als value
		else if(elem < this.value){
			insertInSmallerTree(elem);
		}
		
		/*
		 * 	Rotations Bedingung
		 */
		int biggerHigh = 0;
		if(biggerElement != null) biggerHigh = biggerElement.high();
		
		int smallerHigh = 0;
		if(smallerElement != null) smallerHigh = smallerElement.high();
		
		int diff = biggerHigh - smallerHigh;
		
		//Übergewicht besteht im rechten teilbaum
		if(diff >= 2){
			
			/*
			 * Problemerkennung: Wenn die balance des rechten Knotens vom aktuellen Knoten ein ANDERES vorzeichen besitzt
			 * als die Balance des aktuellen Knotens
			 */
			biggerHigh = 0;
			if(biggerElement.biggerElement != null) biggerHigh = biggerElement.biggerElement.high();
			
			smallerHigh = 0;
			if(biggerElement.smallerElement != null) smallerHigh = biggerElement.smallerElement.high();
			
			diff = biggerHigh - smallerHigh;
			
			//Problemfall doppelrotation links
			if(diff < 0){
				rotateDoubleLeft();
			}
			
			//Else: Beide Balancen besitzen das selbe Vorzeichen -> Kein Problemfall
			else{
				
				int bigHigh = this.high();
				rotateLeft();
				
				//Anpassung der Höhen nach der Rotation
				this.high = bigHigh-1;
				this.smallerElement.high -= 2;
			}
		}
		//Übergewicht besteht im linken Teilbaum
		else if(diff <= -2){
			
			/*
			 * Problemerkennung: Wenn die balance des linken Knotens vom aktuellen Knoten ein ANDERES vorzeichen besitzt
			 * als die Balancen des aktuellen Knotens
			 */
			
			biggerHigh = 0;
			if(smallerElement.biggerElement != null) biggerHigh = smallerElement.biggerElement.high();
			
			smallerHigh = 0;
			if(smallerElement.smallerElement != null) smallerHigh = smallerElement.smallerElement.high();
			
			diff = biggerHigh - smallerHigh;
			
			//Problemfall doppelrotation rechts
			if(diff > 0){
				rotateDoubleRight();
			}
			
			//ELSE: beide Balancen bestizen das selbe Vorzeichen -> kein Problemfall
			else{
				int smallerhigh = this.smallerElement.high;
				rotateRight();
				this.high = smallerHigh+1;
				this.biggerElement.high -= 2;
			}
		}
		
		
	}
	
	private void rotateRight() {
		
		//Kopieren der aktuellen Werte der zu verschiebenden Knoten
		ADTTree copyOfThis = this.copy();
		ADTTree copyOfSmallerTree = this.smallerElement.copy();
		
		/*
		 * linker Knoten übernimmt die Position von dem aktuellen Knoten
		 */
		this.value = copyOfSmallerTree.getValue();
		if(copyOfSmallerTree.smallerElement != null){
			this.smallerElement = copyOfSmallerTree.smallerElement.copy();
		}else{
			this.smallerElement = null;
		}
		this.biggerElement = copyOfThis.copy();
		// Hat Position übernommen
		
		
		//Der rechte Teilbaum von k wird der neue linke Teilbaum von d. d selbst wird neuer rechter Teilbaum von k.
		if(copyOfSmallerTree.biggerElement != null){
			this.biggerElement.smallerElement = copyOfSmallerTree.biggerElement;
		}else{
			this.biggerElement.smallerElement = null;
		}
		
		
	}
	
	private void rotateLeft() {
		ADTTree copyOfThis = this.copy();
		ADTTree copyOfBiggerTree = this.biggerElement.copy();
		
		//k übernimmt die Position von d
		this.value = copyOfBiggerTree.getValue();
		if(copyOfBiggerTree.biggerElement != null){
			this.biggerElement = copyOfBiggerTree.biggerElement.copy();
		}else{
			this.biggerElement = null;
		}
		this.smallerElement = copyOfThis.copy();
		
		
		//Der linke Teilbaum von k wird der neue rechte Teilbaum von d. d selbst wird neuer linker Teilbaum von k. 
		if(copyOfBiggerTree.smallerElement != null){
			this.smallerElement.biggerElement = copyOfBiggerTree.smallerElement;
		}else{
			this.smallerElement.biggerElement = null;
		}
		
		
	}

	private void rotateDoubleRight() {
		
		this.smallerElement.rotateLeft();
		
		this.smallerElement.high = this.high - 1;
		this.smallerElement.smallerElement.high = this.high - 2;
		
		this.rotateRight();
		
		this.high = this.smallerElement.high+1;
		this.biggerElement.high -= 2;
		
		
		
	}
	
	private void rotateDoubleLeft() {
		
		this.biggerElement.rotateRight();
		
		this.biggerElement.high = this.high - 1;
		this.biggerElement.biggerElement.high = this.high - 2;
		
		this.rotateLeft();
		
		
		this.high = this.high-1;
		this.smallerElement.high -= 2;
		
		
		
		
	}

	

	
	//Hilfsfunktion um ein ADTTree zu kopieren
	private ADTTree copy(){
		ADTTree tree = ADTTree.create();
		tree.insert(this.getValue());
		tree.biggerElement = this.biggerElement;
		tree.smallerElement = this.smallerElement;
		tree.high = this.high;
		return tree;
	}

	//Funktion die ein Knoten am rechten Teilbaum anhängt
	private void insertInBiggerTree(int elem) {
		
		if(this.biggerElement != null){
			if(elem > this.value){
				this.biggerElement.insert(elem);
				try{
				if(this.biggerElement.high > this.smallerElement.high){
					this.high = this.biggerElement.high + 1;
				}else{
					this.high = this.smallerElement.high + 1;
				}
				}catch(Exception e){
					this.high = this.biggerElement.high + 1;
				}
			}else if(elem < this.value){
				this.insert(elem);
			}
		}else{
			this.biggerElement = ADTTree.create();
			this.biggerElement.insert(elem);
			
			if(this.smallerElement == null) this.high++;
			
		}
	}
	
	private void insertInSmallerTree(int elem) {
		if(this.smallerElement != null){
			if(elem > this.value){
				this.insert(elem);
			}else if(elem < this.value){
				this.smallerElement.insert(elem);
				try{
				if(this.biggerElement.high > this.smallerElement.high){
					this.high = this.biggerElement.high + 1;
				}else{
					this.high = this.smallerElement.high + 1;
				}
				}catch(Exception e){
					this.high = this.smallerElement.high + 1;
				}
			}
		}else{
			this.smallerElement = ADTTree.create();
			this.smallerElement.insert(elem);
			
			if(this.biggerElement == null) this.high++;
			
		}
	}

	

	public void print(String path, String fileName) {
		
		int stop = -1;
		
			
			if(root){
				stop = value;
				root = false;
				
				graph += "digraph G {\n";
			}
			if(biggerElement != null) {
				
				graph += this.getValue() + " -> " + biggerElement.getValue() + " [ label=\"" + (this.high-1) + "\"]" + ";\n";
				biggerElement.print(path, fileName);
			}
			
			if(smallerElement != null) {
				
				graph += this.getValue() + " -> " + smallerElement.getValue() + " [ label=\"" + (this.high-1) + "\"]" + ";\n";
				smallerElement.print(path, fileName);
			}
			
			if(stop == value){
				writeStringInFile(path, fileName);
			}
		
		
	}
	private void writeStringInFile(String path, String fileName) {
		String[] fileNameWithoutEnding = fileName.split("\\.");
		try {
			File file = new File(path + fileName);
			file.createNewFile();

			PrintWriter writer = new PrintWriter(file);
			
			writer.write(graph + "}");
			
			writer.close();
			
			TreePNG.treeToPNG(path + fileName, "/home/murat/Dokumente/Uni/AD/Termin3/programme/Graphen/Bilder/" + fileNameWithoutEnding[0] + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getValue(){
		return this.value;
	}
	

	
}
