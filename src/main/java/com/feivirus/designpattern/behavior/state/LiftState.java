package com.feivirus.designpattern.behavior.state;

public abstract class LiftState {
	protected LiftContext context;
	
	public void setContext(LiftContext context) {
		this.context = context;
	}

	//开门动作
	protected abstract void openDoor();
	
	//关门动作
	protected abstract void closeDoor();
	
	//启动运行动作
	protected abstract void run();
	
	//关闭动作
	protected abstract void stop();
}
