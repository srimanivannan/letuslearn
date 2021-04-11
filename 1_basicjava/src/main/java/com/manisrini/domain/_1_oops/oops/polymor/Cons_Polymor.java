package com.manisrini.domain._1_oops.oops.polymor;

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

    public static void main(String args[]) {

    }
}

class Child extends Parent {

    private boolean isbirth = true;

    Child(boolean bir) {
        isbirth = bir;
        System.out.println("Child is born now");
        System.out.println("Child.Child(), isbirth = " + isbirth);
    }

    void birth() {
        System.out.println("Child.birth(), isbirth = " + isbirth);
    }
}

public class Cons_Polymor {

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