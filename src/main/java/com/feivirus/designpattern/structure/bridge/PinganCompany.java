package com.feivirus.designpattern.structure.bridge;

public class PinganCompany extends AbstractInsuranceCompany{

	@Override
	public void run() {
		abstractInsurancePolicyAction.run();
	}
	
}
