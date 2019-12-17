package com.eci.learning.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoCountriesTeamFactorial {

	
	public static void main(String[] args) {
		
		List<Integer> list = maxStrength(540);
		
		// System.out.println(findNextNum(169));
		// System.out.println(findNextNum(1454));
		
		int max = Collections.max(list) * list.size();
		
		System.out.println(max);
		
	}
	
	private static List<Integer> maxStrength(int n) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		int x1 = n;
		list.add(x1);
		int x2 = findNextNum(x1);
		System.out.println(x1 +" : "+list.indexOf(x1));
		while (list.indexOf(x2)==-1) {
			int x3 = findNextNum(x2);
			System.out.println("x3: "+x2);
			list.add(x2);
			x2=x3;
		}
		System.out.println(list);
		return list;
	}
	
	private static int findNextNum(int n) {
		
		int r=0;
		
		while(n>0) {
			
			r = r+fact(n%10);
			n = n/10;
		}
		return r;
	}
	
	
	
	private static int fact(int n) {
		if(n>1) {
			return n * fact(n-1);
		}
		return 1;
	}
}
