package com.feivirus.designpattern.behavior.observer;

public class ClientObserver implements Observer{

	public void update(Observable observable, Object object) {
		System.out.println("观察者监听到变化");
		if (object instanceof String) {
			System.out.println("发送给客户端观察者的消息收到了: " + object);
		}
	}
}
