package com.manisrini.domain.memory.address;

/*
  1. open up terminal and type jvisualvm
  2. Run this class in intellij
  3. The below running class should show up in jvisualvm and double click it
  4. click visualgc tab and monitor garbage collection
 */
public class AllocateSpeed {

  public static void main(String... args) throws Exception {
    int i = 0;
    while (true) {
      new GCMe2();
      i++;
      // 5000000 with finalization
      // 500000000 without
      if (i % 5000000 == 0) {
        System.out.print(".");
      }
    }
  }

}

class GCMe2 {

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }
}
