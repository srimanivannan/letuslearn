package com.manisrini.domain._2_threading.thread;

//File Name ThreadSafeBankAccount.java
class ThreadSafeBankAccount
{
private double balance;
private int number;
public ThreadSafeBankAccount(int num, double initialBalance)
{
   balance = initialBalance;
   number = num;
}
public int getNumber()
{
   return number;
}
public double getBalance()
{
   return balance;
}
public void deposit(double amount)
{
   synchronized(this)
   {
     double prevBalance = balance;
     try
     {
        Thread.sleep(4000);
     }catch(InterruptedException e)
     {}
     balance = prevBalance + amount;
   }
}
public void withdraw(double amount)
{
   synchronized(this)
   {
	     double prevBalance = balance;
      try
      {
         Thread.sleep(4000);
      }catch(InterruptedException e)
      {}
      balance = prevBalance - amount;
   }
}
}
//File Name OrderedTeller.java
class OrderedTeller extends Thread
{
private ThreadSafeBankAccount source, dest;
public OrderedTeller(ThreadSafeBankAccount a,
                     ThreadSafeBankAccount b)
{
   source = a;
   dest = b;
}
public void run()
{
   transfer(250.00);
}
public void transfer(double amount)
{
    System.out.println("Transferring from " + source.getNumber()
        + " to " + dest.getNumber());
    ThreadSafeBankAccount first, second;
    if(source.getNumber() < dest.getNumber())
    {
       first = source;
       second = dest;
    }
    else
    {
       first = dest; 
       second = source;
    }
    synchronized(first)
    {
       Thread.yield();
       synchronized(second)
       {
          System.out.println("Withdrawing from "
                      + source.getNumber());
          source.withdraw(amount);
          System.out.println("Depositing into "
                      + dest.getNumber());
          dest.deposit(amount);
       }
   }
}
}

//File Name DeadlockDemo.java
public class DeadlockDemo
{
public static void main(String [] args)
{
   System.out.println("Creating two bank accounts...");
   ThreadSafeBankAccount checking =
                 new ThreadSafeBankAccount(101, 1000.00);
   ThreadSafeBankAccount savings =
                 new ThreadSafeBankAccount(102, 5000.00);

   System.out.println("Creating two teller threads...");
   Thread teller1 = new OrderedTeller(checking, savings);
   Thread teller2 = new OrderedTeller(savings, checking);
   System.out.println("Starting both threads...");
   teller1.start();
   teller2.start();
}
}
