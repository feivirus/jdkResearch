package com.feivirus.generic;

public class Point<T> {
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
	public String toString() {
		return this.var.toString();
	}
	
    public static void main(String []args) {
    		Point<String> point = new Point<String>();
    		point.setVar("MSDN");
    		
    		System.out.println(point.getVar().length());
    		
    		fun(point);
    }
    
    //public static void fun(Point<Object> param) {
    //public static void fun(Point<? super String> param) {
    public static void fun(Point<? extends String> param) {
    		System.out.println("内容: " + param);
    }
}
