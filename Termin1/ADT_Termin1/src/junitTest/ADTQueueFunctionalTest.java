package junitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adtqueue.ADTQueue;

public class ADTQueueFunctionalTest {

	ADTQueue q1;
	
	@Before
	public void setUp() throws Exception {
		q1 = ADTQueue.createQ();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(q1.isEmptyQ());
	}
	
	@Test
	public void testIsEmpty2() {
		q1 = q1.enqueue(1);
		assertFalse(q1.isEmptyQ());;
	}
	
	@Test
	public void testEnqueue() {
		q1 = q1.enqueue(1);
		assertEquals(1, q1.front());;
	}
	
	@Test
	public void testEnqueue2() {
		q1 = q1.enqueue(3.25);
		assertTrue(q1.isEmptyQ());
	}
	
	@Test
	public void testEnqueue3() {
		q1 = q1.enqueue(1);
		assertEquals(1, q1.front());
		q1 = q1.enqueue(2);
		assertEquals(1, q1.front());
	}
	
	@Test
	public void testDequeue() {
		q1 = q1.enqueue(1);
		assertEquals(1, q1.front());
		q1 = q1.enqueue(2);
		assertEquals(1, q1.front());
		q1 = q1.dequeue();
		assertEquals(2, q1.front());
	}
	
	@Test
	public void testFront() {
		q1 = q1.enqueue(1);
		q1 = q1.enqueue(2);
		q1 = q1.enqueue(3);
		assertEquals(1, q1.front());
		q1 = q1.dequeue();
		assertEquals(2, q1.front());
		
	}

}
