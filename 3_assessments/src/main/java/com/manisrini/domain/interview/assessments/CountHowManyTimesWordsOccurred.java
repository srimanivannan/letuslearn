package com.manisrini.domain.interview.assessments;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountHowManyTimesWordsOccurred {

    public Map<String, Integer> countWordsWithDistinct() {

        Map<String, Integer> words = new HashMap<>();

        String test = "one one two two three four five five five";
        List<String> stringList = Arrays.stream(test.split(" "))
                .collect(Collectors.toList());

        return stringList.stream()
                .distinct()
                .collect(Collectors.toMap(x -> x, x -> Collections.frequency(stringList, x)));

    }

    public Map<String, Integer> countWordsWithMergeNoDistinct() {

        Map<String, Integer> words = new HashMap<>();

        String test = "one one two two three four five five five";
        List<String> stringList = Arrays.stream(test.split(" "))
                .collect(Collectors.toList());

        return stringList.stream()
                .collect(Collectors.toMap(x -> x, x -> Collections.frequency(stringList, x), (x1,x2)->x1));

    }

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("bla", "blabla", "blablabla", "bla");
        Map<Integer, String> map = stringStream.distinct()
                .collect(Collectors.toMap(String::length, Function.identity()));
        System.out.println(map);

        CountHowManyTimesWordsOccurred c = new CountHowManyTimesWordsOccurred();
        System.out.println(c.countWordsWithDistinct());

        System.out.println(c.countWordsWithMergeNoDistinct());
    }
}
