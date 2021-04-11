package com.manisrini.domain._2_threading.thread.communication;

public class ConsumerProducerTest implements Runnable {
	 
	 boolean isConsumer;
	 ConsumerProducer cp;
	 
	 public ConsumerProducerTest(boolean isConsumer, ConsumerProducer cp) {
	  this.isConsumer = isConsumer;
	  this.cp = cp;
	 }
	 public static void main(String[] args) {

	  ConsumerProducer cp = new ConsumerProducer(); //shared by both threads to communicate
	               
	  Thread producer = new Thread(new ConsumerProducerTest(false, cp));
	  Thread consumer = new Thread(new ConsumerProducerTest(true, cp));
	  System.err.println("producer start");
	  producer.start();
	  System.err.println("pconsumer start");
	  consumer.start();
	  System.err.println("no start");
	  System.err.println("some line...");
	 }
	 
	 @Override
	 public void run() {
		System.err.println("Run mothod excuted for=>"+Thread.currentThread().getName());
	  for (int i = 1; i <= 10; i++) {
	   if (!isConsumer) {
		   //System.err.println("mani");
	    cp.produce();
	   } else {
		  // System.err.println("suganthi");
	    cp.consume();
	   }
	  }
	   
	  //try with introducing a sleep for 100ms.
	 
	 }
	}