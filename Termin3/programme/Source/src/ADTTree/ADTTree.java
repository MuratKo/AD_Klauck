package ADTTree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx.Snapshot;

import Helper.TreePNG;

public class ADTTree {

	
	
	
	private static boolean root = true;
	private static String graph = "";
	
	public ADTTree smallerElement, biggerElement;
	
	private int value;
	private int high;
	
	private ADTTree(){
		this.smallerElement = null;
		this.biggerElement = null;
		this.value = -1;
		this.high = 0;
	}
	
	public static ADTTree create(){
		return new ADTTree();
	}
	
	
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
		
		int biggerHigh = 0;
		if(biggerElement != null) biggerHigh = biggerElement.high();
		
		int smallerHigh = 0;
		if(smallerElement != null) smallerHigh = smallerElement.high();
		
		int diff = biggerHigh - smallerHigh;
		
		//Übergewicht besteht im rechten teilbaum
		if(diff >= 2){
			biggerHigh = 0;
			if(biggerElement.biggerElement != null) biggerHigh = biggerElement.biggerElement.high();
			
			smallerHigh = 0;
			if(biggerElement.smallerElement != null) smallerHigh = biggerElement.smallerElement.high();
			
			diff = biggerHigh - smallerHigh;
			//Problemfall doppelrotation links
			if(diff < 0){
				rotateDoubleLeft();
			}
			
			//rotation links
			else{
				
				int bigHigh = this.high();
				rotateLeft();
				this.high = bigHigh-1;
				this.smallerElement.high -= 2;
				
				
			}
		}else if(diff <= -2){
			biggerHigh = 0;
			if(smallerElement.biggerElement != null) biggerHigh = smallerElement.biggerElement.high();
			
			smallerHigh = 0;
			if(smallerElement.smallerElement != null) smallerHigh = smallerElement.smallerElement.high();
			
			diff = biggerHigh - smallerHigh;
			
			//Problemfall doppelrotation rechts
			if(diff > 0){
				rotateDoubleRight();
			}
			
			//rotation rechts
			else{
				int smallerhigh = this.smallerElement.high;
				rotateRight();
				this.high = smallerHigh+1;
				this.biggerElement.high -= 2;
			}
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

	private void rotateRight() {
		ADTTree copyOfThis = this.copy();
		ADTTree copyOfSmallerTree = this.smallerElement.copy();
		
		//k übernimmt die Position von d
		this.value = copyOfSmallerTree.getValue();
		if(copyOfSmallerTree.smallerElement != null){
			this.smallerElement = copyOfSmallerTree.smallerElement.copy();
		}else{
			this.smallerElement = null;
		}
		
		this.biggerElement = copyOfThis.copy();
		
		
		//Der rechte Teilbaum von k wird der neue linke Teilbaum von d. d selbst wird neuer rechter Teilbaum von k.
		if(copyOfSmallerTree.biggerElement != null){
			this.biggerElement.smallerElement = copyOfSmallerTree.biggerElement;
		}else{
			this.biggerElement.smallerElement = null;
		}
		
		
//		this.high = copyOfSmallerTree.high();
//		this.biggerElement.high -= 2;
		
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
		
//		this.high = copyOfBiggerTree.high();
//		this.smallerElement.high -= 2;
		
	}
	
	public ADTTree copy(){
		ADTTree tree = ADTTree.create();
		tree.insert(this.getValue());
		tree.biggerElement = this.biggerElement;
		tree.smallerElement = this.smallerElement;
		tree.high = this.high;
		return tree;
	}

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

	public int high(){
		return this.high;
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
	
//	private static boolean root = true;
//	private static String graph = "";
//	
//	private ADTTree smallerElement, biggerElement;
//	
//	private int smallerTreeHight, biggerTreeHight;
//	private int value;
//	private int high;
//	private static boolean rotatedLeft = false;
//	private static boolean rotatedRight = false;
//	
//	private ADTTree(){
//		smallerElement = null;
//		biggerElement = null;
//		smallerTreeHight = 0;
//		biggerTreeHight = 0;
//		this.value = -1;
//		this.high = 0;
//	}
//	
//	public static ADTTree create(){
//		return new ADTTree();
//	}
//	
//	public int insert(int elem){
//		if(value == -1){
//			this.high = 1;
//			value = elem;
//			return 0;
//		}
//		rotatedLeft = false;
//		rotatedRight = false;
//		if(elem > this.getValue()){
//			insertInBiggerTree(elem);
//		}else{
//			insertInSmallerTree(elem);
//		}
//		System.out.println("LEFT: " + smallerTreeHight);
//		return 0;
//		
//	}
//	
//
//
//	private int insertInSmallerTree(int elem) {
//		
//		
//			
//		if(smallerElement != null){
//			if(elem > this.value) {
//				if(insertInBiggerTree(elem) > 0) biggerTreeHight += 1;
//			}
//			if(smallerElement.insertInSmallerTree(elem) > 0) smallerTreeHight += 1;
//		}else{
//			smallerElement = smallerElement.create();
//			smallerElement.insert(elem);
//			smallerTreeHight++;
//		}
//		
//		
//		if(rotatedRight){
//			smallerTreeHight -= 1;
//		}
//		
//		int diff = biggerTreeHight - smallerTreeHight;
//		System.out.println("diff: " + diff);
//		if(diff <= -2){
//			diff = biggerElement.biggerTreeHight - biggerElement.smallerTreeHight;
//			if(diff > 0){
//				rotatedRight = true;
//				rotateRight();
//			}else if(diff < 0){
//				rotateLeft();
//				rotateRight();
//			}
//			System.out.println("jkj" + diff);
//			
//		}
//
//		return smallerTreeHight;
//	}
//
//	private int insertInBiggerTree(int elem) {
//		
//		if(biggerElement != null){
//			if(elem < this.value){
//				if(insertInSmallerTree(elem) > 0) smallerTreeHight += 1;
//			}
//			if(biggerElement.insertInBiggerTree(elem) > 0) biggerTreeHight += 1;
//		}else {
//			biggerElement = biggerElement.create();
//			biggerElement.insert(elem);
//			biggerTreeHight++;
//		}
//		
//		
//		if(rotatedLeft){
//			biggerTreeHight -= 1;
//		}
//		
//		int diff = biggerTreeHight - smallerTreeHight;
//		System.out.println("diff: " + diff);
//		if(diff >= 2){
//			diff = biggerElement.biggerTreeHight - biggerElement.smallerTreeHight;
//			System.out.println("value: " + value);
//			System.out.println("bigger: " + biggerElement.biggerTreeHight);
//			System.out.println("smaller: " + biggerElement.smallerTreeHight);
//			if(diff > 0){
//				rotatedLeft = true;
//				rotateLeft(1,0);
//			}else if(diff < 0){
//				rotateRight(2,1);
//				rotateLeft(2,1);
//			}
//			
//		}
//		diff = biggerTreeHight - smallerTreeHight;
//		return biggerTreeHight;
//	}
//
//private void rotateRight(int rotations, int rotate) {
//
//		
//		ADTTree tmpThis = this.copy();
//		ADTTree tmpSmaller = smallerElement.copy();
//		
//		this.value = smallerElement.getValue();
//		
//		try{
//			this.smallerElement = smallerElement.getSmallerElement();
//		}catch(Exception e){
//			this.smallerElement = null;
//		}
//		
//		this.biggerElement = tmpThis.copy();
//		this.biggerElement.setSmallerElement(tmpSmaller.getBiggerElement());
//		
//		this.biggerElement.biggerTreeHight = tmpThis.biggerTreeHight;
//		this.biggerElement.smallerTreeHight = tmpThis.biggerTreeHight;
//		
//		if(rotations == 1){
//			this.biggerTreeHight = tmpThis.biggerTreeHight + 1;
//			this.smallerTreeHight = tmpThis.biggerTreeHight + 1;
//		}
//	}
//
//	private void rotateLeft(int rotations, int rotate) {
//
//		
//		System.out.println("VALUE: " + this.value);
//		ADTTree tmpThis = this.copy();
//		ADTTree tmpBigger = this.getBiggerElement().copy();
//		
//		this.value = biggerElement.getValue();
//		
//		try{
//			this.biggerElement = biggerElement.getBiggerElement();
//		}catch(Exception e){
//			this.biggerElement = null;
//		}
//		
//		this.smallerElement = tmpThis.copy();
//		this.smallerElement.setBiggerElement(tmpBigger.getSmallerElement());
//		
//		this.smallerElement.smallerTreeHight = tmpThis.smallerTreeHight;
//		this.smallerElement.biggerTreeHight = tmpThis.smallerTreeHight;
//		
//		
//	}
//	
//	
//
//	private ADTTree copy() {
//		ADTTree tree = ADTTree.create();
//		tree.insert(this.value);
//		tree.setBiggerElement(this.getBiggerElement());
//		tree.setSmallerElement(this.getSmallerElement());
//		return tree;
//	}
//
//
//	public ADTTree getSmallerElement() {
//		return smallerElement;
//	}
//
//	public void setSmallerElement(ADTTree smallerElement) {
//		this.smallerElement = smallerElement;
//	}
//
//	public ADTTree getBiggerElement() {
//		return biggerElement;
//	}
//
//	public void setBiggerElement(ADTTree biggerElement) {
//		this.biggerElement = biggerElement;
//	}
//
//	private void setValue(int tmp) {
//		this.value = tmp;
//	}
//
//	public int getValue(){
//		return this.value;
//	}
//	
//	
//	public void createPNG(String path, String fileName) {
//		
//		int stop = -1;
//		
//			
//			if(root){
//				stop = value;
//				root = false;
//				
//				graph += "digraph G {\n";
//			}
//			if(biggerElement != null) {
//				
//				graph += this.getValue() + " -> " + biggerElement.getValue() + "\n";
//				biggerElement.createPNG(path, fileName);
//			}
//			
//			if(smallerElement != null) {
//				
//				graph += this.getValue() + " -> " + smallerElement.getValue() + "\n";
//				smallerElement.createPNG(path, fileName);
//			}
//			
//			if(stop == value){
//				writeStringInFile(path, fileName);
//			}
//		
//		
//	}
//	private void writeStringInFile(String path, String fileName) {
//		String[] fileNameWithoutEnding = fileName.split("\\.");
//		try {
//			File file = new File(path + fileName);
//			file.createNewFile();
//
//			PrintWriter writer = new PrintWriter(file);
//			
//			writer.write(graph + "}");
//			
//			writer.close();
//			
//			TreePNG.treeToPNG(path + fileName, "/home/murat/Dokumente/Uni/AD/Termin3/programme/Graphen/Bilder/" + fileNameWithoutEnding[0] + ".png");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public String getGraph(){
//		return graph;
//	}
//
//	public int getSmallerTreeHight() {
//		return smallerTreeHight;
//	}
//
//	public void setSmallerTreeHight(int smallerTreeHight) {
//		this.smallerTreeHight = smallerTreeHight;
//	}
//
//	public int getBiggerTreeHight() {
//		return biggerTreeHight;
//	}
//
//	public void setBiggerTreeHight(int biggerTreeHight) {
//		this.biggerTreeHight = biggerTreeHight;
//	}
//
//	
	
}
