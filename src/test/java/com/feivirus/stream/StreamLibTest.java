package com.feivirus.stream;

import org.junit.Before;
import org.junit.Test;

public class StreamLibTest {
	private StreamLib streamLib;
	
	@Before
	public void init() {
		if (streamLib == null) {
			streamLib = new StreamLib();
		}
	}
	
	@Test
	public void testLib() {
		streamLib.testLib();
	}
}
