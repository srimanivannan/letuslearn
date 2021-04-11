package com.manisrini.domain.java8.interfa;

public interface InterfaceB {

  default String getValue() {
    return "Hello from InterfaceB";
  }
}
