package com.manisrini.domain.java8.streams;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manisrini.domain.User;
import com.manisrini.domain.UserData;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsExampleMethods implements UserData {

    public List<Integer> returnSquareRoot(List<Integer> numbers) {
        List<Integer> squareRootNumbers = numbers.stream().map(Math::sqrt).map(Double::intValue).collect(toList());
        System.out.println(squareRootNumbers);
        return squareRootNumbers;
    }

    public List<Integer> getAgeFromUsers(List<User> users) {
        List<Integer> usersAge = users.stream().map(User::getAge).collect(toList());
        System.out.println(usersAge);
        return usersAge;
    }

    public List<Integer> getDistinctAges(List<User> users) {
        List<Integer> usersAge = users.stream().map(User::getAge).distinct().collect(toList());
        System.out.println(usersAge);
        return usersAge;
    }

    public List<User> getLimitedUserList(List<User> users, int limit){
        List<User> collect = users.stream().limit(limit).collect(toList());
        System.out.println(String.format("Total Size of collection: %d and limit is %d", collect.size(), limit));
        System.out.println(collect);
        return collect;
    }

    public Integer countUsersOlderThenGivenAge(List<User> users, int givenAge) {
        long count = users.stream().map(User::getAge).filter(age -> age > givenAge).count();
        System.out.println(String.format("No of users grater than %d is %d", givenAge, count));
        // long to Integer
        // Long.valueOf(count).intValue();

        // another way to long to Integer
        return Math.toIntExact(count);
    }

    public List<String> mapToUpperCase(List<User> users) {
        List<String> collect = users.stream().map(User::getName).map(String::toUpperCase).collect(toList());
        System.out.println(collect);
        return collect;
    }

    public Integer sum(List<Integer> integers) {
        // Remember: sum method is in IntStream, so you would have to map integer.stream to IntStream

        // explicit boxing happens here. but not required. Method reference
        int sumMethod1 = integers.stream().mapToInt(Integer::intValue).sum();

        // explicit boxing happens here. but not required
        int sumMethodintval = integers.stream().mapToInt(it -> it.intValue()).sum();

        // boxing happens here
        int sumMethodautobox = integers.stream().mapToInt(it -> it).sum();

        Integer sumMethod2 = integers.stream().reduce(0, (a, b) -> a + b);
        Integer sumMethod3 = integers.stream().reduce(0, Math::addExact);

        return sumMethod3;
    }

    public void sortedFindFirstFilterIfpresent() {
        System.out.println("\n\n5. Stream.of, sorted and findFirst");
        // 5. Stream.of, sorted and findFirst
        Stream.of("Apple", "Amego", "Aathira", "Aaxrora").sorted().findFirst().ifPresent(System.out::println);

        System.out.println("\n\n6. Stream from Array, sort, filter and print");
        // 6. Stream from Array, sort, filter and print. same as Stream.of(names)
        String[] names = {"aathira", "Aathira", "Apple", "Orange", "ant", "Avacado"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("A")).sorted().forEach(System.out::println);
    }

    public void mapAverage() {
        System.out.println("\n\n7. average of squares of an int array");
        // 7. average of squares of an int array
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}).map(x -> x * 1).average().ifPresent(System.out::println);

        System.out.println("\n\n8. Stream from List, filter and print");
        // 8. Stream from List, filter and print
        List<String> people = Arrays.asList("aathira", "Aathira", "Apple", "Orange", "ant", "Avacado");
        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
    }

    public void filterCollectList() {
        System.out.println("\n\n9. filter CollectList");

        URL resource = getClass().getClassLoader().getResource("Jokes.json");
        ObjectMapper mapper = new ObjectMapper();
        try {

            List<LinkedHashMap<String, String>> myObjects =
                    mapper.readValue(resource, new TypeReference<List<LinkedHashMap<String, String>>>() {
                    });

            List<LinkedHashMap<String, String>> filteredJokesList = myObjects
                    .stream()
                    .filter(jokesMap -> jokesMap.get("type").equals("programming"))
                    .collect(toList());

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
                    mapper.readValue(resource, new TypeReference<List<LinkedHashMap<String, String>>>() {
                    });

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

    private void callAllMethods() {
        sortedFindFirstFilterIfpresent();
        mapAverage();
        filterCollectList();
        filterCollectMap();
        reduction();
        returnSquareRoot(Arrays.asList(16, 9, 25)); // results should be 4, 3, 5
        getAgeFromUsers(buildUser());
        getDistinctAges(buildUser());
        getLimitedUserList(buildUser(), 5);
        countUsersOlderThenGivenAge(buildUser(), 25);
        mapToUpperCase(buildUser());
    }

    public static void main(String[] args) {
        StreamsExampleMethods streamsExampleMethods = new StreamsExampleMethods();
        streamsExampleMethods.callAllMethods();
    }
}
