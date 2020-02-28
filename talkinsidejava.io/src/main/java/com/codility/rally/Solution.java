package com.codility.rally;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author nisingh
 *
 *
 *
James is a businessman. He is on a tight schedule this week. The week starts on Monday at 00:00 and ends on Sunday at 24:00. His schedule consists of M meetings he needs to take part in. Each of them will take place in a period of time, beginning and ending on the same day (there are no two ongoing meetings at the same time). James is very tired, thus he needs to find the longest possible time slot to sleep. In other words, he wants to find the longest period of time when there are no ongoing meetings. The sleeping break can begin and end on different days and should begin and end in the same week.
You are given a string containing M lines. Each line is a substring representing one meeting in the schedule, in the format " Ddd hh:mm-hh:mm". "Ddd" is a three-letter abbreviation for the day of the week when the meeting takes plaMon" (Monday), "Tue", "Wed", "Thu", "Fri", "Sat", "Sun". "hh:mm-hh:mm" means the beginning time and the ending time of the meeting (from 00:00 to 24:00 inclusive).
The given times represent exact moments of time. So, there are exactly five minutes between 13:40 and 13:45.
For example, given a string:
"Sun 10:00-20:00
Fri 05:00-10:00
Fri 16:30-23:50
Sat 10:00-24:00
Sun 01:00-04:00
Sat 02:00-06:00
Tue 03:30-18:15
Tue 19:00-20:00
Wed 04:25-15:14
Wed 15:14-22:40
Thu 00:00-23:59
Mon 05:00-13:00
Mon 15:00-21:00"
the longest time slot when James can sleep is 505 minutes, since James can sleep from Tuesday 20:00 to Wednesday 04:25, which gives 8 hours and 25 minutes = 505 minutes.
Also, for a string:
"Mon 01:00-23:00
Tue 01:00-23:00
Wed 01:00-23:00
Thu 01:00-23:00
Fri 01:00-23:00
Sat 01:00-23:00
Sun 01:00-21:00"
 James should sleep on Sunday from 21:00 to 24:00 (180 minutes).
Write a function:
int solution(char *S);
that, given a string S representing the schedule, returns the length of the longest time slot when James can sleep (in minutes).
Assume that:
M is an integer within the range [1..100];
Each line of the input string is in the format "Ddd hh:mm-hh:mm" and lines are separated with newline characters;
There cannot be two ongoing meetings at any time;
Each meeting lasts at least 1 minute.
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = solution("Mon 01:00-23:00\n" + 
				"Tue 01:00-23:00\n" + 
				"Wed 01:00-23:00\n" + 
				"Thu 01:00-23:00\n" + 
				"Fri 01:00-23:00\n" + 
				"Sat 01:00-23:00\n" + 
				"Sun 01:00-21:00");
		
		System.out.println("rsult: "+i);
		
		int j = solution("Sun 10:00-20:00\n" + 
				"Fri 05:00-10:00\n" + 
				"Fri 16:30-23:50\n" + 
				"Sat 10:00-24:00\n" + 
				"Sun 01:00-04:00\n" + 
				"Sat 02:00-06:00\n" + 
				"Tue 03:30-18:15\n" + 
				"Tue 19:00-20:00\n" + 
				"Wed 04:25-15:14\n" + 
				"Wed 15:14-22:40\n" + 
				"Thu 00:00-23:59\n" + 
				"Mon 05:00-13:00\n" + 
				"Mon 15:00-21:00");
		
		System.out.println("rsult: "+j);
		
		
	}
	

	    public static int solution(String S) {
	        // write your code in Java SE 8
	    	
	    	Map<String, Integer> map = new HashMap<>();
	    	
	    	map.put("Mon", 0);
	    	map.put("Tue", 1);
	    	map.put("Wed", 2);
	    	map.put("Thu", 3);
	    	map.put("Fri", 4);
	    	map.put("Sat", 5);
	    	map.put("Sun", 6);
	    	
	    	
	    	int [][] timearr = new int[7][24*60];
	        
	        String [] arr = S.split("\n");
	        System.out.println(arr);
	        
	        for (String str: arr){
	        	// String main = str;
	            // System.out.println(str);
	            
	            String day = str.substring(0,3);
	            
	            // System.out.println(day);
	            
	            int i = map.get(day);
	            // System.out.println(str);
	            // System.out.println(Integer.parseInt(str.substring(7,9)));
	            
	            int intime = (Integer.parseInt(str.substring(4,6))*60) + Integer.parseInt(str.substring(7,9)) ;
	            // System.out.println(intime);
	            
	            int outtime = (Integer.parseInt(str.substring(10,12))*60) + Integer.parseInt(str.substring(13,15)) ;
	            // System.out.println(outtime);
	            
	            for (int j = intime ; j< outtime; j++) {
	            	timearr[i][j]=1;
	            }
	            
	            
	        }
	        
	        
	        return pirntarr(timearr);
	    }
	
	    static int pirntarr(int[][] arr){
	    	
	    	
	    	
	    	int count = 0; 
	        int result = 0; 
	      
	       
	      
	        
	    	
	    	
	    	for(int i=0; i<7; i++ ) {
	    		for(int j=0; j<24*60; j++ ) {
	    			if (arr[i][j] == 1) 
		                count = 0; 
	    			else
		            { 
		                count++;//increase count 
		                result = Math.max(result, count); 
		            } 
		    	}
	    	}
	    	
	    	
	    	return result;
	    }

}
