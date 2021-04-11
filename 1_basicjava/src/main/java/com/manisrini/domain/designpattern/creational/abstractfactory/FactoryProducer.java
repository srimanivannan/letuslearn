package com.manisrini.domain.designpattern.creational.abstractfactory;

public class FactoryProducer {

	public static AbstractFactory getFactory(String choice){if(choice.equalsIgnoreCase("person"))
	{ 
		return new PersonFactory();
	} else if(choice.equalsIgnoreCase("dress"))
	{ 
		return new DressFactory();
	} 
	return null; 
	}
	
}