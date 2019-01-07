package com.feivirus.statemachine.impl;

import java.util.Map;

import com.feivirus.statemachine.SingleTransitionBuilder;
import com.feivirus.statemachine.State;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.Transition;

public abstract class FSM {
	static <T extends StateMachine<T, S, E, C>, S, E, C> SingleTransitionBuilder<T, S, E, C> newSingleTransitionBuilder(
			Map<S, State<T, S, E, C>> states) {
		return new TransitionBuilderImpl(states);
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> State<T, S, E, C> getState(
			Map<S, State<T, S, E, C>> states,
			S stateId) {
			State<T, S, E, C> state = states.get(stateId);
			if (state == null) {
				state = FSM.newState(stateId);
			}
			return state;
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> State<T, S, E, C> newState(S stateId) {
		return new StateImpl(stateId);
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> Transition<T, S, E, C> newTransition() {
		return new TransitionImpl();
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> ActionProxyImpl<T, S, E, C> newActionProxyImpl(
			String methodName) {
		return new ActionProxyImpl(methodName);
	}
}
