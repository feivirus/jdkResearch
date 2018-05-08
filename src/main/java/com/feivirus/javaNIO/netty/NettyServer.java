package com.feivirus.javaNIO.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 
 * @author feivirus
 *
 */
public class NettyServer implements Runnable{
	private int port;
	
	public NettyServer(int port) {
		this.port = port;
	}
	
	public void run() {		
		//EventLoop就是nio里面的while(true)
		// 接收连接的while
		EventLoopGroup connLoopGroup = new NioEventLoopGroup();
		//处理readdata读数据的while
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
				
			bootstrap.group(connLoopGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<SocketChannel>() {
				protected void initChannel(SocketChannel socketChannel) {
					socketChannel.pipeline().addLast(new ServerHandler());
				}
			})
			.option(ChannelOption.SO_BACKLOG, 128)
			.option(ChannelOption.SO_SNDBUF, 32 * 1024)
			.option(ChannelOption.SO_RCVBUF, 32 * 1024)
			.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			ChannelFuture future = bootstrap.bind(port).sync();
			future.channel().closeFuture().sync();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
			connLoopGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		new NettyServer(1234).run();
	}
}
