package com.java.freelance.julianne.Calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReverseWordinString {
	
	
	
	// abcdefght, 3 -> abc,bcd,  def, fgh, 

	public static void main(String[] args) {
		
		
//		String input = "This is the hello world";
//		
//		char [] charr = input.toCharArray();
//		
//		
//		String output="";
//		
//		
//		for (int i= charr.length-1; i>=0; i--) {
//			
//			
//			int k = i;
//			
//			while(i>=0 && charr[i]!= ' ') {
//				i--;
//			}
//			
//			int j=i+1;
//			
//			
//			while (j<=k) {
//				
//				
//				output = output + charr[j];
//				j++;
//			}
//			
//			output = output +  " ";
//			
//		}
//		
//		
//		System.out.println(output);
		
		
		
		
		
		
		String input = "defgnaaabc"; //  def efg fgn gna nab, abc
		
		int l = 3;
		List<String> list = new ArrayList<String>();
		
		for (int i= 0; i< input.length()-2; i++) {
			
			list.add(input.substring(i, i+3));
		}
		
		
			list.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			});
		
		  System.out.println(list.get(0)+ " - " + list.get(list.size()-1));
		
		
		

	}

}



