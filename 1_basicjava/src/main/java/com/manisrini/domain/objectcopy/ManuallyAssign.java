package com.manisrini.domain.objectcopy;

public class ManuallyAssign {

	private String name;
	private int id;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String toString(){
		return "Name["+this.name+"]:id["+this.id+"]";
	}
	public static void main(String[] args) {
		
		ManuallyAssign object1=new ManuallyAssign();
		object1.setId(101);
		object1.setName("Suganthi");
		System.err.println("object1=>"+object1.toString());
		ManuallyAssign object2=new ManuallyAssign();
		object2.setId(object1.getId());//Manually I'm copying the data here
		object2.setName(object1.getName());//Manually I'm copying the data here
		System.err.println("object2=>"+object2.toString());
		System.err.println("is object1 equals object2=>"+object1.equals(object2));
		System.err.println("Hash code of object1=>"+object1.hashCode());
		System.err.println("Hash code of object2=>"+object2.hashCode());
	}

}
