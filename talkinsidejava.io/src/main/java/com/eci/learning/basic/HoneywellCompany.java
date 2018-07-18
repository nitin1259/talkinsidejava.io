/**
 * 
 */
package com.eci.learning.basic;

import java.util.Scanner;

/**
 * @author nsingh
 *
 */
public class HoneywellCompany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int [] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
            //System.out.print (arr[i] + " " );
        }
        
        int q = s.nextInt();
        
        for (int i = 0; i < q; i++) {
        	int j = s.nextInt();
        	int k = s.nextInt();
        	doSwaping(arr, N, j-1, k-1);
        }

        for (int i = 0; i < N; i++) {
            System.out.print (arr[i] + " " );
        }
        
        
	}
	
	private static void doSwaping(int [] input, int len, int j, int k){
			
			int temp = input[j];
			input[j] = input[len-j-1];
			input[len-j-1] = temp;
			
			temp = input[k];
			input[k] = input[len-k-1];
			input[len-k-1] = temp;
		}

}
