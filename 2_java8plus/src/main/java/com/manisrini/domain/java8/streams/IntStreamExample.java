package com.manisrini.domain.java8.streams;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamExample {

  private void range_method() {

    System.out.println("1. Integer Stream range");
    // 1. Integer Stream range . In range Number 5 is not included
    IntStream.range(1, 5).forEach(System.out::print);

    System.out.println("\n\n2. Integer Stream rangeClosed");

    // 2. Integer Stream rangeClosed. In rangeClosed Number 5 is included
    IntStream.rangeClosed(1, 5).forEach(System.out::print);

    System.out.println("\n\n3. Integer Stream with skip");

    // 3. Integer Stream with skip. It acutualy jumps to 6 meaning starts from 6
    IntStream.range(1, 10).skip(5).forEach(System.out::print);

    System.out.println("\n\n4. Integer Stream with sum");

    // 4. Integer Stream with sum
    System.out.println(IntStream.range(1, 5).sum());
  }

  private void generate_method() {
    System.out.println(IntStream.generate(() -> ThreadLocalRandom.current()
        .nextInt(50))// continuously generate random number with in boundary 50
        .limit(25) // limit to 25 random numbers
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(",")));
  }

  private void iterate_method() {
    AtomicInteger atomicInteger = new AtomicInteger();
    System.out.println(IntStream.iterate(12345, i -> i > 0, i -> i / 10)
        .map(it -> it % 10)
        .mapToObj(Objects::toString).collect(Collectors.joining()));
  }

  public static void main(String[] args) {
    IntStreamExample intStreamExample = new IntStreamExample();
    //intStreamExample.range_method();
    //intStreamExample.generate_method();
    intStreamExample.iterate_method();
  }
}
