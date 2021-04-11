package com.manisrini.domain.completablefuture.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import io.vavr.control.Try;

public class SimpleFutureExample {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Future<String> result = executorService.submit(() -> {
      delay(5000); //simulate network call
      return "{\"result\":\"success\"}";
    }); // non blocking until result.get() is called

    IntStream.range(1, 2).forEach(i -> {
      delay(100);
      System.out.println("non blocking. Doing useful work by main thread");
    });

    System.out.println(result.get());
  }

  private static void delay(int millis) {
    Try.run(() -> {
      System.out.println(Thread.currentThread().getName());
      Thread.sleep(millis);
    });
  }
}
