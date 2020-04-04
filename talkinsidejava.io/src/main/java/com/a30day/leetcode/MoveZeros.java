/**
 * 
 */
package com.a30day.leetcode;

/**
 * @author nisingh
 *
	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	
	Example:
	
	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]
	Note:
	
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
 */
public class MoveZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int [] input = {0,1,0,0,0,0,4,7,0,2,3,12};
		int [] input = {0,1,0,3,12};
		
		// moveZeroesWithExtraSpace(input);
		noveZeros(input);
	}

	// solution with extra array space
	private static void moveZeroesWithExtraSpace(int[] nums) {
		
		int [] res = new int[nums.length];
		int index = 0;
		for(int i=0; i<nums.length; i++) {
			
			if(nums[i]!=0) res[index++] = nums[i];
			else {
				res[nums.length-i-1]= 0;
			}
			
		}
		
		for(int i: res) {
			System.out.println(i);
		}
    }
	
	// Runtine: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
	private static void noveZeros(int [] nums) {
		
		int runningIndex = 0;
		
		for(int i = 0; i< nums.length;i++) {
			
			if(nums[i]!= 0) nums[runningIndex++]=nums[i];
			
		}
		while(runningIndex<nums.length) {
			nums[runningIndex++]=0;
		}
		
		for(int i: nums) {
			System.out.println(i);
		}
	}
}
