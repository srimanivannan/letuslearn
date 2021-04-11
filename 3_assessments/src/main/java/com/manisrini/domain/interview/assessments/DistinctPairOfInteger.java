package com.manisrini.domain.interview.assessments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class DistinctPairOfInteger {

    public Map<Integer, Integer> determineDistinctPair(int targetSum, int ... numbers) {

        validateNumbers(targetSum, numbers);

        Map<Integer, Integer> pairs = new HashMap<>();

        Arrays.stream(numbers).boxed().distinct().forEach(inputValue -> {
            IntStream.range(0, numbers.length)
                    .filter(i -> (inputValue + numbers[i]) == targetSum)
                    .filter(i -> !pairs.containsKey(numbers[i]))
                    .forEach(i -> pairs.put(inputValue, numbers[i]));
        });
        return pairs;
    }

    private void validateNumbers(int targetSum, int[] numbers) {
        if (targetSum < 0 || targetSum > (5 * Math.pow(10,9))) {
            throw new IllegalArgumentException("validation failed");
        }

        if (null == numbers || numbers.length > (5 * Math.pow(10,5))) {
            throw new IllegalArgumentException("validation failed");
        }

        OptionalInt anInt = Arrays.stream(numbers).filter(i -> i < 0 || i > (5 * Math.pow(10, 9))).findAny();

        if (anInt.isPresent()) {
            throw new IllegalArgumentException("validation failed");
        }
    }

    public static void main(String[] args) {
        DistinctPairOfInteger pair = new DistinctPairOfInteger();
        // find pair that sums of 10 (first parameter). 3pairs : {1=9, 2=8, 3=7}
        Map<Integer, Integer> distinctPair = pair.determineDistinctPair(10, 1, 2, 3, 6, 7, 8, 9, 1);
        System.out.format("Total no of distinct pairs: %d : %s", distinctPair.size(), distinctPair);
    }
}
