package com.manisrini.domain.interview.assessments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindLonelyInteger {

    public List<Integer> findLonelyInteger(int... inputs) {

        List<Integer> intArrayToListOfIntegers = Arrays.stream(inputs).boxed().collect(Collectors.toList());

        //IntStream intStream = Arrays.stream(inputs);
        //Stream<Integer> toObj = intStream.mapToObj(x -> Integer.valueOf(x));
        //Stream<Integer> boxed = intStream.boxed();

        List<Integer> integerList = intArrayToListOfIntegers.stream()
                .filter(num -> Collections.frequency(intArrayToListOfIntegers, num) == 1)
                .collect(Collectors.toList());

        return integerList;
    }

    public static void main(String[] args) {
        FindLonelyInteger find = new FindLonelyInteger();
        System.out.println(find.findLonelyInteger(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 7, 8));
    }
}
