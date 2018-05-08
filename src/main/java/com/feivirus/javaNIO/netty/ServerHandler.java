package com.feivirus.javaNIO.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 
 * @author feivirus
 *
 */
public class ServerHandler extends ChannelHandlerAdapter{
	
	
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buffer = (ByteBuf)msg;
		byte[] data = new byte[buffer.readableBytes()];
		buffer.readBytes(data);
		String request = new String(data, "utf-8");
		System.out.println("server: " + request);
		
		String response = "Hi, I am feivirus\r\n";
		ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
	}	
}
