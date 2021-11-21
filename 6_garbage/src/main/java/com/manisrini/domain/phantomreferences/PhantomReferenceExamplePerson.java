package com.manisrini.domain.phantomreferences;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class PhantomReferenceExamplePerson {

  public static void main(String[] args) {
    ReferenceQueue<Person> queue = new ReferenceQueue<>();
    ArrayList<FinalizePerson> finalizePersonArrayList = new ArrayList<>();
    ArrayList<Person> personArrayList = new ArrayList<>();

    for (int i = 0; i < 1; i++) {
      Person p = new Person();
      personArrayList.add(p);
      finalizePersonArrayList.add(new FinalizePerson(p, queue));
    }

    personArrayList = null;
    System.gc();

    for (PhantomReference<Person> reference : finalizePersonArrayList) {
      System.out.println("reference.isEnqueued():" + reference.isEnqueued());
    }

    Reference<? extends Person> referenceFromQueue;
    while ((referenceFromQueue = queue.poll()) != null) {
      ((FinalizePerson) referenceFromQueue).cleanup();
    }

  }
}

class FinalizePerson extends PhantomReference<Person> {

  public FinalizePerson(Person referent, ReferenceQueue<? super Person> q) {
    super(referent, q);
  }

  public void cleanup() {
    System.out.println("person is finalizing resources");
  }

}

class Person {

}