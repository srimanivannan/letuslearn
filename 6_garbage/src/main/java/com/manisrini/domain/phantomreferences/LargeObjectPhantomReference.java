package com.manisrini.domain.phantomreferences;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import com.manisrini.domain.LargeObject;

public class LargeObjectPhantomReference extends PhantomReference<LargeObject> {

  private int id;

  /**
   * Creates a new phantom reference that refers to the given object and is registered with the
   * given queue.
   * <p> It is possible to create a phantom reference with a <tt>null</tt>
   * queue, but such a reference is completely useless: Its <tt>get</tt> method will always return
   * null and, since it does not have a queue, it will never be enqueued.
   *
   * @param referent the object the new phantom reference will refer to
   * @param q the queue with which the reference is to be registered,
   */
  LargeObjectPhantomReference(LargeObject referent, ReferenceQueue<? super LargeObject> q) {
    super(referent, q);
    id = referent.getId();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "LargeObjectReference{" + "id=" + id + '}';
  }
}
