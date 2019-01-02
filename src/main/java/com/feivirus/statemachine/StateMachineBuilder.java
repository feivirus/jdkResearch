package com.feivirus.statemachine;

/**
 * 
 * @author feivirus
 *
 */
public interface StateMachineBuilder<T extends StateMachine<T, E, S, C>, E, S, C> {
	//返回单一状态机的Builder
	SingleTransitionBuilder<T, E, S, C> singleTransition();
	
	//返回状态机实例
	T newStateMachine(S stateId);
}
