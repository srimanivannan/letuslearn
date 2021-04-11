package com.manisrini.domain.interview.myworkouts;

import java.util.LinkedList;
import java.util.List;

class Indices {
  public String s;
  public List<Integer> indices;

  public Indices(String s) {
    this.s = s;
    indices = new LinkedList<>();
    for (int i = 0; i < this.s.length() ; i++) {
      System.out.println(indices.add(i));
    }
  }
}
public class Mani {

  public static void main(String[] args) {
//    Stream.of(new Indices("Mercury"),new Indices("venu"),new Indices("ear"))
//        .flatMap(i -> i.indices.stream()).mapToInt(j -> j).max().ifPresent(s -> System.out.println(s));
    byte arr[] = new byte[] {2,3,4,5};
    for (final int i : get(arr)) {
      System.out.println(i + " ");
    }

  }
  static  char[] get(byte[] arr) {
    char[] carr = new char[4];
    int i =0;
    for (byte c : arr) {
      carr[i] = (char) c++;
      i++;
    }
    return carr;
  }
}
