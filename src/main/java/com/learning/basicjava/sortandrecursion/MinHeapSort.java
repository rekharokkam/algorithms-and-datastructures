package com.learning.basicjava.sortandrecursion;

import java.util.Arrays;

public class MinHeapSort implements HeapSort {
	
	@Override
	public void sort(int[] array) {
		//heapify the array first
		heapify (array);
		
		System.out.println("After heapifying");
		Arrays.stream(array).forEach(System.out::println);
		
		int index = array.length - (array.length/2 + 1);
		while (index >= 0) {
			int parentIndex = 0;
			System.out.printf("%nindex : %d :: arrayElement : %d , parentIndex : %d :: arrayElement : %d%n ", index, array[index + array.length/2], parentIndex, 
					array[parentIndex + array.length/2]);
			
			if (array[parentIndex + array.length/2] > array[index + array.length/2]) {
				swap (array, parentIndex + array.length/2, index + array.length/2);
//				heapify (array);
			}
			
			for (int i :  array) {
				System.out.print("\t" + i);
			}
			
			index = index - 1;
		}
		
//		for (int i = (array.length /2 ); i < array.length ; i ++) {
//			int parentIndex = getParentIndex(i);
//			swap (array, i, array.length/2);
//			heapify (array);
//		}
	}
	
	private void heapify (int[] array) {
		for (int i = array.length/2; i >=0 ; i --) {
			int leftChildIndex = getLeftChild (i, array);
			if (-1 != leftChildIndex){ //If not left Child then surely no right child
				//compare
				if (array[i] > array[leftChildIndex]) {
					swap (array, i, leftChildIndex);
					heapify (array);
				}
				
				int rightChildIndex = getRightChild (i, array);
				if (-1 != rightChildIndex) { //Right Child Exists
					if (array[i] > array[rightChildIndex]) {
						swap (array, i, rightChildIndex);
						heapify (array);
					}
				}
			}
		}
	}
	
	private void swap (int[] array, int source, int target) {
		int temp = array[source];
		array[source] = array[target];
		array[target] = temp;
	}
	
	private int getLeftChild (int parentIndex, int[] array) {
		int leftChildIndex = (parentIndex * 2) + 1  ;
		if (leftChildIndex >= array.length) {
			leftChildIndex = -1;
		}
		return leftChildIndex;
	}
	
	private int getRightChild (int parentIndex, int[] array) {
		int leftChildIndex = (parentIndex * 2) + 2;
		if (leftChildIndex >= array.length) {
			leftChildIndex = -1;
		}
		return leftChildIndex;
	}
	
	private int getParentIndex (int childIndex) {
		return childIndex / 2;
	}
	
	private boolean isLeftChildPresent (int parentIndex, int[] array)
	{
		return (getLeftChild(parentIndex, array) != -1);
	}
	
	private boolean isRighttChildPresent (int parentIndex, int[] array)
	{
		return (getRightChild(parentIndex, array) != -1);
	}
}
