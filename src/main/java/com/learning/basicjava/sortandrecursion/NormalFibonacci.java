package com.learning.basicjava.sortandrecursion;

public class NormalFibonacci implements Fibonacci {

	@Override
	public long fibonacci(int number) {
		
		if (number == 0 || number == 1) {
			return number;
		}
		
		if (number == 1){
			return 1;
		}
		
		return fibonacci (number -1) + fibonacci(number -2);
	}
}
