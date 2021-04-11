package com.manisrini.domain._4_exception;

public class ExceptionExample1 {

  public void method1() throws NullPointerException{
    throw new NullPointerException("test");
  }
  public void method2() throws NullPointerException{
    method1();
  }

  public void method3(){
    method2();
  }
  public static void main(String[] args){

    try{

      ExceptionExample1 object = new ExceptionExample1();
      object.method3();
    }catch(Exception e){
      System.err.println("Exception handled: Message="+e.getMessage());
    }
  }

}
