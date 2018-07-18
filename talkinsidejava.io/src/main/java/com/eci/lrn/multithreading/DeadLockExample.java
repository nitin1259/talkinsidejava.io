/**
 * 
 */
package com.eci.lrn.multithreading;

/**
 * @author nsingh
 *
 */
public class DeadLockExample{

	/**
	 * @param args
	 * 
	 * Some quick tips to avoid dead lock

		don't use multiple threads (like Swing does, for example, by mandating that everything is done in the EDT)
		don't hold several locks at once. If you do, always acquire the locks in the same order
		don't execute foreign code while holding a lock
		use interruptible locks
	 * 
	 * 
	 */
	
	
	String str1="Java";
	String str2="C++";
	
	Thread t1= new Thread("Thread1"){
		
		public void run(){
			while(true){
				synchronized (str1) {
					
					try {
						Thread.sleep(1000);
						System.out.println("Locked on "+str1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (str2) {
						System.out.println("Locked on "+str1 +" and " +str2);
					}
				}
			}
		}
	};
	
	
	Thread t2= new Thread("Thread1"){
		
		public void run(){
			while(true){
				synchronized (str2) {
					
					try {
						Thread.sleep(1000);
						System.out.println("Locked on "+str2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (str1) {
						System.out.println("Locked on "+str2 +" and " +str1);
					}
				}
			}
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeadLockExample dl = new DeadLockExample();
		dl.t1.start();
		dl.t2.start();
	}

}
