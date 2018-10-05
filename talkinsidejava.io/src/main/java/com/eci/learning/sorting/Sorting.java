/**
 * 
 */
package com.eci.learning.sorting;

/**
 * @author nsingh
 *
 *bubble, selection, insertion, quick, merge
 *
 */
public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] input = {45,23,11,89,77,98,4,28,65,43};
		System.out.println("Before Sorting:");
		printArray(input);
		System.out.println("After bubble Sorting:");
		printArray(bubbleSorting(input));
		
		System.out.println("After selection Sorting:");
		printArray(selectionSorting(input));
	}

	private static int [] bubbleSorting( int [] inArr){
		//compare 0 to 1 and 1 to 2 and 2 to 3 etc
		int temp=0;
		for(int i=0; i< inArr.length-1;i++){
			for(int j=0; j< inArr.length-1-i;j++){
				if(inArr[j]>inArr[j+1]){
					temp = inArr[j];
					inArr[j] = inArr[j+1];
					inArr[j+1]=temp;
				}
			}
		}
		
		return inArr;
	}

	private static int[] selectionSorting(int[] inArr) {
		// select the minimum element and put it at right position.
		int temp = 0;
		int min;
		for (int i = 0; i < inArr.length; i++) {
			min = i;
			for (int j = i + 1; j < inArr.length; j++) {
				if (inArr[j] < inArr[min])
					min = j;
			}
			temp = inArr[i];
			inArr[i] = inArr[min];
			inArr[min] = temp;
		}
		return inArr;
	}
	private static int [] insertionSorting( int [] inArr){
		//http://www.studytonight.com/data-structures/insertion-sorting
		return null;
	}
	
	
	private static void printArray(int [] arr){
		
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+ arr[i]);
		}
		System.out.println(" ");
	}
}
