package com.learning.basicjava.hash;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class ProperHashCodeKeyTest {

	@Test
	public void test() {
		//given 
		MyHashTable<ProperHashCodeKey, Integer> map = new MyHashTable<>();
		
		//when 
		IntStream.range(0, 10_000).forEach(i -> map.put(new ProperHashCodeKey(i), 1));
		
		//then
		BDDAssertions.then(map.
				getEachBucketSize().
				stream().
				filter(i -> i == 1_000).
				collect(Collectors.toList()).size()).isEqualTo(10);
		BDDAssertions.then(map.size()).isEqualTo(10_000);
	}
}
