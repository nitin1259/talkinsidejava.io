/**
 * 
 */
package com.java.brillio.interview;

/**
 * @author nisingh
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	
	// write a interface which can accept any two Number of same type of double, int, long and return the result of same type.
	public static void main(String[] args) {
		
		System.out.println(AddNumber.add(2, 3));

	}

}

class AddNumber{
	
	
	public static <T extends Number> T add(T t1, T t2){
		
			Double sum;
		  sum = t1.doubleValue() + t2.doubleValue();
		  return (T) sum;
		
	}
}
