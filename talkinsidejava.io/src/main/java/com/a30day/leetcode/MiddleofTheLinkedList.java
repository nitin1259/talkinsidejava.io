/**
 * 
 */
package com.a30day.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author nisingh


	Given a non-empty, singly linked list with head node head, return a middle node of linked list.
	
	If there are two middle nodes, return the second middle node.
	
	 
	
	Example 1:
	
	Input: [1,2,3,4,5]
	Output: Node 3 from this list (Serialization: [3,4,5])
	The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
	Note that we returned a ListNode object ans, such that:
	ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
	Example 2:
	
	Input: [1,2,3,4,5,6]
	Output: Node 4 from this list (Serialization: [4,5,6])
	Since the list has two middle nodes with values 3 and 4, we return the second one.
	 
	
	Note:
	
	The number of nodes in the given list will be between 1 and 100.

 */
public class MiddleofTheLinkedList {
	
	
	static ListNode head;

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		list.forEach(e->{
			head = addNode(head, new ListNode(e));
		});
		
		System.out.println(head.val);
		// printList(head);
	}
	
	private static void printList(ListNode head) {
		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
        ListNode slow_ptr = head; 
        ListNode fast_ptr = head; 
        if (head != null) 
        { 
            while (fast_ptr != null && fast_ptr.next != null) 
            { 
                fast_ptr = fast_ptr.next.next; 
                slow_ptr = slow_ptr.next; 
            } 
             
        } 
        return slow_ptr;
    }
	
	// TODO
	private static ListNode addNode(ListNode head, ListNode node) {
		System.out.println("coming in");
		if(head==null) {
			System.out.println("coming in: 1 -> "+node.val);
			head = node;
			System.out.println("coming in: 1.1 -> "+head.val);
		}
		
		while(head.next!=null) {
			System.out.println("coming in: 2");
			head = head.next;
			System.out.println("coming in: 2.2 ->"+ head.next +" : "+head.val);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		head.next = node;
		
		return head;
		
	}

}


class ListNode {
	int val;
	ListNode next;
	
	public ListNode(int val) {
		this.val=val;
		this.next=null;
	}
	
	
}
     