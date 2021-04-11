package com.manisrini.domain.designpattern.creational.abstractfactory;

public class PersonFactory extends AbstractFactory{
	
	@Override
	public Dress getDress(String dress){
		return null;
	}
	@Override
	public Person getPerson(String person){
		if(person==null){
			return null;
		}
		if(person.equalsIgnoreCase("Indian")){
			return new Indian();
		}
		if(person.equalsIgnoreCase("German")){
			return new German();
		}
		if(person.equalsIgnoreCase("England")){
			return new England();
		}
		return null;
	}
	
}