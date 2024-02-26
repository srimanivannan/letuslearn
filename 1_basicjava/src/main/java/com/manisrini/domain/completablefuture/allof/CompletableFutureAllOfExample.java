package com.manisrini.domain.completablefuture.allof;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureAllOfExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Simulate an exception
            throw new RuntimeException("Exception in future1");
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 42);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                future1.exceptionally(ex -> {
                    System.err.println("Future1 completed exceptionally: " + ex.getMessage());
                    return null; // Return a default value or null
                }),
                future2.exceptionally(ex -> {
                    System.err.println("Future2 completed exceptionally: " + ex.getMessage());
                    return null; // Return a default value or null
                })
        );

        allOf.join(); // Wait for all futures to complete
    }
}
