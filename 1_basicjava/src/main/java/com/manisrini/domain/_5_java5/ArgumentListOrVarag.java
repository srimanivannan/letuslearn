package com.manisrini.domain._5_java5;

public class ArgumentListOrVarag {
  //Only one variable argument list is allowed per method
  //Variable list must be the last argument defined for the method
  //for example this is not allowed in public static void printNames(String...names,int intvalue){
  //The ellipsis "�" is used to indicate that an argument might appear a variable number of times

  public static void printNames(int intValue, String... names) {
    for (String string : names) {
      System.out.println("Name:" + string);
    }
    System.out.println("intValue=>" + intValue);
  }

  public static void printNames(int... nums) {
    for (int i : nums) {
      System.out.println("nums:" + i);
    }
  }

  public static void main(String[] args) {
    printNames(44, "one");
    printNames(100, "one", "two", "three");
    int[] nums = {22, 33, 44, 55, 66, 77};
    printNames(nums);
  }
}
