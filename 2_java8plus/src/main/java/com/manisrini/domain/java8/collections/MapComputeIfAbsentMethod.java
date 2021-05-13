package com.manisrini.domain.java8.collections;

import java.util.HashMap;

public class MapComputeIfAbsentMethod {

  public static void main(String[] args) {
    // create a HashMap and add some values
    HashMap<String, Integer> map = new HashMap<>();
    map.put("a", 10000);
    map.put("b", 55000);
    map.put("c", 44300);
    map.put("e", 53200);

    // print original map
    System.out.println("HashMap:\n " + map);

    // put a new value which is not mapped before in map
    System.out.println("when key is not there:" + map.computeIfAbsent("d", it -> 3344));

    System.out.println("New HashMap:\n " + map);

    // get a old value with existing key . don't put new value
    System.out.println("when key is already there:" + map.computeIfAbsent("d", it -> 55555));

    // print newly mapped map
    System.out.println("Unchanged HashMap:\n " + map);
  }
}
