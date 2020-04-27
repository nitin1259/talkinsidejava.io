package com.a30day.leetcode;
import java.util.List;

/**
 * 
 */

/**
 * @author nisingh
 *
 *
	448. Find All Numbers Disappeared in an Array

	Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	
	Find all the elements of [1, n] inclusive that do not appear in this array.
	
	Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
	
	Example:
	
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[5,6]
 */
public class LC448AllNumDisapperedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> list= findDisappearedNumbers(nums);
		
	}

	private static List<Integer> findDisappearedNumbers(int[] nums) {
		
		int len = nums.length;
		for(int i = 0; i< len ;i++) {
			
		}
        
		return null;
    }
}
