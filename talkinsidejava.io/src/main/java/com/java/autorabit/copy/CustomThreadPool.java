/**
 * 
 */
package com.java.autorabit.copy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author nisingh
 *
 */
public class CustomThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(3);
		 
        for (int i = 0; i < 5; i++) {
            Tasks task = new Tasks(i);
            pool.execute(task);
        }

	}

}

class ThreadPool{
	private final int nthreads;
	private final PoolWorker [] threads;
	private final BlockingQueue<Runnable> queue;
	
	public ThreadPool(int num) {
		this.nthreads=num;
		threads = new PoolWorker[num];
		queue = new LinkedBlockingDeque<Runnable>();
		
		for(int i=0;i<num;i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}
	
	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}
	
	private class PoolWorker extends Thread{
		public void run() {
			Runnable task;
			
			while(true) {
				synchronized (queue) {
					while(queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = queue.poll();
				}
				try {
					task.run();
				}catch(RuntimeException e) {
					System.out.println("ThreadPool is intrrupted because of: "+ e.getMessage());
				}
			}
		}
	}
}

class Tasks implements Runnable{
	
	private int n;
	
	public Tasks(int n) {
		this.n=n;
	}
	
	public void run() {
		
		
		System.out.println("Task running is: " + this.n + " In thread - "+ Thread.currentThread().getName());
	}
}
