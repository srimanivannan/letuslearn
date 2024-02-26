package reactor.core.examples.classestorun;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

public class FluxVsStreamsExample {

  public static void main(String[] args) {
    // Example 1: Asynchronous Processing with Flux
    System.out.println("Example 1: Asynchronous Processing with Flux");
    Flux.range(1, 5)
        .publishOn(Schedulers.parallel()) // Run on a separate thread
        .map(i -> {
          System.out.println("Processing: " + i + " on Thread: " + Thread.currentThread().getName());
          return i * 2;
        })
        .subscribeOn(Schedulers.single()) // Subscribe on another thread
        .subscribe(result -> System.out.println("Result: " + result));

    sleep(5000); // Wait for asynchronous processing to complete
//
//    // Example 2: Backpressure Handling with Flux
//    System.out.println("\nExample 2: Backpressure Handling with Flux");
//    Flux.range(1, 10)
//        .log()
//        .limitRate(3) // Limit the rate of emission
//        .subscribe(item -> {
//          System.out.println("Received item: " + item + " on Thread: " + Thread.currentThread().getName());
//          sleep(100); // Simulate slow processing
//        });
//
//    sleep(2000); // Wait for backpressure handling to complete
//
//    // Example 3: Hot and Cold Streams with Flux
//    System.out.println("\nExample 3: Hot and Cold Streams with Flux");
//    Flux<Integer> coldFlux = Flux.range(1, 3);
//
//    // Cold Flux (Subscribed multiple times)
//    coldFlux.subscribe(value -> System.out.println("Subscriber 1: " + value + " on Thread: " + Thread.currentThread().getName()));
//    coldFlux.subscribe(value -> System.out.println("Subscriber 2: " + value + " on Thread: " + Thread.currentThread().getName()));
//
//    // Hot Flux (Emits even if no subscribers)
//    Flux<Integer> hotFlux = Flux.just(1, 2, 3).publish().autoConnect();
//
//    // Hot Flux (Subscribed multiple times)
//    hotFlux.subscribe(value -> System.out.println("Subscriber 3: " + value + " on Thread: " + Thread.currentThread().getName()));
//    hotFlux.subscribe(value -> System.out.println("Subscriber 4: " + value + " on Thread: " + Thread.currentThread().getName()));
//
//    sleep(2000); // Wait for hot and cold streams to complete
//
//    // Example 4: Error Handling with Flux
//    System.out.println("\nExample 4: Error Handling with Flux");
//    Flux<Integer> errorFlux = Flux.just(1, 2, 3)
//        .concatWith(Mono.error(new RuntimeException("Error occurred!")))
//        .onErrorResume(e -> {
//          System.err.println("Error handled: " + e.getMessage() + " on Thread: " + Thread.currentThread().getName());
//          return Flux.just(4, 5, 6);
//        });
//
//    errorFlux.subscribe(result -> System.out.println("Result: " + result + " on Thread: " + Thread.currentThread().getName()),
//        throwable -> throwable.printStackTrace());
//
//    sleep(2000); // Wait for error handling to complete
//
    // Example 5: Synchronous Processing with Java Streams
    System.out.println("\nExample 5: Synchronous Processing with Java Streams");
    List<String> list = List.of("Apple", "Banana", "Cherry");

    list.parallelStream()
        .map(item -> {
          System.out.println("Processing: " + item + " on Thread: " + Thread.currentThread().getName());
          return item.toUpperCase();
        })
        .forEach(result -> System.out.println("Result: " + result + " on Thread: " + Thread.currentThread().getName()));
  }

  private static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}

