package com.manisrini.domain._1_oops.interf;

public interface InterfaceSampleJava8 {

  /**
   * 1. default static is not allowed
   * 2. default access modifier is public. others not allowed like protected,private
   * 3. private concrete method allowed
   * 4. static method allowed
   * 5. final method NOT allowed
   */

  default Integer defaultMethod(Integer number1, Integer number2) {
    if (isNull(number1)) { return 0; }
    if (isNull(number2)) { return 0; }
    return number1 + number2;
  }

  private boolean isNull(Integer number1) {
    return null == number1;
  }

  static Integer minus(Integer number1, Integer number2) {
    return number1 - number2;
  }
}
