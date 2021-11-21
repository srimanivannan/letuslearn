package com.manisrini.domain.weakmap;

import java.time.Instant;
import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapExample1 {

  public static void main(String[] args) {
    weakHashMap();
    regularHashMap();
  }

  private static void weakHashMap() {
    WeakHashMap<Person, PersonMetaData> weakHashMap = new WeakHashMap<Person, PersonMetaData>();
    Person kevin = new Person();
    weakHashMap.put(kevin, new PersonMetaData());

    PersonMetaData p = weakHashMap.get(kevin);

    System.out.println("weakHashMap before gc:" + weakHashMap);

    kevin = null;
    System.gc();

    if (weakHashMap.containsValue(p)) {
      System.out.println("Still contains key");
    } else {
      System.out.println("Key gone");
    }
    System.out.println("weakHashMap after gc:" + weakHashMap);
  }

  private static void regularHashMap() {
    HashMap<Person, PersonMetaData> regularHashMap = new HashMap<>();
    Person mani = new Person();
    regularHashMap.put(mani, new PersonMetaData());

    PersonMetaData p = regularHashMap.get(mani);

    System.out.println("regularHashMap before gc:" + regularHashMap);

    mani = null;
    System.gc();

    if (regularHashMap.containsValue(p)) {
      System.out.println("Still contains key");
    } else {
      System.out.println("Key gone");
    }
    System.out.println("regularHashMap after gc:" + regularHashMap);
  }
}

final class Person {

}

class PersonMetaData {

  Instant date;

  PersonMetaData() {
    date = Instant.now();
  }

  @Override
  public String toString() {
    return "PersonMetaData {" +
        "date=" + date +
        '}';
  }
}