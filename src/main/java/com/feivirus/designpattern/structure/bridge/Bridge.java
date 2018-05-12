package com.feivirus.designpattern.structure.bridge;

/**
 * 桥接模式
 * @author feivirus
 *
 */
public class Bridge {
	public static void main(String []args) {
		AbstractInsurancePolicyAction quoteAction = new QuoteAction();
		AbstractInsuranceCompany pinganCompany = new PinganCompany();
		pinganCompany.setAbstractInsurancePolicyAction(quoteAction);
		pinganCompany.run();
	}
}
