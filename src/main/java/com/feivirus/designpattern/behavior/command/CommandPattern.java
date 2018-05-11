package com.feivirus.designpattern.behavior.command;

import com.feivirus.designpattern.behavior.command.base.Command;
import com.feivirus.designpattern.behavior.command.base.ConcreteCommand;
import com.feivirus.designpattern.behavior.command.base.ConcreteInvoker;
import com.feivirus.designpattern.behavior.command.base.ConcreteReceiver;
import com.feivirus.designpattern.behavior.command.base.Invoker;
import com.feivirus.designpattern.behavior.command.base.Receiver;

/**
 * 命令模式
 * @author feivirus
 * 场景
 * 1.处理发送者和接受者互不知道的问题,类似消息队列
 * 2.发送者Invoker中保存命令的引用，调用命令的execute方法.
 *   具体command中保存命令的接收者，执行接收者的action方法.
 * 3.具体command中的接收者可以是个list或者队列，存储多个receiver,模仿消息队列
 * 4.Receiver和ConreteReceiver可以不用，因为在类中没有区分针对不同的命令做什么操作，
 * 	 只有一个无参的action调用
 */
public class CommandPattern {
	public static void main(String[] args) {
		//1
		System.out.println("测试命令模式基础类");
		Receiver receiver = new ConcreteReceiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new ConcreteInvoker();
		
		invoker.setCommand(command);
		invoker.call();
		invoker.undoCommand();
		
		//2
		System.out.println("测试命令模式程序员模拟类");
		Command codeCommand = new CodeCommand();
		GroupLeader groupLeader = new GroupLeader();
		groupLeader.setCommand(codeCommand);
		groupLeader.call();
		groupLeader.undoCommand();
	}
}
