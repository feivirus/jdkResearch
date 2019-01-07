package com.feivirus.statemachine.impl;

import com.feivirus.statemachine.StateMachine;

public abstract class AbstractStateMachine<T extends StateMachine<T, S, E, C>, S, E, C> implements StateMachine<T, S, E, C>{

	@Override
	public void fire(E event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fire(E event, C context) {
		// TODO Auto-generated method stub
		
	}		
}
