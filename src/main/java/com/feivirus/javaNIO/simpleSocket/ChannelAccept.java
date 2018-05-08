package com.feivirus.javaNIO.simpleSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 
 * @author feivirus
 * 
 */
public class ChannelAccept {
	public static final String SAYHELLO = "hello I am here.\r\n";
	
	public static void main(String[] args) throws Exception {
		int port = 1234;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		ByteBuffer buffer = ByteBuffer.wrap(SAYHELLO.getBytes());
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		//设置监听为非阻塞
		serverSocketChannel.configureBlocking(false);
		while (true) {
			System.out.println("Waiting for Connection");
			SocketChannel sChannel = serverSocketChannel.accept();
			
			if (sChannel == null) {
				Thread.sleep(2000);
			} else {
				System.out.println("Incoming connection from: " + sChannel.getRemoteAddress());
				System.out.println("Incoming connection from:"
						+ sChannel.socket().getRemoteSocketAddress());
				buffer.rewind();
				sChannel.write(buffer);
				Thread.sleep(50000);
				sChannel.close();
			}
		}
	}
}
