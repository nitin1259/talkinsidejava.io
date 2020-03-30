/**
 * 
 */
package com.java.brillio.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author nisingh
 *
 */
public class Sol2 {

	/**
	 * @param args
	 */
	
	
	// list of int
	// find factorial of int 
	// sqr fact
	// arrang in desceding order
	
	//later maintain thread safety.
	// maintaine thread safety...
	
	public static void main(String[] args) {
		
		
		List<Integer> list = Arrays.asList(4, 20 ,14,5,17,8);
		
		
		List<Integer> res =  doOperation(list);
	}
	
	public static List<Integer> doOperation(List<Integer> inputlist){
		
		
		List<Integer> res1 =  inputlist.stream().map(e -> {return findFactorial(e);}).map(e-> Math.sqrt(e)).sorted((e1, e2)-> e2.compareTo(e1)).map(e -> e.intValue()).collect(Collectors.toList());
		res1.forEach(System.out::println);
		
		List<Integer> res2 =  inputlist.stream()
				.map(e -> e*2)
				.map(e-> Math.sqrt(e))
				.sorted((e1, e2)-> e2.compareTo(e1))
				.map(e -> e.intValue())
				.collect(Collectors.toList());
		res2.forEach(System.out::println);
		
		List<Double> ret3 = new ArrayList<Double>();
		
		inputlist.forEach(e->{
			
			long num;
			double d;
			
			synchronized (Integer.class) {
				 num = findFactorial(e);
			}
			
			synchronized (Double.class) {
				 d = findSquareRoot(num);
			}
			
			ret3.add(d);
			
		});
		
		// Collections.sort(ret3);
		
		
		ret3.forEach(System.out::println);
		
		
		return res2;
		
	}
	
	
	
	public static long findFactorial(int n) {
		
		long res = 1;
		for(int i=2; i< n;i++) {
			
			res = res* i;
			
		}
		return res;
		
	}
	
	
	public static double findSquareRoot (long n) {
		
		return Math.sqrt(n);
	}
	

}
