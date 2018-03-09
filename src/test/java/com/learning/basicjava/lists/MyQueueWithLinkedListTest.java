package com.learning.basicjava.lists;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class MyQueueWithLinkedListTest {

	@Test
	public void test_whenAddedAnElementShouldSuccessfullyRetrrieveIt() {
		//given
		MyQueueWithLinkedList<String> queue = new MyQueueWithLinkedList<>();
		
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
	public void test_elementsShouldBeRetrievedInTheOrderTheyWerePushed () {
		//given
		MyQueueWithLinkedList<String> queue = new MyQueueWithLinkedList<>();
		
		//when
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		
		//then
		BDDAssertions.then(queue.poll()).isEqualTo("a");
		BDDAssertions.then(queue.poll()).isEqualTo("b");
		BDDAssertions.then(queue.poll()).isEqualTo("c");
		
	}
	
	@Test
	public void test_whenAddedAnElementAndPeekedElementShouldNotBeRemoved () {
		//given
		MyQueueWithLinkedList<String> queue = new MyQueueWithLinkedList<>();
		
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
