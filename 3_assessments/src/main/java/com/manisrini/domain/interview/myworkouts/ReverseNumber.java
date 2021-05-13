package com.manisrini.domain.interview.myworkouts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseNumber {

  public static void main(String[] args) {
    int num = 123456789;
    int from = 1;
    int to = 10;
    List<Integer> collect = IntStream.range(from, to)
        .map(i -> to - i + from - 1).boxed().collect(Collectors.toList());
    System.out.println(collect);
  }
}
