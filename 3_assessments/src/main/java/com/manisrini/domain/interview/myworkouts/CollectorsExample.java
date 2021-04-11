package com.manisrini.domain.interview.myworkouts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

  public static void main(String[] args) {
    String sample = "1A 1B,2A 2B";
    BinaryOperator<Set<String>> operator = (item1, item2) -> {
      item2.addAll(item1);
      return item2;
    };

    Function<String, Set<String>> function = value -> {
      Set<String> setval = new HashSet<>();
      setval.add(value.substring(1, 2));
      return setval;
    };
    Map<String, Set<String>> collect = Arrays.stream(sample.split(","))
        .flatMap(it -> Arrays.stream(it.split(" ")))
        .collect(Collectors.toMap(key -> key.substring(0, 1), function, operator));
    System.out.println(collect);
  }
}
