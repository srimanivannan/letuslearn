package com.manisrini.domain.java8.collections;

import java.util.HashMap;

public class MapComputeMethod {

  public static void main(String[] args) {
    // create a HashMap and add some values
    HashMap<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);
    map.put("d", 4);

    // print original map
    System.out.println("HashMap:\n " + map);

    map.compute("b", (key, value) -> {
      return value == null? 1: value + 10;
    });

    map.compute("e", (key, value) -> {
      return value == null? 1: value + 10;
    });

    System.out.println("New computed HashMap:\n " + map);

  }
}
