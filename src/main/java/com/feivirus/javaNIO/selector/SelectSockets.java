package com.feivirus.javaNIO.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 
 * @author feivirus
 *
 */
public class SelectSockets {
	public static int PORT_NUMBER = 1234;
	
	private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
	
	public static void main(String[] args) throws IOException {
		new SelectSockets().run(args);
	}
	
	public void run(String[] args) throws IOException {
		int port = PORT_NUMBER;
		
		if (args.length > 0) {
			port = Integer.valueOf(args[0]);
		}
		System.out.println("Listening on port " + port);
		
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverSocketChannel.socket();
		Selector selector = Selector.open();
		
		serverSocket.bind(new InetSocketAddress(port));
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);		
		
		while (true) {			
			int n = selector.select(); // 阻塞,select,poll,epoll三种非阻塞模型
			
			if (n == 0) {
				continue;
			}
			
			Iterator it = selector.selectedKeys().iterator();
			
			while (it.hasNext()) {
				SelectionKey key = (SelectionKey)it.next();
				
				//连接事件
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel)key.channel();
					SocketChannel channel = server.accept();
					
					registerChannel(selector, channel, SelectionKey.OP_READ);
					sayHello(channel);
				}
				
				if (key.isReadable()) {
					readDataFromSocket(key);
				}
				
				it.remove();
			}
		}
	}
	
	protected void registerChannel(Selector selector, SelectableChannel channel, int ops) throws IOException {
		if (channel == null) {
			return;
		}
		channel.configureBlocking(false);
		channel.register(selector, ops);
	}
	
	private void sayHello(SocketChannel channel) throws IOException {
		buffer.clear();
		buffer.put("Hi there!\r\n".getBytes());
		buffer.flip();
		channel.write(buffer);
	}
	
	protected void readDataFromSocket(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel)key.channel();
		int count;
		
		buffer.clear();
		while ((count = socketChannel.read(buffer)) > 0) {
			buffer.flip();
			
			while (buffer.hasRemaining()) {
				//socketChannel.write(buffer);	数据收到之后，又直接返回给客户端				
				System.out.println(buffer.get());
			}			
			buffer.clear();
		}
		//正常业务逻辑
		//doBussinessLogic(Byte buffer)
		
		if (count < 0) {
			socketChannel.close();
		}
	}
}
