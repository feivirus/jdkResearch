package com.feivirus.generic;

public class InfoImpl implements Info<String>{
	private String var;
	
	public InfoImpl(String var) {
		this.setVar(var);
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
	//泛型方法
	public <T> T fun(T t) {
		return t;
	}

	public static void main(String [] args) {
		Info info = null;
		
		info = new InfoImpl("helloworld");
		System.out.println("内容: " + info.getVar());
	
		InfoImpl impl = new InfoImpl("feivirus");
		int i = impl.fun(30);
		System.out.println(i);
	}
}
