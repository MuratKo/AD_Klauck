package adtqueue;

import adtarray.ADTArray;
import adtstack.ADTStack;

public class ADTQueue {
	
	//Variablen
	ADTStack stackIN;
	ADTStack stackOUT;
	
	//Konstruktor
	private ADTQueue() {
		stackIN = ADTStack.createS();
		stackOUT = ADTStack.createS();
	}
	
	//Operationen
	
	//create
	public static ADTQueue createQ() {
		return new ADTQueue();
	}
	
	
	//isEmpty
	public boolean isEmptyQ() {
		if(this.getStackIN().isEmptyS() && this.getStackOUT().isEmptyS()) {
			return true;
		}
		return false;
	}
	
	
	//enqueue (haengt ein Element an)
	public ADTQueue enqueue(int element) {
		//Copy Old Queue-Stacks
		ADTStack copyIN = stackIN;
		ADTStack copyOUT = stackOUT;
		//Add element to stack 1
		copyIN = copyIN.push(element);
		ADTQueue returnQueue = ADTQueue.createQ();
		returnQueue.setStackIN(copyIN);
		returnQueue.setStackOUT(copyOUT);
		return returnQueue;
	}
		//Fehlerbehandlung (es wurde kein int übergeben)
		public ADTQueue enqueue(Object element){
			return this;
		}
	
	
	//dequeue (entfernt das vorderste Element)
	public ADTQueue dequeue() {
		
		//Fehlerbehandlung (Queue is totally empty)
		if(this.isEmptyQ()) {
			return this;
		}
		//Copy Old Queue-Stacks to return Queue
		ADTQueue returnQueue = ADTQueue.createQ();
		returnQueue.setStackIN(this.getStackIN());
		returnQueue.setStackOUT(this.getStackOUT());

		//Umstapeln, fall noetig):
		if(this.stackOUT.isEmptyS()) {
			returnQueue = umstapeln(this.getStackIN(), this.getStackOUT());
		}
		//vorderste Element entfernen
		returnQueue.setStackOUT(returnQueue.getStackOUT().pop());
		
		return returnQueue;
	}
	
	
	//front
	public int front() {
		
		int returnValue;;
		
		//Fehlerbehandlung (Queue is totally empty)
		if(this.isEmptyQ()) {
			returnValue = -1;
		}
		else {
			//Umstapeln, falls noetig):
			if(this.getStackOUT().isEmptyS()) {
				//Copy to stay functional
				ADTQueue copy = umstapeln(this.getStackIN(), this.getStackOUT());
				returnValue = copy.getStackOUT().top();
			//Einfach aeltestes Element zurueck geben
			} else {
				returnValue = this.getStackOUT().top();
			}
		}
		return returnValue;
	}

	
		//Getter- und Setter-Methoden
		private ADTStack getStackIN() {
			return stackIN;
		}
	
		private void setStackIN(ADTStack stackIN) {
			this.stackIN = stackIN;
		}
	
		private ADTStack getStackOUT() {
			return stackOUT;
		}
	
		private void setStackOUT(ADTStack stackOUT) {
			this.stackOUT = stackOUT;
		}
		
		//Umstapeln
		private ADTQueue umstapeln(ADTStack stackINPUT, ADTStack stackOUTPUT) {
			while(!stackINPUT.isEmptyS()) {
				int tmpElement = stackINPUT.top();
				stackOUTPUT = stackOUTPUT.push(tmpElement);
				stackINPUT = stackINPUT.pop();
			}
		    ADTQueue umgestapelt = ADTQueue.createQ();
		    umgestapelt.setStackIN(stackINPUT);
		    umgestapelt.setStackOUT(stackOUTPUT);
		    return umgestapelt;
		}
		
		@Override
	    public boolean equals(Object o) {
			
	        if (o == this) return true;
	        
	        if(o instanceof ADTQueue){
	        	ADTQueue q1 = ADTQueue.createQ();
	    		q1.setStackIN(this.getStackIN());
	    		q1.setStackOUT(this.getStackOUT());
	    		
	    		ADTQueue q2 = ADTQueue.createQ();
	    		q2.setStackIN(((ADTQueue) o).getStackIN());
	    		q2.setStackOUT(((ADTQueue) o).getStackOUT());
	    		
	    		
	        	while(!q1.isEmptyQ()){
	        		if(!(q1.front() == q2.front())) return false;
	        		q1 = q1.dequeue();
	        		q2 = q2.dequeue();
	        	}
	        	if(!q2.isEmptyQ()) return false;
	        	
	        }else{
	        	return false;
	        }
	        	
	        return true;
	    }

}
