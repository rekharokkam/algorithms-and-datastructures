package com.learning.basicjava.multithreadingandprobabilistic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class MyProducer implements Runnable{
	private BlockingQueue<Integer> blockingQueue;
	private int poisonPill;
	private int poisonPillPerProducer;
	
	public MyProducer (BlockingQueue<Integer> blockingQueue, int poisonPill, int poisonPillPerProducer) {
		this.blockingQueue = blockingQueue;
		this.poisonPill = poisonPill;
		this.poisonPillPerProducer = poisonPillPerProducer;
	}
	
	@Override
	public void run () {
		try {
			generateNumbers ();
		} catch (InterruptedException exception) {
			exception.printStackTrace(System.err);
			Thread.currentThread().interrupt();
		}
	}
	
	private void generateNumbers () throws InterruptedException { 
		for (int i = 0; i < 100; i ++) {
			blockingQueue.put(ThreadLocalRandom.current().nextInt(100));
		}
		
		for (int j = 0; j < poisonPillPerProducer; j ++) {
			blockingQueue.put(poisonPill);
		}
	}
}
