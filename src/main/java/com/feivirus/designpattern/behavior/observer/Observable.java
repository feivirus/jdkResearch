package com.feivirus.designpattern.behavior.observer;

import java.util.Vector;

public class Observable {
	private Vector<Object> objsVec;
	
	public Observable() {
		if (objsVec == null) {
			objsVec = new Vector<Object>();
		}
	}
	
	public void addObserver(Observer observer) {
		if (observer == null) {
			throw  new NullPointerException();
		}
		if (!objsVec.contains(observer)) {
			objsVec.addElement(observer);
		}
	}
	
	public void deleteObserver(Object observer) {
		if ((objsVec != null) && (objsVec.contains(observer))) {
			objsVec.remove(observer);
		}
	}
	
	public void notifyObservers(Object arg) {
		
	}
}
