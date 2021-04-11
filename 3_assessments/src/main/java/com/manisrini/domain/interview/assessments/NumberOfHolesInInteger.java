package com.manisrini.domain.interview.assessments;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

/**
 * This class would count number of holes in integer number.
 * When we say hole means, literally holes(o)
 */
public class NumberOfHolesInInteger {

    public Integer calculateHoles(Integer val) {
        int noOfHoles = 0;
        while (val > 0) {
            int d = val % 10;
            noOfHoles = noOfHoles + Holes.lookupNoOfHoles(d);
            val = val / 10;
        }
        return noOfHoles;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your number");
        String inputNumber = scanner.next();
        //String expectedValue = scanner.next();
        NumberOfHolesInInteger num = new NumberOfHolesInInteger();
        Integer actualValue = num.calculateHoles(Integer.parseInt(inputNumber));
        System.out.format("No of holes in the given number %s is %d", inputNumber, actualValue);
        scanner.close();
    }
}

enum Holes {

    ZERO(0, 1),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 0),
    FOUR(4, 1),
    FIVE(5, 0),
    SIX(6, 1),
    SEVEN(7, 0),
    EIGHT(8, 2),
    NINE(9, 1);

    private int digitValue;
    private int noOfHoles;

    Holes(int digitValue, int noOfHoles) {
        this.digitValue = digitValue;
        this.noOfHoles = noOfHoles;
    }

    public int getDigitValue() {
        return digitValue;
    }

    public int getNoOfHoles() {
        return noOfHoles;
    }

    public static int lookupNoOfHoles(int val) {
        for (Holes holes : values()) {
            if (holes.getDigitValue() == val) {
                return holes.getNoOfHoles();
            }
        }
        return 0;
    }
}