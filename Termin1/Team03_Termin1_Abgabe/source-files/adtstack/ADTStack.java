package adtstack;

import adtliste.ADTList;
import adtqueue.ADTQueue;

public class ADTStack {
	
	private ADTList internalViewOfStack;
	
	private ADTStack() {
		internalViewOfStack = ADTList.create();
	}
	
	//Methode muss statisch sein, da sonst kein Objekt erzeugt werden kann
	public static ADTStack createS(){
		return new ADTStack();
	}
	
	//push (Element oben auf den Stack legen)
	public ADTStack push(int element){
		
		ADTList copy = internalViewOfStack;
		copy = copy.insert(element, copy.laenge()+1); //Jüngstes Element ganz rechts in der Liste
		ADTStack returnStack = ADTStack.createS();
		returnStack.setInternalViewOfStack(copy);
		
		
		
		return returnStack;
	
	}
		//Fehlerbehandlung (es wurde kein int übergeben)
		public ADTStack push(Object element){
			return this;
		}
	
		private ADTList getInternalViewOfStack() {
			return internalViewOfStack;
		}
	
		private void setInternalViewOfStack(ADTList internalViewOfStack) {
			this.internalViewOfStack = internalViewOfStack;
		}
		

	//pop (obersten Element löschen)
	public ADTStack pop(){
		//Fehlerbehandlung
		if(this.isEmptyS()){return this;}
		
		ADTList copy = internalViewOfStack;
		copy = copy.delete(copy.laenge()); 
		ADTStack returnStack = ADTStack.createS();
		returnStack.setInternalViewOfStack(copy);
		return returnStack;

	}
	
	//top (obersten Element zurückgeben)
	public int top(){
		int returnValue = -1; //Fehlerbehandlung
		if(!internalViewOfStack.isEmpty()){
			returnValue = internalViewOfStack.retrieve(internalViewOfStack.laenge());
		}
		return returnValue;
	}
	
	//isEmptyS
	public boolean isEmptyS(){
		return internalViewOfStack.isEmpty();
	}
	
	@Override
    public boolean equals(Object o) {
		
        if (o == this) return true;
        
        if(o instanceof ADTStack){
        	ADTStack s1 = ADTStack.createS();
    		s1.setInternalViewOfStack(this.getInternalViewOfStack());
    		
    		ADTStack s2 = ADTStack.createS();
    		s2.setInternalViewOfStack(((ADTStack) o).getInternalViewOfStack());
    		
    		
        	while(!s1.isEmptyS()){
        		if(!(s1.top() == s2.top())) return false;
        		s1 = s1.pop();
        		s2 = s2.pop();
        	}
        	if(!s2.isEmptyS()) return false;
        	
        }else{
        	return false;
        }
        	
        return true;
    }

}
