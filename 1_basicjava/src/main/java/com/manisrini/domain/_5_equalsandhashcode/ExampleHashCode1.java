package com.manisrini.domain._5_equalsandhashcode;

public class ExampleHashCode1 {

  @Override
  public int hashCode(){
    return 1;
  }
  public static void main(String[] args) {

    ExampleHashCode1 obj1= new ExampleHashCode1();
    ExampleHashCode1 obj2= new ExampleHashCode1();
    System.out.println(obj1==obj2); // false though hashcode is same
    System.out.println(obj1.equals(obj2)); // false though hashcode is same
    System.out.println(obj1.hashCode());
    System.out.println(obj2.hashCode());
  }

}
