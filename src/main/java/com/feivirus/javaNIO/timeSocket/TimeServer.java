package com.feivirus.javaNIO.timeSocket;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;

/**
 * 
 * @author feivirus
 *
 */
public class TimeServer {
	private static final int  DEFAULT_TIME_PORT = 37;
	private static final long DIFF_1900 = 2208988800L;
	protected DatagramChannel channel;
	
	public TimeServer(int port) throws Exception {
		this.channel = DatagramChannel.open();
		this.channel.socket().bind(new InetSocketAddress(port));
		System.out.println("Listening on port:" + port
				+ " for time requests");
	}
	
	public void Listen() throws Exception{
		ByteBuffer longBuffer = ByteBuffer.allocate(8);
		
		longBuffer.order(ByteOrder.BIG_ENDIAN);		
		longBuffer.putLong(0, 0);
		longBuffer.position(4);
		ByteBuffer buffer = longBuffer.slice();
		while (true) {
			buffer.clear();
			SocketAddress socketAddress = this.channel.receive(buffer);
			if (socketAddress == null) {
				continue;
			}
			System.out.println("Time request from " + socketAddress);
			buffer.clear();
			longBuffer.putLong(0, (System.currentTimeMillis() / 1000) + DIFF_1900);
			this.channel.send(buffer, socketAddress);
		}
	}
	
	public static void main(String[] args) throws Exception {
		int port = DEFAULT_TIME_PORT;
		
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		try {
			TimeServer server = new TimeServer(port);
			server.Listen();
		} catch (SocketException socketException) {
			System.out.println("cant't bind to port " + port + ", try a different one");
		}
	}
}
