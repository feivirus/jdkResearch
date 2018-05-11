package com.feivirus.designpattern.behavior.command.base;

/**
 * 
 * @author feivirus
 *
 */
public interface Command {
	//执行命令
	public void execute();
	
	//撤销命令
	public void undo();
}
