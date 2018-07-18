/**
 * 
 */
package com.eci.lrn.ArrayProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author nsingh
 *
 */
public class FindStudentRank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] marks = {2,1,3,1,5,2,9,4};
		
		System.out.println("Marks: "+findRank(marks,4));

	}

	private static int findRank(int[] marks, int rank){
	    List<Integer> lst = new ArrayList<Integer>();
	    int[] ranks=new int[marks.length]; // maximum length for already unique array
	    for(int d:marks)
	        if (lst.indexOf(d) == -1) //only unique elements in list
	            lst.add(d);

	    Collections.sort(lst);
	    for(int i=0;i<marks.length;i++) {
	        ranks[i]=lst.indexOf(marks[i]);
	    }
	    Map<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
	    for (int i=0;i<marks.length;i++){
	    	rankMap.put(ranks[i], marks[i]);
	    }
	    
	    
	    /*for (Map.Entry<Integer, Integer> entry : rankMap.entrySet())
	    	System.out.println(entry.getKey() +" : "+entry.getValue());*/
	    int size = rankMap.size();
	    if(rankMap.get(size-rank)!=null)
	    	return rankMap.get(size-rank);
	    else
	    	return 0;
	}
	
	
	
}
