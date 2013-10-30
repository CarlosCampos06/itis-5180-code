package com.example.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TestMain {

	@Before
	public void init(){
		System.out.println("Here");
	}
	
	@Test
	@Ignore(value="Will be done later")
	public void notImplemented(){
		throw new RuntimeException("Implement me !!");
	}
	
	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		double result = calculator.add(100.0, 200.0);
		assertEquals(300.0, result, 0);
	}
	
	@Test
	public void testSubtract() {
		Calculator calculator = new Calculator();
		double result = calculator.subtract(100.0, 200.0);
		assertEquals(-100.0, result, 0);
	}
	
	@Test
	public void testMultiply() {
		Calculator calculator = new Calculator();
		double result = calculator.multiply(100.0, 200.0);
		assertEquals(100.0*200.0, result, 0);
	}
	
	@Test
	public void testDivide() {
		Calculator calculator = new Calculator();
		double result = calculator.divide(100.0, 200.0);
		assertEquals(100.0/200.0, result, 0);
	}

}
