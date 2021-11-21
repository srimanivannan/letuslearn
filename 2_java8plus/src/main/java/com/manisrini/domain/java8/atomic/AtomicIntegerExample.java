package com.manisrini.domain.java8.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

  private final AtomicInteger atomicInteger = new AtomicInteger();

  private void test() {
    int test = 0;
    for (int i = 0; i < 5; i++) {
      test = atomicInteger.getAndAdd(i);
      System.out.println(test);
    }
    //System.out.println(test);
  }

  public static void main(String[] args) {
    AtomicIntegerExample example = new AtomicIntegerExample();
    example.test();
  }
}
