package com.manisrini.domain.java8.collections.hashmapfeature;

import java.util.HashMap;

public class MapPutIfAbsentMethod {

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
    System.out.println("when key is not there:" + map.putIfAbsent("d", 77633));

    System.out.println("New HashMap:\n " + map);

    // try to put a new value with existing key
    // before in map
    System.out.println("when key is already there:" + map.putIfAbsent("d", 55555));

    // print newly mapped map
    System.out.println("Unchanged HashMap:\n " + map);
  }
}
