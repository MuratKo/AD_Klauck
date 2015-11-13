package junitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adtqueue.ADTQueue;

public class ADTQueueFunctionalTest2 {

ADTQueue q1;
	
	@Before
	public void setUp() throws Exception {
		q1 = ADTQueue.createQ();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(q1.isEmptyQ());
		//100 Elemente einfuegen
		for(int i=1; i<=200; i++) {
			q1 = q1.enqueue(i);
		}
		assertFalse(q1.isEmptyQ());
		//Vorderstes Element ist die 1
		assertEquals(1, q1.front());
		//Die ersten 90 Elemente enfernen
		for(int i=1; i<=90; i++) {
			q1 = q1.dequeue();
		}
		//Vorderstes Element ist jetzt die 91
		assertEquals(91, q1.front());
	}
	
	@Test
	public void testIsEmpty2() {
		q1 = q1.enqueue(1);
		assertFalse(q1.isEmptyQ());;
		//9999 Elemente zusaetzlich einfuegen => 10.000 Elemente
		for(int i=2; i<=10000; i++) {
			q1 = q1.enqueue(i);
		}
		assertFalse(q1.isEmptyQ());
		//Vorderstes Element ist die 1
		assertEquals(1, q1.front());
		
		//Die ersten 999 Elemente enfernen
		for(int i=1; i<=999; i++) {
			q1 = q1.dequeue();
		}
		//Vorderstes Element ist jetzt die 1000
		assertEquals(1000, q1.front());
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
		q1 = q1.enqueue(3);
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
		//Fehlerbehandlung
		assertEquals(-1,q1.front());
		
		q1 = q1.enqueue(1);
		q1 = q1.enqueue(2);
		q1 = q1.enqueue(3);
		assertEquals(1, q1.front());
		q1 = q1.dequeue();
		assertEquals(2, q1.front());
		
	}

}
