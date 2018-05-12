package com.feivirus.designpattern.structure.bridge;

public class InitCarInfoAction  extends AbstractInsurancePolicyAction{

	@Override
	public void run() {
		System.out.println("初始化车型信息");
	}	
}
