package com.eci.lrn.ds;

import java.util.Arrays;

public class MyStack {
	
	private int size=0;
	private int [] element;
	private static final int DEFAULT_CAPACITY=10;
	
	public MyStack(){
		element = new int[DEFAULT_CAPACITY];
	}
	
	public void push(int num){
		
		if(size==element.length)
			enchanceCapacity();
		element[size++]=num;
	}
	
	public int pop(){
		int ret = element[--size];
		element[size]=-1;
		return ret;
	}

	private void enchanceCapacity() {
		
		int len = element.length*2;
		element = Arrays.copyOf(element, len);
		
	}
	
	
	
	
	public static void main(String [] args){
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		stack.push(5);
		stack.push(4);
		System.out.println(stack.pop());
	}
}
