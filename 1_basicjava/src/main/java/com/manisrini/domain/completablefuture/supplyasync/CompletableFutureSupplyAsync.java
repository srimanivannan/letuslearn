package com.manisrini.domain.completablefuture.supplyasync;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureSupplyAsync {

    public void manitest() {
        String s = executeCommand(getPiDataServicesSupplier(), piCoreServicesSupplier(), true);
        System.out.println("Final Result" + s + "by thread" + Thread.currentThread().getName());
    }

    private Supplier<String> getPiDataServicesSupplier() {
        return () -> {
            System.err.println("error getPiDataServicesSupplier happened by thread:" + Thread.currentThread().getName());
            throw new RuntimeException("hello error");
        };
    }

    private Supplier<String> piCoreServicesSupplier() {
        return () -> {
            System.out.println("piCoreServicesSupplier executed by thread:"+ Thread.currentThread().getName());
            return "test";
        };
    }

    private <T> T executeCommand(Supplier<T> piDataServicesSupplier, Supplier<T> piCoreServicesSupplier, boolean test) {

        List<CompletableFuture<T>> futures = new ArrayList<>();

        if (test) {
            invokeServicesSupplyAsync(piDataServicesSupplier, piCoreServicesSupplier, futures);
        } else {
            invokeServicesSupplyAsync(piCoreServicesSupplier, piDataServicesSupplier, futures);
        }

        System.out.println("Size of futures arraylist" + futures.size());
        Optional<CompletableFuture<T>> successFuture = futures.stream().filter(f-> !f.isCompletedExceptionally()).findFirst();
        if (successFuture.isPresent()) {
            System.out.println("successFuture.get().join() by thread: " + Thread.currentThread().getName());
            return successFuture.get().join();
        }

        // TODO Handle Exception for the either New or Legacy Facade or Both and store in db error table
        throw new RuntimeException("last exception is thrown by thread: " + Thread.currentThread().getName());
    }

    private <T> void invokeServicesSupplyAsync(Supplier<T> primaryService, Supplier<T> secondaryService, List<CompletableFuture<T>> serviceFutures) {
        CompletableFuture<T> primaryServiceFuture = CompletableFuture.supplyAsync(() -> {
            Thread.currentThread().setName("primaryService");
            return primaryService.get();
        });

        handleIfAnyExceptionHappened(primaryServiceFuture);
        serviceFutures.add(0, primaryServiceFuture);

        if (!primaryServiceFuture.isCompletedExceptionally()) {
            CompletableFuture<T> secondaryServiceFuture = CompletableFuture.supplyAsync(() -> {
                Thread.currentThread().setName("secondaryServiceFuture");
                return secondaryService.get();
            });
            handleIfAnyExceptionHappened(secondaryServiceFuture);
            serviceFutures.add(1, secondaryServiceFuture);
        }
    }
    private <T> void handleIfAnyExceptionHappened(CompletableFuture<T> future) {
        future.handle((result, ex) -> {
            if (Objects.nonNull(ex)) {
                System.err.println("Failed message:" + ex.getMessage() + "by thread:" + Thread.currentThread().getName());
                return future.completeExceptionally(ex);
            }
            return result;
        });
    }
    public static void main(String[] args) {
        CompletableFutureSupplyAsync completableFutureSupplyAsync =
            new CompletableFutureSupplyAsync();
        completableFutureSupplyAsync.manitest();
    }
}
