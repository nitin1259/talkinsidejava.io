/**
 * 
 */
package com.eci.lrn.collectionProb;

import java.util.HashMap;

/**
 * @author nsingh
 * 
 * http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * http://stackoverflow.com/questions/23772102/lru-cache-in-java-with-generics-and-o1-operations
 *
 */
public class LRUCacheImplementation {

	/**
	 * @param args
	 */
	int initialCapacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head=null;
	Node end=null;
	
	
	public LRUCacheImplementation(int initialCapacity){
		this.initialCapacity=initialCapacity;
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node n=map.get(key);
			remove(n);
			setAtHead(n);
			return n.value;
		}
		return -1;
	}
	
	
	
	private void setAtHead(Node n) {
		n.next=head;
		n.prev=null;
		
		if(head!=null)
			head.prev=n;
		
		head =n;
		
		if(end==null)
			end=head;
		
	}

	private void remove(Node n) {
		if(n.prev!=null)
			n.prev.next=n.next;
		else
			head=n.next;
		if(n.next!=null)
			n.next.prev=n.prev;
		else
			end=n.prev;		
	}

	public void set(int key, int value){
		if(map.containsKey(key)){
			Node old = map.get(key);
			old.value=value;
			remove(old);
			setAtHead(old);
		}else{
			Node node= new Node(key, value);
			if(map.size()>=initialCapacity){
				map.remove(end.key);
				remove(end);
				setAtHead(node);
			}else{
				setAtHead(node);
			}
			map.put(key, node);
		}
	}

}

class Node{
	int value;
	int key;
	Node prev;
	Node next;
	
	public Node(int value, int key){
		this.value=value;
		this.key=key;
	}
}