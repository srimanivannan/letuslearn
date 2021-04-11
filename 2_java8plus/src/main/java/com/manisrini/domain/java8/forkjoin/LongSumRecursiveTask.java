package com.manisrini.domain.java8.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class LongSumRecursiveTask extends RecursiveTask<Long> {

  private static final long LIMIT = 1000L;

  private final long[] numbers;
  private final long start;
  private final long end;

  public LongSumRecursiveTask(long[] numbers, long start, long end) {
    this.numbers = numbers;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    long length = end - start;
    if (length <= LIMIT) {
      return computeSequentially();
    }

    LongSumRecursiveTask left = new LongSumRecursiveTask(numbers, start, length/2);
    left.fork();

    LongSumRecursiveTask right = new LongSumRecursiveTask(numbers, start + length/2, end);
    Long rightResult = right.compute();
    Long leftResult = left.join();

    return leftResult + rightResult;
  }

  private Long computeSequentially() {
    return Arrays.stream(numbers).sum();
  }
}
