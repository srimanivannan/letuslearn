package reactor.core.examples.classestorun;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ReactorExample {

  public static void main(String[] args) {
    // 1. Creating a Flux from a collection
    Flux<String> fluxFromList = Flux.fromIterable(List.of("Apple", "Banana", "Cherry"));

    // 2. Subscribing to a Flux to consume data
    fluxFromList.subscribe(it -> {
      System.out.println(Thread.currentThread().getName() + ":" + it);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    fluxFromList.subscribe(it -> {
      System.out.println(Thread.currentThread().getName() + ":" + it);
    });

//    // 3. Creating a Flux from a range
//    Flux<Integer> fluxFromRange = Flux.range(1, 5);
//
//    // 4. Transforming data using map
//    fluxFromRange.map(i -> i * 2)
//        .subscribe(System.out::println);
//
//    // 5. Filtering data using filter
//    fluxFromRange.filter(i -> i % 2 == 0)
//        .subscribe(System.out::println);
//
//    // 6. Combining multiple Flux using concat
//    Flux<Integer> flux1 = Flux.just(1, 2, 3);
//    Flux<Integer> flux2 = Flux.just(4, 5, 6);
//    Flux<Integer> combinedFlux = Flux.concat(flux1, flux2);
//
//    combinedFlux.subscribe(System.out::println);
//
//    // 7. Handling errors with onErrorResume
//    Flux<Integer> errorFlux = Flux.just(1, 2, 3)
//        .concatWith(Mono.error(new RuntimeException("Error occurred!")))
//        .onErrorResume(e -> {
//          System.err.println("Error handled: " + e.getMessage());
//          return Flux.just(4, 5, 6);
//        });
//
//    errorFlux.subscribe(System.out::println, Throwable::printStackTrace);
//
//    // 8. Asynchronous processing with Schedulers
//    Flux.range(1, 3)
//        .publishOn(Schedulers.parallel())
//        .map(i -> i * 10)
//        .subscribeOn(Schedulers.single())
//        .subscribe(System.out::println);
//
//    // 9. Creating a Mono (single-value publisher)
//    Mono<String> mono = Mono.just("Single Value");
//
//    mono.subscribe(System.out::println);
  }
}

