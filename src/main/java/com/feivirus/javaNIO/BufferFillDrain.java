package com.feivirus.javaNIO;

import java.nio.CharBuffer;

/**
 * 
 * @author feivirus
 * 缓冲区用法
 */
public class BufferFillDrain {
	
	private static int index = 0;
	
	private static String [] strings = {"Hello Buffer Fill",
			"Drain test!"};
	
	public static void main(String[] argas) {
		CharBuffer buffer = CharBuffer.allocate(100);
		
		while (fillBuffer(buffer)) {
			buffer.flip();
			drainBuffer(buffer);
			buffer.clear();
		}
	}
	
	private static void drainBuffer(CharBuffer buffer) {
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get());			
		}
		System.out.println("");
	}
	
	private static boolean fillBuffer(CharBuffer buffer) {
		if (index >= strings.length) {
			return false;
		}
		
		String tmpString = strings[index++];
		
		for(int i = 0; i < tmpString.length(); i ++) {
			buffer.put(tmpString.charAt(i));
		}
		return true;
	}
	
}
