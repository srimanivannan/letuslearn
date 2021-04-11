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
public class Test2 {
    public static void main(String[] args) {
        int i = -2,j=2;
        //for(;j>0;) {
        //for(;i++>0;) {
        //for(;++i>0;) {
         for(;i>0;) {
            i = ++i;
            j--;
        }
        System.out.println(i);
    }
   
}
