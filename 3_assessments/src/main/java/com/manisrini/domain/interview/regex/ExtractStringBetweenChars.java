package com.manisrini.domain.interview.regex;

import java.util.LinkedList;
import java.util.List;

public class ExtractStringBetweenChars {

  public static void main(String[] args) {

    List<String> values = new LinkedList<>();
    String s = "test (test(a b(cd)ef)kk) string (67) (78) (as(fg)ht)ghg";
    int start = 0;
    int open = 0;
    int close = 0;

    for (int i = 0; i < s.toCharArray().length; i++) {

      if (s.charAt(i) == '(') {
        open = open + 1;
      }

      if (s.charAt(i) == ')') {
        close = close + 1;
      }

      if (close > 0 && open == close) {
        values.add(s.substring(start, i+1));
        start = i+1;
        close=0;
        open=0;
      }

    }
    values.add(s.substring(start));
    String s1 = values.get(0);
    System.out.println(s1);
    String substring = s1.substring(s1.indexOf("(") + 1);
    StringBuilder builder = new StringBuilder(substring);
    String output = builder.reverse().toString().replace("(", "").replace(")", "");
    System.out.println(substring);
    System.out.println(output);
    System.out.println(s1.replace(s1.substring(s1.indexOf("(")), output));
  }
}
