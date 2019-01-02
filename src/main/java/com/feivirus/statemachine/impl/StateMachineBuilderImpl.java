package com.feivirus.statemachine.impl;

import com.feivirus.statemachine.SingleTransitionBuilder;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.StateMachineBuilder;

public class StateMachineBuilderImpl<T extends StateMachine<T, E, S, C>, E, S, C> implements StateMachineBuilder<T, E, S, C>{

	@Override
	public SingleTransitionBuilder<T, E, S, C> singleTransition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T newStateMachine(S stateId) {
		// TODO Auto-generated method stub
		return null;
	}
}
