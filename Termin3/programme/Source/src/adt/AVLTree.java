package adt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import Helper.TreePNG;

public class AVLTree {
	
	/*
	 * Notwendinge static variablen fuer das erstellen der PNG-Datei
	 */
	private static boolean root = true;
	private static String graph = "";
	//-----------------
	
	
	//linker sowie rechter Knoten des aktuellen Knotens
	private AVLTree smallerElement, biggerElement;
	
	//der wert des Knotens
	private int value;
	
	//die hoehe des knotens
	private int high;
	
	/*
	 * create: ein leeren ADT-AVLTree erstellen				
	 * (nichts -> avlTree)
	 */
	
	private AVLTree(){
		this.smallerElement = null;
		this.biggerElement = null;
		this.value = -1;
		this.high = 0;
	}
	
	public static AVLTree create(){
		return new AVLTree();
	}
	
	//--------------
	
	/*
	 * Abfrage, ob der ADT-AVLTree kein Knoten enthaelt
	 * (avlTree -> Wahrheitswert) 
	 * -1 -> kein knoten
	 */
	
	public boolean isEmpty(){
		return this.value == -1;
	}
	
	//------------------
	
	
	/*
	 * Hoehe des Knotens
	 */
	public int high(){
		return this.high;
	}
	//---------------
	
	
	public AVLTree delete(int elem){
		
		//find element
		if(elem > this.value){
			if(this.biggerElement != null) this.biggerElement.delete(elem);
		}else if(elem < this.value){
			if(this.smallerElement != null) this.smallerElement.delete(elem);
		}else if (elem == this.value){
			//element found
			
			//Element ist ein Blatt
			if(this.smallerElement == null && this.biggerElement == null){
				this.reset(); //knoten wird zum leeren AVLTree
			}
			
			//Element ist kein Blatt
			int newValue = -1;
				//Suche im linken Baum nach groessten wert und speichere ihn
			if(this.smallerElement != null && this.biggerElement == null){
				newValue = this.smallerElement.searchInBigger();
			}
			
		    	//Suche im rechten Baum nach kleinsten wert
			if(this.biggerElement != null){
				newValue = this.biggerElement.searchInSmaller();
			}
			
			this.value = newValue;
			this.setSubTreeToNullIFMinus1();
			this.calcHigh();
			
			
		}
		
		this.proofBalance();
		
		//Knoten der reseted wurde, wird geloescht
		this.setSubTreeToNullIFMinus1();
		
		this.calcHigh();
		
		return this;
	}
	
	private int searchInSmaller() {
		int newValue = -1;
		if(this.smallerElement != null){
			newValue = this.smallerElement.searchInSmaller();
		}else{
			//kleinsten wert gefunden
			newValue = this.value;
			//hat der Knoten mit dem kleinsten wert noch rechten teilbaum
			if(this.biggerElement != null){
				this.set(biggerElement);
			}else{
				this.reset();
			}
			
		}
		
		this.setSubTreeToNullIFMinus1();
		this.calcHigh();
		
		this.proofBalance();
		
		
		return newValue;
	}
	
	

	private int searchInBigger() {
		int newValue = -1;
		if(this.biggerElement != null){
			newValue = this.biggerElement.searchInBigger();
		}else{
			//groessten wert gefunden
			newValue = this.value;
			//hat der Knoten mit dem groessten wert noch einen linken teilbaum
			if(this.smallerElement != null){
				this.set(smallerElement);
			}else{
				this.reset();
			}
		}
		this.calcHigh();
		
		
		this.proofBalance();
		
		
		return newValue;
	}

	private void setSubTreeToNullIFMinus1() {
		if(this.biggerElement != null){
			if(this.biggerElement.getValue() == -1){
				this.biggerElement = null;
			}
		}
		
		if(this.smallerElement != null){
			if(this.smallerElement.getValue() == -1){
				this.smallerElement = null;
			}
		}
	}
	
	private void proofBalance() {
		this.calcHigh();
		
			int diff = this.getDiff();
			//Loeschung erfolgte im rechten teilbaum
			if(diff < -1){
				//betrachte linken teilbaum
				diff = this.smallerElement.getDiff();
				if(diff <= 0 ){
					this.rotateRight();
				}else{
					this.smallerElement.rotateLeft();
					this.rotateRight();
				}
			}
			//Loeschung erfolgte im linken teilbaum
			else if(diff > 1){
				//betrachte rechten teilbaum
				diff = this.biggerElement.getDiff();
				if(diff >= 0){
					this.rotateLeft();
				}else{
					this.biggerElement.rotateRight();
					this.rotateLeft();
				}
			}

	}

	private int getDiff(){
		if(this.biggerElement != null && this.smallerElement != null){
			return this.biggerElement.high() - this.smallerElement.high();
		}else if(this.biggerElement == null && this.smallerElement != null){
			return 0 - this.smallerElement.high();
		}else if(this.biggerElement != null && this.smallerElement == null){
			return this.biggerElement.high() - 0;
		}
		return 0;
	}
	
	private void set(AVLTree tree) {
		this.value = tree.value;
		this.biggerElement = tree.biggerElement;
		this.smallerElement = tree.smallerElement;
		this.calcHigh();
	}

	private void reset() {
		this.value = -1;
		this.biggerElement = null;
		this.smallerElement = null;
		this.high = 0;
	}

	/*
	 * insert: Ein Knoten wird an richtiger Position an dem AVLTree eingehaengt, wobei das Element dem value des neu erstelten Knotens darstellt.
	 * (avlTree x elem -> avlTree)
	 */
	
	public AVLTree insert(int elem){
		//falls knoten noch kein wert besitzt
		if(value == -1){
			this.value = elem;
			//knoten besitzt hoehe 1
			this.high = 1;
		}
		//falls elem groesser ist als value
		else if(elem > this.value){
			insertInBiggerTree(elem);
		}
		//fals elem kleiner ist als value
		else if(elem < this.value){
			insertInSmallerTree(elem);
		}
		this.calcHigh();
		/*
		 * 	Rotations Bedingung
		 */
		int biggerHigh = 0;
		if(biggerElement != null) biggerHigh = biggerElement.high();
		
		int smallerHigh = 0;
		if(smallerElement != null) smallerHigh = smallerElement.high();
		
		int diff = biggerHigh - smallerHigh;
		
		//Uebergewicht besteht im rechten teilbaum
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
			}
		}
		//Uebergewicht besteht im linken Teilbaum
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
				rotateRight();
			}
		}
		
		return this;
	}
	
	private void rotateRight() {
		
		//Kopieren der aktuellen Werte der zu verschiebenden Knoten
		AVLTree copyOfThis = this.copy();
		AVLTree copyOfSmallerTree = this.smallerElement.copy();
		
		/*
		 * linker Knoten uebernimmt die Position von dem aktuellen Knoten
		 */
		this.value = copyOfSmallerTree.getValue();
		if(copyOfSmallerTree.smallerElement != null){
			this.smallerElement = copyOfSmallerTree.smallerElement.copy();
		}else{
			this.smallerElement = null;
		}
		this.biggerElement = copyOfThis.copy();
		// Hat Position Uebernommen
		
		
		//Der rechte Teilbaum von k wird der neue linke Teilbaum von d. d selbst wird neuer rechter Teilbaum von k.
		if(copyOfSmallerTree.biggerElement != null){
			this.biggerElement.smallerElement = copyOfSmallerTree.biggerElement;
		}else{
			this.biggerElement.smallerElement = null;
		}
		
		//erst die hoehe der unterbaeume anpassen
		if(this.biggerElement.biggerElement != null) this.biggerElement.biggerElement.calcHigh();
		if(this.smallerElement != null)	this.smallerElement.calcHigh();
		if(this.biggerElement != null ) this.biggerElement.calcHigh();
		this.calcHigh();
	}
	
	private void rotateLeft() {
		AVLTree copyOfThis = this.copy();
		AVLTree copyOfBiggerTree = this.biggerElement.copy();
		
		//k Uebernimmt die Position von d
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
		
		//erst die hoehe der unterbaeume anpassen
		if(this.smallerElement.smallerElement != null) this.smallerElement.smallerElement.calcHigh();
		if(this.smallerElement != null)	this.smallerElement.calcHigh();
		if(this.biggerElement != null ) this.biggerElement.calcHigh();
		this.calcHigh();
	}

	private void calcHigh() {
		
		//Teilbaeume mit dem wert -1 auf null setzen
		this.setSubTreeToNullIFMinus1();
		
		//hoehe des aktuellen sowie die nachbarknoten neu berechnen
		if(this.value != -1){
			if(this.biggerElement == null && this.smallerElement != null) this.high = this.smallerElement.high() + 1;
			if(this.biggerElement != null && this.smallerElement == null) this.high = this.biggerElement.high() + 1;
			if(this.biggerElement != null && this.smallerElement != null) this.high = Math.max(this.biggerElement.high(), this.smallerElement.high()) + 1;
			if(this.biggerElement == null && this.smallerElement == null) this.high = 1;
			
			if(this.biggerElement != null ){
				if(this.biggerElement.biggerElement == null && this.biggerElement.smallerElement != null) this.biggerElement.high = this.biggerElement.smallerElement.high() + 1;
				if(this.biggerElement.biggerElement != null && this.biggerElement.smallerElement == null) this.biggerElement.high = this.biggerElement.biggerElement.high() + 1;
				if(this.biggerElement.biggerElement != null && this.biggerElement.smallerElement != null) this.biggerElement.high = Math.max(this.biggerElement.biggerElement.high(), this.biggerElement.smallerElement.high()) + 1;
				if(this.biggerElement.biggerElement == null && this.biggerElement.smallerElement == null) this.biggerElement.high = 1;
			}
			
			if(this.smallerElement != null ){
				if(this.smallerElement.biggerElement == null && this.smallerElement.smallerElement != null) this.smallerElement.high = this.smallerElement.smallerElement.high() + 1;
				if(this.smallerElement.biggerElement != null && this.smallerElement.smallerElement == null) this.smallerElement.high = this.smallerElement.biggerElement.high() + 1;
				if(this.smallerElement.biggerElement != null && this.smallerElement.smallerElement != null) this.smallerElement.high = Math.max(this.smallerElement.biggerElement.high(), this.smallerElement.smallerElement.high()) + 1;
				if(this.smallerElement.biggerElement == null && this.smallerElement.smallerElement == null) this.smallerElement.high = 1;
			}
		}else{
			this.high = 0;
		}
		
	}

	private void rotateDoubleRight() {
		this.smallerElement.rotateLeft();
		this.rotateRight();
	}
	
	private void rotateDoubleLeft() {
		this.biggerElement.rotateRight();
		this.rotateLeft();
	}

	

	
	//Hilfsfunktion um ein ADTTree zu kopieren
	private AVLTree copy(){
		AVLTree tree = AVLTree.create();
		tree.insert(this.getValue());
		tree.biggerElement = this.biggerElement;
		tree.smallerElement = this.smallerElement;
		tree.high = this.high;
		return tree;
	}

	//Funktion die ein Knoten am rechten Teilbaum anhaengt
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
			this.biggerElement = AVLTree.create();
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
			this.smallerElement = AVLTree.create();
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
			if(biggerElement == null && smallerElement == null){
				graph += this.getValue()  + "\n";//+ " [ label=\"" + this.value + ":" + this.high + "\"]" + ";\n";
			}
			if(biggerElement != null) {
				
				graph += this.getValue() + " -> " + biggerElement.getValue()  + "\n";//+ " [ label=\"" + this.value + ":" + this.high + "\"]" + ";\n";
				biggerElement.print(path, fileName);
			}
			
			if(smallerElement != null) {
				
				graph += this.getValue() + " -> " + smallerElement.getValue() + "\n";// + " [ label=\"" + this.value + ":" + this.high + "\"]" + ";\n";
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
			
			TreePNG.treeToPNG(path + fileName, path + fileNameWithoutEnding[0] + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int getValue(){
		return this.value;
	}
	

	
}
