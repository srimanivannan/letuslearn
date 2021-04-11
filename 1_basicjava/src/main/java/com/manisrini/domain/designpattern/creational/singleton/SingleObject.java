package com.manisrini.domain.designpattern.creational.singleton;

public class SingleObject {

	private static SingleObject instance = new SingleObject();
	
	private SingleObject(){
		
	}
	public static SingleObject getInstance(){
		return instance;
	}
	public void showMessage(){
		System.out.println("This is Single object");
	}
	@Override
	public Object clone(){
		return new CloneNotSupportedException("Clone is not acceptable for this class");
	}
}
