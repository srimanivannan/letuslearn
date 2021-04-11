package com.manisrini.domain._2_threading.executors;

import static java.lang.String.format;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.vavr.control.Try;

/**
 * Run main Method Runnable task execute by execute method doesn't block main thread task
 */
public class ExecutorsRunnableExample1 {

  private ExecutorService executorService;

  public ExecutorsRunnableExample1(ExecutorService executorService) {
    this.executorService = executorService;
  }

  public void doIt() {
    executeRunnableTaskWithexecuteMethod(); // Runnable Task : it returns void
    // you can keep thread alive until it gets shutdown. until then you can perform more tasks
    executorService.shutdown(); // to shutdown executorService
    System.out.println("executorService.isShutdown() " + executorService.isShutdown());
    // Though you shutdown in above line, executorService termination will not happen until all threads complete it's task
    // By defaut all task sleeping period I put id 3 seconds ( 3000 ms )
    System.out.println("executorService.isTerminated() " + executorService.isTerminated());
    // you can check isTerminated with waiting time. it will be true if it's terminated with mentioned time or else false
    // if you change the below wait time to more than 3 seconds, then it will true
    System.out.println("executorService.awaitTermination() " + Try
        .ofCallable(() -> executorService.awaitTermination(1, TimeUnit.SECONDS)).get());
  }

  /**
   * Step1: main thread is doing some task Step2: new thread takes ObjectRunnableTask1 Step3:
   * another new thread takes lambda runnableTask Step4: main thread is doing some other task
   */
  private void executeRunnableTaskWithexecuteMethod() {
    someOtherTaskContinuesOnMainThread("main thread task1");
    // Class Implements Runnable Interface
    // Runnable execute method returns void
    executorService.execute(new RunnableTask("ObjectRunnableTask1"));
    executorService.execute(runnableTask); // Lambda expression Runnable Interface
    //executorService.
    someOtherNewTaskContinuesOnMainThread("main thread new task1");
  }

  private Runnable runnableTask = () -> {
    Try.run(() -> TimeUnit.SECONDS.sleep(3));
    System.out.println(
        format("I'm a lamda runnable task executed/performed by thread name:[%s]",
            Thread.currentThread().getName()));
  };

  private void someOtherTaskContinuesOnMainThread(String task) {
    System.out.println(
        format("I'm a main thread and my name is:[%s] and doing the task:[%s]",
            Thread.currentThread().getName(), task));
  }

  private void someOtherNewTaskContinuesOnMainThread(String newTask) {
    System.out.println(
        format("I'm a main thread and my name is:[%s] doing some other new task:[%s]",
            Thread.currentThread().getName(),
            newTask));
  }

  /**
   * Creates 5 fixed threads. if you create or execute more than 5 tasks. Tasks will be shared to
   * only these 5 threads Example, if you have 6 tasks, 6th task will be executed by any one of
   * these 5 Threads
   */
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    var executorServiceExample1 = new ExecutorsRunnableExample1(executorService);
    executorServiceExample1.doIt();
  }
}
