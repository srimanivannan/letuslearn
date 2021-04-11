package com.manisrini.domain.completablefuture.thenCombine;

import java.util.concurrent.CompletableFuture;

public class ExampleThenCombine {

  public static void main(String[] args) {
    final CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> 2);
    final CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> 4);

    task1.thenCombine(task2, (task1Data, task2Data) -> task1Data * 2 + task2Data * 2)
        .thenAccept(System.out::println);
  }
}
