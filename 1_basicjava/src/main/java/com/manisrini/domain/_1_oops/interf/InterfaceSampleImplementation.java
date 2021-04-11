package com.manisrini.domain._1_oops.interf;

public class InterfaceSampleImplementation implements InterfaceSample {

  @Override
  public void testmethod(){
    System.err.println("empty");
  }

  @Override
  public void testmethod(int a){
    System.err.println("a=>"+a);
  }

  public static void main(String[] args) {
    System.err.println("b==>"+b);
    System.err.println("b==>"+ b);
    System.err.println("b==>"+new InterfaceSampleImplementation().b);
    new InterfaceSampleImplementation().testmethod();
    new InterfaceSampleImplementation().testmethod(100);
  }
}
