package com.feivirus.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

/**
 * 
 * @author feivirus
 *
 */
public class TcpClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("127.0.0.1", 1234);
		client.setSoTimeout(1000000);
		
		PrintStream out = new PrintStream(client.getOutputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String[] msgArray = {"hello\r\n", "feiviurs\r\n"};
		
		for(String msg : msgArray) {
			out.print(msg);
			
			while (true) {
				String echo = bufferedReader.readLine();
				
				if (echo != null) {
					System.out.println(echo);
					break;
				}
			}
		}
		
	}
}
