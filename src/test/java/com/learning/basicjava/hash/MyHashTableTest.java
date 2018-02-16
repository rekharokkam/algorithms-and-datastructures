package com.learning.basicjava.hash;

import java.util.stream.IntStream;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class MyHashTableTest {

	@Test
	public void test_whenElementsAreAddedShouldRetrieveIt() {
		//given
		MyHashTable<String, Integer> map = new MyHashTable<>();
		
		//when
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		
		//then
		BDDAssertions.then(map.size()).isEqualTo(3);
		BDDAssertions.then(map.get("a")).isEqualTo(1);
		BDDAssertions.then(map.get("b")).isNotNull();
		BDDAssertions.then(map.get("d")).isNull();
	}
	
	@Test
	public void test_whenLargeDataIsAddedShouldPass () {
		//given
		MyHashTable<String, Integer> map = new MyHashTable<>(); 
		
		//when
		IntStream.range(0, 10_000).forEach(i -> map.put(String.valueOf(i), i));
		
		//then
		BDDAssertions.then(map.size()).isEqualTo(10_000);
	}
}
