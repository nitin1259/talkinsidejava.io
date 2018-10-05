package com.oracle.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Checks if a string is a palindrome.
 *
 * Palindrome is a word, phrase or sentence that reads the same backward or
 * forward. For example, the following string is a palindrome: "Madam, I'm Adam."
 */
public class PalindromeUtil {
	/**
	 * Checks whether passed String is a palindrome or not.
	 *
	 * Requirements:
	 * - Limit the amount of additional consumed memory to O(1).
	 * - Limit complexity to O(n).
	 *
	 * @return true if passed string is palindrome, false - otherwise
	 */
	
	public static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i <= j) {
			if (isSpecialChar(str.charAt(i))) {
				i++;
				continue;
			}
			if (isSpecialChar(str.charAt(j))) {
				j--;
				continue;
			}
			if (!(Math.abs((int) str.charAt(i) - (int) str.charAt(j)) == 32 || Math
					.abs((int) str.charAt(i) - (int) str.charAt(j)) == 0))
				return false;
			else {

				i++;
				j--;
			}
		}
		return true;

	}
	
	private static boolean isSpecialChar(char charAt) {
		int cint = (int)charAt;
	    if(cint <48 || (cint > 57 && cint < 65) || (cint > 90 && cint < 97) || cint > 122)
	    	return true;
	    else
	    	return false;
	}

	private static String sanitize(String in) {
		Pattern p = Pattern.compile("[^a-zA-Z0-9]+");
	    Matcher m = p.matcher(in);
	    return m.replaceAll("");
	 }
	
	public static void main(String [] args){
		System.out.println(isPalindrome("Mada2m, I'm 2Adam."));
		System.out.println(isPalindrome("Ab,c,de!$p3!p^&*(ed$@c'b>>a"));
		System.out.println("sanitize: "+sanitize("Madam, I'm Adam."));
		
		/*List<String> list = new ArrayList<String>();
		Iterator<String> it = list.iterator();*/
	}
	
	
	/*public static boolean isPalindrome(String str) {
		int n = str.length();
		  for (int i = 0; i < (n/2); ++i) {
		     if (str.charAt(i) != str.charAt(n - i - 1)) {
		         return false;
		     }
		  }

		  return true;
	}*/
}

