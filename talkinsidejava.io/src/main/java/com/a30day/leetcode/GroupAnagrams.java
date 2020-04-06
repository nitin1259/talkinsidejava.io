/**
 * 
 */
package com.a30day.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nisingh

	Given an array of strings, group anagrams together.
	
	Example:
	
	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	Output:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note:
	
	All inputs will be in lowercase.
	The order of your output does not matter.
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		String [] inp = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		// String [] inp = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};

		// List<List<String>> list = groupAnagrams(inp);
		List<List<String>> list= groupAnagramsAnother(inp);
		
		list.forEach(e-> System.out.println(e));

		// System.out.println(isAnagramString("cdb".toCharArray(), "dbc".toCharArray()));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
	
		List<List<String>> ret = new ArrayList<List<String>>();
		List<String> visited = new ArrayList<String>();
		for(int i=0; i< strs.length;i++) {
			List<String> list = new ArrayList<String>();
			
			
			if(visited.contains(strs[i])) {
				continue;
			}
			else {
				visited.add(strs[i]); 
				list.add(strs[i]);
			}
			
			for(int j=i+1; j< strs.length;j++) {
				
				if(isAnagramString(strs[i].toCharArray(), strs[j].toCharArray())){
					list.add(strs[j]); visited.add(strs[j]);
				}
				
			}
			ret.add(list);
		}
		
		
		return ret;
    }
	
	private static boolean isAnagramString(char [] str1, char[] str2) {
		
		int [] totalarr = new int[26];
		Arrays.fill(totalarr, 0);
		
		if(str1.length != str2.length) {
			return false;
		}
		int l = str1.length;
		
		for(int i=0; i< l; i++) {
			totalarr[str1[i]-97]++;
			totalarr[str2[i]-97]--;
		}
		
		for(int i=0; i< totalarr.length; i++) {
			if(totalarr[i]!=0) return false;
		}
		
		return true;
	}

	
	public static List<List<String>> groupAnagramsAnother(String[] strs) {
	       int n = strs.length;        
	        
	        HashMap<String, Integer> map = new HashMap<>();
	        
	        List<List<String>> list = new ArrayList<>();
	        
	        int count = 0;
	        
	        for(int i=0;i<n;i++){
	            char[] c = strs[i].toCharArray();
	            Arrays.sort(c);
	            String s = String.valueOf(c);
	            
	            if(map.containsKey(s)){
	                int l = map.get(s);
	                list.get(l).add(strs[i]);
	            }else{
	                List<String> w = new ArrayList<>();
	                w.add(strs[i]);
	                
	                list.add(w);
	                map.put(s, count++);
	            }
	        }
	        return list;
	    }
}
