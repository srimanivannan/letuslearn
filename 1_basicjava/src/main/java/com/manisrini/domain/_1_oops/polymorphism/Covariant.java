package com.manisrini.domain._1_oops.polymorphism;

class Par {

    //Overriding method return type is different. 
    Par getObject() {
        return this;
    }
}

public class Covariant extends Par {

    //Overriding method return type is different. This is called Covariant return type
    Covariant getObject() {
        return this;
    }

    public void message() {
        System.err.println("Example of Covariant return type:" + this.getClass().getSimpleName());
    }

    public static void main(String[] args) {

        new Covariant().getObject().message();
    }

}
