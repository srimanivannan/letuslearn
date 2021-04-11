package com.manisrini.domain._1_oops.polymorphism;

public class OverLoading1 {

    /*public void sum(int a,int b){
		System.err.println("sum(int a,int b) invoked");
	}
	public void sum(long a,long b){
		System.err.println("sum(long a,long b) invoked");
	}*/
    public void sum(int a, long b) {
        System.err.println("sum(int a,long b) invoked");
    }

    public void sum(long a, int b) {
        System.err.println("sum(long a,int b) invoked");
    }

    public static void main(String[] args) {

        OverLoading1 object = new OverLoading1();
        object.sum(10L, 20);
        object.sum(10, 20L);

    }

}
