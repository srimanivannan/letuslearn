package com.manisrini.domain._2_threading.thread;

public class CalculatePrimes extends Thread {
	
public static final int MAX_PRIMES = 10;
public static final int TEN_SECONDS = 10;
public boolean finished = false;
public volatile int testvalue=500;
public void run() {
		testvalue=3333;
		for (int i=0; i<MAX_PRIMES; i++) {
			
		// Check to see if the timer has expired
			//if (finished) {
				//break;
			//}
			//System.err.println("i Value=>"+i);
			System.err.println("testvalue=>"+testvalue);
		}
}
public static void main(String[] args) {
			CalculatePrimes calculator = new CalculatePrimes();
			calculator.start();
			//try {
			//Thread.sleep(TEN_SECONDS);
			//}
			//catch (InterruptedException e) {
			// fall through
			//}
			calculator.finished = true;
			calculator.testvalue=888;
			System.err.println("Mani=>"+calculator.testvalue);
}
}