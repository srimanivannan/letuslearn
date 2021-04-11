package com.manisrini.domain.interview.assessments;

public class FloatingNumberToInteger {

    private static final String CONSTRAINT_REGEX = "^[0-9]{1,7}.[0-9]{1,8}$";

    public Integer addNumbers(double numberA, double numberB) {

        validateConstrains(numberA, numberB);

        return Integer.valueOf((int) Math.floor(numberA + numberB));
    }

    private void validateConstrains(double numberA, double numberB) {

        if (!String.valueOf(numberA).matches(CONSTRAINT_REGEX) || !String.valueOf(numberB).matches(CONSTRAINT_REGEX)) {
            throw new IllegalArgumentException(String.format("number must in the pattern %s", CONSTRAINT_REGEX));
        }

        if (numberA < 0.1 || numberB < 0.1) {
            throw new IllegalArgumentException(String.format("cannot be lesser than %s", "0.1"));
        }
    }

    public static void main(String[] args) {
        FloatingNumberToInteger fti = new FloatingNumberToInteger();
        Integer addedNumbers = fti.addNumbers(3.12345678, 0.9);
        System.out.println("Result:" + addedNumbers);
    }
}
