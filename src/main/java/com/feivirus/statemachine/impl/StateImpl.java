package com.feivirus.statemachine.impl;

import java.util.HashMap;
import java.util.Map;

import com.feivirus.statemachine.State;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.Transition;

public class StateImpl<T extends StateMachine<T, S, E, C>, S, E, C> implements State<T, S, E, C>{
	protected S stateId;
	
	protected Map<E, Transition<T, S, E, C>> transitions = new HashMap<>();
	
	public StateImpl(S stateId) {
		this.stateId = stateId;
	}
	
	@Override
	public S getStateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transition<T, S, E, C> addTransitionOn(E event) {
		Transition<T, S, E, C> newTransition = FSM.newTransition();
		newTransition.setSourceState(this);
		newTransition.setEvent(event);
		transitions.put(event, newTransition);
		return newTransition;
	}

}
