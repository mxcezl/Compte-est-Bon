package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestOpe {

	@Test
	void testSous() {
		Operateur op = Operateur.SOUSTRACTION;
		int a=6, b=5;
		assertTrue(op.test.apply(a,b));
		assertEquals(op.calcul.apply(a,b).intValue(), 1);	
	}
	
	@Test
	void testAdd() {
		Operateur op = Operateur.ADDITION;
		int a=4, b=9;
		assertTrue(op.test.apply(a,b));
		assertEquals(op.calcul.apply(a,b).intValue(), a + b);	
	}
	
	@Test
	void testMult() {
		Operateur op = Operateur.MULTIPLICATION;
		int a=9, b=3;
		assertTrue(op.test.apply(a,b));
		assertEquals(op.calcul.apply(a,b).intValue(), a * b);	
	}
	
	@Test
	void testDiv() {
		Operateur op = Operateur.SOUSTRACTION;
		int a=4, b=2;
		assertTrue(op.test.apply(a,b));
		assertEquals(op.calcul.apply(a,b).intValue(), a / b);	
	}
}