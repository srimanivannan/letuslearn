package com.manisrini.domain.java8.interfa;

public class InterfaceImpl implements InterfaceA , InterfaceB {

  /*
    if comment below Overrided getValue method, compiler won't like it
    because both InterfaceA and InterfaceB have default method of getValue
   */
  @Override
  public String getValue() {
    return "InterfaceImpl";
  }

  public static void main(String[] args) {
    InterfaceImpl anInterface = new InterfaceImpl();
    System.out.println(anInterface.getValue());
  }

}
