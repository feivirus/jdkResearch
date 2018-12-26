package com.feivirus.designpattern.behavior.state;

public class LiftContext {
	//当前电梯状态
	private LiftState liftState;

	public LiftState getLiftState() {
		return liftState;
	}

	public void setLiftState(LiftState liftState) {
		this.liftState = liftState;
		this.liftState.setContext(this);
	}
	
}
