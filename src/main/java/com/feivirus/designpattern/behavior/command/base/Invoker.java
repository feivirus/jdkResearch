package com.feivirus.designpattern.behavior.command.base;

public abstract class Invoker {
	private Command command;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void call() {
		System.out.println("我是调用者，发布命令执行");
		command.execute();
	}
	
	public void undoCommand() {
		System.out.println("我是调用者，撤销命令执行");
		command.undo();
	}
}
