package com.java.autorabit.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AutoRabit {

	
	// list 
	// string 
	// a,b,c ....10
		
	
	public static void main(String [] args) {
		
		List<String> strList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
		
		
		ExecutorService executer = Executors.newFixedThreadPool(5);
		
		
		for (String str : strList) {
			Task t = new Task(str);
			
			executer.execute(t);
		}
		((ThreadPoolExecutor) executer).shutdown();
	}
}



class Task implements Runnable{
	
	String str;
	public Task(String s) {
		this.str = s;
	}
	
	
	public void run() {
		
		try {
			Thread.sleep(100);
			System.out.println(this.str + ": in "+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
