/**
 * 
 */
package com.eci.learning.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author nsingh
 *
 */
public class NCR_HackerRank {

	
	 // http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
	
	public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int nofq = in.nextInt();
        
        for(int i=0;i<nofq;i++){
            int test =  in.nextInt();
            int [] arr = new int[test];
            for(int j=0;j<test;j++){
            	arr[j] = in.nextInt();
            			
            }
            if (checkBST(arr, test) == true) System.out.println("YES"); else System.out.println("NO");
            
        }
        
    }
    
	// Check if a given array can represent Preorder Traversal of Binary Search Tree
    private static boolean checkBST(int pre[], int n){
    	
    	
        Stack<Integer> s = new Stack<Integer>();
        
        int root = Integer.MIN_VALUE;
        
        for(int i = 0; i<n;i++){
            if(pre[i] < root) return false;
            
            while (!s.empty() && s.peek()<pre[i]){
                root = s.peek();
                s.pop();
            }
            s.push(pre[i]);
        }
        return true;
    }
    
    
    
    // this is for delete nodes in singlelinked list which has value greater than x
    
/*	static LinkedListNode removeNodes(LinkedListNode list, int x) {
		while (list != null && list.val > x) {
			LinkedListNode temp = list;
			list = list.next;
			temp = null;
		}

		if (list == null)
			return null;

		LinkedListNode current = list;

		while (current.next != null) {
			if (current.next.val > x) {
				LinkedListNode temp = current.next;
				current.next = temp.next;
				temp = null;
			} else {
				current = current.next;
			}
		}
		return list;
	}*/
}
