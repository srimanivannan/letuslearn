package com.manisrini.domain.designpattern.creational.abstractfactory;

public class DressFactory extends AbstractFactory{
	
	@Override
	public Person getPerson(String person){
		return null;
	}
	
	@Override
	public Dress getDress(String dress){
		if(dress==null){
			return null;
		}
		if(dress.equalsIgnoreCase("dhoti")){
			return new Dhoti();
		}
		if(dress.equalsIgnoreCase("jean")){
			return new Jean();
		}
		if(dress.equalsIgnoreCase("suitcoat")){
			return new SuitCoat();
		}
		return null;
	}
	
}