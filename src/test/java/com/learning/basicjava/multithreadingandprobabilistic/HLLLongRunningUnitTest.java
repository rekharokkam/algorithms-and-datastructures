package com.learning.basicjava.multithreadingandprobabilistic;

import java.util.stream.LongStream;

import org.assertj.core.api.BDDAssertions;
import org.assertj.core.data.Offset;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import net.agkn.hll.HLL;

public class HLLLongRunningUnitTest {

	@Test
	@Ignore
	public void test_whenAddLargeSetOfNumbers_thenShouldReturnEstimatedCardinality() {
		//given 
		long numberOfElements = 100_000_000;
		long toleratedDifference = 1_000_000; //1% of total elements
		
		HashFunction hashFunction = Hashing.murmur3_128();
		HLL hll = new HLL (14, 5);
		
		//when 
		LongStream.range(0, numberOfElements).forEach(element -> {
			long hashedValue = hashFunction.newHasher().putLong(element).hash().asLong();
			hll.addRaw(hashedValue);
		});
		
		//then
		long cardinality = hll.cardinality();
		System.out.printf("First test Cardinality : %s.%n", cardinality);
		BDDAssertions.then(cardinality).isCloseTo(numberOfElements, Offset.offset(toleratedDifference));
	}
	
	@Test
	public void test_whenTwoHLLWithLargeSetOfNumbers_thenShouldReturnEstimatedCardinalityForBothSets () {
		//given 
		long numberOfElements = 100_000_000;
		long toleratedDifference = 1_000_000; //1% of total elements
		
		HashFunction hashFunction = Hashing.murmur3_128();

		HLL firstHLL = new HLL (15, 5);
		HLL secondHLL = new HLL (15, 5);
		
		//when
		LongStream.range(0, numberOfElements).forEach(element -> {
			long hashedValue = hashFunction.newHasher().putLong(element).hash().asLong();
			firstHLL.addRaw(hashedValue);
		});

		LongStream.range(numberOfElements, numberOfElements * 2).forEach(element -> {
			long hashedValue = hashFunction.newHasher().putLong(element).hash().asLong();
			secondHLL.addRaw(hashedValue);
		});
		
		//then
		firstHLL.union(secondHLL);
		long cardinality = firstHLL.cardinality();
		System.out.printf("Second test Cardinality : %s.%n", cardinality);
		BDDAssertions.then(cardinality).isCloseTo(numberOfElements * 2, Offset.offset(toleratedDifference));

	}
}
