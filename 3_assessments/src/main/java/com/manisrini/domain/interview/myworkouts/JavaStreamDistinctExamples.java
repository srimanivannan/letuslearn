package com.manisrini.domain.interview.myworkouts;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.manisrini.domain.Person;

public class JavaStreamDistinctExamples {

  public static void main(String[] args) {
    JavaStreamDistinctExamples examples = new JavaStreamDistinctExamples();
    examples.removeduplicate();
  }

  private void removeduplicate() {
    Person lokesh = new Person(1L, "Lokesh", "Gupta");
    Person brian = new Person(2L, "Brian", "Clooney");
    Person alex = new Person(3L, "Alex", "Kolen");

    //Add some random persons
    Collection<Person> list = Arrays.asList(lokesh, brian, alex, lokesh, brian, lokesh);

    // Get distinct objects by key
    List<Person> distinctElements = list.stream()
        .filter(getPersonPredicate())
        .collect(Collectors.toList());

    // Let's verify distinct elements
    System.out.println(distinctElements);
  }

  private Predicate<Person> getPersonPredicate() {
    Map<Long, Boolean> instanceMap = new ConcurrentHashMap<>(); // This is kind of closure in java
    // consider two functions here. the above declaration is out side
    // the return is inner function and it's accessing outside instanceMap
    System.out.println(instanceMap);
    return p -> {
      System.out.println("instanceMap:" + instanceMap.size());
      System.out.println("id:" + p.getId());
      return instanceMap.putIfAbsent(p.getId(), true) == null;
    };
  }


  //
//  //Utility function
  private <T> Predicate<T> distinctByKey(Function<T, Long> key) {
    Map<Long, Boolean> map = new ConcurrentHashMap<>();
    System.out.println("map size:" + map.size());
    return t -> map.putIfAbsent(key.apply(t), true) == null;
  }
}