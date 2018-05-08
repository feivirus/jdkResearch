package com.feivirus.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 
 * @author feivirus
 *
 */
public class TcpServer implements Runnable {
	private Socket client = null;
	private String address;
	
	public TcpServer(Socket client) {
		this.client = client;
	}
	
	public void run() {
		try {
			String host = client.getInetAddress().toString();
			String port = Integer.toString(client.getPort());
			
			PrintStream out = new PrintStream(client.getOutputStream());
			System.out.println("Get Connection");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			address = host + ":" + port;
			System.out.println("get connection from " + address);
			
			while (true) {
				String line = bufferedReader.readLine();
				System.out.println(line);
				//问题三: 业务逻辑和操作socket的代码混在一起.
				//response = doBusinessLogic(String content)
				//out.println(response);
				out.println("hello, I am server!");
				if (line != null) {
					out.println(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Thread> list = new ArrayList<Thread>();
		
		try {
			ServerSocket socket = new ServerSocket(1234);
			
			while (true) {
				//问题一  阻塞在这
				Socket client = socket.accept();
				//问题二 每一个连接都需要一个线程. 线程太多，cpu打满
				Thread thread = new Thread(new TcpServer(client));
				list.add(thread);
				thread.start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
