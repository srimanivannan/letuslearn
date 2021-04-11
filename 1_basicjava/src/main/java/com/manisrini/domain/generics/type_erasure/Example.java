package com.manisrini.domain.generics.type_erasure;

public class Example {

  //Compile the code and then use javap -c -p -s Sample to view the signature.

  public static <T> void use(T inst1, T inst2) {
    //Erased to use(Object, Object)
  }

  public static <T extends Comparable<T>> void foo(T inst1, T inst2) {
    //Erased to foo(Comparable, Comparable)

  }

  public static void main(String[] args) {

  }
}
