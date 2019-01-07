package com.feivirus.statemachine.impl;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import com.feivirus.statemachine.SingleTransitionBuilder;
import com.feivirus.statemachine.State;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.StateMachineBuilder;
import com.feivirus.statemachine.util.ReflectionUtil;

public class StateMachineBuilderImpl<T extends StateMachine<T, S, E, C>, S, E, C> implements StateMachineBuilder<T, S, E, C>{
	private Map<S, State<T, S, E, C>> states = new HashMap<>();
	
	private Constructor<? extends T> constructor;
	
	public StateMachineBuilderImpl(Class<? extends T> stateMachineImplClazz,
			Class<S> stateClazz, Class<E> eventClazz, Class<C> contextClazz,
			Class<?>...constructorParams) {
		constructor = extractConstructor(stateMachineImplClazz, constructorParams);
	}
	
	private <T> Constructor<? extends T> extractConstructor(Class<T> type, Class<?>[] paramTypes) {
		Constructor<? extends T> constructor = null;
		
		try {
			constructor = ReflectionUtil.getConstructor(type, paramTypes);
		} catch (Exception e) {
			try {
				constructor = ReflectionUtil.getConstructor(type, new Class<?>[0]);
			} catch(Exception ex) {
				
			}
		}
		return constructor;
	}
	
	@Override
	public SingleTransitionBuilder<T, S, E, C> singleTransition() {		
		return FSM.newSingleTransitionBuilder(states);
	}

	@Override
	public T newStateMachine(S stateId, Object... constructorParam) {
		// TODO Auto-generated method stub
		return null;
	}	
}
