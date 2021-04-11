package com.manisrini.domain._1_oops.oops.polymor;

class Par {

    //Overriding method return type is different. 
    Par getObject() {
        return this;
    }
}

public class Covariant extends Par {

    //Overriding method return type is different. 
    Covariant getObject() {
        return this;
    }

    public void message() {
        System.err.println("Example of Covariant return type");
    }

    public static void main(String[] args) {

        new Covariant().getObject().message();
    }

}
