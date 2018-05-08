package com.feivirus.javaNIO.simpleSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 
 * @author feivirus
 * 连接客户端,可以启动ChannelAccept尝试连接
 */
public class ConnectionAsync {
	
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 1234;
		if (args.length == 2) {
			host = args[0];
			port = Integer.parseInt(args[1]);
		}
		InetSocketAddress address = new InetSocketAddress(host, port);
		SocketChannel socketChannel = SocketChannel.open();
		
		socketChannel.configureBlocking(false);
		System.out.println("initiating connection");
		socketChannel.connect(address);
		while (!socketChannel.finishConnect()) {
			//等待连接
		}
		doBusinessLogic(socketChannel);
		System.out.println("connection Established");
		socketChannel.close();
	}
	
	private static void doBusinessLogic(SocketChannel channel) throws IOException {
		System.out.println("do business logic");
		ByteBuffer buffer = ByteBuffer.allocate(512);
		int count = 0;		
		
		while (true) {
			if ((count = channel.read(buffer)) > 0) {
				buffer.flip();
				
				while (buffer.hasRemaining()) {								
					System.out.println(buffer.get());
				}			
				buffer.clear();
			}			
		}
	}
}
