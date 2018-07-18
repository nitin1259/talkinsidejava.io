/**
 * 
 */
package com.eci.lrn.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.aspectj.util.Reflection;

/**
 * @author nsingh
 *
 */
public class ExecutorServiceExample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for(int i=0;i<5;i++)
		executor.execute(new ProcessThread(i));

		executor.shutdown();
		System.out.println("All task submitted");
	}

}


class ProcessThread implements Runnable{

	int id;
	
	public ProcessThread(int i){
		this.id=i;
	}
	@Override
	public void run() {
		System.out.println("Thread name"+ Thread.currentThread().getName());
		System.out.println("Starting thread" + id);
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("sorry, being interupted, good bye!");
            System.out.println("Interrupted "+Thread.currentThread().getName());
            e.printStackTrace();    
        }

        System.out.println("Completed: " + id);
		
	}
	
}