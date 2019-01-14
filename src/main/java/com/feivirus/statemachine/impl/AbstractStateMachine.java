package com.feivirus.statemachine.impl;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.feivirus.statemachine.ActionExecutionService;
import com.feivirus.statemachine.State;
import com.feivirus.statemachine.StateContext;
import com.feivirus.statemachine.StateMachine;
import com.feivirus.statemachine.StateMachineData;
import com.feivirus.statemachine.TransitionResult;
import com.feivirus.statemachine.util.Pair;
import lombok.Data;

@Data
public abstract class AbstractStateMachine<T extends StateMachine<T, S, E, C>, S, E, C> implements StateMachine<T, S, E, C>{
	
	private volatile StateMachineStatus status = StateMachineStatus.INITIALIZED;	
	
	private LinkedBlockingDeque<Pair<E, C>> queuedEvents = new LinkedBlockingDeque<>();
	
	//处理对queuedEvents的读写
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	private StateMachineData<T, S, E, C> data;
	
	private ActionExecutionService<T, S, E, C> executor = new ExecutionServiceImple<>();
	
	@Override
	public boolean isStarted() {
		// TODO Auto-generated method stub
		return getStatus() == StateMachineStatus.IDLE || getStatus() == StateMachineStatus.BUSY;
	}	
	
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
		fire(event, context, false);
	}		
	
	/**
	 * 
	 * @param event
	 * @param context
	 * @param insertFirst 在队列头部还是尾部插入事件
	 */
	public void fire(E event, C context, boolean insertFirst) {
		boolean isEntryPoint = isEntryPoint();
		if (isEntryPoint) {
			StateMachineContext.set((T)this);
		} 
		
		try {
			internalFire(event, context, insertFirst);
		} finally {
			if (isEntryPoint) {
				StateMachineContext.set(null);
			}
		}
		
	}
	
	private void internalFire(E event, C context, boolean insertFirst) {
		if (getStatus() == StateMachineStatus.INITIALIZED) {
			start(context);
		}
		if (getStatus() == StateMachineStatus.TERMINATED) {
			throw new IllegalStateException("The state machine is terminated");
		}
		if (getStatus() == StateMachineStatus.ERROR) {
			throw new IllegalStateException("The state machine errored");
		}
		if (insertFirst) {	
			
		} else {
			queuedEvents.addLast(new Pair<E, C>(event, context));
		}
		processEvents();
	}
	
	private boolean isEntryPoint() {
		return StateMachineContext.currentInstance() == null;
	}

	/**
	 * 从持久化数据中进入状态机，一个个读入历史状态,直到最新状态
	 */
	@Override
	public void start(C context) {
		if (isStarted()) {
			return;
		}
		//TODO 读历史状态
		
	}
	
	private void processEvents() {
		if (getStatus() != StateMachineStatus.BUSY) {
			rwLock.writeLock().lock();
			setStatus(StateMachineStatus.BUSY);
			
			try {
				Pair<E, C> eventPair = null;
				E event = null;
				C context = null;
				while ((eventPair = queuedEvents.poll()) != null) {
					if (Thread.interrupted()) {
						queuedEvents.clear();
						break;
					}
					event = eventPair.key();
					context = eventPair.value();
					processEvent(event, context, data, executor);					
				}
				
				
			} finally {
				if (getStatus() == StateMachineStatus.BUSY) {
					setStatus(StateMachineStatus.IDLE);
				}
				rwLock.writeLock().unlock();
			}
			
		}
	}
	
	private boolean processEvent(E event, C context, StateMachineData<T, S, E, C> oldData,
			ActionExecutionService<T, S, E, C> executionService) {
		StateMachineData<T, S, E, C> localData = oldData;
		State<T, S, E, C> fromState = localData.read().currentState();
		S fromStateId = fromState.getStateId();
		S toStateId = null;
		
		try {
			TransitionResult<T, S, E, C> result = FSM.newResult(false, fromState);
			StateContext<T, S, E, C> stateContext = FSM.newStateContext(this, localData, fromState, 
					event, context, result, executionService);
			
			fromState.internalFire(stateContext);
			toStateId = result.getTargetState().getStateId();
			
			//接受状态转换，调用用户提供的回调方法
			if (result.isAccepted()) {
				executionService.execute();
			}
		} catch (Exception ex) {
			
		}finally {
			
		}
		return false;
	}

	@Override
	public T getThis() {
		return (T)this;
	}	
}
