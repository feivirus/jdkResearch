package com.feivirus.designpattern.structure.bridge;

/**
 * 桥接模式
 * @author feivirus
 * 场景
 * 1.系统从多个维度分类，桥接模式将各维度独立变化。比如宝马车，奔驰车是车辆的一个维度，手动，自动，手自一体是一个维度
 * 2.
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
