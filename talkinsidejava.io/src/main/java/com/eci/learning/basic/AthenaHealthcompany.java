/**
 * 
 */
package com.eci.learning.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nsingh
 *
 */
public class AthenaHealthcompany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//System.out.println(firstRepeatchar("He had had quire enough of this nonsense"));
		System.out.println("max sum :"+ maxMoney(2, 2));

	}
	
	// Money collection from classmate.
	static int maxMoney(int n, long k) {
        
        int maxSum=0;
        int totalSum=0;
	        for(int i=1; i<=n;i++){
	        	totalSum +=i;
	        	if(totalSum == k)
	        		break;
	        }
	        maxSum = maxSum<totalSum ? totalSum : maxSum;
	        
	        totalSum = 0;
	        for(int i=2; i<=n;i++){
	        	totalSum +=i;
	        }
	        maxSum = maxSum<totalSum ? totalSum : maxSum; 
        
        /*totalSum = 0;
        for(int i=1; i<=n;i++){
        	if(totalSum+i==k)
        		continue;
        	else
        		totalSum = totalSum+i;
        }
        maxSum = maxSum<totalSum ? totalSum : maxSum;*/
        return maxSum;
    }
	
	
	//first repeatitive word in the sentence
	static String firstRepeatchar(String s){
		
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		
		String [] strArr = s.split(" ");
		
		for (String str : strArr){
			if(!countMap.containsKey(str)){
				countMap.put(str, 1);
			}else{
				countMap.put(str, countMap.get(str)+1);
			}
		}
		for (String str : strArr){
			if(countMap.get(str)>1)
				return str;
		}
		return null;
	}

}
