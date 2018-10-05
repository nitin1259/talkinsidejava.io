/**
 * 
 */
package com.java.learning.salesforce;

import java.util.Stack;

/**
 * @author sinni14
 *
 */
public class StockSpanProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int price[] = {100, 80, 60, 70, 60, 75, 85};
		func(price);
	}

	public static void func(int arr[]) {

		// push first element
		Stack<Integer> s = new Stack<>();
		s.push(0);

		// and make its span as 1 as it is first element
		int S[] = new int[arr.length];
		S[0] = 1;

		for (int i = 1; i < arr.length; i++) {

			// while you don't find element smaller than previous element, keep poping
			// we are doing this as lower element which occur at previous indexes should be
			// added to
			// span of bigger price day
			System.out.println("arr["+s.peek()+"] <= arr["+ i +"] : " + arr[s.peek()] +" <= "+ arr[i]);
			while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
				System.out.println("s.pop(): "+s.pop());
				// s.pop();
			}

			// this handles two cases
			// 1) when there is no element in the stack: simply i+1 as no all previous
			// elements will be smaller thats why they were popped out

			// 2) if not empty, keep popping in above step till you reach something bigger
			// that can not
			// be added to span of current observed element
			S[i] = s.isEmpty() ? (i + 1) : i - s.peek();

			// afterwards push element
			s.push(i);
		}

		for (int x : S)
			System.out.print(x + " ");
		System.out.println("");
	}

}
