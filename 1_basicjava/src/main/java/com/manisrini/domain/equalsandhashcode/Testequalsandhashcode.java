package com.manisrini.domain.equalsandhashcode;

public class Testequalsandhashcode {
	public String name;
	public Testequalsandhashcode(){
		
	}
	public Testequalsandhashcode(String str){
		this.name=str;
	}
	public static void main(String[] args) {
		Testequalsandhashcode obj1= new Testequalsandhashcode();
		Testequalsandhashcode obj2= new Testequalsandhashcode();
		System.out.println(obj1==obj2);//false
		System.out.println(obj1.equals(obj2));//false
		
	}

}
