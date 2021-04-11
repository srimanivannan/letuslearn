package com.manisrini.domain.completablefuture.supplyasyncgetandgetnow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.vavr.control.Try;

public class ExampleLambdaFutureBlocking {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("In start of main " + Thread.currentThread());

    final CompletableFuture<Integer> resultFuture = startAsyncTask(2);

    System.out.println("After startAsyncTask of main " + Thread.currentThread());

    System.out.println(resultFuture.get()); //get() is blocking call. It puts main thread waiting

    System.out.println("At the end of main " + Thread.currentThread());
  }

  private static CompletableFuture<Integer> startAsyncTask(int number) {
    return CompletableFuture.supplyAsync(() -> {
      Try.run(() -> Thread.sleep(2000));
      return number * 2;
    });
  }

}
