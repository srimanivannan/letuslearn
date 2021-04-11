package com.manisrini.domain.interview.myworkouts;

public class IkmTest {
private int data;
  public IkmTest() {
    this(10);
    //super();
  }
  public IkmTest(int data) {
    this.data = data;
  }
  public void display() {
    //super();
    class Decrementer {
      public void decrement() {
        data --;
      }
    }
    Decrementer d = new Decrementer();
        d.decrement();;
    System.out.println("data="+data);
  }

  public static void main(String[] args) {
    int data = 0;
    IkmTest t = new IkmTest();
    t.display();
    System.out.println("data="+data);
  }
}
