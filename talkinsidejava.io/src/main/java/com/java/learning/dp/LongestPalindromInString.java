/**
 * 
 */
package com.java.learning.dp;

/**
 * @author nisingh
 *
 */
public class LongestPalindromInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "initins";
		
		String res = findLongestPalindrome(input);

	}

	private static String findLongestPalindrome(String input) {
		
		int len = input.length();
		int [][] table = new int[len][len];
		int maxLen = 1;
		
		for(int i=0; i<len; i++) {
			table[i][i] = 1;
			
		}
		
		int start = 0;
		for(int i=0; i< len-1; ++i) {
			if(input.charAt(i)==input.charAt(i+1)) {
				table[i][i+1] = 1;
				start = i;
				maxLen =2;
				System.out.println(start);
			}
		}
		
		// Check for lengths greater than 2. k is length 
        // of substring 
		
		for(int k=3; k<len; ++k ) {
			//fix the starting index
			for(int i=0;i<len-k+1; i++) {
				
				// Get the ending index of substring from 
                // starting index i and length k 
				int j = i+k-1;
				
				// checking for sub-string from ith index to 
                // jth index iff str.charAt(i+1) to  
                // str.charAt(j-1) is a palindrome 
				if(table[i+1][j-1]==1 && input.charAt(i)==input.charAt(j)) {
					table[i][j]=1;
					
					System.out.println("i: "+i+" j: "+j+ " k: "+k + " start: "+ start);
					
					if(k>maxLen) {
						start=i;
						maxLen=k;
					}
				}
			}
		}
		
		
		System.out.println("Longest palindrome substring is; "+ input.substring(start, start + maxLen)); 
        // printSubStr(str, start, start + maxLength - 1); 
        
		print2Darray(table, len);
		return input.substring(start, start + maxLen);
	}

	
	private static void print2Darray(int [][] arr, int l) {
		
		for(int i = 0; i<l;i++) {
			for(int j=0; j<l;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
