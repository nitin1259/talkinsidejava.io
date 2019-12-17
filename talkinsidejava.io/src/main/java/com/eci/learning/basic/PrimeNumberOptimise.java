package com.eci.learning.basic;

public class PrimeNumberOptimise {

	
	public static void main(String[]args) {
		int n = 200;
		
		for(int i=1;i<=200;i++) {
		boolean isPrime = checkPrimeNo(i);
		if(isPrime) {
			System.out.println(i+ " :is PRIME");
		}else{
			System.out.println(i+ " :not prime");
		}
		}
	}

	private static boolean checkPrimeNo(int n) {
		
		if(n==0 || n==1) return false;
		for(int i =2; i<=Math.sqrt(n) ;i++)
			if(n%i == 0)return false;
		return true;
	}
}
