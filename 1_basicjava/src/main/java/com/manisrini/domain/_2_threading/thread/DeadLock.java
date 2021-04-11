package com.manisrini.domain._2_threading.thread;

public class DeadLock {
	  public static void main(String[] args){
	    
		  //These are the two resource objects 
	    //we'll try to get locks for
	    final Object resource1 = "Gas Stove";
	    final Object resource2 = "Milk Vesel";
	    
	    //Here's the first thread.It tries to lock resource1 then resource2
	    Thread t1 = new Thread() {
	      public void run() {
	        //Lock resource 1
	        synchronized(resource1){
	          System.out.println("Mani: locked Gas Stove");
	          //Pause for a bit, simulating some file I/O or 
	          //something. Basically, we just want to give the 
	          //other thread a chance to run. Threads and deadlock
	          //are asynchronous things, but we're trying to force 
	          //deadlock to happen here...
	          try{ 
	            Thread.sleep(50); 
	          } catch (InterruptedException e) {}
		        //Now wait 'till we can get a lock on resource 2
		        synchronized(resource2){
		            System.out.println("Mani: locked Milk Vesel");
		        }	          
	        }

	        System.out.println("Mani has finished");
	      }
	      
	    };
		 //Here's the second thread.It tries to lock resource2 then resource1
	    Thread t2 = new Thread(){
	      public void run(){
	        //This thread locks resource 2 right away
	        synchronized(resource2){
	          System.out.println("Suganthi: locked Milk Vesel");
	          //Then it pauses, for the same reason as the first 
	          //thread does
	          try{
	    		Thread.sleep(50); 
	    	  } catch (InterruptedException e){}

	          //Then it tries to lock resource1.  
	          //But wait!  Thread 1 locked resource1, and 
	          //won't release it till it gets a lock on resource2.  
	          //This thread holds the lock on resource2, and won't
	          //release it till it gets resource1.  
	          //We're at an impasse. Neither thread can run, 
	          //and the program freezes up.
		        synchronized(resource1){
		        	System.out.println("Suganthi: locked Gas Stove");
		        }	          
	        }
	        System.out.println("Suganthi has finished");
	      }
	    };
	    //Start the two threads. 
	    //If all goes as planned, deadlock will occur,and the program will never exit.
	    
	    
	   /* //Here's the Solution for the dead lock
	      // Use the resources by Thread order. which means Suganthi first has to use gas stove and then has to use milk vesel
	    
	    Thread t2 = new Thread(){
	      public void run(){
	        //This thread locks resource 2 right away
	        synchronized(resource1){
	          System.out.println("Suganthi: locked Gas Stove");
	          //Then it pauses, for the same reason as the first 
	          //thread does
	          try{
	    		Thread.sleep(50); 
	    	  } catch (InterruptedException e){}

	          //Then it tries to lock resource1.  
	          //But wait!  Thread 1 locked resource1, and 
	          //won't release it till it gets a lock on resource2.  
	          //This thread holds the lock on resource2, and won't
	          //release it till it gets resource1.  
	          //We're at an impasse. Neither thread can run, 
	          //and the program freezes up.
		        synchronized(resource2){
		        	System.out.println("Suganthi: locked Milk Vesel");
		        }	          
	        }
	        System.out.println("Suganthi has finished");
	      }
	    };
	    //Start the two threads. 
	    //If all goes as planned, deadlock will occur,and the program will never exit.*/
	    
	    t1.start(); 
	    t2.start();
	  }
	}