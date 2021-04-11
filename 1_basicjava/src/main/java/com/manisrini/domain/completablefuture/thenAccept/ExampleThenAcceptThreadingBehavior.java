package com.manisrini.domain.completablefuture.thenAccept;

import java.util.concurrent.CompletableFuture;

import io.vavr.control.Try;

public class ExampleThenAcceptThreadingBehavior {

  public static void main(String[] args) {
    final CompletableFuture<Integer> task = startAsyncTask(2);

    Try.run(() -> Thread.sleep(100));

    task.thenAccept(result -> System.out.println("result " + result + " : " + Thread.currentThread()));
    //when main hits this line, if the task is completed, then the execution of the
    //lambda runs in the main thread. However, when main hits this line, if the task is not
    //completed, then the lambda may run into a different thread. Non-blocking.

    //A stage that is being attached to a resolved or rejected CompletableFuture complete in the
    //calling thread. However, a state that is being attached to a pending CompletableFuture will
    //run eventually when that resolves or rejects in the other thread.

    Try.run(() -> Thread.sleep(3000));

  }

  private static CompletableFuture<Integer> startAsyncTask(int number) {
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("running in thread " + Thread.currentThread());
      if (Math.random() > 0.75) {
        System.out.println("taking a slow run this time");
        Try.run(() -> Thread.sleep(2000));
      }
      return number * 2;
    });
  }
}
