package com.learning.basicjava.sortandrecursion;

import java.util.Arrays;

import org.junit.Test;

public class MaxHeapSortTest {

	@Test
	public void test() {
		MySort maxHeapSort = new MaxHeapSort();
		int[] array = new int[] {1, 2, 49, 100, 3};
//		int[] array = new int[] {10, 3, 1, 8, 2, 5, 7};
//		int[] array = new int[] {24, 5, 101, 2, 10, 21, 8};
		
		maxHeapSort.sort(array);
		System.out.println("\n\n");
		Arrays.stream(array).forEach(System.out::println);
	}
}