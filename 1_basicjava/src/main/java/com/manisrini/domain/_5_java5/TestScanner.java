package com.manisrini.domain._5_java5;

import java.util.Scanner;

public class TestScanner {

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number:");
		int val = in.nextInt();
		System.out.println("val="+val);
		in.close();
	}

}
