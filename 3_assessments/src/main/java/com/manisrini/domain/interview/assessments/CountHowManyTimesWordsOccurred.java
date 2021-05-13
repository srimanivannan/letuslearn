package com.manisrini.domain.interview.assessments;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountHowManyTimesWordsOccurred {

    public Map<String, Integer> countWordsWithDistinct() {

        String test = "one one two two three four five five five";
        List<String> stringList = Arrays.stream(test.split(" "))
                .collect(Collectors.toList());

        return stringList.stream()
                .distinct()
                .collect(Collectors.toMap(x -> x, x -> Collections.frequency(stringList, x)));

    }
    public Map<String, Long> countWordsWithGroupingBy() {

        String test = "one one two two three four five five five";
        return Arrays.stream(test.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    public Map<String, Integer> countWordsWithMergeNoDistinct() {

        String test = "one one two two three four five five five";
        List<String> stringList = Arrays.stream(test.split(" "))
                .collect(Collectors.toList());

        return stringList.stream()
                .collect(Collectors.toMap(Function.identity(), x -> Collections.frequency(stringList, x), (x1,x2)->x1));

    }

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("bla", "blabla", "blablabla", "bla");
        Map<String, Integer> map = stringStream.distinct()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);

        CountHowManyTimesWordsOccurred c = new CountHowManyTimesWordsOccurred();
        System.out.println("Distinct:" + c.countWordsWithDistinct());
        System.out.println("MergeNoDistinct:" + c.countWordsWithMergeNoDistinct());
        System.out.println("GroupingBy:" + c.countWordsWithGroupingBy());
    }
}
