package com.manisrini.domain.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MultiplePredicate {

  public void test() {
    List<String> strings = Arrays.asList("mani", "suganthi", "aathira", "atharva", "aarna");
    System.out.println(strings.stream()
        .filter(((Predicate<String>) it1 -> it1.startsWith("a")).and(it -> it.length() < 6))
        .count());
  }

  public static void main(String[] args) {
    MultiplePredicate multiplePredicate = new MultiplePredicate();
    multiplePredicate.test();
  }
}
