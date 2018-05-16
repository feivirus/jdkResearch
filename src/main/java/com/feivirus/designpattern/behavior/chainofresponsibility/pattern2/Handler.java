package com.feivirus.designpattern.behavior.chainofresponsibility.pattern2;

public abstract class Handler {
	protected Handler successor;

	public Handler getSuccessor() {
		return successor;
	}

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	public abstract String  handleRequest(String userName, double fee);
}
