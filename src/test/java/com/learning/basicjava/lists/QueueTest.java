package com.learning.basicjava.lists;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class QueueTest {

	@Test
	public void test_whenAddedAnElementShouldSuccessfullyRetrrieveIt() {
		//given
		Queue<String> queue = new LinkedBlockingQueue<>();
		
		//when
		queue.offer("a");
		
		//then
		BDDAssertions.then(queue.size()).isEqualTo(1);
		
		//when
		String element = queue.poll();
		
		//then
		BDDAssertions.then(element).isEqualTo("a");
		BDDAssertions.then(queue.isEmpty()).isTrue();
	}
	
	@Test
	public void test_whenAddedAnElementAndPeekedElementShouldNotBeRemoved () {
		//given
		Queue<String> queue = new LinkedBlockingQueue<>();
		
		//when 
		queue.offer("a");
		queue.offer("b");
		
		String element1 = queue.peek();
		String element2 = queue.peek();
		
		BDDAssertions.then(element1).isEqualTo("a");
		BDDAssertions.then(element2).isEqualTo("a");
		BDDAssertions.then(queue.size()).isEqualTo(2);
	}
}
