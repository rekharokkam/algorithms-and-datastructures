package com.learning.basicjava.lists;

public class MyQueueWithLinkedList <T> {
	private Node<T> head;
	private Node<T> tail;
	
	public void offer (T data){
		Node<T> newNode = new Node<T> (data);
		
		if (null == head) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		Node<T> currentTail = tail;
		tail = newNode;
		currentTail.next = tail;
	}
	
	public T poll () {
		T data = head.data;
		
		if (null != head.next){
			head = head.next;
		} else {
			head = null;
		}
		return data;
	}
	
	public T peek () {
		return head.data;
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
	
	public boolean isEmpty () {
		return (head == null);
	}
	
	public static class Node <T> {
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
