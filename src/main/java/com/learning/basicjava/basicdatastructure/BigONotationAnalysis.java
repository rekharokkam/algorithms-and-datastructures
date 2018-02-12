package com.learning.basicjava.basicdatastructure;

import java.util.Arrays;

public class BigONotationAnalysis {

	/*
	 * This function runs in O(1) constant time relative to its input.
	 * Irrespective of how long the array is and how it grows it still takes the same time.
	 */
	public static void printFirstElement (int[] array) {
		System.out.println(array[0]);
	}
	
	
	/*
	 * This function is said to have a complexity of O(n)
	 * This function runs in O(n) time or Linear time
	 * If the array has 10 items then it prints 10 times, if the array has 5 times then it prints 5 times.
	 * As the input grows, time taken to run this function also grows linear to the input.
	 * 
	 */
	public static void printAllItems (int[] array) {
		Arrays.stream(array).forEach(System.out::println);
	}
	
	/*
	 * This function runs in O(n^2) time OR quadratic times. read n^2 as n square 2
	 * As n increases the time taken to run also increases in squares of n.
	 * 
	 */
	public static void printAllOrderedPair (int[] array) {
		for (int outerElement : array) {
			for (int innerElement : array) {
				int[] orderedPair = new int[] {outerElement, innerElement};
				System.out.println(Arrays.toString(orderedPair));
			}
		}
	}
	
	/*
	 * This function runs in O(n) + O(n) = O(n) times.
	 * Here 2O(n) - constant 2 is ignored and said that this function runs in O(n) time. 
	 */
	public static void printAllItemsTwice (int[] array) {
		Arrays.stream(array).forEach(System.out::println);
		Arrays.stream(array).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
