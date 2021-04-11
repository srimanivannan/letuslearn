package com.manisrini.domain.completablefuture.thenComposethenApplythenCombine;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import io.vavr.control.Try;

public class ComposeCompletableFuture {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    //thenApplyExample(); // this is like stream map . returns nested CompletableFuture
    thenComposeExample(); // this is like stream flatmap . flattens nested CompletableFu
    //thenCombineAndThenAcceptExample();
  }

  private static void thenApplyExample() throws InterruptedException, ExecutionException {
    CompletableFuture<Integer> future = supplyAsync(() -> 4 + 3)
        .thenApply(i -> i*2);
    System.out.println(future.get());
  }

  private static void thenComposeExample() throws InterruptedException, ExecutionException {
    CompletableFuture<Integer> future = supplyAsync(() -> 4 + 3)
        .thenCompose(it -> supplyAsync(() -> it * 2));
    System.out.println(future.get());
  }

  private static void thenCombineAndThenAcceptExample() {
    CompletableFuture<Void> future = supplyAsync(ComposeCompletableFuture::getFruits)
        .thenCombine(supplyAsync(ComposeCompletableFuture::getVeggies), passBiFunction())
        .thenAccept(items -> items.forEach(System.out::println));
    future.join();
  }

  private static BiFunction<String[], String[], Stream<String>> passBiFunction() {
    return (fruits, veggies) -> Stream.concat(Arrays.stream(fruits), Arrays.stream(veggies));
  }

  private static String[] getVeggies() {
    System.out.println("getting veggies...");
    delay(2000);
    System.out.println("completed veggies");
    return new String[]{"broccoli", "brussels sprout"};
  }

  private static String[] getFruits() {
    System.out.println("getting fruits...");
    delay(1500);
    System.out.println("completed fruits");
    return new String[]{"apple", "apricot", "banana"};
  }

  private static void delay(int millis) {
    Try.run(() -> {
      System.out.println(Thread.currentThread().getName());
      Thread.sleep(millis);
    });
  }
}
