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
 * 一.同步
 * 1.block recv ->ready copy 每个连接一个线程
 * 2.non-block recv(O_NONBLOCK, read立即返回错误码)-> ready? ready? ....copy
 *    
 * 二.异步
 * 1.block io(jdk 1.4) multicomplex select 内部异步循环遍历所有连接,比如100万个 ready? 如果有ready,遍历所有，判断哪种事件
 * epoll 如果100万个连接，加入红黑树，如果有些节点连接有ready事件。内核上抛这个数组，只遍历这些节点.
 * 减少处理连接的数目,单个连接处理速度不会加快.
 * 2.non-block aio(内核2.6版本,jdk 1.7版本), linux? window? iocp? 
 * 
 * 备注:
 * netty不支持aio,原因:比epoll提高性能不多，破坏了netty的线程模型
 * 
 * 参考
 * https://blog.csdn.net/historyasamirror/article/details/5778378
 * https://segmentfault.com/a/1190000019055720?utm_source=tag-newest
 * https://blog.csdn.net/lishenglong666/article/details/45536611
 * https://blog.csdn.net/HDUTigerkin/article/details/7517390
 * https://www.ibm.com/developerworks/cn/linux/l-async/#N10056
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
