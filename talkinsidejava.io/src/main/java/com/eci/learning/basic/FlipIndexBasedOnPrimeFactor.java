package com.eci.learning.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlipIndexBasedOnPrimeFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> states = Arrays.asList(0,0,0,0,0,0,0,0,0,0);
		
		List<Integer> flipFactor = Arrays.asList(3,5,12);
		
		List<Integer> flipStates = flipBulbs(states, flipFactor);
		
		
		
		// Set<Integer> pf = findPrimeFactor(6);
		
		// System.out.println(pf);
		
		System.out.println(states);
		System.out.println(flipStates);

	}
	
	public static List<Integer> flipBulbs(List<Integer> states, List<Integer> flipFactor){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(Integer i : flipFactor) {
			Set<Integer> pf = findPrimeFactor(i);
			
			addToMap(map, pf);
			
			System.out.println(pf);
			System.out.println(map);
			
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey());
			int key = entry.getKey(), val = entry.getValue();
			
			if(val%2 != 0) {
				int k = key-1;
				while (k<states.size()) {
					
					states.set(k, (states.get(k)+1)%2);
					k=k+key;
				}
				
			}
			
		}
		
		return states;
	}

	private static Set<Integer> findPrimeFactor(int n) {
		
		Set<Integer> pf = new HashSet<Integer>();
		
		while(n%2 ==0) {
			pf.add(2);
			n=n/2;
		}
		
		for(int i=3; i<= Math.sqrt(n); i=i+2) {
			while(n%i ==0) {
				pf.add(i);
				n=n/i;
			}
		}
		
		if(n>2) {
			pf.add(n);
		}
		
		return pf;
	}
	
	private static void addToMap(Map<Integer, Integer> map, Set<Integer> set) {
		
		for(Integer i: set) {
			if(map.containsKey(i)) map.put(i, map.get(i)+1);
			else map.put(i, 1);
		}
	}

	
}
