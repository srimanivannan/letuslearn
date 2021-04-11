package com.manisrini.domain._2_threading.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.vavr.control.Try;

public class CallableTask implements Callable<String> {

  private final String message;

  public CallableTask(String messsage) {
    this.message = messsage;
  }

  @Override
  public String call() {
    Try.run(() -> TimeUnit.MILLISECONDS.sleep(3000));
    System.out.println(String.format(
        "\t\tI'm doing [%s] through CallableTask implements Callable interface with Thread name:[%s]",
        this.message, Thread.currentThread().getName()));
    return "CallableTask implements Callable interface is done";
  }
}
