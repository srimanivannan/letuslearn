package com.manisrini.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public interface RandomData {
    default List<Integer> generateRandomIntegersList(int start, int end) {
        //Other way
/*        return new Random().ints(start, end)
                .boxed()
                .collect(Collectors.toList()); */
        return new Random().ints(start, end)
                .mapToObj(intVal -> Integer.valueOf(intVal))
                .collect(Collectors.toList());
    }
}
