
package com.manisrini.domain.java8.lamdas.lamda.examples;



public class TestMani {
    
    public static void main(String[] args) {
        int[][] array2d = new int[3][2];
        int count = 0;
        System.out.println(array2d.length);
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                ++count;

            }
        }
        System.out.println(count);
    }
}
