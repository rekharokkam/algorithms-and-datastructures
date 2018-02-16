package com.learning.basicjava.lists;

import java.util.LinkedList;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

import com.learning.basicjava.lists.MyLinkedList;

public class MyLinkedListTest {

	@Test
	public void test_ElementsShouldBeAddedSuccessfully() {
		//given
		MyLinkedList<String> myLinkedList = new MyLinkedList<>();
		
		//when
		myLinkedList.add("a");
		
		//then
		BDDAssertions.then(myLinkedList.size()).isEqualTo(1);
		
		//when
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.add("d");
		
		//then
		BDDAssertions.then(myLinkedList.size()).isEqualTo(4);
		BDDAssertions.then(myLinkedList.get(3)).isEqualTo("d");
	}
	
	@Test
	public void test_peekFirstShouldReturnFirstElement () {
		//given
		MyLinkedList<String> myLinkedList = new MyLinkedList<>();
		
		//when
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		
		//then
		BDDAssertions.then(myLinkedList.peekFirst()).isEqualTo("a");
	}
	
	@Test
	public void test_peekFirstAndPeekLastShouldReturnFirstAndLastElements () {
		//given
		LinkedList<String> linkedList = new LinkedList<>();
		
		//when
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");
		linkedList.add("d");
		
		BDDAssertions.then(linkedList.peekFirst()).isEqualTo("a");
		BDDAssertions.then(linkedList.peekLast()).isEqualTo("d");
	}
	
	@Test
	public void test_DeletingElements () {
		//given
		MyLinkedList<String> myLinkedList = new MyLinkedList<>();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		 
		//when
		String element = myLinkedList.remove("b");
		
		BDDAssertions.then(element).isEqualTo("b");
		BDDAssertions.then(myLinkedList.size()).isEqualTo(2);
		
	}
}
