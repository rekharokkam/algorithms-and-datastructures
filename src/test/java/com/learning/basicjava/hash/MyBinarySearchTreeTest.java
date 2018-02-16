package com.learning.basicjava.hash;

import java.util.List;

import org.assertj.core.api.BDDAssertions;
import org.junit.Ignore;
import org.junit.Test;

public class MyBinarySearchTreeTest {

	@Test
	@Ignore
	public void test_whenRandomElementsAreAddedFetchShouldReturnThemInOrder() {
		
		//given 
		MyBinarySearchTree tree = new MyBinarySearchTree();
		
		//when
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(4);
		tree.insert(6);
		tree.insert(2);
		tree.insert(10);
		tree.insert(9);
		tree.insert(20);
		tree.insert(25);
		tree.insert(15);
		tree.insert(16);
		
		//then
		List<Integer> data = tree.getDataInOrder();
		BDDAssertions.then(data.size()).isEqualTo(12);
		BDDAssertions.then(data).containsExactly(1, 2, 3, 4, 6, 8, 9, 10, 15, 16, 20, 25);
		
		BDDAssertions.then(tree.find(2)).isTrue();
		BDDAssertions.then(tree.find(100)).isFalse();
	}
	
	@Test
	public void test_deletion() {
		//given 
		MyBinarySearchTree tree = new MyBinarySearchTree();
		
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(4);
		tree.insert(6);
		tree.insert(2);
		tree.insert(10);
		tree.insert(9);
		tree.insert(20);
		tree.insert(25);
		tree.insert(15);
		tree.insert(16);

		//when
		tree.delete(10);
		
		//then
		List<Integer> data = tree.getDataInOrder();
		BDDAssertions.then(data).containsExactly(1, 2, 3, 4, 6, 8, 9, 15, 16, 20, 25);
		
		BDDAssertions.then(tree.find(2)).isTrue();
		BDDAssertions.then(tree.find(10)).isFalse();

	}
}
