package com.manisrini.domain.completablefuture.supplyasyncgetandgetnow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.vavr.control.Try;

public class ExampleLambdaFutureBlockingGetNow {

  public static final int VALUE_IF_ABSENT = 0;

  // Run multiple time. sometimes value and sometimes default VALUE_IF_ABSENT because of getNow(VALUE_IF_ABSENT)
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("In start of main " + Thread.currentThread());

    final CompletableFuture<Integer> resultFuture = startAsyncTask(2);

    System.out.println("At the end of main " + Thread.currentThread());

    Try.run(()->Thread.sleep(1000));

    System.out.println(resultFuture.getNow(VALUE_IF_ABSENT)); //getNow() is also blocking call.
    //getNow() is a little bit better than get, but they both are bad.
    //getNow(valueifAbsent) parameter is default value if task doesn't return
  }

  private static CompletableFuture<Integer> startAsyncTask(int number) {
    return CompletableFuture.supplyAsync(() -> {
      if(Math.random() > 0.25) {
        System.out.println("taking a slow run this time");
        Try.run(()->Thread.sleep(2000));
      }
      return number * 3;
    });
  }
}
