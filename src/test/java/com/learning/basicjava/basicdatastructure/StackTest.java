package com.learning.basicjava.basicdatastructure;

import java.util.Stack;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class StackTest {

	@Test
	public void test_whenPushedToStackShouldRetreieveIt() {
		//given
		Stack<String> stack = new Stack <>();
		
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
		Stack<String> stack = new Stack<>();
		
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
		Stack<String> stack = new Stack<>();
		
		//when
		stack.push("a");
		
		//then
		BDDAssertions.then(stack.size()).isEqualTo(1);
		BDDAssertions.then(stack.peek()).isEqualTo("a");
		BDDAssertions.then(stack.size()).isEqualTo(1);
	}
}
