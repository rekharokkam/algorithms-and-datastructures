package com.learning.basicjava.hash;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class BrokenHashCodeKeyTest {

	@Test
	public void test_whenBrokenHashCodeClassIsUsedAsKeyAllElementsAreStoredInSameBucket() {//All elements are stored in the same bucket due to the broken hash code in Key.
		
		//given
		MyHashTable<BrokenHashCodeKey, Integer> map = new MyHashTable<>();
		
		//when
		IntStream.range(0, 10_000).forEach(i -> map.put(new BrokenHashCodeKey(i), i));
		
		//then
		BDDAssertions.then(map.getEachBucketSize().
				stream().
				filter(i -> i == 10_000).
				collect(Collectors.toList()).
			size()).
		isEqualTo(1);
		BDDAssertions.then(map.size()).isEqualTo(10_000);
	}
}
