package com.manisrini.domain.java8.streams;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StreamsExampleMethods {

    public void sortedFindFirstFilterIfpresent() {
        System.out.println("\n\n5. Stream.of, sorted and findFirst");
        // 5. Stream.of, sorted and findFirst
        Stream.of("Apple", "Amego", "Aathira", "Aaxrora").sorted().findFirst().ifPresent(System.out::println);

        System.out.println("\n\n6. Stream from Array, sort, filter and print");
        // 6. Stream from Array, sort, filter and print. same as Stream.of(names)
        String[] names = { "aathira", "Aathira", "Apple", "Orange", "ant", "Avacado" };
        Arrays.stream(names)
                .filter(x -> x.startsWith("A")).sorted().forEach(System.out::println);
    }

    public void mapAverage() {
        System.out.println("\n\n7. average of squares of an int array");
        // 7. average of squares of an int array
        Arrays.stream(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }).map(x -> x * 1).average().ifPresent(System.out::println);

        System.out.println("\n\n8. Stream from List, filter and print");
        // 8. Stream from List, filter and print
        List<String> people = Arrays.asList( "aathira", "Aathira", "Apple", "Orange", "ant", "Avacado" );
        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
    }

    public void filterCollectList() {
        System.out.println("\n\n9. filter CollectList");

        URL resource = getClass().getClassLoader().getResource("Jokes.json");
        ObjectMapper mapper = new ObjectMapper();
        try {

            List<LinkedHashMap<String, String>> myObjects =
                    mapper.readValue(resource, new TypeReference<List<LinkedHashMap<String, String>>>(){});

            List<LinkedHashMap<String,String>> filteredJokesList = myObjects
                    .stream()
                    .filter(jokesMap -> jokesMap.get("type").equals("programming"))
                    .collect(Collectors.toList());

            System.out.println(filteredJokesList.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterCollectMap() {
        System.out.println("\n\n10. filter CollectList");

        URL resource = getClass().getClassLoader().getResource("Jokes.json");
        ObjectMapper mapper = new ObjectMapper();
        try {

            List<LinkedHashMap<String, String>> myObjects =
                    mapper.readValue(resource, new TypeReference<List<LinkedHashMap<String, String>>>(){});

            Map<String, String> collect = myObjects
                    .stream()
                    .filter(jokesMap -> jokesMap.get("type").equals("computer"))
                    .collect(Collectors.toMap(x -> x.get("id"), x -> x.get("punchline")));

            System.out.println(collect.get("21"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reduction() {
        System.out.println("\n\n11. Reduction - sum");

        // 11. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        System.out.println("\n\n12. Reduction - summary statistics");
        // 12. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);
    }

    public static void main(String[] args) {
        StreamsExampleMethods example1 = new StreamsExampleMethods();
		/*example1.integerStream();
		example1.sortedFindFirstFilterIfpresent();
		example1.mapAverage();
		example1.filterCollectList();
		example1.filterCollectMap();*/
        example1.reduction();
    }
}
