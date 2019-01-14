package com.feivirus.statemachine;

import java.io.Serializable;

public interface StateMachineData <T extends StateMachine<T, S, E, C>, S, E, C> extends Serializable{
	void dump(StateMachineData.Reader<T, S, E, C> src);
	
	Reader<T, S, E, C> read();
	
	Writer<T, S, E, C> write();
	
	public interface Reader<T extends StateMachine<T, S, E, C>, S, E, C> extends Serializable {
		State<T, S, E, C> currentState();
	}
	
	public interface Writer<T extends StateMachine<T, S, E, C>, S, E, C> extends Serializable {
		
	}
}
