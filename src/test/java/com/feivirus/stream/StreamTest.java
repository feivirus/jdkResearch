package com.feivirus.stream;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class StreamTest {
	private StreamProgram stream;
	
	@Before
	public void init() {
		if (stream == null) {
			stream = new StreamProgram();
		}
	}
	
	@Test
	@Ignore
	public void testHistory() {
		List<String> result = stream.history();
	}
	
	@Test
	public void testStreamSample() {
		stream.streamSample();
	}
	
	@Test
	public void testCreateStream() {
		stream.createStream();
	}
	
	@Test
	public void testCreateCollector() {
		stream.createCollector();
	}
	
	@Test
	public void testCreateGroup() {
		stream.createGroup();
	}
	
	@Test
	public void testCreatePartition() {
		stream.createPartition();
	}
}
