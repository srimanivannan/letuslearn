package com.manisrini.domain._1_oops.classes;

public class FinalClass {

  public FinalClass() {
    System.out.println("Constructor of: " + this.getClass().getSimpleName());
  }

  final class InnerClassCanBeFinal {

    public InnerClassCanBeFinal() {
      System.out.println("Constructor of: " + this.getClass().getSimpleName());
    }

    public void InnerMethod() {
      System.out.println("InnerMethod:" + this.getClass().getSimpleName());
    }
  }

  public static void main(String[] args) {

    new FinalClass().new InnerClassCanBeFinal().InnerMethod();
  }

}
