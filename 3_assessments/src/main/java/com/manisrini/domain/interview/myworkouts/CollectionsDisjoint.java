package com.manisrini.domain.interview.myworkouts;

import java.util.Arrays;
import java.util.Collections;

public class CollectionsDisjoint {

  public static void main(String[] args) {
    String[] x = {"1","2","3"};
    String[] y = {"4","5","6"};
    boolean isNoCommonElements = Collections.disjoint(
        Arrays.asList(x), Arrays.asList(y));
    System.out.println(isNoCommonElements);
  }
}
