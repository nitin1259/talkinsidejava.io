package com.eci.lrn.StringProblems;

import java.util.concurrent.ConcurrentHashMap;

public class ReverseStringRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String res = reverseString("Sachine");
		
		System.out.println(res);
		
		

	}

	private static String reverseString(String str) {
		
		if(str.isEmpty()) {
			System.out.println("String is now empty");
			return str;
		}
		
		System.out.println("String left with reverse: "+ str.substring(1));
		return reverseString(str.substring(1))+ str.charAt(0);
	}

}
