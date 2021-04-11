package com.manisrini.domain.completablefuture.checkingstatus;

import java.util.concurrent.CompletableFuture;

public class ExampleCheckingStatus {

  public static void main(String[] args) throws InterruptedException {
    final CompletableFuture<Integer> failedTask = createFailedTask();

    Thread.sleep(100);

    System.out.println("isDone(): " + failedTask.isDone());
    System.out.println("isCancelled(): " + failedTask.isCancelled());
    System.out.println("isCompletedExceptionally(): " + failedTask.isCompletedExceptionally());

    final CompletableFuture<Integer> successTask = createSuccessTask();
    Thread.sleep(100);
    System.out.println("isDone(): " + successTask.isDone());
    System.out.println("isCancelled(): " + successTask.isCancelled());
    System.out.println("isCompletedExceptionally(): " + successTask.isCompletedExceptionally());
  }

  private static CompletableFuture<Integer> createFailedTask() {
    return CompletableFuture.supplyAsync(() -> {
      throw new RuntimeException("oops");
    });
  }

  private static CompletableFuture<Integer> createSuccessTask() {
    return CompletableFuture.supplyAsync(() -> 2);
  }
}
