package com.manisrini.domain.interview.myworkouts;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromArray {

  private int[] removeDuplicates(int[] numbers) {
    List<Integer> wholeList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
    //wholeList.remove(Integer.valueOf(2));
    //System.out.println("removed" + wholeList);
    Collection<Integer> duplicates = wholeList.parallelStream()
        .filter(it -> Collections.frequency(wholeList, it) > 1)
        .collect(Collectors.toMap(key -> key, value -> value, (value1, value2) -> value2)).values();
    System.out.println(duplicates);
    //wholeList.removeAll(duplicates);
    duplicates.forEach(wholeList::remove);
    System.out.println(wholeList);
    return null;
  }

  private int[] getDistinct(int[] numbers) {
    List<Integer> wholeList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
    //wholeList.remove(Integer.valueOf(2));
    //System.out.println("removed" + wholeList);
    Collection<Integer> duplicates = wholeList.parallelStream()
        .filter(it -> Collections.frequency(wholeList, it) > 1)
        .collect(Collectors.toMap(key -> key, value -> value, (value1, value2) -> value2)).values();
    System.out.println(duplicates);
    //wholeList.removeAll(duplicates);
    duplicates.forEach(wholeList::remove);
    System.out.println(wholeList);
    return null;
  }


  public static void main(String[] args) {
    RemoveDuplicatesFromArray removeDuplicatesFromArray = new RemoveDuplicatesFromArray();
    removeDuplicatesFromArray.removeDuplicates(new int[] {2,8,4,6,2,3,5,3});
  }
}
