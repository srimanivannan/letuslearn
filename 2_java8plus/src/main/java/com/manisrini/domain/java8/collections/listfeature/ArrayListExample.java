package com.manisrini.domain.java8.collections.listfeature;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.manisrini.domain.Gender;
import com.manisrini.domain.Person;

public class ArrayListExample {

  private double calculateSumOfSalaryForPersonAgeGreaterThan(int age) {
    return getPeople().stream().filter(byAge(age)).mapToDouble(Person::getSalary).sum();
  }

  private Person getMaxAgePerson() {
    return getPeople().stream()
        .max(Comparator.comparing(Person::getAge) // Here max Age is pulled
            .thenComparing(Person::getSalary, Comparator.reverseOrder())) // Here min salary is pulled
        .orElse(null);
  }

  private Person getMinSalaryPerson() {
    return getPeople().stream()
        .min(Comparator.comparing(Person::getSalary) // Here min salary is pulled
            .thenComparing(Person::getDateOfBirth)) // Here old DateOfBirth is pulled
        .orElse(null);
  }

  private List<Person> getPeople() {
    return Arrays.asList(
        new Person(1L, "mani", "srini", 1000.00, Gender.MALE, LocalDate.parse("1984-03-10")),
        new Person(2L, "aarna", "mani", 1.00, Gender.FEMALE, LocalDate.parse("2020-05-30")),
        new Person(3L, "aathira", "mani", 1.00, Gender.FEMALE, LocalDate.parse("2015-07-01")),
        new Person(4L, "atharva", "mani", 1.00, Gender.MALE, LocalDate.parse("2020-05-30")),
        new Person(5L, "suganthi", "mani", 2000.00, Gender.FEMALE, LocalDate.parse("1986-07-01")),
        new Person(6L, "viji", "srini", 1500.00, Gender.FEMALE, LocalDate.parse("1987-07-01")),
        new Person(7L, "aravinth", "vijaya", 4000.00, Gender.MALE, LocalDate.parse("1984-03-10")));
  }

  private Predicate<Person> byAge(int age) {
    return person -> person.getAge() > age;
  }

  public static void main(String[] args) {
    ArrayListExample arrayListExample = new ArrayListExample();
    System.out.println(arrayListExample.calculateSumOfSalaryForPersonAgeGreaterThan(2));
    System.out.println(arrayListExample.getMaxAgePerson());
    System.out.println(arrayListExample.getMinSalaryPerson());
  }
}
