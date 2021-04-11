package com.manisrini.domain.interview.myworkouts;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Testint implements Account{


  public static void main(String[] args) {
//    Supplier<String> i = () -> "Car";
//    Consumer<String> c = x -> System.out.println(x.toLowerCase());
//    Consumer<String> d = x -> System.out.println(x.toUpperCase());
//    c.andThen(d).accept(i.get());
//    System.out.println();
//    Character cq = new Character("C");
//    new Boolean("false");
//    new Double("17.46d");
//    new Float(23.43);
//    int i1 = Integer.parseUnsignedInt(4);
    System.out.println(Stream.of("green","yello","blue").max((s1,s2) -> s1.compareTo(s2)).filter(s->s.endsWith("n")).orElse("yello"));
  }

  public Testint(BigDecimal d) {
    //balance = d;
  }

}
interface  Account {
  BigDecimal balance = new BigDecimal(0.00);
}
