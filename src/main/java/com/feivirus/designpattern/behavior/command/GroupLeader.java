package com.feivirus.designpattern.behavior.command;

import com.feivirus.designpattern.behavior.command.base.Command;
import com.feivirus.designpattern.behavior.command.base.Invoker;

public class GroupLeader extends Invoker{

	@Override
	public void call() {
		System.out.println("组长分析命令");
		super.call();
	}

	@Override
	public void undoCommand() {
		System.out.println("组长分析撤销命令");
		super.undoCommand();
	}
		
	
}
