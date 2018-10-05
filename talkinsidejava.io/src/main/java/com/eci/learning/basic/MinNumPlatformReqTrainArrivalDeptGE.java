/**
 * 
 */
package com.eci.learning.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nsingh
 *
 *
 *Minimum Number of Platforms Required for a Railway/Bus Station
Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop

Examples:

Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
There are at-most three trains at a time (time between 11:00 to 11:20)

http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class MinNumPlatformReqTrainArrivalDeptGE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[]  = {900,  940, 950,  1100, 1500, 1800};
        int dep[]  = {910, 1200, 1120, 1130, 1900, 2000};
        
        System.out.println("Min platform Required: "+ minPlatformReqCalculation(arr, dep));

	}
	
	public static int minPlatformReqCalculation(int [] arr, int  [] dept){
		return 0;
	}
	
	
}
