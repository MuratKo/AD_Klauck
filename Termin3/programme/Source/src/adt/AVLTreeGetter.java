package adt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import Helper.TreePNG;

public class AVLTreeGetter {
	
	/*
	 * Notwendinge static variablen für das erstellen der PNG-Datei
	 */
	private static boolean root = true;
	private static String graph = "";
	//-----------------
	
	/*
	 * Rotationszähler
	 */
	private static int rotationLeft = 0;
	private static int rotaionRight = 0;
	//------------
	
	//linkes sowie rechtes Knoten des aktuellen Knotens
	private AVLTreeGetter smallerElement, biggerElement;
	
	//der wert des Knotens
	private int value;
	
	//die höhe des knotens
	private int high;
	
	/*
	 * create: ein leeren ADT-AVLTree erstellen				
	 * („nichts“ -> avlTree)
	 */
	
	private AVLTreeGetter(){
		this.smallerElement = null;
		this.biggerElement = null;
		this.value = -1;
		this.high = 0;
	}
	
	public static AVLTreeGetter create(){
		return new AVLTreeGetter();
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
	
	
	public AVLTreeGetter delete(int elem){
		
		
		
		//find element
		if(elem > this.value){
			if(this.biggerElement != null) this.biggerElement.delete(elem);
		}else if(elem < this.value){
			if(this.smallerElement != null) this.smallerElement.delete(elem);
		}else if (elem == this.value){
			//element found
			
			//Element ist ein Blatt
			if(this.smallerElement == null && this.biggerElement == null){
				this.reset();
			}
			
			//Element ist kein Blatt
			int newValue = -1;
				//Suche im linken Baum nach größten wert
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
			//hat der kleinste wert noch rechten teilbaum
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
			//größten wert gefunden
			newValue = this.value;
			//hat der größe wert noch linken teilbaum
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
			//Löschung erfolgte im rechten teilbaum
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
			//Löschung erfolgte im linken teilbaum
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
//			this.calcHigh();
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
	
	private void set(AVLTreeGetter tree) {
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
	 * insert: Ein Knoten wird an richtiger Position an dem AVLTree eingehängt, wobei das Element dem value des neu erstelten Knotens darstellt.
	 * (avlTree x elem -> avlTree)
	 */
	
	public AVLTreeGetter insert(int elem){
		
		
		
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
		this.calcHigh();
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
//				this.high = bigHigh-1;
//				this.smallerElement.high -= 2;
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
				rotateRight();
			}
		}
		
		return this;
	}
	
	public int getRotationLeft(){
		return rotationLeft;
	}
	
	public int getRotationRight(){
		return rotaionRight;
	}
	
	public int getRotationAll(){
		return rotaionRight + rotationLeft;
	}
	
	private void rotateRight() {
		rotaionRight++;
		//Kopieren der aktuellen Werte der zu verschiebenden Knoten
		AVLTreeGetter copyOfThis = this.copy();
		AVLTreeGetter copyOfSmallerTree = this.smallerElement.copy();
		
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
		
		//erst die höhe der unterbäume anpassen
		if(this.biggerElement.biggerElement != null) this.biggerElement.biggerElement.calcHigh();
		if(this.smallerElement != null)	this.smallerElement.calcHigh();
		if(this.biggerElement != null ) this.biggerElement.calcHigh();
		this.calcHigh();
	}
	
	private void rotateLeft() {
		rotationLeft++;
		AVLTreeGetter copyOfThis = this.copy();
		AVLTreeGetter copyOfBiggerTree = this.biggerElement.copy();
		
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
		
		//erst die höhe der unterbäume anpassen
		if(this.smallerElement.smallerElement != null) this.smallerElement.smallerElement.calcHigh();
		if(this.smallerElement != null)	this.smallerElement.calcHigh();
		if(this.biggerElement != null ) this.biggerElement.calcHigh();
		this.calcHigh();
	}

	private void calcHigh() {
		
		//Teilbäume mit dem wert -1 auf null setzen
		this.setSubTreeToNullIFMinus1();
		
		//höhe des aktuellen sowie die nachbarknoten neu berechnen
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
	private AVLTreeGetter copy(){
		AVLTreeGetter tree = AVLTreeGetter.create();
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
			this.biggerElement = AVLTreeGetter.create();
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
			this.smallerElement = AVLTreeGetter.create();
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
	
	public int getValue(){
		return this.value;
	}
	
	public AVLTreeGetter getSmallerTree(){
		return this.smallerElement;
	}

	public AVLTreeGetter getBiggerTree(){
		return this.biggerElement;
	}
}
