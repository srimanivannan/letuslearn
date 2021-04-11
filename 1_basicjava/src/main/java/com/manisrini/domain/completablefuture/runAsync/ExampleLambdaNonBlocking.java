package com.manisrini.domain.completablefuture.runAsync;

import java.util.concurrent.CompletableFuture;

import io.vavr.control.Try;

public class ExampleLambdaNonBlocking {

  public static void main(String[] args) {
    System.out.println("In start of main " + Thread.currentThread());

    startAsyncTask(); //this is non-blocking

    System.out.println("At the end of main " + Thread.currentThread());
    Try.run(() -> Thread.sleep(2000));
  }

  private static void startAsyncTask() {
    CompletableFuture.runAsync(() -> {
      System.out.println("running a little task starts" + Thread.currentThread());
      Try.run(() -> Thread.sleep(2000));
      System.out.println("running a little task ends" + Thread.currentThread());
    });
  }
}
