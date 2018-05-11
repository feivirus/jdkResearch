package com.feivirus.designpattern.structure.facade;

/**
 * 外观模式
 * @author feivirus
 * 场景:
 * 1.封装聚合关系的同一个操作，多个部件组成一个系统，为了实现同一个功能做封装
 * 2.聚合的各个子部件最好实现统一的接口
 * 3.是的客户端和子系统间解耦，只需要和facade类交互即可
 * 4.比如保单对于一家的险企的报价，核保，支付，出单四个步骤，可以定义统一的接口，类似AbstractAppliance
 */
public class Facade {
	public static void main(String[] args) {
		ComputerFacade computerFacade = new ComputerFacade();
		
		computerFacade.start();
		computerFacade.shutdown();
	}
}
