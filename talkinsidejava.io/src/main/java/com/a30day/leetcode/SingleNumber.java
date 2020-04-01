/**
 * 
 */
package com.a30day.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nisingh
 *
 */
public class SingleNumber {

	/**
	 * @param args
	 * 
	 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

		Note:
		
		Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
		
		Example 1:
		
		Input: [2,2,1]
		Output: 1
		Example 2:
		
		Input: [4,1,2,1,2]
		Output: 4
	 */
	
	
	
	// solution  - unique num sum *2 - sum of all num
	public static void main(String[] args) {
		
		//int [] arr = {2,2,1};
		int [] arr = {4,1,2,1,2};
		
		System.out.println(findSingleElement(arr));
		

	}

	public static int findSingleElement(int[] input) {
		Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
		for(int i: input) {
			if (cnt.containsKey(i))
				cnt.put(i, cnt.get(i)+1);
			else
				cnt.put(i, 1);
			
		}
		
		for(Map.Entry<Integer, Integer> e: cnt.entrySet()) {
			if(e.getValue()==1)
				return e.getKey();
		}
		
		return 0;
	}
}
