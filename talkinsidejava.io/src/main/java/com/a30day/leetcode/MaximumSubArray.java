/**
 * 
 */
package com.a30day.leetcode;

/**
 * @author nisingh
 *
 *
 *         Given an integer array nums, find the contiguous subarray (containing
 *         at least one number) which has the largest sum and return its sum.
 * 
 *         Example:
 * 
 *         Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has
 *         the largest sum = 6. Follow up:
 * 
 *         If you have figured out the O(n) solution, try coding another
 *         solution using the divide and conquer approach, which is more subtle.
 * 
 * 
 */
public class MaximumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int sum = findContigousArrayMaxSum(input);
		System.out.println(sum);

	}

	// applying the kadence 
	private static int findContigousArrayMaxSum(int[] input) {
		int retmax = input[0];
		int currmax = input[0];
		if (input.length == 0)return 0;
		if (input.length == 1)return input[0];
		for (int i = 1; i < input.length; i++) {
			currmax = Math.max(input[i], currmax + input[i]);
			// retmax = Math.max(retmax, currmax);
			if (retmax < currmax) retmax = currmax;

		}
		return retmax;

	}

}
