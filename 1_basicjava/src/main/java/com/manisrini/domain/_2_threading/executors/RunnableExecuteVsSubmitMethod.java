package com.manisrini.domain._2_threading.executors;

import static java.lang.String.format;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.vavr.control.Try;

public class RunnableExecuteVsSubmitMethod {

  private ExecutorService executorService;

  public RunnableExecuteVsSubmitMethod(ExecutorService executorService) {
    this.executorService = executorService;
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    RunnableExecuteVsSubmitMethod method = new RunnableExecuteVsSubmitMethod(executorService);
    method.doSubmit(); // This will not throw exception until you make future.get() method
    method.doExecute(); // This will throw exception and propagates
    method.doSubmitWithResult(); // you can put the result when you perform task
    executorService.shutdown();
  }

  public void doSubmit() {
    Future<?> submit = executorService.submit(failedRunnableTask);
    Try.ofCallable(submit::get).onFailure( throwable -> {
      System.out.println(
          format("Failed task be performed by thread name:[%s] and error message:[%s]",
              Thread.currentThread().getName(), throwable.getMessage()));
    });
  }

  public void doSubmitWithResult() {
    Future<String> submit = executorService.submit(runnableTask, "return result");
    String s = Try.ofCallable(submit::get).get();
    System.out.println("result of submit method: " + s);
  }

  public void doExecute() {
    executorService.execute(runnableTask);
  }

  private Runnable failedRunnableTask = () -> {
    throw new RuntimeException("execption occured on the thread name: " + Thread.currentThread().getName());
  };

  private Runnable runnableTask = () -> {
    Try.run(() -> TimeUnit.SECONDS.sleep(3));
    System.out.println(
        format("Task in progress by thread name:[%s]",
            Thread.currentThread().getName()));
    int a = 10, b = 2;
    System.out.println(String.format("%d/%d=%d", a,b, (a / b)));
    System.out.println(
        format("Task is done by thread name:[%s]",
            Thread.currentThread().getName()));
  };

}
