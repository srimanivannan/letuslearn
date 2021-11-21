package com.manisrini.domain.java9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.Cleaner;

public class CleanerExample {

  static Cleaner cleaner;

  public static void main(String[] args) throws Exception {

    System.out.println("main on thread: " + Thread.currentThread().getId());

    cleaner = Cleaner.create();

    Person p1 = new Person(1);

    p1 = null;
    System.gc();

    try (Person p2 = new Person(2)) {

    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Press any key to continue");
    br.readLine();
  }
}

class Person implements AutoCloseable {

  private final Cleaner.Cleanable cleanable;
  private int id;
  private final State state;

  public Person(int id) {
    this.id = id;
    state = new State(id);
    cleanable = CleanerExample.cleaner.register(this, state);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public void close() throws Exception {
    System.err.println("close method before clean");
    cleanable.clean();
    System.err.println("close method after clean");
  }

  static class State implements Runnable {

    private final int id;

    State(int id) {
      this.id = id;
    }

    @Override
    public void run() {
      Thread.currentThread().setName("State id " + id + "run method");
      String format = String.format("Cleanup State: %d on thread id: %d and name: %s", id,
          Thread.currentThread().getId(), Thread.currentThread().getName());
      System.out.println(format);
    }
  }
}