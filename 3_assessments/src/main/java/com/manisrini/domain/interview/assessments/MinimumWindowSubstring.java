package com.manisrini.domain.interview.assessments;

import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

  private String minWindow(String givenInput, String toBeSearched) {
    //HashMap<Character, Integer> goal = new HashMap<>();
    int goalSize = toBeSearched.length();
    int minLen = Integer.MAX_VALUE;
    String result = "";
//target dictionary
//    for (int k = 0; k < toBeSearched.length(); k++) {
//      goal.put(toBeSearched.charAt(k), goal.getOrDefault(toBeSearched.charAt(k), 0) + 1);
//    }

    ConcurrentMap<Character, Long> toBeSearchedAsMap = toBeSearched.codePoints().mapToObj(c -> (char) c)
        .collect(Collectors.groupingByConcurrent(c -> c, Collectors.counting()));
    System.out.println("toBeSearchedAsMap:" + toBeSearchedAsMap);
    int i = 0;
    int total = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int j = 0; j < givenInput.length(); j++) {
      char c = givenInput.charAt(j);
      if (!toBeSearchedAsMap.containsKey(c)) {
        continue;
      }
//if c is a target character in the goal, and count is < goal, increase the total
      int count = map.getOrDefault(c, 0);
      if (count < toBeSearchedAsMap.get(c)) {
        total++;
      }
      map.put(c, count + 1);
//when total reaches the goal, trim from left until no more chars can be trimmed.
      if (total == goalSize) {
        while (!toBeSearchedAsMap.containsKey(givenInput.charAt(i)) || map.get(givenInput.charAt(i)) > toBeSearchedAsMap.get(givenInput.charAt(i))) {
          char pc = givenInput.charAt(i);
          if (toBeSearchedAsMap.containsKey(pc) && map.get(pc) > toBeSearchedAsMap.get(pc)) {
            map.put(pc, map.get(pc) - 1);
          }
          i++;
        }
        if (minLen > j - i + 1) {
          minLen = j - i + 1;
          result = givenInput.substring(i, j + 1);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    MinimumWindowSubstring windowSubstring = new MinimumWindowSubstring();
    System.out.println(windowSubstring.minWindow("ADOBECODEBANC", "ABCA"));
    System.out.println(windowSubstring.minWindow("ADOBECODEBANYYYYYYC", "AB"));
  }
}
