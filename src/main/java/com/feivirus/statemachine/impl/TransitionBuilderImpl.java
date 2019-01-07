package com.feivirus.statemachine.impl;

import java.util.Map;

import com.feivirus.statemachine.Action;
import com.feivirus.statemachine.SingleTransitionBuilder;
import com.feivirus.statemachine.State;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.Transition;

public class TransitionBuilderImpl<T extends StateMachine<T, S, E, C>, S, E, C> implements SingleTransitionBuilder<T, S, E, C>{
	private State<T, S, E, C> sourceState;
	
	private State<T, S, E, C> targetState;
	
	private Transition<T, S, E, C> transition;
	
	private Map<S, State<T, S, E, C>> states;	
	
	public TransitionBuilderImpl(Map<S, State<T, S, E, C>> states) {
		this.states = states;
	}
	
	/**
	 * 这个地方可以提取出From接口，隔离出SingleTransitionBuilder和其他类型的Builder
	 */
	@Override
	public SingleTransitionBuilder<T, S, E, C> from(S stateId) {
		sourceState = FSM.getState(states, stateId);
		return this;
	}

	@Override
	public SingleTransitionBuilder<T, S, E, C> to(S stateId) {
		targetState = FSM.getState(states, stateId);
		return this;
	}

	@Override
	public SingleTransitionBuilder<T, S, E, C> on(E event) {
		transition = sourceState.addTransitionOn(event);
		transition.setTargetState(targetState);
		
		return this;
	}

	@Override
	public SingleTransitionBuilder<T, S, E, C> callMethod(String methodName) {
		Action<T, S, E, C> action = FSM.newActionProxyImpl(methodName);
		transition.addAction(action);
		return this;
	}
}
