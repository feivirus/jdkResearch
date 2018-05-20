package com.feivirus.designpattern.behavior.observer;

/**
 * 观察者
 * @author feivirus
 *参考链接:
 *https://www.cnblogs.com/intsmaze/p/6017508.html 
 */
public class ObserverPattern {
	public static void main(String[] args) {
		Subject subject = new Subject();
		ClientObserver clientObserver = new ClientObserver();
		
		subject.addObserver(clientObserver);
		subject.doBusiness();
	}
}
