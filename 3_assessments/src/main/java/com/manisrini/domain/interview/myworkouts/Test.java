package com.manisrini.domain.interview.myworkouts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test implements  Itest {

  @Override
  public String test() {
    return "hi";
  }

//  public static void main(String[] args) {
//    Set<String> set = new LinkedHashSet<>();
//    set.add("3");
//    set.add("1");
//    set.add("3");
//    set.add("2");
//    set.add("3");
//    set.add("1");
//    set.forEach(s -> System.out.print(s+"-"));
//  }

//  public static void main(String[] args) throws FileNotFoundException {
//    BufferedReader t = new BufferedReader(new FileReader("t"));
//    Integer x = 3;
//    Integer y = null;
//    try {
//      System.out.println(Integer.compareUnsigned(x,3) == 0 || Integer.compareUnsigned(y,3) == 0);
//    } catch (Exception ex) {
//      System.out.println(ex.getClass().toString());
//    }
//    try {
//      System.out.println(y.compareTo(null) == 0 || true);
//    } catch (Exception ex) {
//      System.out.println(ex.getClass().toString());
//    }
//  }
public static void main(String[] args) {
  BufferedReader t = null;
  try {
    t = new BufferedReader(new FileReader("t"));
    t.close();
  } catch (IOException e) {
    e.printStackTrace();
  }

}
}
