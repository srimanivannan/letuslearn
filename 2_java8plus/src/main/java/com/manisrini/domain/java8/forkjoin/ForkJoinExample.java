package com.manisrini.domain.java8.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinExample {

  public static void main(String[] args) {
    long[] numbers = LongStream.rangeClosed(1, 1000L).toArray();
    LongSumRecursiveTask longSum = new LongSumRecursiveTask(numbers, 0, numbers.length);
    Long result = new ForkJoinPool().invoke(longSum);
    System.out.println(result);
    System.out.println(LongStream.rangeClosed(1, 1000L).sum());
  }
}
