package com.manisrini.domain.generics.type_safety;

import java.util.ArrayList;
import java.util.List;

public class Example {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    ArrayList noGenericsNumbers = new ArrayList();

    noGenericsNumbers.add(1);
    noGenericsNumbers.add(2);
    noGenericsNumbers.add(3);
    noGenericsNumbers.add(1.0);

    int noGenericsNumberTotal = 0;
    for(Object number : noGenericsNumbers) {
      noGenericsNumberTotal += (Integer)(number);
      // We know at runtime
      //Exception in thread "main" java.lang.ClassCastException: class java.lang.Double cannot be cast to class java.lang.Integer
    }

    System.out.println(noGenericsNumberTotal);

    List<Integer> genericsNumbers = new ArrayList<>();
    genericsNumbers.add(1);
    genericsNumbers.add(2);
    genericsNumbers.add(3);
    //numbers.add(1.0); // capture error during compilation time . thanks to Generics

    int genericsNumberTotal = 0;
    for (int number : genericsNumbers) {
      genericsNumberTotal += number;
    }

    System.out.println(genericsNumberTotal);
  }
}
