/**
 * 
 */
package com.eci.lrn.ArrayProblems;

/**
 * @author nsingh
 *
 */
public class A1A2A3B1B2B3ToA1B1A2B2A3B3 {

	/**
	 * 	Suppose an array is of the form [i1,i2,i3,i4,c1,c2,c3,c4] where i[1..n] is 
       	a set of integer elements and c[1..n] is another set of integer elements. 
       	Write an in place algorithm so that the resulting array is of the form 
		[i1,c1,i2,c2,i3,c3,i4,c4]. State optimized time and space complexities.
    	Example: array: [1,2,3,4,11,12,13,14] should become [1,11,2,12,3,13,4,14].
    	
    	http://onestopinterviewprep.blogspot.in/2014/03/a1a2a3b1b2b3-to-a1b1a2b2a3b3-in-place.html
	 */
	public static void main(String[] args) {
		String str="abcdpqrs";
		System.out.println("before conversion"+str);
		System.out.println("after conversion: "+convertString(str));

	}

	public static String convertString(String str){
		char [] arr = str.toCharArray();
		int n=arr.length/2;
		char temp;
		for(int i=n-1;i>0;i--){
			for(int j=n-1;j+i>=n;j--){
				temp=arr[j];
				arr[j]=arr[i+j];
				arr[i+j]=temp;
			}
		}
		return new String(arr);
	}
}
