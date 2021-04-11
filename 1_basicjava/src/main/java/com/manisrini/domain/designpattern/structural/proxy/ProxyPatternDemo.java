package com.manisrini.domain.designpattern.structural.proxy;

/**
 * The Class ProxyPatternDemo.
 */
public class ProxyPatternDemo {
	
	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Image image = new ProxyImage("mani.jpg");
		image.imageDisplay("Real");
		
		image.imageDisplay("Proxy");
	}

}
