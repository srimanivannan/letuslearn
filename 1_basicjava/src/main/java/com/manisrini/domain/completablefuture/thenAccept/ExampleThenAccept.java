package com.manisrini.domain.completablefuture.thenAccept;

import java.util.concurrent.CompletableFuture;

import io.vavr.control.Try;

public class ExampleThenAccept {

  public static void main(String[] args) {
    startAsyncTask(2)
        .thenAccept(result -> System.out.println("result: " + result));
  }

  private static CompletableFuture<Integer> startAsyncTask(int number) {
    return CompletableFuture.supplyAsync(() -> {
      if (Math.random() > 0.75) {
        System.out.println("taking a slow run this time");
        Try.run(() -> Thread.sleep(2000));
      }
      return number * 2;
    });
  }
}
