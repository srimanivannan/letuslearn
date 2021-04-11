package com.manisrini.domain.designpattern.creational.factory;
public class FactoryDemo {

	
	public static void main(String[] args) {
		PersonFactory factory= new PersonFactory();
		Person person1=(Person)factory.getPerson("Indian");
		System.out.println("Hi..."+person1.getLanguage());
		Person person2=(Person)factory.getPerson("German");
		System.out.println("Hi..."+person2.getLanguage());
		Person person3=(Person)factory.getPerson("England");
		System.out.println("Hi..."+person3.getLanguage());
	}

}
