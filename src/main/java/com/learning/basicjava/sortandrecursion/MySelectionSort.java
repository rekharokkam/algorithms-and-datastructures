package com.learning.basicjava.sortandrecursion;

public class MySelectionSort implements MySort {

	@Override
	public void sort(int[] array) {
		for (int i = 0; i < (array.length - 1); i ++) {
			for (int j = (i + 1); j < array.length; j ++) {
				if (array[j] < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
