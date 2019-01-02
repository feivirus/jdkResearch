package com.feivirus.statemachine.impl;

import com.feivirus.statemachine.SingleTransitionBuilder;
import com.feivirus.statemachine.StateMachine;

public class TransitionBuilderImpl<T extends StateMachine<T, E, S, C>, E, S, C> implements SingleTransitionBuilder<T, E, S, C>{

	@Override
	public SingleTransitionBuilder<T, E, S, C> from(S stateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SingleTransitionBuilder<T, E, S, C> to(S stateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SingleTransitionBuilder<T, E, S, C> on(E event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SingleTransitionBuilder<T, E, S, C> callMethod(String methodName) {
		// TODO Auto-generated method stub
		return null;
	}
}
