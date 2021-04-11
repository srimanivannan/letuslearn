package com.manisrini.domain.designpattern.creational.abstractfactory;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		

		//get person factory 
		AbstractFactory personFactory = FactoryProducer.getFactory("person"); 
		//get an object of Person German 
		Person person1 = personFactory.getPerson("German");
		System.out.println("Hi.."+person1.getLanguage());

		//get dress factory 
		AbstractFactory dressFactory = FactoryProducer.getFactory("dress"); 
		//get an object of Person German 
		Dress dress1 = dressFactory.getDress("jean");
		System.out.println("Hi.."+dress1.wearDress());
		
	}
}
