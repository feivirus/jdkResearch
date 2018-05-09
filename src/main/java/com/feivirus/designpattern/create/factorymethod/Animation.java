package com.feivirus.designpattern.create.factorymethod;

/**
 * 动漫类
 * @author feivirus
 *
 */
public class Animation extends Video{

	@Override
	public String play() {
		return "正在播放动漫";
	}
	
}
