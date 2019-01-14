package com.feivirus.statemachine.impl;

import com.feivirus.statemachine.State;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.TransitionResult;

public class TransitionResultImpl<T extends StateMachine<T, S, E, C>, S, E, C> implements TransitionResult<T, S, E, C>{
	private boolean isAccepted;
	
	private State<T, S, E, C> targetState;
	
	@Override
	public boolean isAccepted() {
		return isAccepted;
	}		

	@Override
	public TransitionResult<T, S, E, C> setAccepted(boolean accept) {
		this.isAccepted = accept;
		return this;
	}

	@Override
	public TransitionResult<T, S, E, C> setTargetState(State<T, S, E, C> targetState) {
		this.targetState = targetState;
		return this;
	}

	@Override
	public State<T, S, E, C> getTargetState() {
		return targetState;
	}	
}
