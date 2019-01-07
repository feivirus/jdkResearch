package com.feivirus.statemachine.impl;

import com.feivirus.statemachine.Action;
import com.feivirus.statemachine.State;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.Transition;

public class TransitionImpl<T extends StateMachine<T, S, E, C>, S, E, C> implements Transition<T, S, E, C>{

	protected TransitionImpl() {
	}
	
	@Override
	public void setSourceState(State<T, S, E, C> state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTargetState(State<T, S, E, C> state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEvent(E event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAction(Action<T, S, E, C> newAction) {
		// TODO Auto-generated method stub
		
	}
}
