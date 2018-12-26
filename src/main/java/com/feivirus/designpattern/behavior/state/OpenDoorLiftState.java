package com.feivirus.designpattern.behavior.state;

public class OpenDoorLiftState extends LiftState{

	@Override
	protected void openDoor() {
		System.out.println("系统开门");
		return;
	}

	@Override
	protected void closeDoor() {
		this.context.setLiftState(LiftStateEnum.CLOSE_DOOR_STATE.create());
		//触发关门动作,关门动作的业务代码在这里执行还是在CloseDoorLiftState.closeDoor()中执行，值得讨论
		this.context.getLiftState().closeDoor();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void stop() {
		// TODO Auto-generated method stub
		
	}	
}
