/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manisrini.domain.java8.lamdas.lamda.examples;

/**
 *
 * @author dsh
 */
public class Test1 {
    
    public static void main(String[] args) {
        int temp=0;
        String [] table = {"dd","oo","pp"};
        do while(temp < table.length)
        System.out.print((temp++)+"");
        
        while(temp < table.length);
    }
}
