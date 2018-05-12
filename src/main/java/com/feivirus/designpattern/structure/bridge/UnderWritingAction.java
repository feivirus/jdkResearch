package com.feivirus.designpattern.structure.bridge;

public class UnderWritingAction extends AbstractInsurancePolicyAction {

	@Override
	public void run() {
		System.out.println("去核保");
	}
	
}
