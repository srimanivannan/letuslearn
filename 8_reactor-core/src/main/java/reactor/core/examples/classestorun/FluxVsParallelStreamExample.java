package reactor.core.examples.classestorun;

import reactor.core.examples.util.ThreadUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;

public class FluxVsParallelStreamExample {

  public static void main(String[] args) {
    // Using parallelStream
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);

    numbers.parallelStream()
        .map(i -> {
          System.out.println("parallelStream Processing: " + i + " on Thread: " + Thread.currentThread().getName());
          return i * 2;
        })
        .forEach(result -> System.out.println("parallelStream Result: " + result + " on Thread: " + Thread.currentThread().getName()));

    // Using Flux for asynchronous processing
    Flux.fromIterable(numbers)
        .publishOn(Schedulers.parallel()) // Use parallel scheduler
        .map(i -> {
          System.out.println("Flux Processing: " + i + " on Thread: " + Thread.currentThread().getName());
          return i * 2;
        })
        .subscribeOn(Schedulers.single()) // Subscribe on another thread
        .subscribe(result -> System.out.println("Flux Result: " + result + " on Thread: " + Thread.currentThread().getName()));

    ThreadUtil.waitFor(Duration.ofSeconds(3));
  }
}

