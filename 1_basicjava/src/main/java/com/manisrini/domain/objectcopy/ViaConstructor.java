package com.manisrini.domain.objectcopy;

public class ViaConstructor {

	private String name; 
	
	public ViaConstructor(String name) {
		this.name=name;
	}
	public ViaConstructor(ViaConstructor object){
		this.name=object.name;
	}
	
	public String toString(){
		return "overridded=>"+this.name;
	}
	public static void main(String[] args) {
		
		ViaConstructor object1= new ViaConstructor("Manivannan");
		System.err.println(object1.toString());
		ViaConstructor object2 = new ViaConstructor(object1);
		System.err.println(object2.toString());
		
		System.err.println("is object1 equals object2=>"+object1.equals(object2));
		System.err.println("Hash code of object1=>"+object1.hashCode());
		System.err.println("Hash code of object2=>"+object2.hashCode());
	}

}
