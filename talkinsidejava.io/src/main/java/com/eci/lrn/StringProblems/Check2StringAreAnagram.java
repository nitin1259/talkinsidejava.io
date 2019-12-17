package com.eci.lrn.StringProblems;

public class Check2StringAreAnagram {

	
	public static void main(String [] args) {
		
		
		
		boolean check = checkForAnagramString("silent", "listen");
		System.out.println("check: "+check);
	}

	private static boolean checkForAnagramString(String s1, String s2) {
		
		int l1 = s1.length(), l2= s2.length();
		
		int dif = l1-l2;
		
		if(dif!=0) return false;
		else {
		
			int [] count = new int [26];
			int i=0;
			while (i<l1) {
				
				count[s1.charAt(i)-97] += 1;
				count[s2.charAt(i)-97] -= 1;
				i++;
				
			}
			
			for (int j=0; j<26; j++) {
				// System.out.println("index: "+j + " : "+count[j]);
				if(count[j]!=0) return false;
			}
			
			
			return true;
		}
		
	}
}
