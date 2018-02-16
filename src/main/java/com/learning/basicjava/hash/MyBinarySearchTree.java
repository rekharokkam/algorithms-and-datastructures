package com.learning.basicjava.hash;

import java.util.LinkedList;
import java.util.List;

public class MyBinarySearchTree {

	private Node rootNode;
	
	public void insert (int data){
		Node newNode = new Node (data);
		
		//check if the root is null
		if (null == rootNode) {
			rootNode = newNode;
			return;
		}
		
		//check to see which side of the root node to traverse
		Node currentNode = rootNode;
		Node parentNode = rootNode;
		
		while (currentNode != null) {
			int currentData = currentNode.data;
			parentNode = currentNode;
			if (data < currentData) { // traverse left
				currentNode = currentNode.left;
				if (currentNode == null) {
					parentNode.left = newNode;
				}
			} else if (data > currentData){ //traverse right
				currentNode = currentNode.right;
				if (currentNode == null) {
					parentNode.right = newNode;
				}
			} else { //value already present on the tree so do not add
				return;
			}
		}
	}
	
	public boolean find (int data) {
		Node currentNode = rootNode;
		
		while (currentNode != null) {
			int currentData = currentNode.data;
			
			if (currentData == data){
				return true;
			}
			
			if (data < currentData) { //traverse left
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		return false;
	}
	
	public List<Integer> getDataInOrder () {
		List<Integer> dataList = new LinkedList<>();
		iterate (rootNode, dataList);
		
		return dataList;
	}
	
	private void iterate (Node node, List<Integer> result) {
		if (node != null) {
			//traverse the left side
			iterate (node.left, result);
			result.add (node.data);
			iterate (node.right, result);
			
		}
	}
	
	public void delete (int data) {
		//get to the node that contains this data
		boolean isPresent = find (data);
		if (isPresent) {
			//locate the node
			Node[] nodeToBeDeletedNParent = new Node[2];
			boolean isRight = getNode (data, nodeToBeDeletedNParent);
			
			Node toBeDeletedNode = nodeToBeDeletedNParent[1];
			Node parentNode = nodeToBeDeletedNParent[0];
			
			//if the node has no children
			if (toBeDeletedNode.left == null && toBeDeletedNode.right == null) {
				if (isRight) {
					parentNode.right = null;
				} else {
					parentNode.left = null;
				}
			} else if (toBeDeletedNode.left != null && toBeDeletedNode.right == null){ //if has only left node
				parentNode.left = toBeDeletedNode.left;
			} else if (toBeDeletedNode.left == null && toBeDeletedNode.right != null) { //if has only right node
				parentNode.right = toBeDeletedNode.right;
			} else { //if it has both the nodes
				Node[] smallestRightNodeNParent = getRightSideSuccessor(toBeDeletedNode.right);
				Node successor = smallestRightNodeNParent[1];
				Node successorParent = smallestRightNodeNParent[0];
				
				//check to see if the successor has right node, it is impossible for successor to have a left node as we picked the smallest Node in the subtree
				if (successor.right != null) {
					successorParent.left = successor.right;
				} else {
					successorParent.left = null;
				}
				
				successor.right = toBeDeletedNode.right;
				successor.left = toBeDeletedNode.left;
				
				if (isRight) {
					parentNode.right = successor;
				} else {
					parentNode.left = successor;
				}
			}
		}
	}
	
	private boolean getNode (int data, Node[] result) {
		Node currentNode = rootNode;
		Node parentNode = rootNode;
		boolean isRight = false;
		
		while (currentNode != null) {
			
			if (currentNode.data == data) {
				result[0] = parentNode;
				result[1] = currentNode;
				return isRight;
			}
			parentNode = currentNode;
			if (data < currentNode.data ) { //traverse left 
				currentNode = currentNode.left;
				isRight = false;
			} else { //traverse right
				currentNode = currentNode.right;
				isRight = true;
			}
		}
		return false;
	}
	
	private Node[] getRightSideSuccessor (Node toBeDeletedNodeRightNode) {
		Node currentNode = toBeDeletedNodeRightNode;
		Node parentNode = toBeDeletedNodeRightNode;
		
		while (currentNode != null) {
			
			if (currentNode.left != null) {
				parentNode = currentNode;
				currentNode = currentNode.left;
			} else {
				return new Node[] {parentNode, currentNode};
			}
		}
		
		return null;
	}
	
	private class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node (int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public Node (int data) {
			this.data = data;
		}
	}
}
