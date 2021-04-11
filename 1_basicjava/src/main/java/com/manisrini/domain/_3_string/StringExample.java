package com.manisrini.domain._3_string;

public class StringExample {

  public static void testEquals() {

    String s1 = "hello";
    String s2 = "hel" + "lo";
    String s3 = "mum";

    if (s1 == s2) { // because of string+string s1 and s2 reference is same
      System.out.println("1. same");
    } else {
      System.out.println("1. different");
    }

    if ((s1 + s3) == "hellomum") { // because of assignment reference it's different
      System.out.println("2. same");
    } else {
      System.out.println("2. different");
    }

    if ((s1 + s3).equals("hellomum")) { // because of string content it's same
      System.out.println("3. same");
    } else {
      System.out.println("3. different");
    }

    if ((s1.concat(s3)) == ("hellomum")) { // because of assignment reference it's different
      System.out.println("4. same");
    } else {
      System.out.println("4. different");
    }

  }

  public static void main(String[] args) {

    String s1 = "mani";
    String s2 = "mani";
    String s3 = "mani";
    String s4 = "mani";

    s3 = "cool";

    System.out
        .println(String.format("s1 value:%s s2 value:%s s3 value:%s s4 value:%s", s1, s2, s3, s4));

    System.out
        .println(String
            .format("s1.hashCode():%d s2.hashCode():%d s3.hashCode():%d s4.hashCode():%d",
                s1.hashCode(), s2.hashCode(), s3.hashCode(), s4.hashCode()));

    System.out.println("Look same hashcode for s1 s2 s4");

    String test1 = new String("welcome");
    String test2 = new String("welcome");
    String test3 = "welcome";
    System.out.println("test1 == test2:" + (test1 == test2)); // This is false because of new instance
    System.out.println("test1.equals(test2):" + (test1.equals(test2))); // This is true because of content of strings
    System.out.println("test1 == test3:" + (test1 == test3)); // This is false because of new instance
    System.out.println("test1.equals(test3):" + (test1.equals(test3))); // This is true because of content of strings

    System.out.println("test1 hascode=>" + test1.hashCode());
    System.out.println("test2 hascode=>" + test2.hashCode());
    System.out.println("test3 hascode=>" + test3.hashCode());
    //Both the hash codes are same because string literal pool

    testEquals();
  }
}
