package com.feivirus.designpattern.structure.facade;

public class ComputerFacade implements AbstractAppliance{
	private CPU cpu;
	private Disk disk;
	
	public ComputerFacade() {
		cpu = new CPU();
		disk = new Disk();
	}
	
	public void start() {
		System.out.println("computer begin start");
		cpu.start();
		disk.start();
	}

	public void shutdown() {
		cpu.shutdown();
		disk.shutdown();
		System.out.println("computer has shutdown");
	}
	
}
