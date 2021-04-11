package com.manisrini.domain.generics.wildcard;

import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Banana extends Fruit {}
class Orange extends Fruit {}

public class Example {
  // if you remove super T from List<? super T> then compiler won't like it
  public static <T> void copy(List<T> source, List<? super T> destination) {
    for(T element : source) {
      destination.add(element);
    }
  }

  public static void main(String[] args) {
    Banana banana = new Banana();
    Orange orange = new Orange();

    List<Fruit> fruits = new ArrayList<>();
    fruits.add(banana);
    fruits.add(orange);

    List<Fruit> newFruitsBasket = new ArrayList<>();
    copy(fruits, newFruitsBasket);
    System.out.println(newFruitsBasket.size());

    List<Banana> basketOfBanana = new ArrayList<>();
    basketOfBanana.add(banana);

    List<Fruit> newFruitsBasket2 = new ArrayList<>();
    copy(basketOfBanana, newFruitsBasket2);
    //Compliler protects us here as well (as in
    //we'd expect as discussed in the Liskov's substitution principle sample).

    //But in this case, it is OK, we know it. We can tell the compiler it
    //is ok by using ? super T

    System.out.println(newFruitsBasket2.size());
  }
}
