package com.manisrini.domain.java8.optional;

import java.sql.Timestamp;
import java.util.Optional;

public class OptionalExample {

	private Timestamp sentTs;
	
	public static void main(String[] args) {
		
		OptionalExample example = new OptionalExample();
		
		Optional<String> s = Optional.of("input");
		
		System.out.println(s.map(example::getOutput));
		System.out.println(s.flatMap(example::getOutputReturnsOptional));
		System.out.println(s.map(example::getOutputReturnsOptional));
		System.out.println(s.map(OptionalExample::getOutputStatic));
		
		example.setSentTs(null);
	}

	private String getOutput(String input) {
		return input == null ? null : "output for " + input;
	}

	private Optional<String> getOutputReturnsOptional(String input) {
		return input == null ? Optional.empty() : Optional.of("output for " + input);
	}
	
	private static String getOutputStatic(String input) {
		return input == null ? null : "output for " + input;
	}

	public Timestamp getSentTs() {
		return new Timestamp(sentTs.getTime());
	}

	public void setSentTs(Timestamp sentTs) {
		Optional<Timestamp> ofNullable = Optional.ofNullable(sentTs);
		if (ofNullable.isPresent()) {
			//ofNullable.flatMap(val -> this.sentTs = new Timestamp(val.getTime()));
		} else {
			//this.sentTs = new Timestamp(new Date());
		}
	}
}
