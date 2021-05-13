package com.manisrini.domain.interview.myworkouts;

import java.util.Deque;
import java.util.LinkedList;

public class DeQueueExample {

  public static void main(String[] args) {
    String sample = "kdjf(fgfg(aw)juh)jfhd(out)";
    String finalString = "";
    //Deque<String> d = new LinkedList<>();

    while (sample.indexOf("(") > 0) {
      int openCount = 0;
      int closeCount = 0;
      int firstPosition = 0;
      int lastPosition = 0;

      char[] charArray = sample.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
        char c = charArray[i];
        if (c == '(') {
          openCount = openCount + 1;
          if (openCount == 1) {
            firstPosition = i;
          }
        }
        if (c == ')') {
          closeCount = closeCount + 1;
          lastPosition = i;
        }
        if (closeCount > 0 && openCount == closeCount) {
          break;
        }
      }
      String replace = sample.substring(firstPosition + 1, lastPosition).replace("(", "")
          .replace(")", "");
      finalString = finalString.concat(new StringBuilder(replace).reverse().toString());
      //+ sample.substring(lastPosition);
      System.out.println(sample);
    }
  }
}
