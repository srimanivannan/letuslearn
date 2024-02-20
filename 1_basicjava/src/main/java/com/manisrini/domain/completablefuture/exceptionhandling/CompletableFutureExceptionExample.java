package com.manisrini.domain.completablefuture.exceptionhandling;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionExample {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("going to sleep 5 seconds and comeback");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Your code that may throw an exception
            int result = 10 / 0; // This will throw an ArithmeticException
        });

        future.handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception occurred: " + ex);
            }
            return result; // Return a default value or null to continue processing
        });
        System.out.println("this is main method");
        // No need to explicitly call join() here
        System.out.println("doing other tasks and keep it going....");
        try {
            System.out.println("all done. main going to sleep 10 seconds and finish");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
