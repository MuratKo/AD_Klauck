package junitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adtstack.ADTStack;

public class ADTStackTest {
	
	ADTStack stack1 = ADTStack.createS();

	@Test
	public void testTop() {
		assertEquals(0, stack1.top()); //0 ist Fehlerbehandlung
		stack1.push(15);
		stack1.push(16);
		stack1.push(17);
		assertEquals(17, stack1.top());
		for(int i=1; i <= 5000; i++){
			stack1.push(i);
		}
		assertEquals(5000, stack1.top());
		while(!stack1.isEmptyS()){
			stack1.pop();
		}
		assertEquals(0,stack1.top());
	}
	
	@Test
	public void testPop() {
		stack1.push(15);
		stack1.push(16);
		stack1.push(17);
		stack1.pop();
		assertEquals(16, stack1.top());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(stack1.isEmptyS());
		stack1.push(18);
		stack1.push(6);
		stack1.push(2);
		stack1.pop();
		assertFalse(stack1.isEmptyS());
		stack1.pop();
		stack1.pop();
		assertTrue(stack1.isEmptyS());
	}

}
