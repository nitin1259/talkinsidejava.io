/**
 * 
 */
package com.a30day.leetcode;

/**
 * @author nisingh
 *
 */
public class StringReverseUseRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		String revstr = doReverse("something");
		
		System.out.println(" Reverse string:-----> "+ revstr);

	}

	private static String doReverse(String string) {
		
		if(string.isEmpty()) return string;
		
		return doReverse(string.substring(1)) + string.charAt(0);
	}

}
