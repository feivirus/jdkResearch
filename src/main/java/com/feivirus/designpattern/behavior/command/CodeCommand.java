package com.feivirus.designpattern.behavior.command;

import com.feivirus.designpattern.behavior.command.base.Command;

public class CodeCommand implements Command{
	private Worker worker = new Programmer();

	public void execute() {
		worker.work();
		worker.overWork();
		worker.writeDocument();
	}

	public void undo() {
		// TODO Auto-generated method stub
		
	}
	
}
