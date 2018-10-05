/**
 * 
 */
package com.eci.lrn.ds;

import javax.sound.sampled.ReverbType;

/**
 * @author nsingh
 *http://www.java2novice.com/data-structures-in-java/linked-list/singly-linked-list/
 */
public class SingleLinkedListImplementation<T> {

	/**
	 * @param args
	 */
	private Node<T> head;
	private Node<T> tail;
	
	public void add(T element){
		Node<T> node = new Node<T>();
		node.setValue(element);
		System.out.println("Adding element: "+element);
		
		//check if list is empty
		if(head==null){
			head=node;
			tail=node;
		}else{
			//set current tail next link to new node
			tail.setNext(node);
			tail=node;
		}
		
	}
	
	public void addAfter(T element, T after){
		Node<T> node = new Node<T>();
		node.setValue(element);
		//checking for empty list
		if(head==null){
			System.out.println("List is empty so inserting at head: ");
			head=node;
			tail=node;
		}
		Node<T> temp =head;
		Node<T> refNode =null;
		while(temp.getNext()!=null){
			if(temp.getValue().equals(after)){
				refNode=temp;
				break;
			}else{
				temp=temp.getNext();
			}
		}
		if(refNode!=null){
			node.setNext(refNode.getNext());
			if(temp==tail)tail=node;
			temp.setNext(node);
		}else{
			System.out.println("unable to find given element");
		}
	}
	
	public void deleteFront(){
		if(head==null)System.out.println("List do not contain anything");
		else{
			Node<T> temp = head;
			head=temp.getNext();
			if(head==null){
				tail=null;
			}
			System.out.println("Deleted Node: "+temp.getValue());
		}
		
	}
	
	public void delete(){
		if(head==null)System.out.println("List do not contain anything");
		else{
			Node<T> temp = head;
			Node<T> prev=null;
			while(temp!=null){
				prev=temp;
				temp=temp.getNext();
			}
			if(prev==head){
				head=null;
				tail=null;
			}else{
				prev.setNext(null);
				tail=prev;
			}
		}
		
	}
	
	public void deleteElement(T element){
		if(head==null){
			System.out.println("List does not contain anything");
		}else{
			Node<T> temp=head;
			Node<T> prevNode=null;
			while(temp!=null){
				if(temp.getValue()==element){
					break;
				}else{
					prevNode=temp;
					temp=temp.getNext();
				}
			}
			if(temp!=null){
				if(temp==head){
					head=null;
					tail=null;
				}else{
					prevNode.setNext(temp.getNext());
				}
				System.out.println("deleted node: "+temp.getValue());
			}else{
				System.out.println("Element not found: "+element);
			}
		}
	}
	
	public void traverseList(){
		Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
	}
	
	//Reverse a linked List
	public void reverseLinkedList(){
		
		Node<T> current=head;
		Node<T> next=null;
		Node<T> prev=null;
		
		while(current!=null){
			next=current.getNext();
			current.setNext(prev);
			prev=current;
			current=next;
		}
		head=prev;
		
	}
	
	
	public static void main(String[] args) {
		SingleLinkedListImplementation<Integer> sl = new SingleLinkedListImplementation<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.addAfter(76, 54);
        //sl.deleteFront();
        //sl.deleteElement(54);
        sl.traverseList();
        System.out.println("Reverse of linked list");
        sl.reverseLinkedList();
        sl.traverseList();
	}

}

class Node<T> implements Comparable<T>{
	
	private T value;
	private Node<T> next;
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public int compareTo(T o) {
		if(this.value.equals(o)){
			return 0;
		}else{
			return 1;
		}
	}
	
}
