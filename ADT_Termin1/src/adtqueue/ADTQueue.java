package adtqueue;

import adtstack.ADTStack;

public class ADTQueue {
	
	//Variablen
	ADTStack stack1;
	ADTStack stack2;
	
	//Konstruktor
	private ADTQueue() {
		
	}
	
	//Operationen
	
	//create
	public ADTQueue create() {
		return new ADTQueue();
	}
	
	//isEmpty
	public boolean isEmpty() {
		return false;
	}
	
	//enqueue
	public ADTQueue enqueue(int elem) {
		return new ADTQueue();
	}
	
	//dequeue
	public ADTQueue dequeue() {
		return new ADTQueue();
	}
	
	//front
	public int front() {
		return -1;
	}

}
