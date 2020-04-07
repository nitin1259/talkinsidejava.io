/**
 * 
 */
package com.a30day.leetcode;

import java.util.Arrays;

/**
 * @author nisingh
	Given an integer array arr, count element x such that x + 1 is also in arr.
	
	If there're duplicates in arr, count them seperately.
	
	Example 1:
	
	Input: arr = [1,2,3]
	Output: 2
	Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
	Example 2:
	
	Input: arr = [1,1,3,3,5,5,7,7]
	Output: 0
	Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
	Example 3:
	
	Input: arr = [1,3,2,3,5,0]
	Output: 3
	Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
	Example 4:
	
	Input: arr = [1,1,2,2]
	Output: 2
	Explanation: Two 1s are counted cause 2 is in arr.
	 
	
	Constraints:
	
	1 <= arr.length <= 1000
	0 <= arr[i] <= 1000
 */
public class CountingNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int [] arr = {1,2,3};
		// int [] arr = {1,1,3,3,5,5,7,7};
		// int [] arr = {1,3,2,3,5,0};
		 int [] arr = {1,1,2,2};
		
		int cnt = countElements(arr);
		System.out.println("cnt: "+ cnt);
	}
	
	
	public static int countElements(int[] arr) {
		int cnt=0;
		int l = Arrays.stream(arr).max().orElse(0);
		// System.out.println("l: "+l);
		int [] inarr = new int[l+1];
		
		for(int i=0; i<arr.length;i++) {
			inarr[arr[i]]++;
		}
		
		// for(int i: inarr) System.out.println(i);
		
		for(int i=0; i < l;i++) {
			
			if(inarr[i+1]!=0) {
				cnt += inarr[i];
				// System.out.println("i:"+i+" cnt:"+cnt);
			}
		}
		
		
		// for(int i: inarr) System.out.println(i);
		
		return cnt;
	}
}
