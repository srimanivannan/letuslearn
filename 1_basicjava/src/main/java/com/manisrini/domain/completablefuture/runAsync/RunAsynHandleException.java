package com.manisrini.domain.completablefuture.runAsync;

import java.util.concurrent.CompletableFuture;

public class RunAsynHandleException {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                // Your code that may throw an exception
                int result = 10 / 0; // This will throw an ArithmeticException
            } catch (Exception ex) {
                throw new RuntimeException("Exception occurred in task", ex);
            }
        });

        future.handle((result, ex) -> {
            if (ex != null) {
                System.err.println("Exception occurred: " + ex);
            }
            return null; // Return a default value or null to continue processing
        });

        // Explicitly handle the exception
        future.exceptionally(ex -> {
            System.err.println("Unhandled exception occurred: " + ex);
            return null; // Return a default value or null to continue processing
        });

        // Wait for the CompletableFuture to complete (or handle it differently)
        future.join(); // This will not throw an exception and finish with zero exit value
    }
}
