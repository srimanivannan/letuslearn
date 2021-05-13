package com.manisrini.domain.interview.myworkouts;

import java.util.stream.IntStream;

public class PalindromeString {

  public static void main(String[] args) {
    String temp = " MADAM \t";
    temp  = temp.replaceAll("\\s+", "").toLowerCase();
    System.out.println(temp);
    String finalTemp = temp;
    boolean b = IntStream.range(0, temp.length() / 2)
        .noneMatch(i -> finalTemp.charAt(i) != finalTemp.charAt(finalTemp.length() - i - 1));
    System.out.println(b);
  }
}
