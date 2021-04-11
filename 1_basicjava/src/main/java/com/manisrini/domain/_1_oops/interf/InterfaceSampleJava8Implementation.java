package com.manisrini.domain._1_oops.interf;

public class InterfaceSampleJava8Implementation implements InterfaceSampleJava8 {

  public static void main(String[] args) {
    System.out.println(InterfaceSampleJava8.minus(12, 3));
    new InterfaceSampleJava8Implementation().testDefaultMethod(12, 12);
  }

  private void testDefaultMethod(int number1, int number2) {
    System.out.println(defaultMethod(number1, number2));
  }
}
