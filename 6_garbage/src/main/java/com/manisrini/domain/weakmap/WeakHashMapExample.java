package com.manisrini.domain.weakmap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

  public static void main(String[] args) {

    Key k1 = new Key("Hello");
    Key k2 = new Key("World");
    Key k3 = new Key("Java");
    Key k4 = new Key("Programming");

    Map<Key, String> wm = new WeakHashMap<>();
    Map<Key, String> hm = new HashMap<>();

    wm.put(k1, "Hello");
    wm.put(k2, "World");
    wm.put(k3, "Java");
    wm.put(k4, "Programming");

    hm.put(k1, "Hello");
    hm.put(k2, "World");
    hm.put(k3, "Java");
    hm.put(k4, "Programming");
    k1 = null;
    k2 = null;
    k3 = null;
    k4 = null;
/*
    A WeakHashMap discards entries when the key is no longer strongly reachable from live code.
    Since the HashMap maintains a hard reference to the keys, the keys are still reachable and the WeakHashMap doesn't discard the entries.
    The point is that the behavior has to do with references to the key objects,
    not to the value of any variable that might have at one time had a reference to the keys.
*/
    hm = null; //READ Below
    /*
      In order to see WeakHashMap discard entries you will have to make hm = null un-commented out because hm is holding the references
    */
    System.gc();
    System.out.println("Weak Hash Map :" + wm);
    System.out.println("Hash Map :" + hm);
  }

}

class Key {

  private final String key;

  public Key(String key) {
    this.key = key;
  }

  @Override
  public boolean equals(Object obj) {
    return this.key.equals(obj);
  }

  @Override
  public int hashCode() {
    return key.hashCode();
  }

  @Override
  public String toString() {
    return key;
  }

}