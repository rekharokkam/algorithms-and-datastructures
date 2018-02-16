package com.learning.basicjava.sortandrecursion;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class MySelectionSortTest {

	@Test
	public void test() {
		//given
		MySort selectionSort = new MySelectionSort();
		int[] array = {4, 5, 1, 2, 10, 21, 1};
		
		//when
		selectionSort.sort(array);
		
		//then
		BDDAssertions.then(array).containsExactly(1, 1, 2, 4, 5, 10, 21);
	}
}
