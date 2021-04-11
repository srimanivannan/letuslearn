package com.manisrini.domain._2_threading.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import io.vavr.control.Try;

public class CompletableFutureExample1 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFutureExample1 completableFutureExample = new CompletableFutureExample1();
    completableFutureExample.doIt();
  }

  public void doIt() throws ExecutionException, InterruptedException {
    System.out.println("Main thread task:" + Thread.currentThread().getName());
    Supplier<String> supplier = () -> {
      Try.run(() -> TimeUnit.MILLISECONDS.sleep(3000));
      return "supplier input message from thread name: " + Thread.currentThread().getName();
    };

    Function<? super String, ? extends String> function = (String s) -> s
        + " thenApplyAsync function input message" + Thread.currentThread().getName();

    Consumer<? super String> consumer = (String s) -> {
      System.out.println(s.toUpperCase() + Thread.currentThread().getName());
    };

    CompletableFuture<Void> completableFuture = CompletableFuture
        .supplyAsync(supplier) // supplier
        .thenApplyAsync(function) // function
        .thenAccept(consumer);

    CompletableFuture<Void> completableFuture1 = CompletableFuture
        .supplyAsync(supplier) // supplier
        .thenApply(function) // function
        .thenAccept(consumer);

    completableFuture.get(); // with out get() these will not get executed because that's when you ask question what happened and these are lambda

    System.out.println("completableFuture.isDone():" + completableFuture.isDone());
    System.out.println("completableFuture1.completeExceptionally(new RuntimeException(\"failed\")):"
        + completableFuture1.completeExceptionally(new RuntimeException(
        "failed"))); // This means that things are not working in CompletableFuture on time then complete with mentioned exception
    System.out.println("completableFuture1.isDone():" + completableFuture1.isDone());
    System.out.println("Main thread final task:" + Thread.currentThread().getName());
  }
}
