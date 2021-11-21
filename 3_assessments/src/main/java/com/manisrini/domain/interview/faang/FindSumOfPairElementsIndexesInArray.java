package com.manisrini.domain.interview.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import io.vavr.Tuple;

public class FindSumOfPairElementsIndexesInArray {

  private List<Tuple> findSumOfPairElementsIndexesInArrayMultipleNoDuplicates(int[] numbers, int targetSum) {
    List<Tuple> pair = new ArrayList<>();
    IntStream.range(0, numbers.length).forEach(out -> {
      IntStream.range(out + 1, numbers.length).forEach(in -> {
        if (numbers[out] + numbers[in] == targetSum) {
          pair.add(Tuple.of(out, in));
        }
      });
    });
    return pair;
  }

  private List<Tuple> findSumOfPairElementsIndexesInArrayOneForLoop(int[] numbers, int targetSum) {
    List<Tuple> pair = new ArrayList<>();
    int previousNumber = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] + previousNumber == targetSum) {
        pair.add(Tuple.of(i - 1, i));
      }
      previousNumber = numbers[i];
    }
    return pair;
  }

  public static void main(String[] args) {
    FindSumOfPairElementsIndexesInArray findSumOfPairElementsIndexesInArray = new FindSumOfPairElementsIndexesInArray();
    List<Tuple> sumOfPairElementsIndexesInArray = findSumOfPairElementsIndexesInArray
        .findSumOfPairElementsIndexesInArrayMultipleNoDuplicates(new int[]{1, 3, 7, 9, 2}, 10);
    System.out.println(sumOfPairElementsIndexesInArray);
    List<Tuple> oneloop = findSumOfPairElementsIndexesInArray
        .findSumOfPairElementsIndexesInArrayOneForLoop(new int[]{1, 3, 7, 9, 2}, 10);
    System.out.println(oneloop);
  }
}
