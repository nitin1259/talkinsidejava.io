package com.codility.rally;

public class FindmaximumContinousZeros {
	
	
	public static void main(String []args) {
		
		int [] arr = {1,1,1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1};
		int count= 0, result=0;
		for(int i =0; i< arr.length; i++) {
			if(arr[i]==1) count=0;
			else {
				count++;
				result = Math.max(result, count);
			}
		}
		
		System.out.println(result);
	}
}
