package com.manisrini.domain.java8.collections.hashmapfeature;

import java.time.LocalDate;
import java.util.HashMap;

public class MapComputeIfPresentMethod {

  public static void main(String[] args) {
    System.out.println(LocalDate.now());
    // create a HashMap and add some values
    HashMap<String, Integer> map = new HashMap<>();
    map.put("a", 10000);
    map.put("b", 55000);
    map.put("c", 44300);
    map.put("e", 53200);

    // print original map
    System.out.println("HashMap:\n " + map);

    // put a new value which is not mapped before in map
    System.out.println("when key is not there:" + map.computeIfPresent("d", (key, value) -> {
      System.out.println("BiFunction won't get called: the key is:" + key);
      return 3344;
    }));

    System.out.println("New HashMap:\n " + map);

    // get a old value with existing key . don't put new value
    System.out.println("when key is already there:" + map.computeIfPresent("a", (key, value) -> {
      System.out.println("BiFunction is getting called: the key is:" + key);
      return 55555;
    }));

    // print newly mapped map
    System.out.println("Unchanged HashMap:\n " + map);
  }
}
