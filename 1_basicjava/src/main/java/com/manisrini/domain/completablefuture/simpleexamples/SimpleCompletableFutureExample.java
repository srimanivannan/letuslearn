package com.manisrini.domain.completablefuture.simpleexamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import io.vavr.control.Try;

public class SimpleCompletableFutureExample {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Future<String> future = getResultOverNetwork3();

    // the below code will continue to execute by main thread due to non blocking future async process of getResultOverNetwork
    IntStream.range(1, 2).forEach(i -> {
      delay(100);
      System.out.println("Doing useful work in main thread");
    });
    System.out.println(future.get()); // get() will block main thread forever unless you have future.complete method called.
    System.out.println(Thread.currentThread().getName() + " thread died");
  }

  private static Future<String> getResultOverNetwork() {
    CompletableFuture<String> future = new CompletableFuture<>();
    Thread thread = new Thread(() -> {
      delay(5000);
      future.complete("{\"result\":\"success\"}");
    });
    thread.setName("thread that executes future.complete");
    thread.start();
    return future;
  }

  private static Future<String> getResultOverNetwork3() {
    CompletableFuture<String> future = new CompletableFuture<>();

    Executors.newCachedThreadPool().submit(() -> {
      delay(5000);
      return future.complete("{\"result\":\"success\"}");
    });
    return future;
  }

  private static Future<String> getResultOverNetwork2() {
    return CompletableFuture.supplyAsync(() -> {
      delay(5000);
      return "{\"result\":\"success\"}";
    });
  }

  private static void delay(int millis) {
    Try.run(() -> {
      System.out.println(Thread.currentThread().getName());
      Thread.sleep(millis);
    });
  }
}
