package com.eci.lrn.ArrayProblems;

import java.util.ArrayList;
import java.util.List;


/*
 * Program to print a number in an array only if sum of two numbers are present in array
 * 
 */
public class SumOfTwoNumPresentInArray {

	public static void main(String[] args) {
		List<Integer> outList = doCalculation(new int[]{1,2,3,6,9,13,5});
		for(int i : outList)
			System.out.println(i);

	}
	
	public static List<Integer> doCalculation(int [] inputArr){
		List<Integer> outList = new ArrayList<Integer>();
		for(int i : inputArr){
			for(int j: inputArr){
				if(j>i)
					continue;
				else{
					System.out.println("i:"+i+" j:"+j);
					if(checkNoInArray(i, j, inputArr)){
						outList.add(i);
						break;
					}
				}
			}
		}
		return outList;
	}
	
	public static boolean checkNoInArray(int i, int j, int [] inputArr){
		for(int n: inputArr){
			if(n==i||n==j)
				continue;
			if((i-j)==n)
				return true;
		}
		return false;
	}

}
