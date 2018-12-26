package com.feivirus.designpattern.behavior.state;

public class CloseDoorLiftState extends LiftState{

	@Override
	protected void openDoor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void closeDoor() {
		System.out.println("系统关门");
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
