package com.learning.basicjava.multithreadingandprobabilistic;

import java.util.concurrent.BlockingQueue;

public class MyConsumer implements Runnable{
	
	private BlockingQueue<Integer> blockingQueue;
	private int poisonPill;
	
	public MyConsumer (BlockingQueue<Integer> blockingQueue, int poisonPill) {
		this.blockingQueue = blockingQueue;
		this.poisonPill = poisonPill;
	}
	
	@Override
	public void run () {
		try {
			while (true) {
				int number = blockingQueue.take();
				if (number == poisonPill) {
					return;
				}
				System.out.printf("Current Thread Name : %s , :: number being processed : %d.%n", 
						Thread.currentThread().getName(), number);
			}
		} catch (InterruptedException exception) {
			exception.printStackTrace(System.err);
			Thread.currentThread().interrupt();
		}
	}
}
