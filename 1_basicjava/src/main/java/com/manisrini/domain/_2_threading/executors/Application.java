package com.manisrini.domain._2_threading.executors;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;


class Api1 {

  static String call(String text) {
    return Application.call(text, "1");
  }
  static CompletableFuture<String> callAsync(String text) {
    return CompletableFuture.supplyAsync(() -> Application.call(text, "1"));
  }
}

class Api2 {

  static String call(Long text) {
    return Application.call(text.toString(), "2");
  }

  static CompletableFuture<String> callAsync(Long text) {
    return CompletableFuture.supplyAsync(() -> Application.call(text.toString(), "2"));
  }
}

class Api4 {

  static String call(Api2 ignored) {
    return Application.call("why", "4");
  }

  static CompletableFuture<String> callAsync(Api2 ignored) {
    //return CompletableFuture.supplyAsync(() -> Application.call("why", "4"));
    return CompletableFuture.supplyAsync(() -> {
      System.out.println("supplyAsync thread =:" + Thread.currentThread().getName());
      throw new RuntimeException("oops");
    });
  }
}


public class Application {

  static final List<String> items = Arrays.asList("1", "2", "4");

  public static String call(String text, String prefix) {
    try {
      Thread.sleep((long) (Math.random() * 500.0));
    } catch (Exception ignored) {

    }
    return String.format("[%s-%s]", text, prefix);
  }

  public static void main(String[] args) {
    //System.out.println(parallel());
    //System.out.println(future());
    System.out.println(completableFuture());
  }

  public static String parallel() {
    return items.parallelStream()
        .map(it -> { // might want move into a function
          System.out.printf("on %s%n", it);
          switch (it) {
            case "1":
              return Api1.call("hey there");
            case "2":
              return Api2.call(232323L);
            case "4":
              return Api4.call(new Api2());
          }
          System.out.printf("%s will not be matched%n", it);
          return null;
        }).filter(Objects::nonNull)
        .reduce("", // initial value
            (s, it) -> String.format("%s %s", s, it), //will map them onto the incoming string
            // will be used to merge the parallel results
            //this is ignored if it were a normal stream but is called when in parallel
            (s1, s2) -> String.format("%s %s", s1, s2));
  }

  public static String future() {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    String item = items.stream()
        .map(it -> { // might want move into a function
          System.out.printf("on %s%n", it);
          switch (it) {
            case "1":
              return executorService.submit(() -> Api1.call("hey there"));
            case "2":
              return executorService.submit(() -> Api2.call(232323L));
            case "4":
              return executorService.submit(() -> Api4.call(new Api2()));
          }
          System.out.printf("%s will not be matched%n", it);
          return null;
        }).filter(Objects::nonNull)
        .map(it -> {
          try {
            return it.get();
          } catch (Exception ignored) {
            return "";
          }
        })
        .collect(Collectors.joining(" "));
    executorService.shutdown();
    return item;
  }

  public static String completableFuture() {

    String item = items.stream()
        .map(it -> { // might want move into a function
          System.out.printf("on %s%n", it);
          switch (it) {
            case "1":
              return Api1.callAsync("hey there");
            case "2":
              return Api2.callAsync(232323L);
            case "4":
              return Api4.callAsync(new Api2());
          }
          System.out.printf("%s will not be matched%n", it);
          return null;
        }).filter(Objects::nonNull)
        .map(completableFuture -> {
          try {
            return completableFuture
                .exceptionally((throwable -> "exceptionally"))
                .get();
          } catch (Exception ignored) {
            return "";
          }
        })
        .collect(Collectors.joining(" "));

    return item;
  }

}