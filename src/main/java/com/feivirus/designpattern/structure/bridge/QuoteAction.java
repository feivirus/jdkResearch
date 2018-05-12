package com.feivirus.designpattern.structure.bridge;

public class QuoteAction  extends AbstractInsurancePolicyAction{

	@Override
	public void run() {
		System.out.println("去报价");
	}
}
