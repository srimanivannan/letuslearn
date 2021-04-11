package com.manisrini.domain.interview.assessments;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountDistinctWordsFromFile {

    public static void main(String[] args) {
        CountDistinctWordsFromFile co = new CountDistinctWordsFromFile();
        System.out.println(co.countNoOfDistinctWords("data.txt"));
        System.out.println(co.countNoOfWordsInEachLine("data.txt"));
    }

    private Map<Integer, Long> countNoOfWordsInEachLine(String fileName) {
        try {

            Stream<String> lineStream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()));
            List<String> listOfLines = lineStream.collect(Collectors.toList());

            Map<Integer, Long> integerLongMap = IntStream.range(0, listOfLines.size())
                    .boxed().collect(Collectors.toMap(i -> i+1,
                            i -> Arrays.stream(listOfLines.get(i).split(" ")).distinct().count()));


            return integerLongMap;

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    private Long countNoOfDistinctWords(String fileName) {
        try {
            Stream<String> lineStream =
                    Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()));

            Stream<String> stream = lineStream.flatMap(line -> Arrays.stream(line.split(" ")));

            List<String> wholeList = stream.collect(Collectors.toList());

            return wholeList
                    .stream()
                    .distinct()
                    .count();
                    //.collect(Collectors.toMap(x->x , x->Collections.frequency(wholeList, x)));

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
