package com.manisrini.domain._2_threading.executors;

import static java.lang.String.format;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


import io.vavr.control.Try;

/**
 * Run main Method
 * Callable task submit by submit method  blocks main thread task because if Future.
 * it waits for those task to be completed because of get method
 */
public class ExecutorCallableExample1 {

  private ExecutorService executorService;

  /**
   * Creates 5 fixed threads. if you create or execute more than 5 tasks. Tasks will be shared to
   * only these 5 threads, For Example, if you have 6 tasks, 6th task will be executed by any one of
   * these 5 Threads
   */
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    var executorCallableExample1 = new ExecutorCallableExample1(executorService);
    executorCallableExample1.doIt();
  }

  public ExecutorCallableExample1(ExecutorService executorService) {
    this.executorService = executorService;
  }

  public void doIt() {
    // Un comment below to see single callable task
    //executeCallableTask(); // Callable Task : it returns data

    // Un comment below to see multiple callable tasks via invoke all method
    executeCallableTasks(); // invokeAll callable tasks. it's a list of future
    executorService.shutdown(); // to kill and shutdown threads
  }

  private void executeCallableTasks() {
    someOtherTaskContinuesOnMainThread("main thread invokeAll task2");
    List<Future<String>> futures = Try.ofCallable(() -> executorService.invokeAll(callableTasks()))
        .get();
    futures.forEach(
        it -> System.out.println("\t\tCallable Task returns: " + Try.ofCallable(it::get)));
    someOtherNewTaskContinuesOnMainThread("main thread new invokeAll task2");
  }

  private void executeCallableTask() {
    someOtherTaskContinuesOnMainThread("main thread task1");
    // Class Implements Callable Interface
    Future<String> objectFuture = Try
        .ofCallable(() -> executorService.submit(new CallableTask("ObjectCallableTask1"))).get();
    System.out.println("\t\tCallable Task returns:" + Try.ofCallable(objectFuture::get).get());
    // Lambda expression Callable Interface
    Future<String> lamdaFuture = Try.ofCallable(() -> executorService.submit(callableTsk)).get();
    System.out.println("\t\tCallable Task returns:" + Try.ofCallable(lamdaFuture::get));

    // Note: Because of get() method in future, the main thread is blocked until callable is done.
    someOtherNewTaskContinuesOnMainThread("main thread new task2");
  }

  private Callable<String> callableTsk = () -> {
    TimeUnit.MILLISECONDS.sleep(3000);
    System.out.println(
        format("\t\tI'm a lambda callable task executed/performed by Thread name:[%s]",
            Thread.currentThread().getName()));
    return "callable task complete";
  };

  private List<Callable<String>> callableTasks() {
    return Arrays
        .asList(callableTsk, callableTsk, callableTsk, callableTsk, callableTsk, callableTsk);
  }

  private void someOtherTaskContinuesOnMainThread(String task) {
    System.out.println(
        format("I'm a main thread and my name is:[%s] and doing the task:[%s]",
            Thread.currentThread().getName(), task));
  }

  private void someOtherNewTaskContinuesOnMainThread(String newTask) {
    System.out.println(
        format("I'm a main thread and my name is:[%s] doing some other new task:[%s]",
            Thread.currentThread().getName(), newTask));
  }

}
