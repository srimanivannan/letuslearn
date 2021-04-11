package com.manisrini.domain.interview.myworkouts;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberSplit {

  public static void main(String[] args) {
    int[] ints = IntStream.iterate(123400, i -> i > 0, i -> i / 10).map(i -> i % 10).toArray();
    System.out.println(Arrays.toString(ints));
  }
}
