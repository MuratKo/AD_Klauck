package junitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adtstack.ADTStack;

public class ADTStackFunctionalTest {
	
	ADTStack stack;

	@Before
	public void setUp() throws Exception {
		stack = ADTStack.createS();
	}

	@Test
	public void isEmptyTest() {
		assertTrue(stack.isEmptyS());
		
		stack = stack.push(1);
		assertFalse(stack.isEmptyS());
		
		stack = stack.push(2);
		assertFalse(stack.isEmptyS());
	}
	
	@Test
	public void pushTest() {
		
		stack = stack.push(1);
		assertEquals(1, stack.top());
		
		stack = stack.push(2);
		stack = stack.push(3);
		
		assertEquals(3, stack.top());
		
		stack = stack.push(4);
		
		stack = stack.push(3.25);
		assertEquals(4, stack.top());
	}
	
	@Test
	public void popTest() {
		
		assertTrue(stack.isEmptyS());
		stack = stack.pop();
		assertTrue(stack.isEmptyS());
		
		stack = stack.push(1);
		stack = stack.push(2);
		stack = stack.push(3);
		
		stack = stack.pop();
		
		assertEquals(2, stack.top());
	}

	@Test
	public void topTest() {
		
		assertEquals(-1, stack.top());
		stack = stack.push(1);
		stack = stack.push(2);
		stack = stack.push(3);
		assertEquals(3, stack.top());
		
	}
}
