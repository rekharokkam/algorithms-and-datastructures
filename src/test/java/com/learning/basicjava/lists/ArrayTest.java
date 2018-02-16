package com.learning.basicjava.lists;

import java.util.stream.IntStream;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class ArrayTest {

	@Test
	public void test() {
		//given
		int[] integers = new int[10];
		IntStream.range(0, 10).forEach(i -> integers[i] = i);
		
		//O(1) - when
		int integer = integers[8]; // get/fetch operations
		
		//then
		BDDAssertions.then (integer).isEqualTo(8);
	}
}
