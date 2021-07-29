/**
 * 
 */
package com.a30day.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nisingh
 *
 *	Write an algorithm to determine if a number is "happy".

	A happy number is a number defined by the following process: Starting with any positive integer,
	 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
	  or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
	
	Example: 
	
	Input: 19
	Output: true
	Explanation: 
	1^2 + 9^2 = 82
	8^2 + 2^2 = 68
	6^2 + 8^2 = 100
	1^2 + 0^2 + 02 = 1
 *
 */
public class HappyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n =2;
		
		System.out.println(findHappyNumber(n));
	}

	private static boolean findHappyNumber(int n) {
		List<Integer> ls = new ArrayList<Integer>();
		while (n>=1) {
			int res = findSquareandSum(n);
			System.out.println("res: "+ res);
			if(res==1) {
				return true;
			}else if(ls.contains(res)){
				return false;
			}else {
				ls.add(res);
				n = res;
			};
		}
		
		
		return false;
	}

	private static int findSquareandSum(int n) {
		int res = 0;
		while(n>0) {
			int r = n%10;
			res += (r*r);
			n = n/10;		
		}
		return res;
	}

}
