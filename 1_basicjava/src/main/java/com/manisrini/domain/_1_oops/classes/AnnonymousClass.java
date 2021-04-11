package com.manisrini.domain._1_oops.classes;

abstract class Parent {

  public abstract void message();
}

interface Animal {

  public void message();
}

class Fruit {

  public void message() {
    System.err.println("This is regular annonymous class");
  }
}

public class AnnonymousClass {


  public static void main(String[] args) {

    Parent p = new Parent() {
      @Override
      public void message() {
        System.err.println("This is abstract annonymous");
      }
    };//semicolon is must

    p.message();//this executes message method because it is sitting in main method

    Animal obj = new Animal() {
      @Override
      public void message() {
        System.err.println("This is interface annonymous");
      }
    };//semicolon is must

    obj.message();//this executes message method because it is sitting in main method

    new Fruit() {}.message();//This is annonymous
    new Fruit().message();//This is regular

  }

}
