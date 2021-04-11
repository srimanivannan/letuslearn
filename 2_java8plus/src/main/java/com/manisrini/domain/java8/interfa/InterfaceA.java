package com.manisrini.domain.java8.interfa;

public interface InterfaceA {

  default String getValue() {
    return "Hello from InterfaceA";
  }
}
