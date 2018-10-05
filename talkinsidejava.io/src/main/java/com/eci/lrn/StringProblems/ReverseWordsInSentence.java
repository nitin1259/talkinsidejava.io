/**
 * 
 */
package com.eci.lrn.StringProblems;

/**
 * @author nsingh
 *
 */
public class ReverseWordsInSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reverseString("My name is Akbar");

	}
	
	public static String reverseString(String input){
		char [] charArr = input.toCharArray();
		int n=charArr.length;
		for(int i=0;i<n/2;i++){
			char temp=charArr[i];
			charArr[i]=charArr[n-1-i];
			charArr[n-1-i]=temp;
		}
		int start=0;
		for(int i=0;i<n;i++){
			
			if(charArr[i]=='\0' ||charArr[i]==' '){
				swapChar(charArr,start, i-1);
				start=i+1;
			}
		}
		
		for(int i=0;i<n;i++){
			System.out.print(charArr[i]);
		}
		return null;
	}

	private static void swapChar(char[] charArr, int start, int end) {
		System.out.println("Start: "+start+ " end: "+end);
		while(start<end){
			char temp = charArr[start];
			charArr[start++] = charArr[end];
			charArr[end--]=temp;
		}
		
	}

}
