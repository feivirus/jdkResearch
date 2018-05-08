package com.feivirus.javaNIO.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelHandlerAdapter{

	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			ByteBuf buffer = (ByteBuf)msg;			
			byte[] data = new byte[buffer.readableBytes()];
			buffer.readBytes(data);
			String request = new String(data, "utf-8");
			System.out.println("Client: " + request);
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}
	
}
