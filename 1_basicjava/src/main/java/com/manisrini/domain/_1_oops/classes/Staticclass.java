package com.manisrini.domain._1_oops.classes;

public class Staticclass {

  //Only inner class can be declared as static
  static class InnerClass {

    public static void InnerMethod() {
      System.out.println("Static Inner Class!");
    }
  }

  public static void main(String[] args) {
    InnerClass.InnerMethod();
  }

}
