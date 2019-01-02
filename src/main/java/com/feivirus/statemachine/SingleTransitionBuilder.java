package com.feivirus.statemachine;

/**
 * 
 * @author feivirus
 * 单一转换
 * 现态只有一个次态
 * 现态有多个次态的暂未实现
 */
public interface SingleTransitionBuilder<T extends StateMachine<T, E, S, C>, E, S, C> {
	//源状态
	SingleTransitionBuilder<T, E, S, C> from(S stateId);
	
	//目标状态
	SingleTransitionBuilder<T, E, S, C> to(S stateId);
	
	//事件
	SingleTransitionBuilder<T, E, S, C> on(E event);
	
	//动作
	SingleTransitionBuilder<T, E, S, C> callMethod(String methodName);
}
