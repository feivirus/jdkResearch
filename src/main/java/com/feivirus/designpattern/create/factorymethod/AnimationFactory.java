package com.feivirus.designpattern.create.factorymethod;

public class AnimationFactory extends VideoFactory{

	@Override
	public Video createVideo() {
		return new Animation();
	}
	
}
