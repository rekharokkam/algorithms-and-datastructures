package com.learning.basicjava.multithreadingandprobabilistic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MyProducerConsumerBlockingQueue {

	private static final int BLOCKING_QUEUE_CAPACITY = 10;
	private static final int NUMBER_OF_PRODUCERS = 4;
	private static final int NUMBER_OF_CONSUMERS = Runtime.getRuntime().availableProcessors();
	private static final int POISON_PILL = Integer.MAX_VALUE;
	private static final int POISON_PILL_PER_PRODUCER = NUMBER_OF_CONSUMERS / NUMBER_OF_PRODUCERS;
	
	public static void addProducersAndConsumers () {
		ExecutorService taskList = Executors.newFixedThreadPool(10);
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(BLOCKING_QUEUE_CAPACITY);

		for (int i = 0; i < NUMBER_OF_PRODUCERS; i ++) {
			taskList.execute(new MyProducer(blockingQueue, POISON_PILL, POISON_PILL_PER_PRODUCER));
		}
		
		for (int j = 0; j < NUMBER_OF_CONSUMERS; j ++) {
			taskList.execute(new MyConsumer(blockingQueue, POISON_PILL));
		}
		
		taskList.shutdown();
	}
	
	public static void main(String[] args) {
		addProducersAndConsumers();
	}
}
