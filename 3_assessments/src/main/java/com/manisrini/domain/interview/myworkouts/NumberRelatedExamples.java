package com.manisrini.domain.interview.myworkouts;

import java.util.Arrays;

public class NumberRelatedExamples {

  private void findMaxNumberInArrayOrListOrVarg() {
    int[] arrayOfInt = new int[] {4,8,64,96,2,7,9,8,45,87};
    // max from whole list which is 96
    System.out.println(Arrays.stream(arrayOfInt).max().orElse(0));
    // max from 5th element meaning skip 4 on the list which is 87
    System.out.println(Arrays.stream(arrayOfInt).skip(4).max().orElse(0));

    System.out.println(Arrays.stream(arrayOfInt).skip(4).limit(5).max().orElse(0));
  }

  private void dataManipulationInsideArray() {
    int[] ints = {6, 1, 4, 6, 3, 2, 7, 4};
    //Arrays.stream(ints).boxed().map(it -> it.);
  }

  private void stringToInt() {
    //Arrays.asList(1,2,3,).stream().map
  }

  public static void main(String[] args) {
    NumberRelatedExamples numberRelatedExamples = new NumberRelatedExamples();
    numberRelatedExamples.findMaxNumberInArrayOrListOrVarg();
  }
}
