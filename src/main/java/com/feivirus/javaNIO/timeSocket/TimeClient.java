package com.feivirus.javaNIO.timeSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;
import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author feivirus
 *
 */
public class TimeClient {
	private static final int DEFAULT_TIME_PORT = 37;
	
	private static final long DIFF_1900 = 2208988800L;
	
	protected int port = DEFAULT_TIME_PORT;
	
	protected List remoteHosts;
	
	protected DatagramChannel channel;
	
	public TimeClient(String[] args) throws Exception {
		if (args.length == 0) {
			throw new Exception("Usage: [-p port ] host ...");
		}
		parseArgs(args);
		this.channel = DatagramChannel.open();
	}
	
	protected void sendRequests() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1);
		Iterator it = remoteHosts.iterator();
		while (it.hasNext()) {
			InetSocketAddress socketAddress = (InetSocketAddress)it.next();
			System.out.println("Requsting time from " + socketAddress.getHostName() + ":" + socketAddress.getPort());
			buffer.clear().flip();
			channel.send(buffer, socketAddress);
		}
	}
	
	protected InetSocketAddress receivePacket(DatagramChannel channel, ByteBuffer buffer) throws IOException {
		buffer.clear();
		return (InetSocketAddress)channel.receive(buffer);
	}
	
	public void getReplies() throws Exception {
		ByteBuffer longBuffer = ByteBuffer.allocate(8);
		
		longBuffer.order(ByteOrder.BIG_ENDIAN);
		longBuffer.putLong(0, 0);
		longBuffer.position(4);
		ByteBuffer buffer = longBuffer.slice();
		int expect = remoteHosts.size();
		int replies = 0;
		System.out.println("Waiting for replies...");
		while (true) {
			InetSocketAddress socketAddress;
			socketAddress = receivePacket(channel, buffer);
			buffer.flip();
			replies++;
			printTime(longBuffer.getLong(0), socketAddress);
			if (replies == expect) {
				System.out.println("All packets answered");
				break;
			}
			System.out.println("Received " + replies + " of " + expect + " replies");
		}
		
	}
	
	protected void printTime(long remote1900, InetSocketAddress socketAddress) {
		long local = System.currentTimeMillis() / 1000;
		long remote = remote1900 - DIFF_1900;
		Date remoteDate = new Date(remote * 1000);
		Date localDate = new Date(local * 1000);
		long skew = remote - local;
		System.out.println("Reply from " + socketAddress.getHostName() + ":" + remoteDate);
		System.out.println("there: " + remoteDate);
		System.out.println("here: " + localDate);
		System.out.println("skew: ");
		if (skew == 0) {
			System.out.println("none");
		} else if (skew > 0) {
			System.out.println(skew + " seconds ahead");
		} else {
			System.out.println((-skew) + " seconds behind");
		}
	}
	
	protected void parseArgs(String [] args) {
		remoteHosts = new LinkedList();
		for(int i = 0; i < args.length; i++) {
			String argument = args[i];
			if (argument.equals("-p")) {
				i++;
				this.port = Integer.parseInt(args[i]);
				continue;
			}
			
			InetSocketAddress socketAddress = new InetSocketAddress(argument, port);
			if (socketAddress.getAddress() == null) {
				System.out.println("cannot resolve address: " + argument);
				continue;
			}
			remoteHosts.add(socketAddress);
		}
	}
	
	public static void main(String[] args) throws Exception {
		TimeClient client = new TimeClient(args);
		client.sendRequests();
		client.getReplies();
	}
}
