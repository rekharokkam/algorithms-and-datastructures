package com.learning.basicjava.sortandrecursion;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class NormalFibonacciTest {

	@Test
	public void test() {
		//given
		Fibonacci normalFibonacci = new NormalFibonacci();
		
		long result = normalFibonacci.fibonacci(12);
		BDDAssertions.then(result).isEqualTo(144L);
		
	}
}
