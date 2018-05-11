package com.feivirus.designpattern.structure.facade;

public class CPU implements AbstractAppliance{

	public void start() {
		System.out.println("cpu has started");
	}

	public void shutdown() {
		System.out.println("cpu has shutdown");
	}
	
}
