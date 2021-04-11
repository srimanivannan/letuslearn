package com.manisrini.domain._1_oops.polymorphism;

/*
 * Constructors and polymorphism don't produce what you might expect
 */
abstract class Parent {

  abstract void birth();

  Parent() {
    System.out.println("Parent() before birth()");
    birth();
    System.out.println("Parent() after birth()");
  }

  public static void main(String[] args) {

  }
}

class Child extends Parent {

  private boolean isbirth = true;

  Child(boolean isbirth) {
    this.isbirth = isbirth;
    System.out.println("Child is born now");
    System.out.println("Child.Child(), isbirth = " + this.isbirth);
  }

  /**
   * This is false because, birth is being called from parent constructor though isbirth has been
   * initialized to true because child object is not yet created or initialized
   */
  @Override
  void birth() {
    System.out.println("Child.birth(), isbirth = " + isbirth);
  }
}

public class Initialize_Variable_Polymorphism {

  public static void main(String[] args) {
    new Child(true);
  }
}

//Output
/* Parent() before birth()
Child.birth(), isbirth = false
Parent() after birth()
Child is born now
Child.Child(), isbirth = true */