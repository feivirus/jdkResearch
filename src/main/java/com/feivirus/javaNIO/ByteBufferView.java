package com.feivirus.javaNIO;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * 
 * @author feivirus
 * limit, position,capacity
 */
public class ByteBufferView {
	
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(5).order(ByteOrder.BIG_ENDIAN);
		CharBuffer charBuffer = byteBuffer.asCharBuffer();
		
		byteBuffer.put(0, (byte)0);
		byteBuffer.put(1, (byte)'H');
		byteBuffer.put(2, (byte)0);
		byteBuffer.put(3, (byte)'i');
		byteBuffer.put(4, (byte)'!');		
		
		println(byteBuffer);
		println(charBuffer);
	}
	
	private static void	println(Buffer buffer) {
		System.out.println("pos=" + buffer.position() 
		+ ", limit=" + buffer.limit()
		+ ", capacity=" + buffer.capacity()
		+ ": '" + buffer.toString() + "'");
	}
}
