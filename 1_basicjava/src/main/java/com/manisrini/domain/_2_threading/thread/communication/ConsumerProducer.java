package com.manisrini.domain._2_threading.thread.communication;

public class ConsumerProducer {
	 
	private int count;
	
	 public synchronized void consume() {
	  while (count == 0) {  // keep waiting if nothing is produced to consume
	   try {
		  // System.err.println("consumer is waiting");
	    wait(); // give up lock and wait
	   } catch (InterruptedException e) {
		   System.err.println("exception");
	    // keep trying
	   }
	  }
	  count--; // consume
	  System.out.println(Thread.currentThread().getName() + " after consuming " + count);
	 }
	 
	 public synchronized void produce() {
	  count++;             //produce
	  System.err.println(Thread.currentThread().getName() + " after producing " + count);
	  notifyAll();         // notify waiting threads to resume
	 }
	}