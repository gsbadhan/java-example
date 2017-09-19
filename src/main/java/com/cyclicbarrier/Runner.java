package com.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Runner implements Runnable {
	private CyclicBarrier cyclicBarrier;

	public Runner(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			doSomething();
			// wait for other runners to reach at same stoping point
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	private void doSomething() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + ": reached at barrier");
	}

}
