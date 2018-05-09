package com.feivirus.designpattern.create.factorymethod;

public class MovieFactory extends VideoFactory{

	@Override
	public Video createVideo() {
		return new Movie();
	}
	
}
