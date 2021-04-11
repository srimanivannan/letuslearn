package com.manisrini.domain.designpattern.creational.abstractfactory;

public abstract class AbstractFactory {
	public abstract Person getPerson(String person);
	public abstract Dress getDress(String dress);
}
