package com.feivirus.statemachine.impl;

import com.feivirus.statemachine.Action;
import com.feivirus.statemachine.StateMachine;

public class ActionProxyImpl<T extends StateMachine<T, S, E, C>, S, E, C> implements Action<T, S, E, C>{
	private String methodName;
	
	public ActionProxyImpl(String methodName) {
		this.methodName = methodName;
	}
	
	@Override
	public void execute(S from, S to, E event, C context, T stateMachine) {
		
	}
	
}
