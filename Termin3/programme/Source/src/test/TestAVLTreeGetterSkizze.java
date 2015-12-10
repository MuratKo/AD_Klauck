package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import adt.AVLTreeGetter;
import adtarray.ADTArray;
import einleser.Einleser;

public class TestAVLTreeGetterSkizze {

	AVLTreeGetter treeA;
	AVLTreeGetter treeB;
	AVLTreeGetter treeC;
	AVLTreeGetter treeD;
	AVLTreeGetter treeE;
	AVLTreeGetter treeF;
	
	AVLTreeGetter treeA2;
	AVLTreeGetter treeB2;
	AVLTreeGetter treeC2;
	AVLTreeGetter treeD2;
	AVLTreeGetter treeE2;
	AVLTreeGetter treeF2;
	
	AVLTreeGetter treeA3;
	AVLTreeGetter treeB3;
	AVLTreeGetter treeC3;

	public static final String PATH = "C:/Users/abp516.INFORMATIK/Documents/AD_Klauck/Termin3/Tests/";
	
	@Before
	public void setUp() throws Exception {
		treeA = AVLTreeGetter.create();
		treeB = AVLTreeGetter.create();
		treeC = AVLTreeGetter.create();
		treeD = AVLTreeGetter.create();
		treeE = AVLTreeGetter.create();
		treeF = AVLTreeGetter.create();
		
		treeA2 = AVLTreeGetter.create();
		treeB2 = AVLTreeGetter.create();
		treeC2 = AVLTreeGetter.create();
		treeD2 = AVLTreeGetter.create();
		treeE2 = AVLTreeGetter.create();
		treeF2 = AVLTreeGetter.create();
		
		treeA3 = AVLTreeGetter.create();
		treeB3 = AVLTreeGetter.create();
		treeC3 = AVLTreeGetter.create();
	}
	
	@Test
	public void testBalanceA(){
		//AVL Baum mit einem Knoten
		treeA.insert(1);
		assertTrue(treeA.high()==1);
	}
	
	@Test
	public void testBalanceB(){
		//AVL Baum mit keinem Knoten
		assertTrue(treeB.isEmpty());
	}
	
	@Test
	public void testBalanceC(){
		//Linksrotation erzwingen
		treeC.insert(1);
		treeC.insert(2);
		treeC.insert(3);
		
		boolean boolLeft, boolRight;
		boolLeft = testBalanceOfChildLeft(treeC);
		boolRight = testBalanceOfChildRight(treeC);

		assertTrue(boolLeft&&boolRight);
	}
	
	@Test
	public void testBalanceD(){
		//Rechtsrotation erzwingen
		treeD.insert(3);
		treeD.insert(2);
		treeD.insert(1);
		
		boolean boolLeft, boolRight;
		boolLeft = testBalanceOfChildLeft(treeD);
		boolRight = testBalanceOfChildRight(treeD);

		assertTrue(boolLeft&&boolRight);
	}
	
	@Test
	public void testBalanceE(){
		//Problemsituation links erzwingen
		treeE.insert(20);
		treeE.insert(19);
		treeE.insert(30);
		treeE.insert(18);
		treeE.insert(25);
		treeE.insert(40);
		treeE.insert(41);
		treeE.insert(24);
		treeE.insert(28);
		treeE.insert(23);
		
		boolean boolLeft, boolRight;
		boolLeft = testBalanceOfChildLeft(treeE);
		boolRight = testBalanceOfChildRight(treeE);
		
		assertTrue(boolLeft&&boolRight);
		
	}
	
	@Test
	public void testBalanceF(){
		//Problemsituation rechts erzwingen
		treeF.insert(20);
		treeF.insert(15);
		treeF.insert(21);
		treeF.insert(22);
		treeF.insert(14);
		treeF.insert(18);
		treeF.insert(13);
		treeF.insert(17);
		treeF.insert(19);
		treeF.insert(16);
		
		boolean boolLeft, boolRight;
		boolLeft = testBalanceOfChildLeft(treeF);
		boolRight = testBalanceOfChildRight(treeF);
		
		assertTrue(boolLeft&&boolRight);
		
	}
	
	@Test
	public void testInsertA(){
		//500
		int anzahl = 500;
		for(int i=0;i<anzahl;i++) {
			treeA2.insert(i+1);
		}
		
		boolean boolLeft, boolRight;
		boolLeft = testBalanceOfChildLeft(treeA2);
		boolRight = testBalanceOfChildRight(treeA2);
		
		assertTrue(boolLeft&&boolRight);
		
	}
	
	@Test
	public void testInsertB(){

		einleser.Einleser ein = new Einleser(PATH + "1000WithoutDublicates.dat");
		adtarray.ADTArray array = ADTArray.initA();
		array = ein.parse(array);
		
		int anzahl = 1000;
		for(int i=0;i<anzahl;i++) {
			treeB2.insert(array.getA(i));
		}
		
		boolean boolLeft, boolRight;
		boolLeft = testBalanceOfChildLeft(treeB2);
		boolRight = testBalanceOfChildRight(treeB2);
		
		assertTrue(boolLeft&&boolRight);
		
	}
	
	@Test
	public void testInsertC(){

		einleser.Einleser ein = new Einleser(PATH + "2000WithoutDublicates.dat");
		adtarray.ADTArray array = ADTArray.initA();
		array = ein.parse(array);
		
		int anzahl = 2000;
		for(int i=0;i<anzahl;i++) {
			treeC2.insert(array.getA(i));
		}
		//treeC2.print(PATH + "png/", "treeC2.gv");
		boolean boolLeft, boolRight;
		boolLeft = testBalanceOfChildLeft(treeC2);
		boolRight = testBalanceOfChildRight(treeC2);
		
		assertTrue(boolLeft&&boolRight);
		
	}
	
	@Test
	public void testInsertF(){

		einleser.Einleser ein = new Einleser(PATH + "16000WithoutDublicates.dat");
		adtarray.ADTArray array = ADTArray.initA();
		array = ein.parse(array);
		
		
		int anzahl = 16000;
		for(int i=0;i<anzahl;i++) {
			treeF2.insert(array.getA(i));
		}
		
		boolean boolLeft, boolRight;
		boolLeft = testBalanceOfChildLeft(treeF2);
		boolRight = testBalanceOfChildRight(treeF2);
		
		assertTrue(boolLeft&&boolRight);
		
	}
	
	@Test
	public void testDeleteA(){
		
		//sortiert insert 1,2,3 .. 100
		int anzahl = 100;
		for(int i = 0; i < anzahl; i++){
			treeA3.insert(i+1);
		}
		assertFalse(treeA3.high()==0);
		
		//delete all
		for(int i = 0; i < anzahl; i++){
			treeA3.delete(i+1);
		}
		assertTrue(treeA3.high()==0);
	}
	
	@Test
	public void testDeleteB(){
		
		//sortiert insert 1,2,3 .. 1.000
		int anzahl = 1000;
		for(int i = 0; i < anzahl; i++){
			treeB3.insert(i+1);
		}
		assertFalse(treeB3.high()==0);
		
		//delete all
		for(int i = 0; i < anzahl; i++){
			treeB3.delete(i+1);
		}
		assertTrue(treeB3.high()==0);
	}
	
	@Test
	public void testDeleteC(){
		
		//sortiert insert 1,2,3 .. 2.000
		int anzahl = 2000;
		for(int i = 0; i < anzahl; i++){
			treeB3.insert(i+1);
		}
		assertFalse(treeB3.high()==0);
		
		//delete 1.999
		for(int i = 0; i < anzahl-1; i++){
			treeB3.delete(i+1);
		}
		assertTrue(treeB3.high()==1);
	}
	

	
	/**BALANCE-Left*/
	private boolean testBalanceOfChildLeft(AVLTreeGetter inAVL) {

		int leftHigh;
		int rightHigh;
		
		//Abbruch (Blatt)
		if(inAVL.getSmallerTree() == null && inAVL.getBiggerTree() == null) {return true;}
		
		//Linkes Kind vorhanden?
		if(inAVL.getSmallerTree() != null) {
			//Hoehe des Linken Kindes auslesen
			leftHigh = inAVL.getSmallerTree().high();
				//Sollte Rechtes Kind vorhanden sein -> Vergleichen
				if(inAVL.getBiggerTree() != null) {
					//Hoehe des Rechten Kindes auslesen
					rightHigh = inAVL.getBiggerTree().high();
					if(rightHigh-leftHigh > -2 && rightHigh-leftHigh < 2) {
						//System.out.println("Parent: "+inAVL.getValue()+" -> "+"KindRechts:"+inAVL.getBiggerTree().getValue()+"("+rightHigh+")"+"-"+"Knoten:"+inAVL.getSmallerTree().getValue()+"("+leftHigh+")"+"= "+(rightHigh-leftHigh));
						return (testBalanceOfChildLeft(inAVL.getSmallerTree()) && testBalanceOfChildRight(inAVL.getBiggerTree()));
					}
					else {
						System.out.println("false");
						return false;
					}
				}
			//Kein Rechtes Kind zum Vergleich vorhanden
			return testBalanceOfChildLeft(inAVL.getSmallerTree());
		}
		else {
			//Nur Rechtes Kind zum Vergleich vorhanden
			if(inAVL.getBiggerTree().high() < 2)
			return testBalanceOfChildLeft(inAVL.getBiggerTree());
		}
		return false; //hier sollte ich niemals ankommen
	}
	
	/**BALANCE-Right*/
	private boolean testBalanceOfChildRight(AVLTreeGetter inAVL) {

		int leftHigh;
		int rightHigh;
		
		//Abbruch (Blatt)
		if(inAVL.getSmallerTree() == null && inAVL.getBiggerTree() == null) {return true;}
		
		//Rechtes Kind vorhanden?
		if(inAVL.getBiggerTree() != null) {
			//Hoehe des Rechtes Kindes auslesen
			rightHigh = inAVL.getBiggerTree().high();
				//Sollte Linkes Kind vorhanden sein -> Vergleichen
				if(inAVL.getSmallerTree() != null) {
					//Hoehe des Rechten Kindes auslesen
					leftHigh = inAVL.getSmallerTree().high();
					if(rightHigh-leftHigh > -2 && rightHigh-leftHigh < 2) {
						//System.out.println("Parent: "+inAVL.getValue()+" -> "+"KindRechts:"+inAVL.getBiggerTree().getValue()+"("+rightHigh+")"+"-"+"Knoten:"+inAVL.getSmallerTree().getValue()+"("+leftHigh+")"+"= "+(rightHigh-leftHigh));
						return (testBalanceOfChildRight(inAVL.getBiggerTree()) && testBalanceOfChildLeft(inAVL.getSmallerTree()));
					}
					else {
						System.out.println("false");
						return false;
					}
				}
			//Kein Rechtes Kind zum Vergleich vorhanden
			return testBalanceOfChildRight(inAVL.getBiggerTree());
		}
		else {
			//Nur Linkes Kind zum Vergleich vorhanden
			if(inAVL.getSmallerTree().high() < 2)
			return testBalanceOfChildLeft(inAVL.getSmallerTree());
		}
		return false; //hier sollte ich niemals ankommen
	}
	
	/**VALUE*/
	private boolean testValueOfChild(AVLTreeGetter inAVL) {

		//Abbruch (Blatt)
		if(inAVL.getSmallerTree() == null && inAVL.getBiggerTree() == null) {return true;}
		
		//Linkes Kind vorhanden?
		if(inAVL.getSmallerTree() != null) {
			//Values vergleichen
			if(inAVL.getValue() > inAVL.getSmallerTree().getValue()) {
				//Ist auch Rechtes Kind vorhanden?
				if(inAVL.getBiggerTree() != null) {	
					//Values vergleichen
					if(inAVL.getValue() < inAVL.getBiggerTree().getValue()) {
						//Mit beiden Kindern in die Rekursion
						//System.out.println(inAVL.getBiggerTree().getValue()+">"+inAVL.getValue()+">"+inAVL.getSmallerTree().getValue());
						return (testValueOfChild(inAVL.getSmallerTree()) && testValueOfChild(inAVL.getBiggerTree()));
					}	
					else {
						return false;
					}
				}
				//Sonst nur mit linkem Kind
				//System.out.println(inAVL.getValue()+">"+inAVL.getSmallerTree());
				return testValueOfChild(inAVL.getSmallerTree());
			}
			//ELSE-Fall falls Vergleich nicht stimmt
			else {
				return false;
			}
		}
			
		//Rechtes Kind vorhanden?
		if(inAVL.getBiggerTree() != null) {
			//Values vergleichen
			if(inAVL.getValue() < inAVL.getBiggerTree().getValue()) {
				//System.out.println(inAVL.getBiggerTree().getValue()+">"+inAVL.getValue());
				return testValueOfChild(inAVL.getBiggerTree());
			}
			//ELSE-Fall falls Vergleich nicht stimmt
			else {
				return false;
			}
		}		
		return false; //Hier sollte ich niemals ankommen
	}

}
