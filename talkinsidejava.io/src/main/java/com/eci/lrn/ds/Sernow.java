/**
 * 
 */
package com.eci.lrn.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author nisingh
 *
 */
public class Sernow {

	/**
	 * @param args
	 */
	
	
	// 2 arg - 1 int [1,2,3, 4],  int val=5
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		
		int sum = 6;
		
		
		List<List<Integer>> res = findElementofSume(list, sum);
		
		
		for(List<Integer> l: res) {
			System.out.println(l);
		}

	}
	
	
	
	public static List<List<Integer>> findElementofSume(List<Integer> input, int num) {
		
		List<List<Integer>> ret = new ArrayList<>();
		
		// Collections.sort(input);
		
		
		// int l=0, r=input.size();
		
		for(int i : input) {
			// 6 -1 = 5
			if(input.contains(num-i) && i != num-i) {
				ret.add(Arrays.asList(i, num-i));
				// input.remove(num-i);
			}
				
			
		}
		
		return ret;
		
		
		
	}

}
