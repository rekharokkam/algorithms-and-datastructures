package com.learning.basicjava.lists;

public class MyStackWithLinkedList <T> {

	private Node<T> tail;
	private Node<T> head;
	
	public void push (T data) {
	
		Node<T> newNode = new Node <T>(data);
		
		if (null == head) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		Node<T> currentTail = tail;
		tail = newNode;
		currentTail.next = tail;
	}
	
	public T pop () {
		Node<T> previousNode = head;
		Node<T> node = head;
		while (node != null) {
			if (node.next != null && node.next == tail){
				previousNode = node;
				break;
			} 
			node = node.next;
		}
		
		T toBeReturned = tail.data;
		if (tail == head){
			tail = null;
			head = null;
		} else {
			tail = previousNode;
		}
		return toBeReturned;
	}
	
	public T peek () {
		return tail.data;
	}
	
	public int size() {
		int size = 0;
		
		Node<T> node = head;
		while (node != null) {
			size ++;
			node = node.next;
		}
		return size;
	}
	
	public boolean isEmpty () {
		return (head == null);
	}
	
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node (T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
		
		public Node (T data){
			this (data, null);
		}
	}
}
