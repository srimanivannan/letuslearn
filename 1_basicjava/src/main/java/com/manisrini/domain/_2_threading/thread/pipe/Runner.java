package com.manisrini.domain._2_threading.thread.pipe;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Runner{
final PipedOutputStream outputpipe = new PipedOutputStream();
PipedInputStream inputpipe = new PipedInputStream();

public static void main(String[] args) {
    new Runner().doit();
    System.err.println("Finished main thread");
}
public void doit() {
	try{
		inputpipe.connect(outputpipe);//make connection between pipeinput and pipeoutput stream
		
	    (new Producer(outputpipe)).start();
	    
	    //BufferedInputStream input = new BufferedInputStream(inputpipe);
	    
	    (new Consumer(new BufferedInputStream(inputpipe))).start();
	    
	}catch(Exception e){
		
	}
}

}

class Producer extends Thread {
OutputStream source;
Producer(OutputStream source) {
    this.source=source;
}
@Override
public void run(){
	try{
    byte[] data = new byte[1024];
    System.err.println("Running the Producer...");
    String path="C:/javainterviewpreparation/corejava/src/com/mani/corejava/thread/pipe/test.txt";
    FileInputStream fis = new FileInputStream(path);

    int amount=0;
    while((amount=fis.read(data))>0)
    {
        String s = new String(data, 0, amount);
        source.write(s.getBytes());
        //sunchronized is no use. but you can use.
       // synchronized (this) {
       //     wait(5);
       // }
    }
    source.close();
    fis.close();
	}catch (Exception e) {

	}
}

}

class Consumer extends Thread{
InputStream ins;
Consumer(InputStream ins)
{
    this.ins = ins;
}
public void run()
{
    System.err.println("Consumer running");
    try{
    int amount;
    byte[] data = new byte[1024];
    while ((amount = ins.read(data)) >= 0) {
        String s = new String(data, 0, amount);
        System.err.println("$"+s);
        //synchronized (this) {
        //    wait(5);
        //}
    }
    ins.close();
    }catch(Exception e){
    	
    }
}
}
