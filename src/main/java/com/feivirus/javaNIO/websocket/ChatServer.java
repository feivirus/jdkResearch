package com.feivirus.javaNIO.websocket;

import java.util.Map;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

/**
 * 
 * @author feivirus
 *
 */
public class ChatServer {
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		
		configuration.setHostname("localhost");
		configuration.setPort(1234);
		configuration.setMaxFramePayloadLength(1024 * 1024);
		configuration.setMaxHttpContentLength(1024 * 1024);
		
		SocketIOServer server = new SocketIOServer(configuration);
		server.addEventListener("push_info", String.class, new DataListener<String>() {
			
			public void onData(SocketIOClient client, String data, AckRequest ackSender) throws Exception {
				String remoteAddrStr = client.getRemoteAddress().toString();
				String clientIP = remoteAddrStr.substring(1, remoteAddrStr.indexOf(":"));
				Map params = client.getHandshakeData().getUrlParams();
				
				//业务逻辑，调用业务处理类
				System.out.println(clientIP + " client: " + data);
			}
			
		});
		
		server.addEventListener("notice_info", String.class, new DataListener<String>() {

			public void onData(SocketIOClient client, String data, AckRequest ackSender) throws Exception {
				// TODO Auto-generated method stub
				
			}			
		});
		
		server.addConnectListener(new ConnectListener() {
			
			public void onConnect(SocketIOClient client) {
				String remoteAddrStr = client.getRemoteAddress().toString();
				String clientIP = remoteAddrStr.substring(1, remoteAddrStr.indexOf(":"));
				System.out.println(clientIP + "------" + " client connected");
				Map params = client.getHandshakeData().getUrlParams();
				
				client.sendEvent("push_info", clientIP + " hello, I am server.");
			}
		});
		
		server.addDisconnectListener(new DisconnectListener() {
			
			public void onDisconnect(SocketIOClient client) {
				String remoteAddrStr = client.getRemoteAddress().toString();
				String clientIP = remoteAddrStr.substring(1, remoteAddrStr.indexOf(":"));
				System.out.println(clientIP + "------" + " client disconnected");
				client.sendEvent("push_info", clientIP + " hello, I am server , disconnected");
			}
		});
		
		server.start();
		Thread.sleep(Integer.MAX_VALUE);
		server.stop();
	}
}
