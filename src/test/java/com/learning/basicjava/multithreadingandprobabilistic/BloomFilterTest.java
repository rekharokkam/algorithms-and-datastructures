package com.learning.basicjava.multithreadingandprobabilistic;

import java.util.stream.IntStream;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {

	@Test
	public void test_whenDataIsAddedShouldReturnFalseForElementNotPresent() {
		//given
		BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 
				500, 0.01);
		
		//when
		bloomFilter.put(1);
		bloomFilter.put(2);
		bloomFilter.put(3);
		
		//then
		BDDAssertions.then(bloomFilter.mightContain(1)).isTrue();//Even though it returns true, there is no guarantee element is present.
		BDDAssertions.then(bloomFilter.mightContain(2)).isTrue();
		BDDAssertions.then(bloomFilter.mightContain(3)).isTrue();
		
		BDDAssertions.then(bloomFilter.mightContain(100)).isFalse();
	}
	
	@Test
	public void test_whenDataIsAddedShouldReturnFalseForElementNotPresent2() {
		//given
		BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 
				5_000_000, 0.01);
		
		//when
		IntStream.range(0, 100_000).forEach(bloomFilter::put);
		
		//then
		BDDAssertions.then(bloomFilter.mightContain(1)).isTrue();//Even though it returns true, there is no guarantee element is present.
		BDDAssertions.then(bloomFilter.mightContain(2)).isTrue();
		BDDAssertions.then(bloomFilter.mightContain(3)).isTrue();
		
		BDDAssertions.then(bloomFilter.mightContain(1_000_000)).isFalse();
	}

}
