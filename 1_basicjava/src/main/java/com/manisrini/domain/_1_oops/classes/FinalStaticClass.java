package com.manisrini.domain._1_oops.classes;

public class FinalStaticClass {

  //if it is static class then method must be static
  //then only you can access a method from outside
  final static class InnerClass {

    public static void InnerMethod() {
      System.out.println("Final Static Inner Class!");
    }
  }

  public static void main(String[] args) {
    InnerClass.InnerMethod(); // if you call only from this class
    FinalStaticClass.InnerClass.InnerMethod(); // if you wanna call from ouside from this class
  }

}
