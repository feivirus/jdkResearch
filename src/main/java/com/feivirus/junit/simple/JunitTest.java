package com.feivirus.junit.simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTest {
	@Test
	public void testSimpleType() {
		String str = "hello world";
		assertEquals("hello world", str);
		
		int num = 5;
		assertFalse(num > 6);
		
		assertNotNull(str);
	}
}
