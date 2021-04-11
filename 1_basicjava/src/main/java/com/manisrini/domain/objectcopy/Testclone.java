package com.manisrini.domain.objectcopy;

public class Testclone implements Cloneable{

	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws CloneNotSupportedException{

		Testclone original = new Testclone();
		original.setName("Manivannan");
		Testclone duplicate= (Testclone)original.clone();
		System.err.println("Orginal Name=>"+original.getName());
		System.err.println("Duplicate Name=>"+duplicate.getName());
		
		System.err.println("Hashcode of orginal=>"+original.hashCode());
		System.err.println("Hashcode of duplicate=>"+duplicate.hashCode());
		
		System.err.println("is two objects(orginal and duplicate) equal=>"+original.equals(duplicate));
		
		Testclone duplicatecopy=duplicate;
		System.err.println("duplicatecopy name=>"+duplicatecopy.getName());
		System.err.println("Hashcode of duplicatecopy=>"+duplicatecopy.hashCode());
		
		System.err.println("is two objects(duplicate and duplicate copy) equal=>"+duplicate.equals(duplicatecopy));
		
		duplicatecopy.setName("nameChanged");
		System.err.println("duplicatecopy Name=>"+duplicatecopy.getName());
		System.err.println("duplicate Name=>"+duplicate.getName());
	}
}
