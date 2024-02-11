package com.manisrini.domain.interview.assessments;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramsExample {

    public Map<Character, Integer> buildCharAndFrequency(String input) {

        Set<char[]> chars = Stream.of(input.toCharArray()).collect(Collectors.toSet());

        //input.chars()
        return null;
    }

    public static void main(String[] args) {

        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('c', 1);
        map1.put('x', 2);

        Map<Character, Integer> map2 = new HashMap<>();

        map2.put('c', 1);
        map2.put('x', 2);

        System.out.println(map1.equals(map2));
    }
}
