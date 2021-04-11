package com.manisrini.domain._5_java5;

/*
 * This is first enum class
 */
enum PrcssngStatus {
  Pending, PremRecQR, CalcQR;

  public void normalmethod() {
    System.out.println("This is normalmethod");
  }

  public static void staticmethod() {
    System.out.println("This is staticmethod");
  }

  class enumclass {
    //you can create class inside enum
  }

  interface enuminterface {
    //you can create interface inside enum
  }
}

/*
 * This is second enum class
 */
enum UserStatus {
  PENDING("P"), ACTIVE("A"), INACTIVE("I"), DELETED("D"), UNKNOWN("U");

  private String statusCode;

  private UserStatus(String s) {
    System.out.println("UserStatus");
    statusCode = s;
  }

  public String getStatusCode() {
    System.out.println("getStatusCode");
    return statusCode;
  }

  public static UserStatus getValue(String value) {
    try {
      return valueOf(value.replaceAll("-", "_").toUpperCase());
    } catch (Exception e) {
      return UNKNOWN;
    }
  }
}

/*
 * This eunm test class
 */
public class TestEnum {

  public static void main(String[] args) {

    //#1
    System.out.println("---------------#1-----------");
    PrcssngStatus psts = PrcssngStatus.CalcQR;
    System.out.println(psts);
    //#2
    System.out.println("---------------#2-----------");
    if ("Pending".equalsIgnoreCase(PrcssngStatus.Pending.toString())) {
      System.out.println("Pending is true");
    }
    //#3
    System.out.println("---------------#3-----------");
    for (PrcssngStatus sts : PrcssngStatus.values()) {
      System.out.println(sts);
    }
    //#4
    System.out.println("---------------#4-----------");
    PrcssngStatus.Pending.normalmethod();
    //#5
    System.out.println("---------------#5-----------");
    PrcssngStatus.staticmethod();
    //#6
    System.out.println("---------------#6-----------");
    System.out.println(UserStatus.ACTIVE.getStatusCode());
    //#7
    System.out.println("---------------#7-----------");
    System.out.println(UserStatus.getValue("INACTIVE"));

  }

}
