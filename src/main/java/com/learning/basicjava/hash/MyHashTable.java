package com.learning.basicjava.hash;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyHashTable<K, V> {
	private static final int BUCKET_SIZE = 10;
	private List<List<Entry<K, V>>> buckets;
	
	public MyHashTable () {
		buckets = new LinkedList<>();
		IntStream.range(0, BUCKET_SIZE).forEach(i -> buckets.add(i, new LinkedList<>()));
	}
	
	public void put (K key, V value) {
		//calculate the modulus of key's hash value
		int bucketIndex = key.hashCode() % BUCKET_SIZE;
		List<Entry<K, V>> indexedBucket = buckets.get(bucketIndex);

		//Since no repeated values are allowed
		Entry<K, V> entry = new Entry<K, V> (key, value);
		indexedBucket.remove(entry);
		indexedBucket.add(entry);
	}
	
	public int size () {
		return buckets.stream().map(List::size).reduce((i, j) -> i + j).orElse(null);
	}
	
	public V get (K key) {
		//get the exact bucket for the key
		int bucketIndex = key.hashCode() % BUCKET_SIZE;
		List<Entry<K, V>> indexedBucket = buckets.get(bucketIndex);
		List<V> values = indexedBucket.
							stream().
							filter(entry -> entry.getKey().equals(key)).
							map (Entry::getValue).
							collect(Collectors.toList());
		if (values.isEmpty()) {
			return null;
		} else {
			return values.get(0);
		}
	}
	
	public boolean containsKey (K key) {
		return ( this.get(key) != null);
	}
	
	public List<Integer> getEachBucketSize () {

		return buckets.stream().map(List::size).collect(Collectors.toList());
	}
	
	private class Entry <K, V> {
		private K key;
		private V value;
		
		public Entry (K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public K getKey () {
			return key;
		}
		
		public V getValue () {
			return value;
		}
	}
}
