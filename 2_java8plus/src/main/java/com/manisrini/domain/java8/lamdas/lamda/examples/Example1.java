/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manisrini.domain.java8.lamdas.lamda.examples;

import com.manisrini.domain.java8.lamdas.lamda.functionalInterfaces.Sorting;
import java.util.Arrays;

/**
 *
 * @author dsh
 */
public class Example1 {
    
    public int[] pleaseSort(Sorting sorting, int[] inputs) {
        return sorting.bubbleSort(inputs);
    }
    
    public static void main(String args[]) {
        int [] inputNumbers = {5,2,7,1,8,9};
        Example1 example1 = new Example1();
        System.out.println(Arrays.toString(example1.pleaseSort(doSorting(), inputNumbers)));
    }

    private static Sorting doSorting() {
        Sorting bubbleSorting = (int[] numbersToBeSorted) -> {
            int n = numbersToBeSorted.length;
            int temp = 0;
            for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                    
                    if(numbersToBeSorted[j-1] > numbersToBeSorted[j]){
                        //swap the elements!
                        temp = numbersToBeSorted[j-1];
                        numbersToBeSorted[j-1] = numbersToBeSorted[j];
                        numbersToBeSorted[j] = temp;
                    }
                }
            }
            
            return numbersToBeSorted;
        };
        return bubbleSorting;
    }
    
}
