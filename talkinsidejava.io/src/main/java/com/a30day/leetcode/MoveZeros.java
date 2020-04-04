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
		int [] input = {0,1,0,0,0,0,4,7,0,2,3,12};
		
		moveZeroes(input);
	}

	// solution with extra array space
	private static void moveZeroes(int[] nums) {
		
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
}
