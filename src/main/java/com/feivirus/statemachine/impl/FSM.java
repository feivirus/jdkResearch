package com.feivirus.statemachine.impl;

import java.lang.reflect.Method;
import java.util.Map;

import com.feivirus.statemachine.ActionExecutionService;
import com.feivirus.statemachine.SingleTransitionBuilder;
import com.feivirus.statemachine.State;
import com.feivirus.statemachine.StateContext;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.StateMachineData;
import com.feivirus.statemachine.Transition;
import com.feivirus.statemachine.TransitionResult;

public abstract class FSM {
	static <T extends StateMachine<T, S, E, C>, S, E, C> SingleTransitionBuilder<T, S, E, C> newSingleTransitionBuilder(
			Map<S, State<T, S, E, C>> states, ExecutionContext executionContext) {
		return new TransitionBuilderImpl<T, S, E, C>(states, executionContext);
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> State<T, S, E, C> getState(
			Map<S, State<T, S, E, C>> states,
			S stateId) {
			State<T, S, E, C> state = states.get(stateId);
			if (state == null) {
				state = FSM.newState(stateId);
				states.put(stateId, state);
			}
			return state;
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> State<T, S, E, C> newState(S stateId) {
		return new StateImpl<T, S, E, C>(stateId);
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> Transition<T, S, E, C> newTransition() {
		return new TransitionImpl<T, S, E, C>();
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> ActionImpl<T, S, E, C> newActionImpl(
			Method method, 
			ExecutionContext executionContext) {
		return new  ActionImpl<T, S, E, C>(method, executionContext);
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> ActionProxyImpl<T, S, E, C> newActionProxyImpl(
			String methodName, ExecutionContext executionContext) {
		return new ActionProxyImpl<T, S, E, C>(methodName, executionContext);
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> TransitionResult<T, S, E, C> newResult(
			boolean isAccepted, State<T, S, E, C> targetState) {
		return new TransitionResultImpl<>();
	}
	
	static <T extends StateMachine<T, S, E, C>, S, E, C> StateContext<T, S, E, C> newStateContext(
			StateMachine<T, S, E, C> stateMachine, StateMachineData<T, S, E, C> data,
			State<T, S, E, C> fromState, E event, C context, TransitionResult<T, S, E, C> result,
			ActionExecutionService<T, S, E, C> executor) {
		return new StateContextImpl<T, S, E, C>(stateMachine, data, fromState, event, context, result, executor);
	}
}
