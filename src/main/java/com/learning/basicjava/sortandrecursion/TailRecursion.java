package com.learning.basicjava.sortandrecursion;

public class TailRecursion implements Fibonacci {

	@Override
	public long fibonacci(int times) {
		return fibo (times, 0, 1);
	}
	
	private long fibo (int times, int a, int b) {
		return (times == 0) ? a : fibo ((times - 1), (a + b), a);
	}
}
