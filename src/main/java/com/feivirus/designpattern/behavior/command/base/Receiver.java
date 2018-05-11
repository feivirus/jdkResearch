package com.feivirus.designpattern.behavior.command.base;

/**
 * 
 * @author feivirus
 * 场景
 * 1.这个类在命令模式中可以不用，直接在具体命令中调用接收者的具体方法
 * 2.怎么在action中区分不同的命令，传入一个command引用?
 */
public abstract class Receiver {
	public abstract void action();
	
	public abstract void unAction();
}
