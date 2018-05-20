package com.feivirus.designpattern.behavior.observer;

import java.util.Vector;

public class Observable {
	private Vector<Observer> objsVec;
	
	public Observable() {
		if (objsVec == null) {
			objsVec = new Vector<Observer>();
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
		for(int i = 0; i < objsVec.size(); i++) {
			objsVec.get(i).update(this, arg);
		}
	}
}
