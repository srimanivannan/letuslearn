package com.manisrini.domain._1_oops.polymorphism;

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

class DynamicMethodDispatchorRuntimePolymorphism {

    public static void main(String args[]) {

        //Upcasting
        A a = new A(); // object of type A
        System.out.println("data=>" + a.data); // it prints respective class data

        B b = new B(); // object of type B
        System.out.println("data=>" + b.data); // it prints respective class data

        C c = new C(); // object of type C
        System.out.println("data=>" + c.data); // it prints respective class data


        A r; // obtain a reference of type A

        r = a; // r refers to an A object
        r.callme(); // calls A's version of callme
        System.out.println("data=>" + r.data); // prints A's value

        r = b; // r refers to a B object
        r.callme(); // calls B's version of callme
        System.out.println("data=>" + r.data); // prints A's value

        r = c; // r refers to a C object
        r.callme(); // calls C's version of callme
        System.out.println("data=>" + r.data); // prints A's value

        //Downcasting working
        A aobj = new C();
        C cobj = (C) aobj;
        System.out.println("Downcasting Method");
        cobj.callme(); // calls C's version of callme
        System.out.println("Downcasting data=>" + cobj.data); // prints C's value

        //Downcasting not working
        C test = (C) new A(); // object of type A downcasting to C
        System.out.println("Class Name:" + test.getClass().getSimpleName());
        
        r.callme(); // java.lang.ClassCastException will be caught
        System.out.println("data=>" + r.data);

    }
}
