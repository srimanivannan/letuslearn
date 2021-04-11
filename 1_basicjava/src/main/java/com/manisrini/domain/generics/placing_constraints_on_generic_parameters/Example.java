package com.manisrini.domain.generics.placing_constraints_on_generic_parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example {

  public static <T extends Comparable<T>> void copy(List<T> source, List<T> destination) {
    List<T> copyList = new ArrayList<>();
    copyList.addAll(source);
    copyList.addAll(destination);
    Collections.sort(copyList);
    System.out.println(copyList);
  }

  public static void main(String[] args) {
    copy(Arrays.asList(1, 3, 5, 7, 9), Arrays.asList(2, 4, 6, 8, 10));
    copy(Arrays.asList("a", "c"), Arrays.asList("b", "d"));
    //copy(Arrays.asList(new NotComparable()), Arrays.asList(new NotComparable()));
    // you get compile time error if you don't implement Comparable interface
  }
}

class NotComparable { //implements Comparable<NotComparable> {

//  @Override
//  public int compareTo(NotComparable o) {
//    return 0;
//  }
}
