package com.feivirus.designpattern.structure.bridge;

public class PayAction extends AbstractInsurancePolicyAction {

	@Override
	public void run() {
		System.out.println("去支付");
	}
	
}
