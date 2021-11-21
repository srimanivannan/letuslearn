package com.manisrini.domain.completablefuture.checkingtaskstatus;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExampleCheckingTaskStatus {

  public static void main(String[] args) throws InterruptedException {
    final CompletableFuture<Integer> failedTask = createFailedTask();

    //Thread.sleep(100);

    System.out.println("isDone(): " + failedTask.isDone());
    System.out.println("isCancelled(): " + failedTask.isCancelled());
    //System.out.println("isCompletedExceptionally(): " + failedTask.isCompletedExceptionally());
//    CompletableFuture<Integer> handle = failedTask.handle((numb, err) -> {
//      System.out.println(err.getMessage());
//      return 11;
//    });
    try {
      System.out.println("isDone(): " + failedTask.isDone());
      if (failedTask.isCompletedExceptionally() && failedTask.isDone()) {
        System.out.println("main thread==>" + Thread.currentThread().getName());

        failedTask.whenComplete((it, err) -> {
          System.out.println("when complete");
        });
        //System.out.println(handle.get());
      } else {
        System.out.println("main thread:==> " + Thread.currentThread().getName());
        System.out.println("else part" + failedTask.get());
      }
    } catch (ExecutionException e) {
      System.out.println("exception");
    }

//    final CompletableFuture<Integer> successTask = createSuccessTask();
//    Thread.sleep(100);
//    System.out.println("isDone(): " + successTask.isDone());
//    System.out.println("isCancelled(): " + successTask.isCancelled());
//    System.out.println("isCompletedExceptionally(): " + successTask.isCompletedExceptionally());
//    System.out.println("Main Thread completed");
  }

  private static CompletableFuture<Integer> createFailedTask() {
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("supplyAsync thread =:" + Thread.currentThread().getName());
      throw new RuntimeException("oops");
    });
  }

//  private static CompletableFuture<Integer> createSuccessTask() {
//    return CompletableFuture.supplyAsync(() -> 2);
//  }
}
