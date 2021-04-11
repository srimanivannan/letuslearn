package com.manisrini.domain.java8.vavr;

import java.io.FileInputStream;

import io.vavr.control.Try;

public class TryClassTest {

  public void test() {

    Try<String> of = Try
        .withResources(() -> new FileInputStream("sd"), () -> new FileInputStream("rt"))
        .of((it1, it2) -> {
          return "sd";
        });

  }

  public static void main(String[] args) {

  }

}
