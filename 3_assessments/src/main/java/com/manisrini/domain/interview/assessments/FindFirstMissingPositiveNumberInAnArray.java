package com.manisrini.domain.interview.assessments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindFirstMissingPositiveNumberInAnArray {

  private int test(int[] a) {
    Set<Integer> positiveIntegers = Arrays.stream(a).filter(num -> num > 0).boxed()
        .collect(Collectors.toSet());
    Optional<Integer> first = IntStream.rangeClosed(1, positiveIntegers.size())
        .boxed().filter(it -> !positiveIntegers.contains(it))
        .findFirst();
    return first.orElseGet(() -> {
      if (positiveIntegers.isEmpty()) {
        return 1;
      }
      //return positiveIntegers.stream().max(Comparator.naturalOrder()).get() + 1;
      return positiveIntegers.size() + 1;
    });
  }

  public static void main(String[] args) {
    FindFirstMissingPositiveNumberInAnArray positiveNumbers = new FindFirstMissingPositiveNumberInAnArray();
    System.out.println(positiveNumbers.test(new int[]{1,2,3}));
  }
}
