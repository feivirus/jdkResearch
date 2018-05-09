package com.feivirus.designpattern.create.prototype;

public abstract class ComputerAbstractPrototype implements Cloneable{
	private String keyboard;	
	
	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	@Override
	protected Object clone() {
		Object object = null;
		
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
}
