/**
 * 
 */
package com.eci.lrn.ArrayProblems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author nsingh
 * 
 * 
 * Find all distinct palindromic sub-strings of a given string
	Given a string of lowercase ASCII characters, find all distinct continuous palindromic sub-strings of it.
	Examples:
	Input: str = "abaaa"
	Output:  Below are 5 palindrome sub-strings
	a
	aa
	aaa
	aba
	b
	
	Input: str = "geek"
	Output:  Below are 4 palindrome sub-strings
	e
	ee
	g
	k
 *
 */
public class FindAllDistinctPalindromSubStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(String str : palindromes("abba"))
			System.out.println(str);

	}

	 public static Set<String> palindromes(final String input) {

	     final Set<String> result = new HashSet<String>();

	     for (int i = 0; i < input.length(); i++) {
	         // expanding even length palindromes:
	         expandPalindromes(result,input,i,i+1);
	         // expanding odd length palindromes:
	         expandPalindromes(result,input,i,i);
	     } 
	     return result;
	  }

	  public static void expandPalindromes(final Set<String> result, final String s, int i, int j) {
	      while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
	            result.add(s.substring(i,j+1));
	            i--; j++;
	      }
	  }
	  
	  
	  // another solution in java
	  
	  /*private static void subPal(String str) {
	        String s1 = "";
	        int N = str.length(), count = 0;
	        Set<String> palindromeArray = new HashSet<String>();
	        System.out.println("Given string : " + str);
	        System.out.println("******** Ignoring single character as substring palindrome");
	        for (int i = 2; i <= N; i++) {
	            for (int j = 0; j <= N; j++) {
	                int k = i + j - 1;
	                if (k >= N)
	                    continue;
	                s1 = str.substring(j, i + j);
	                if (s1.equals(new StringBuilder(s1).reverse().toString())) {
	                    palindromeArray.add(s1);
	                }
	            }

	        }
	        System.out.println(palindromeArray);
	        for (String s : palindromeArray)
	            System.out.println(s + " - is a palindrome string.");
	        System.out.println("The no.of substring that are palindrome : "
	                + palindromeArray.size());
	    }*/
}
