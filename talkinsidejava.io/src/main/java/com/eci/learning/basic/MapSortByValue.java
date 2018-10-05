/**
 * 
 */
package com.eci.learning.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author nsingh
 *
 */
public class MapSortByValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		myMap.put(10, "sachin");
		myMap.put(4, "kapil");
		myMap.put(2, "amit");
		myMap.put(7, "nitin");
		myMap.put(13, "anil");
		myMap.put(6, "deepak");
		System.out.println("Before value sorting");
		printMap(myMap);
		
		Set<Entry<Integer, String>> setOfEntry = myMap.entrySet();
		
		List<Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer,String>>(setOfEntry);
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> o1,
					Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
				
			}
		});
		
		Map<Integer, String> result = new LinkedHashMap<Integer, String>();
		for(Map.Entry<Integer, String> entry : list)
			result.put(entry.getKey(), entry.getValue());
		
		//this is to get all the keys whose value consists of certain given input string as a sub-string.
		/*Map<Integer, String> result = new LinkedHashMap<Integer, String>();
		for(Map.Entry<Integer, String> entry : list){
			if(entry.getValue().contains("il"))
			result.put(entry.getKey(), entry.getValue());
		}*/
		
		System.out.println("print after value sort");
		printMap(result);
		
	}

	private static void printMap(Map<Integer, String> myMap) {
		for(Map.Entry<Integer, String> entry : myMap.entrySet())
			System.out.println(entry.getKey()+ " : "+entry.getValue());
		
	}

}
