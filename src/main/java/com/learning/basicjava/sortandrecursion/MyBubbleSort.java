package com.learning.basicjava.sortandrecursion;

public class MyBubbleSort implements MySort {

	@Override
	public void sort(int[] array) {
		for (int i = 0; i < (array.length - 2); i ++) {
			for (int j = 0; j < (array.length -1); j ++) {
				if (array[j + 1] < array[j]){
					int temp = array[j];
					array[j] = array[j  + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}
