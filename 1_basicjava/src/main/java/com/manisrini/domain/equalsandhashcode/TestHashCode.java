package com.manisrini.domain.equalsandhashcode;

public class TestHashCode {

	@Override
	public int hashCode(){
		return 1;
	}
	public static void main(String[] args) {
		
		TestHashCode obj1= new TestHashCode();
		TestHashCode obj2= new TestHashCode();
		System.out.println(obj1==obj2);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

}
