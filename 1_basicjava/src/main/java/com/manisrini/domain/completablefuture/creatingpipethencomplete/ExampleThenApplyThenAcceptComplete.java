package com.manisrini.domain.completablefuture.creatingpipethencomplete;

import java.util.concurrent.CompletableFuture;

public class ExampleThenApplyThenAcceptComplete {

  public static void main(String[] args) {
    CompletableFuture<Integer> task = new CompletableFuture<>();

    task
        .thenApply(e -> e * 2) // 10 * 2
        .thenApply(e -> e + 1) // 20 + 1
        .thenAccept(System.out::println); // 21

    task.complete(10); // this input to task

  }
}
