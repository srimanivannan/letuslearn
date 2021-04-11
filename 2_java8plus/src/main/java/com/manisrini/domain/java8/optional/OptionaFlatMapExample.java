package com.manisrini.domain.java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OptionaFlatMapExample {

  /**
   * you cannot run this in parallel mode
   * due to arraylist is not thread safe and not concurrent aware
   * @return List<Double>
   */
  public List<Double> collectListWithNoFlatMap() {
    List<Double> doubleList = new ArrayList<>();
    ThreadLocalRandom.current()
        .doubles(10_000)
        .boxed()
        //.parallel() // size wouldn't be 10000
        .forEach(aDouble ->
            OptionalMath.invert(aDouble)
                .ifPresent(aDouble1 ->
                    OptionalMath.squareRoot(aDouble1)
                        .ifPresent(doubleList::add)));
    return doubleList;
  }

  public List<Double> collectListWithFlatMap() {
    List<Double> doubleList = new ArrayList<>();
    ThreadLocalRandom.current()
        .doubles(10_000)
        .boxed()
        //.parallel() // size wouldn't be 10000
        .forEach(aDouble ->
            OptionalMath.invert(aDouble).flatMap(OptionalMath::squareRoot)
                .ifPresent(doubleList::add));
    return doubleList;
  }

  public static void main(String[] args) {
    OptionaFlatMapExample example = new OptionaFlatMapExample();
    System.out.println("# result = " + example.collectListWithNoFlatMap().size());
    System.out.println("# result = " + example.collectListWithFlatMap().size());
  }

}
