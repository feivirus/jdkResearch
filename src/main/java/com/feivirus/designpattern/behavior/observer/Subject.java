package com.feivirus.designpattern.behavior.observer;

public class Subject extends Observable{
	public void doBusiness() {
		notifyObservers("subject send msg");
	}
}
