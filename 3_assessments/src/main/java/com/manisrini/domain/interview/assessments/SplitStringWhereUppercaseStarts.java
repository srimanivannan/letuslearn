package com.manisrini.domain.interview.assessments;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SplitStringWhereUppercaseStarts {

  public String split(String input) {
    System.out.println(Instant.now());
    System.out.println(ZonedDateTime.now());
    String[] r = input.split("(?=\\p{Upper})");
    //return Arrays.stream(input.split("\\p{Upper}")).collect(Collectors.joining(" "));
    return Arrays.stream(r).map(it -> it + " ").collect(Collectors.joining());
  }

  public static void main(String[] args) {
    SplitStringWhereUppercaseStarts s = new SplitStringWhereUppercaseStarts();
    System.out.println(s.split("MyNameIsMani.HowAreYouDoing?"));
  }
}
