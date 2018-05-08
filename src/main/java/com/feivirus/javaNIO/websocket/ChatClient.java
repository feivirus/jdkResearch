package com.feivirus.javaNIO.websocket;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;
/**
 * 
 * @author feivirus
 *
 */
public class ChatClient {
	public static void main(String[] args) {
		try {
			IO.Options options = new IO.Options();
			options.forceNew = true;
			options.reconnection = true;
			final Socket socket = IO.socket("http://localhost:1234?deviceId=feivirus", options);
			
			socket.on(Socket.EVENT_CONNECT, new Listener() {
				
				public void call(Object... args) {
					System.out.println("connected server");					
				}
			});
			
			socket.on(Socket.EVENT_DISCONNECT, new Listener() {
				
				public void call(Object... args) {
					System.out.println("disconnected server");
				}
			});
			
			socket.on("push_info", new Listener() {
				
				public void call(Object... args) {
					String data = (String)args[0];
					System.out.println("client received: " + data.toString());
					socket.emit("push_info", "hello, server, I am client");
				}
			});
			
			socket.on("notice_info", new Listener() {
				
				public void call(Object... args) {
					String data = (String)args[0];
					System.out.println("client received notice " + data);
				}
			});
			
			socket.open();
			Thread.sleep(Integer.MAX_VALUE);			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
