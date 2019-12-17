package com.eci.lrn.StringProblems;

public class AltCharFromTwoString {
	
	public static void main(String []args) {
		printAlternateCharFromEachString("ahse ", "bihkPratap");
	}

	
	
	private static void printAlternateCharFromEachString(String s1, String s2) {
		
		int l1 = s1.length(), l2=s2.length();
		
		int dif = Math.abs(l1-l2);
		
		System.out.println(dif);
		
		int i =0,j=0;
		
		while (i<s1.length() && j<s2.length()) {
			
			System.out.print(s1.charAt(i));i++;
			System.out.print(s2.charAt(j));j++;
			
		}
		
		
		if(l1>l2) {
			System.out.println(s1.substring(l2));
		}else {
			System.out.println(s2.substring(l1));
		}
		
		
	}
}
