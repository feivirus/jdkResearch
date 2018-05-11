package com.feivirus.designpattern.behavior.command.base;

public class ConcreteCommand implements Command{
	//可以是个list，存储多个receiver,或者存储具体的接收者对象，在execute中调用该对象的方法
	private Receiver receiver;
	
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action();
	}

	public void undo() {
		receiver.unAction();
	}
	
}
