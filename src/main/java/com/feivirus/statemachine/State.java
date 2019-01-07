package com.feivirus.statemachine;

import com.feivirus.statemachine.StateMachine;

public interface State<T extends StateMachine<T, S, E, C>, S, E, C> {
	
	S getStateId();
	
	Transition<T, S, E, C> addTransitionOn(E event);
}
