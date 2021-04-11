package com.manisrini.domain.designpattern.behavioral.mediator;

public class MediatorPatternDemo {

	
	public static void main(String[] args) {
		
		User user1 = new User("Mani");
		user1.sendMessage("Hello! Suganthi");
		
		User user2 = new User("Suganthi");
		user2.sendMessage("Hi Mani. Waht's Up!");	
	}

}
