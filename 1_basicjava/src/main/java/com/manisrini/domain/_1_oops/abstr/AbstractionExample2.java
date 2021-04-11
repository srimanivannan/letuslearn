package com.manisrini.domain._1_oops.abstr;

class MotorVehicle {

  public String soundHorn() {
    return "hi";
  }
}

class Truck extends MotorVehicle {

  public String soundHorn() {
    return "truck horn";
  }
}

class Car extends MotorVehicle {

  public String soundHorn() {
    return "car horn";
  }
}

public class AbstractionExample2 {

  public static void main(String[] args) {
    MotorVehicle c = new Truck();
    //Car b = new MotorVehicle(); // by default compiler error unless you do explicit cast
  }
}
