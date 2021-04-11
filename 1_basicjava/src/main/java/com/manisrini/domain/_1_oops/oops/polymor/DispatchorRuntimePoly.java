package com.manisrini.domain._1_oops.oops.polymor;

class A {

    String data = "Aclass value";

    void callme() {
        System.out.println("Inside A's callme method");
    }
}

class B extends A {

    String data = "Bclass value";

    void callme() {
        System.out.println("Inside B's callme method");
    }
}

class C extends A {

    String data = "Cclass value";

    void callme() {
        System.out.println("Inside C's callme method");
    }
}

class DispatchorRuntimePoly {

    public static void main(String args[]) {

        //Upcasting
        A a = new A(); // object of type A
        B b = new B(); // object of type B
        C c = new C(); // object of type C

        A r; // obtain a reference of type A

        r = a; // r refers to an A object
        r.callme(); // calls A's version of callme
        System.out.println("data=>" + r.data);

        r = b; // r refers to a B object
        r.callme(); // calls B's version of callme
        System.out.println("data=>" + r.data);

        r = c; // r refers to a C object
        r.callme(); // calls C's version of callme
        System.out.println("data=>" + r.data);

        //Downcasting working
        A aobj = new C();
        C cobj = (C) aobj;
        System.out.println("Downcasting Method");
        cobj.callme(); // calls C's version of callme
        System.out.println("Downcasting data=>" + cobj.data);

        //Downcasting not working
        C test = (C) new A(); // object of type A downcasting to C
        System.out.println(test.getClass().getName());
        
        r.callme(); // java.lang.ClassCastException will be caught
        System.out.println("data=>" + r.data);

    }
}
