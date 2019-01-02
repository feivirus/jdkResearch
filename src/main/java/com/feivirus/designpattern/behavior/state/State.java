package com.feivirus.designpattern.behavior.state;

/**
 * 状态模式
 * @author feivirus
 * 参考:
 * https://blog.csdn.net/hguisu/article/details/7557252
 * http://www.cnblogs.com/bastard/archive/2012/06/05/2536258.html
 * 备注:
 * 1.触发关门动作,关门动作的业务代码在OpenDoorLiftState.closeDoor()执行还是在CloseDoorLiftState.closeDoor()中
 * 执行，值得讨论
 * 2.状态切换谁触发是state还是context值得讨论
 * 3.state状态是提前创建还是用到时再创建值得讨论
 */
public class State {	
	public static void main(String[] args) {
		LiftContext liftContext = new LiftContext();
		
		liftContext.setLiftState(LiftStateEnum.OPEN_DOOR_STATE.create());
		
		liftContext.getLiftState().closeDoor();
	}	
}
