package com.manisrini.domain._1_oops.polymorphism;

/**
 * 1. Weaker access modifier privilege is not allowed from parent to child.
 * For example, public method in parent same overridden protected method in child
 * 2. For the Exceptions, it's other way around
 * Weak exception is allowed from parent to child but not higher exception
 * For example, NullPointerException in parent RuntimeException in child is NOT allowed
 */
class Parentclass {

  /*public void final address()throws NullPointerException {

}*/
//  public void address() throws NullPointerException {
//
//  }

  /*protected void address()throws NullPointerException {

}*/
  public static void test() {
    System.out.println("This is parent class test method");
  }
}

public class Overridding extends Parentclass {

//  public void address() throws NullPointerException {
//
//  }

  /*protected void address() throws NullPointerException {

}*/
  public void address() throws NullPointerException {

  }

  public static void test() {
    System.out.println("This is Overridding class test method");
  }

  public static void main(String[] args) {
    Parentclass.test();
    Overridding.test();
  }

}
