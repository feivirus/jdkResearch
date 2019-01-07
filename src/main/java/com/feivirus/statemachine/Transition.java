package com.feivirus.statemachine;

public interface Transition<T extends StateMachine<T, S, E, C>, S, E, C> {
	
	void setSourceState(State<T, S, E, C> state);
	
	void setTargetState(State<T, S, E, C> state);
	
	void setEvent(E event);
	
	void addAction(Action<T, S, E, C> newAction);
}
