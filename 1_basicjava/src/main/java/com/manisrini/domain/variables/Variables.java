package com.manisrini.domain.variables;

public class Variables {

	public boolean a;//don't have to initialize the instance variables
	@SuppressWarnings("unused")
	private int b;//can be private modifier
	int c;//with no modifier
	protected int d;//can be protected
	final int e=10;//can be final. but it must be Initialized
	static int f;//can be static.may not be finalized
	static final int g=18;//can be static and final
	final String pancard;
	public Variables(){
		pancard="number";
	}
	public void testInstanceVariables(){
		System.err.println("a value=>"+a);
		
	}
	
	public void localVariables(){
		final int a=5;
		//must be declared with in a block of code
		//Must be initialized
		//no modifiers like public or private or protected or static
		// can be finalized
		System.err.println("a value=>"+a);
	}
	
	public static void main(String[] args) {
	
		new Variables().testInstanceVariables();
	}

}
