package com.manisrini.domain._2_threading.executors;

import java.util.concurrent.TimeUnit;

import io.vavr.control.Try;

public class RunnableTask implements Runnable {

  private final String message;

  public RunnableTask(String messsage) {
    this.message = messsage;
  }

  private void doSomeTask() {
    Try.run(() -> TimeUnit.SECONDS.sleep(3));
    System.out.println(String.format("I'm doing [%s] through RunnableTask implements Runnable with Thread name:[%s]",
        this.message, Thread.currentThread().getName()));
  }

  @Override
  public void run() {
    doSomeTask();
  }
}
