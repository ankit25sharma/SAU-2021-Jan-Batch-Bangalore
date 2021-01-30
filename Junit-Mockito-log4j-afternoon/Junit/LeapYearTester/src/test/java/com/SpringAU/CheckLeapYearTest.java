package com.SpringAU;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CheckLeapYearTest {

	CheckLeapYear obj;
	
	@BeforeEach
	void Init() {
		obj = new CheckLeapYear();
	}
	@Test
	void testCheckLeapYear() {
		//CheckLeapYear obj = new CheckLeapYear();
		boolean result = obj.checkLeapYear(2003);
		assertEquals(false, result);
	}
	
	@Test
	void testCheckLeapYear1() {
		//CheckLeapYear obj = new CheckLeapYear();
		boolean result = obj.checkLeapYear(2012);
		assertEquals(true, result);
	}
	
	@Test
	void testCheckLeapYear2() {
		//CheckLeapYear obj = new CheckLeapYear();
		boolean result = obj.checkLeapYear(0);
		assertEquals(false, result);
	}
	
	@Test
	void testCheckLeapYear3() {
		//CheckLeapYear obj = new CheckLeapYear();
		boolean result = obj.checkLeapYear(2020);
		assertEquals(true, result);
	}
	
	@Test
	void testCheckLeapYear4() {
		//CheckLeapYear obj = new CheckLeapYear();
		boolean result = obj.checkLeapYear(1800);
		assertEquals(false, result);
	}
	
	@Test
	void testCheckLeapYear5() {
		//CheckLeapYear obj = new CheckLeapYear();
		boolean result = obj.checkLeapYear(-2);
		assertEquals(false, result);
	}
}
