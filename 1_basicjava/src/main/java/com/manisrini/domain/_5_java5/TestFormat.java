package com.manisrini.domain._5_java5;

import java.util.Date;

public class TestFormat {
	public static void main(String[] args) {
		double balance = 12345678.56;
		System.out.format("Balanceis $%,1.5f",balance);
		Date today = new Date();
		System.out.format("\nToday is %TF %TT", today,today);
	}
}
