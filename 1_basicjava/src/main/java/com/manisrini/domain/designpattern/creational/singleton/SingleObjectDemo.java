package com.manisrini.domain.designpattern.creational.singleton;

/**
 * The Class SingleObjectDemo.
 */
public class SingleObjectDemo {
	
	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		//SingleObject object = new SingleObject(); //compile time error
		SingleObject object1 = SingleObject.getInstance();
		object1.showMessage();
		SingleObject object2 = SingleObject.getInstance();
		object2.showMessage();
		System.out.println("object1==object2=>"+(object1==object2));
		Object object3 = object2.clone();
		System.out.println(object3.toString());
	}

}
