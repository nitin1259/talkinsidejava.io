/**
 * 
 */
package com.eci.learning.sorting;

/**
 * @author nsingh
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	static int [] num = {4,8, 2, 19,7, 24,12,54, 23, 1};
	static int [] helper = new int[num.length];
	
	
	public static void main(String[] args) {
		System.out.println("Before sorting array: ");
		printArray(num);
		mergeSort(0, num.length-1);
		System.out.println("After sorting array");
		printArray(num);

	}

	private static void mergeSort(int low, int high){
		if(low < high){
			int mid = low + (high-low)/2;
			
			mergeSort(low, mid); // sort the left side array
			mergeSort(mid+1, high); // sort the right side array
			
			// merging the sorted array
			merge(low, mid, high);
		}
	}
	
	private static void merge(int low, int mid, int high){
		//copy the array into helper array
		for(int i=low;i<=high;i++)helper[i]=num[i];
		
		int i=low,k=low;
		int j=mid+1;
		
		while(i<=mid && j <= high){
			if(helper[i]  < helper[j]){
				num[k] = helper[i];
				i++;
				k++;
			}else{
				num[k]=helper[j];
				j++;
				k++;
			}
		}
		
		while(i<=mid){
			num[k]= helper[i];
			i++;k++;
		}
		
	}
	
	private static void printArray(int [] arr){
		
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+ arr[i]);
		}
		System.out.println(" ");
	}
}
