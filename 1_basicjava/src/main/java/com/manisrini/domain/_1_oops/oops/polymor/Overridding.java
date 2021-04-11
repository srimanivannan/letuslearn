package com.manisrini.domain._1_oops.oops.polymor;

class Parentclass {

    /*public void final address()throws NullPointerException {

	}*/
    public void address() throws Exception {

    }

    /*protected void address()throws NullPointerException {

	}*/
    public static void test() {

    }
}

public class Overridding extends Parentclass {

    public void address() throws NullPointerException {

    }

    /*protected void address() throws NullPointerException {
		
	}*/
 /*public void address() throws NullPointerException {
		
	}*/
    public static void test() {

    }

    public static void main(String[] args) {
        Overridding.test();
        Parentclass.test();
    }

}
