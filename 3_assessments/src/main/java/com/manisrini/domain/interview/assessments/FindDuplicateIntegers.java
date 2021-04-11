package com.manisrini.domain.interview.assessments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicateIntegers {

    public Set<Integer> findDuplicateInetegers(int ... inputs) {

        IntStream stream = Arrays.stream(inputs);
        List<Integer> integerList = stream.boxed().collect(Collectors.toList());

        Set<Integer> integers = integerList
                .stream()
                .filter(x -> Collections.frequency(integerList, x) > 1)
                .collect(Collectors.toSet());

        return integers;
    }

    public static void main(String[] args) {
        FindDuplicateIntegers find = new FindDuplicateIntegers();
        System.out.println(find.findDuplicateInetegers(1,2,3,4,5,1,2,3,4,5,7,8));
    }
}
