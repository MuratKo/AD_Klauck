package ADTTree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx.Snapshot;

import Helper.TreePNG;

public class ADTTree {

	private static boolean root = true;
	private static String graph = "";
	
	private ADTTree smallerElement, biggerElement;
	private int smallerTreeHight, biggerTreeHight;
	int value;
	private static boolean rotatedLeft = false;
	private static boolean rotatedRight = false;
	
	private ADTTree(int value){
		smallerElement = null;
		biggerElement = null;
		this.value = value;
		smallerTreeHight = 0;
		biggerTreeHight = 0;
	}
	
	public static ADTTree create(int value){
		return new ADTTree(value);
	}
	
	public int insert(int elem){
		rotatedLeft = false;
		rotatedRight = false;
		if(elem > this.getValue()){
			insertInBiggerTree(elem);
		}else{
			insertInSmallerTree(elem);
		}
		System.out.println("LEFT: " + smallerTreeHight);
		return 0;
		
	}
	


	private int insertInSmallerTree(int elem) {
		
		if(elem > this.value) insertInBiggerTree(elem);

		if(smallerElement != null){
			if(smallerElement.insertInSmallerTree(elem) > 0) smallerTreeHight += 1;
		}else{
			smallerElement = smallerElement.create(elem);
			smallerTreeHight++;
		}
		
		
		if(rotatedRight){
			smallerTreeHight -= 1;
		}
		
		int diff = biggerTreeHight - smallerTreeHight;
		if(diff <= -2){
			rotatedRight = true;
			rotateRight();
		}

		return smallerTreeHight;
	}

	private int insertInBiggerTree(int elem) {
		
		if(elem < this.value) insertInSmallerTree(elem);

		if(biggerElement != null){
			if(biggerElement.insertInBiggerTree(elem) > 0) biggerTreeHight += 1;
		}else{
			biggerElement = biggerElement.create(elem);
			biggerTreeHight++;
		}
		
		
		if(rotatedLeft){
			biggerTreeHight -= 1;
		}
		
		int diff = biggerTreeHight - smallerTreeHight;
		if(diff >= 2){
			rotatedLeft = true;
			rotateLeft();
		}
		diff = biggerTreeHight - smallerTreeHight;
		return biggerTreeHight;
	}

private void rotateRight() {

		
		ADTTree tmpThis = this.copy();
		ADTTree tmpSmaller = smallerElement.copy();
		
		this.value = smallerElement.getValue();
		
		try{
			this.smallerElement = smallerElement.getSmallerElement();
		}catch(Exception e){
			this.smallerElement = null;
		}
		
		this.biggerElement = tmpThis.copy();
		this.biggerElement.setSmallerElement(tmpSmaller.getBiggerElement());
		
		this.biggerElement.biggerTreeHight = tmpThis.biggerTreeHight;
		this.biggerElement.smallerTreeHight = tmpThis.biggerTreeHight;
		
		this.biggerTreeHight = tmpThis.biggerTreeHight + 1;
		this.smallerTreeHight = tmpThis.biggerTreeHight + 1;
	}

	private void rotateLeft() {

		
		System.out.println("VALUE: " + this.value);
		ADTTree tmpThis = this.copy();
		ADTTree tmpBigger = this.getBiggerElement().copy();
		
		this.value = biggerElement.getValue();
		
		try{
			this.biggerElement = biggerElement.getBiggerElement();
		}catch(Exception e){
			this.biggerElement = null;
		}
		
		this.smallerElement = tmpThis.copy();
		this.smallerElement.setBiggerElement(tmpBigger.getSmallerElement());
		
		this.smallerElement.smallerTreeHight = tmpThis.smallerTreeHight;
		this.smallerElement.biggerTreeHight = tmpThis.smallerTreeHight;
		
		this.smallerTreeHight = tmpThis.smallerTreeHight + 1;
		this.biggerTreeHight = tmpThis.smallerTreeHight + 1;
	}
	
	

	private ADTTree copy() {
		ADTTree tree = ADTTree.create(this.getValue());
		tree.setBiggerElement(this.getBiggerElement());
		tree.setSmallerElement(this.getSmallerElement());
		return tree;
	}


	public ADTTree getSmallerElement() {
		return smallerElement;
	}

	public void setSmallerElement(ADTTree smallerElement) {
		this.smallerElement = smallerElement;
	}

	public ADTTree getBiggerElement() {
		return biggerElement;
	}

	public void setBiggerElement(ADTTree biggerElement) {
		this.biggerElement = biggerElement;
	}

	private void setValue(int tmp) {
		this.value = tmp;
	}

	public int getValue(){
		return this.value;
	}
	
	
	public void createPNG(String path, String fileName) {
		
		int stop = -1;
		
			
			if(root){
				stop = value;
				root = false;
				
				graph += "digraph G {\n";
			}
			if(biggerElement != null) {
				
				graph += this.getValue() + " -> " + biggerElement.getValue() + "\n";
				biggerElement.createPNG(path, fileName);
			}
			
			if(smallerElement != null) {
				
				graph += this.getValue() + " -> " + smallerElement.getValue() + "\n";
				smallerElement.createPNG(path, fileName);
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

	public String getGraph(){
		return graph;
	}

	public int getSmallerTreeHight() {
		return smallerTreeHight;
	}

	public void setSmallerTreeHight(int smallerTreeHight) {
		this.smallerTreeHight = smallerTreeHight;
	}

	public int getBiggerTreeHight() {
		return biggerTreeHight;
	}

	public void setBiggerTreeHight(int biggerTreeHight) {
		this.biggerTreeHight = biggerTreeHight;
	}

	
	
}
