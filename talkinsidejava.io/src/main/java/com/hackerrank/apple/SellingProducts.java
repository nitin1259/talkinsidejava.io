package com.hackerrank.apple;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SellingProducts {

	public static void main(String[] args) {
		// find the minimum distinct ids left if we take out m number of ids from array
		
		int [] input = {1,2,2,3,1,1};
		
		int m=2; // number of ids to take out
		
		distinctIds(input, m);

	}
	
	
	public static int distinctIds(int []input, int m) {
		
		Map<Integer, Integer> countmap = new HashMap<>();
		
		for(int i=0;i < input.length ;i++) {
			if(countmap.get(input[i])==null) {
				countmap.put(input[i], 1);
			}else {
				countmap.put(input[i], countmap.get(input[i])+1);
			}
		}
		
		Map<Integer, Integer> sortMap = sortByValue(countmap);
		
		
		printMap(sortMap);
		
		int count = 0;
		for (Map.Entry<Integer, Integer> set: sortMap.entrySet()) {
			if(set.getValue()<= m && count+set.getValue() <= m)
			{
				System.out.println(set.getValue() +":="+count);
				count += set.getValue();
				countmap.remove(set.getKey());
			}
			else 
				break;
		}
		
		
		System.out.println(countmap.size());
		return countmap.size();

	}
	
	public static HashMap<Integer, Integer> sortByValue(Map<Integer, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 

	
	public static void printMap(Map<Integer, Integer> countmap) {
for (Map.Entry<Integer, Integer> entryset : countmap.entrySet()){
			
			System.out.println(entryset.getKey()+ ":" + entryset.getValue());
		}
	}
}
