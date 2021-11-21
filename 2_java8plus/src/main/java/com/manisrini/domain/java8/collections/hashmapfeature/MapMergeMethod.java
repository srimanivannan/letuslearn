package com.manisrini.domain.java8.collections.hashmapfeature;

import java.util.HashMap;
import java.util.Map;

public class MapMergeMethod {

  private void mergeWithInSingleMapExample() {
    Map<Integer, Integer> map1 = new HashMap<>();
    map1.put(1, 1);
    map1.put(2, 2);
    map1.put(3, 3);
    /*
      In the below line, we try to update key 3
      the current value for key 3 is 3. we try to over write with 7
      so in BiFunction parameter both are value. v1 is existing 3 v2 is new value 7
      you apply logic which value do you wanna pick. in this example it's v2 which is 7
     */
    map1.merge(3, 7, (existingValueInMap, newValueGoingToBeInMap) -> newValueGoingToBeInMap); // replace with newValueGoingToBeInMap
    map1.merge(2, 100, (existingValueInMap, newValueGoingToBeInMap) -> existingValueInMap + newValueGoingToBeInMap); // you can use both old value and new value for manipulation or calculation
    map1.merge(4, 4,
        (existingValueInMap, newValueGoingToBeInMap) -> newValueGoingToBeInMap); // if the key not available BiFunction will not get called simply it will take expected value
    map1.merge(1, 9, (existingValueInMap, newValueGoingToBeInMap) -> null); // interestingly you can even remove key and value pair entry with simply returning null
    map1.forEach((key, value) -> System.out
        .println("mergeWithInSingleMapExample map1 " + key + " : " + value));
  }

  private void mergeTwoMapsExample() {
    // mergemap
    Map<Integer, Integer> map1 = new HashMap<>();
    map1.put(1, 1);
    map1.put(2, 2);
    map1.put(3, 3);

    Map<Integer, Integer> map2 = new HashMap<>();
    map2.put(4, 4);
    map2.put(5, 5);
    map2.put(1, 6);

    /*
      here we are merging map1 key values into map2
      so we pick map1 value which is 1 will be replaced by new value 6
     */
    map1.forEach((map1Key, map1Val) -> map2.merge(map1Key, map1Val, (map2Val, map1OldVal) -> {
      System.out.println("map1OldVal:" + map1OldVal);
      System.out.println("map2Val:" + map2Val);
      return map1OldVal;
    }));
    map2.forEach((key, value) -> System.out.println("mergeTwoMapsExample " + key + " : " + value));
  }

  public static void main(String[] args) {

    MapMergeMethod mapMergeMethod = new MapMergeMethod();
    mapMergeMethod.mergeWithInSingleMapExample();
    mapMergeMethod.mergeTwoMapsExample();
  }

}
