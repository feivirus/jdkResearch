package com.feivirus.designpattern.structure.facade;

public class Disk implements AbstractAppliance{

	public void start() {
		System.out.println("Disk has started");
	}

	public void shutdown() {
		System.out.println("Dis has shutdown");
	}
	
}
