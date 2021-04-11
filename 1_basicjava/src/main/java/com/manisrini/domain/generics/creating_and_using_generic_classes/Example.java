package com.manisrini.domain.generics.creating_and_using_generic_classes;

public class Example {

  public static void main(String[] args) {
    MyList<Integer> list = new MyList<>();
    list.add(1);

    MyList1<Integer, String> list1 = new MyList1<>(1, "returnType");
    System.out.println(list1.convert());
  }
}

class MyList<T> {

  public void add(T instance) {
    System.out.println("added...");
  }
}

class MyList1<T, R extends String> {

  private T type;
  private R returnType;

  public MyList1(T type, R returnType) {
    this.type = type;
    this.returnType = returnType;
  }

  public String convert() {
    System.out.println("converted...");
    return returnType.concat(type.toString());
  }
}
