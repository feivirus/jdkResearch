package com.feivirus.statemachine;

/**
 * 
 * @author feivirus
 * 状态机
 * @param <T>
 * 事件
 * @param <E>
 * 状态
 * @param <S>
 * 上下文
 * @param <C>
 */
public interface StateMachine<T extends StateMachine<T, E, S, C>, E, S, C> {
	//触发事件
	void fire(E event);
	
	void start();
}
