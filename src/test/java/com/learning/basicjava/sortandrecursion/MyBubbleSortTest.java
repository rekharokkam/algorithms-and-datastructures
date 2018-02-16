package com.learning.basicjava.sortandrecursion;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class MyBubbleSortTest {

	@Test
	public void test() {
		//given
		MySort bubbleSort = new MyBubbleSort();
		int[] array = {24, 5, 101, 2, 10, 21, 8};
		
		//when
		bubbleSort.sort(array);
		
		//then
		BDDAssertions.then(array).containsExactly(2, 5, 8, 10, 21, 24, 101);	
	}
}
