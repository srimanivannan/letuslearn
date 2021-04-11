package com.manisrini.domain.completablefuture.thenAccept_apply_run;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

import io.vavr.control.Try;

public class ExampleThenAcceptThenApplyAndRun {

  private static ForkJoinPool pool;

  public static void main(String[] args) {
    pool = new ForkJoinPool(100);

    final CompletableFuture<Integer> task = startAsyncTask(2);

    Try.run(() -> Thread.sleep(100));

    task
        .thenApply(result -> {
          System.out.println("thenApply Thread : " + Thread.currentThread());
          return result * 2.2;
        })
        .thenAccept(result -> System.out.println(result + ":thenAccept Thread : " + Thread.currentThread()))
        .thenRun(() -> System.out.println("Let's celebrate thenRun Thread: " + Thread.currentThread()));

    Try.run(() -> Thread.sleep(3000));
    pool.shutdown();
  }

  private static CompletableFuture<Integer> startAsyncTask(int number) {
    Supplier<Integer> doubleValue = () -> {
      System.out.println("running in thread " + Thread.currentThread());
      if (Math.random() > 0.75) {
        System.out.println("taking a slow run this time");
        Try.run(() -> Thread.sleep(2000));
      }

      return number * 2;
    };

    if (Math.random() > 0.5) {
      System.out.print("using custom pool ");
      return CompletableFuture.supplyAsync(doubleValue, pool);
    } else {
      System.out.print("using common pool ");
      return CompletableFuture.supplyAsync(doubleValue);
    }
  }
}
