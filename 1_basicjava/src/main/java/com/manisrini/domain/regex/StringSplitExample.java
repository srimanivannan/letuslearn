package com.manisrini.domain.regex;

import java.util.Arrays;

public class StringSplitExample {

  public void example1(String input, String regex) {
    String[] split = input.split(regex);
    System.out.println(Arrays.toString(split));
  }

  public static void main(String[] args) {
    StringSplitExample splitExample = new StringSplitExample();
    splitExample.example1("dot1.dot2.dot3", "\\.");
    splitExample.example1("space1 space2 space3", " ");
  }
}
