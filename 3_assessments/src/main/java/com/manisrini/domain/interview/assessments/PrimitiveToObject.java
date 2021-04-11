package com.manisrini.domain.interview.assessments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveToObject {

    private void primitiveToWrapperObect() {

        // int ot Integer
        int number = 10;
        Integer value = Integer.valueOf(number);
        // int ot Integer

        // char ot Character
        char xchar = 'B';
        Character.valueOf(xchar);
        // char ot Character

        float fval = 1.2f;
        Float.valueOf(fval);

        double dval = 5.789;
        Double.valueOf(dval);

        byte bval = 34;
        Byte.valueOf(bval);

        short sval = 1;
        Short.valueOf(sval);

        boolean boval = true;
        Boolean.valueOf(boval);

        long lval = 45845;
        Long.valueOf(lval);

    }

    private void primitiveArrayList() {
        int number[] = {63,2234,66,23,5943,612,742,83,9287,1120};
        int number1[] = {1864,2123,3945,462,5123};

        List<int[]> asList = Arrays.asList(number, number1);

        for (int[] a : asList) { // This is arraylist loop

            for (int numVal: a) { // This is int array loop. Style is foreach style
                System.out.print(numVal);
            }

            System.out.println();

            for (int index = 0; index < a.length; index++ ) { // This is int array loop. Style is regular forloop
                System.out.print(a[index]);
            }
            System.out.println();
        }

        char charArray[] = {'a','b','c','d','e'};
        List<char[]> charList = Arrays.asList(charArray);

        for (char[] ac: charList) { // This is char list loop

            for(char cha: ac) { // This is char array loop
                System.out.print(cha);
            }
        }

    }

    private void primitiveArrayToWrapperArray() {


        int intval[] = {1,2,3,4,5};

        IntStream intStream1 = IntStream.of(intval);
        Stream<Integer> streamInteger1 = intStream1.boxed();
        streamInteger1.forEach(System.out::print);


        IntStream intStream2 = Arrays.stream(intval);
        intStream2.boxed();

    }

    public static void main(String[] args) {
        PrimitiveToObject obj = new PrimitiveToObject();
        //obj.primitiveArrayList();
        obj.primitiveArrayToWrapperArray();
    }
}
