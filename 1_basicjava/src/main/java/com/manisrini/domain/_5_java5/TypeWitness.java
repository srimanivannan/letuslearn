package com.manisrini.domain._5_java5;

import java.util.List;
import java.util.Set;

public class TypeWitness {

	public void foo(List<String> names) {
		
	}
	
	public void foo(Set<String> names) {
		
	}
	
	public <T> T anyObject() {
		return null;
	}
	
	public static void main(String[] args) {
		TypeWitness typeWitness = new TypeWitness();
		// The below is called type witness. you can also use it for calling static method
		typeWitness.foo(typeWitness.<List<String>>anyObject());
	}
}
