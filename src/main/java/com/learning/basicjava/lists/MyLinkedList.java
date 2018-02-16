package com.learning.basicjava.lists;

public class MyLinkedList <T> {
	private Node<T> head;
	
	//O(1)
	public void add (T element){
		//check if this is the first time insertion
		if (null == head) {
			head = new Node<T> (element, null);
			return;
		}
		
		Node<T> prev = head;
		//traverse the list linearly to find the last element on the list
		for (Node<T> node = head.next; node != null; node = node.next) {
			prev = node;
		}
		prev.next = new Node<T> (element, null);
	}
	
	//O(1)
	public T remove (T element) {
		Node<T> currentNode = head;
		Node<T> prevNode = null;
		
		while (currentNode != null) {
			if (element == currentNode.data) {
				if (null == prevNode ) {
					head = currentNode.next;
				} else {
					Node currentNext = currentNode.next;
					prevNode.next = currentNext;
				}
				return currentNode.data;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		return null;
	}
	
	//O(n) - need to traverse the entire list to fetch the item at an index
	public T get (int index) {
		int counter = 0;
		Node<T> node = head;
		while (counter  <= index) {
			if (counter == index){
				return (T) node.data;
			}
			node = node.next;
			counter ++;
		}
		return null;
	}
	
	public int size () {
		int size = 0;
		Node<T> node = head;
		while (node != null) {
			size ++;
			node = node.next;
		}
		return size;
	}
	
	public T peekFirst () {
		return head.data;
	}
	
	private class Node <T> {
		private T data;
		private Node next;
		
		public Node (T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
