package com.feivirus.designpattern.behavior.state;

public enum LiftStateEnum {
	OPEN_DOOR_STATE(1) {
		@Override
		LiftState create() {			
			return new OpenDoorLiftState();
		}
	},
	CLOSE_DOOR_STATE(2) {
		@Override
		LiftState create() {			
			return new CloseDoorLiftState();
		}
	},
	RUN_STATE(3) {
		@Override
		LiftState create() {			
			return null;
		}
	},
	STOP_STATE(4) {
		@Override
		LiftState create() {			
			return null;
		}
	};
	
	private Integer state;
	
	private LiftStateEnum(Integer state) {
		this.state = state;
	}	
	
	abstract LiftState create();
}
