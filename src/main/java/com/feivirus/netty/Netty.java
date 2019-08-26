package com.feivirus.netty;

/**
 * 
 * @author feivirus
 *  com.feivirus.javaNIO.netty.NettyServer
 *  channel:相当于对socket 的holder封装，内部有remote，local address
 *  eventloop 是对自己写socket时的线程while 死循环处理socket的代码封装
 *  channel handler各种connect,send,recv的回调函数
 *  channel pipeline是各种handler的职责链
 *  socket->channel->channel handler(和一个ChannelHandlerContext对应)->channel pipeline->eventloop->eventloopgroup
 *  消息可以写到channel handler或者ChannelHandlerContext中，前者从pipeline的尾端开始流动，后者从pipeline的下一个handler
 *  开始流动
 */
public class Netty {

}
