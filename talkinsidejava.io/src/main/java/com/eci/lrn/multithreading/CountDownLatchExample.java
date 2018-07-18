/**
 * 
 */
package com.eci.lrn.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * @author nsingh
 *
 */
public class CountDownLatchExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownLatch cdLatch = new CountDownLatch(2);
		
		Thread t1 = new Thread(new Service("Service", 1000, cdLatch));
		Thread t2 = new Thread(new Maintenance("Maintenance", 1000, cdLatch));
		
		t1.start();
		t2.start();
		
		// application should not start processing any thread until all service is up
	       // and ready to do there job.
	       // Countdown latch is idle choice here, main thread will start with count 3
	       // and wait until count reaches zero. each thread once up and read will do
	       // a count down. this will ensure that main thread is not started processing
	       // until all services is up.
	      
	       //count is 3 since we have 3 Threads (Services)


	// Read more: http://javarevisited.blogspot.com/2012/07/countdownlatch-example-in-java.html#ixzz4KJj8NL4F
		
		try {
			cdLatch.await();
			System.out.println("main thread stated to after start service and maintenance");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}


class Service implements Runnable{
	private final String name;
	private final int timeToStart;
	private final CountDownLatch latch;
	
	public Service(String name, int timeToStart, CountDownLatch latch){
		this.name=name;
		this.timeToStart=timeToStart;
		this.latch=latch;
	}

	public void run() {
		
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread Up: "+name);
		latch.countDown();
		
	}
}
	class Maintenance implements Runnable{
		private final String name;
		private final int timeToStart;
		private final CountDownLatch latch;
		
		public Maintenance(String name, int timeToStart, CountDownLatch latch){
			this.name=name;
			this.timeToStart=timeToStart;
			this.latch=latch;
		}

		public void run() {
			
			try {
				Thread.sleep(timeToStart);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("thread Up: "+name);
			latch.countDown();
			
		}
}