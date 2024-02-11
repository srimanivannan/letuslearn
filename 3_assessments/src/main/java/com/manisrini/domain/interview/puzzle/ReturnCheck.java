package com.manisrini.domain.interview.puzzle;

public class ReturnCheck {

    // i as instance variable
    // private int i = 1;

    public int test() {
        // i as local variable
        int i = 1;
        try {
            return i;
        } finally {
            i = 2;
            return i;
        }
    }

    public static void main(String[] args) {
        // Both returns same result
        ReturnCheck obj = new ReturnCheck();
        System.out.println(obj.test());
    }
}
