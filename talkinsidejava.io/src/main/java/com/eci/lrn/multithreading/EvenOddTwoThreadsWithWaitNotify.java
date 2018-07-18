/**
 * 
 */
package com.eci.lrn.multithreading;

/**
 * @author nsingh
 *
 */
public class EvenOddTwoThreadsWithWaitNotify {

	
	public static void main(String[] args) {
		Printer printer = new Printer();
		Thread t1 = new Thread(new TaskEvenOdd(printer, 10, false));
		Thread t2 = new Thread(new TaskEvenOdd(printer, 10, true));
		t1.start();
		t2.start();
	}

}

class TaskEvenOdd implements Runnable{

	int max;
	Printer printer;
	boolean isEvenNumber;
	
	
	public TaskEvenOdd (Printer print, int max, boolean isEvenNumber){
		this.printer = print;
		this.max=max;
		this.isEvenNumber=isEvenNumber;
	}
	
	
	@Override
	public void run() {
	
		int number = (isEvenNumber==true) ? 2:1;
		
		while(number<=max){
			if(isEvenNumber)
				printer.printEven(number);
			else
				printer.printOdd(number);
			
			number +=2;
		}
		
		
	}
	
	
}

class Printer{

	boolean isOdd = false;
	
	public synchronized void printOdd(int number) {
		while(isOdd==true){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Odd: "+number);
		isOdd=true;
		notifyAll();
	}

	public synchronized void printEven(int number) {
		while (isOdd==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("even: "+number);
		isOdd=false;
		notifyAll();
	}
	
}