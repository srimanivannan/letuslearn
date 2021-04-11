package com.manisrini.domain._2_threading.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    CompletableFutureExample completableFutureExample = new CompletableFutureExample();
    completableFutureExample.doIt();
  }

  public void doIt() throws ExecutionException, InterruptedException {
    Supplier<String> supplier = () -> "supplier message\n";
    Consumer<? super String> consumer = System.out::println;
    Function<? super String, ? extends String> function = s -> s += "function message\n";
    Function<Integer, Integer> function1 = i -> i + 1;
    Function<Throwable, ? extends String> throwableFunction = Throwable::getMessage;
    CompletableFuture<Void> future =
        CompletableFuture.supplyAsync(supplier)
            .thenApply(function)
            .thenAccept(consumer);
    //comment to fail
    //future.get(); // with out get() these will not get executed because that's when you ask question what happened and these are lambda
    //future.completeExceptionally(new RuntimeException("purposefully throwing exception"));
    Function<Throwable, ? extends Void> throwableFunction1 = (Function<Throwable, Void>) throwable -> {
      System.out.println("failed:" + throwable.getMessage());
      return null;
    };
    future.exceptionally(throwableFunction1);
    future.get(); // with out get() these will not get executed because that's when you ask question what happened and these are lambda

  }
}
