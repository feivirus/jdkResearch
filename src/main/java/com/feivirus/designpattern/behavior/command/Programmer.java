package com.feivirus.designpattern.behavior.command;

public class Programmer extends Worker{

	@Override
	public void writeDocument() {
		System.out.println("程序员在写开发文档");
	}

	@Override
	public void work() {
		System.out.println("程序员在写代码");		
	}

	@Override
	public void overWork() {
		System.out.println("程序员在加班写需求");

	}
	
}
