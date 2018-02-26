package com.learning.basicjava.sortandrecursion;

public class MaxHeapSort implements HeapSort {

	@Override
	public void sort(int[] array) {
		//heapify
		for (int i = (array.length - 1)/2; i >= 0; i--) {
			heapify (array, i);
		}
	}

	private void heapify (int[] array, int i) {
//		for (int i = 0; i <= array.length/2; i++) {
			int leftChildIndex = 2 * i;
			int rightChildIndex = leftChildIndex + 1;
			int max = i;
			if (leftChildIndex <= array.length - 1 && (array[leftChildIndex] > array[i])) {
				max = leftChildIndex;
			}
			if (rightChildIndex <= array.length - 1 && (array[rightChildIndex] > array[i])) {
				max = rightChildIndex;
			}
			
			if (max != i) {
				swap (array, max, i);
				heapify (array, max);
			}
//		}
	}
	
	private void swap (int[] array, int source, int target) {
		int temp = array[source];
		array[source] = array[target];
		array[target] = temp;
	}
	
	private int getLeftChild (int parentIndex, int[] array) {
		int leftChildIndex = (parentIndex * 2) ;
		if (leftChildIndex >= array.length) {
			leftChildIndex = -1;
		}
		return leftChildIndex;
	}
	
	private int getRightChild (int parentIndex, int[] array) {
		int leftChildIndex = (parentIndex * 2) + 1;
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
