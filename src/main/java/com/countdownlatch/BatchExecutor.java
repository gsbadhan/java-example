package com.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatchExecutor {

	public void process(List<Task> batch) {
		// initialize countdownlatch for batch of Tasks
		CountDownLatch countDownLatch = new CountDownLatch(batch.size());

		// all task run in parallel
		ExecutorService batchPool = Executors.newCachedThreadPool();

		for (Task task : batch) {
			batchPool.submit(new Runnable() {
				@Override
				public void run() {
					try {
						task.execute();
					} finally {
						countDownLatch.countDown();
					}
				}
			});
		}

		// waiting for all tasks to be finished
		System.out.println("waiting for all tasks to be finished..");
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("all tasks to be finished.");
		batchPool.shutdown();
	}
}
