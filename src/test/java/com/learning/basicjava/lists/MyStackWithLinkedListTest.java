package com.learning.basicjava.lists;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class MyStackWithLinkedListTest {

	@Test
	public void test_whenPushedToStackShouldRetreieveIt() {
		//given
		MyStackWithLinkedList<String> stack = new MyStackWithLinkedList <>();
		
		//when
		stack.push("a");
		
		//then
		BDDAssertions.then(stack.size()).isEqualTo(1);
		
		//and then
		String element = stack.pop();
		BDDAssertions.then(element).isEqualTo("a");
		BDDAssertions.then(stack.isEmpty()).isTrue();
	}
	
	@Test
	public void test_elementsShouldBeRetrievedInTheOrderTheyWerePushed () {
		//given
		MyStackWithLinkedList<String> stack = new MyStackWithLinkedList<>();
		
		//when
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		//then
		BDDAssertions.then(stack.pop()).isEqualTo("c");
		BDDAssertions.then(stack.pop()).isEqualTo("b");
		BDDAssertions.then(stack.pop()).isEqualTo("a");
		
	}
	
	@Test
	public void test_whenPeekMethodIsInvokedShouldNotRemoveElement () {
		//given
		MyStackWithLinkedList<String> stack = new MyStackWithLinkedList<>();
		
		//when
		stack.push("a");
		stack.push("b");
		
		String element1 = stack.peek();
		String element2 = stack.peek();
		
		//then
		BDDAssertions.then(stack.size()).isEqualTo(2);
		BDDAssertions.then(element1).isEqualTo("b");
		BDDAssertions.then(element2).isEqualTo("b");
		BDDAssertions.then(stack.size()).isEqualTo(2);
	}
}
