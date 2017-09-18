package com.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

//only one thread can take lock on increment/decrement methods per instance
public class RepositoryAccess {

	private ReentrantLock lock = new ReentrantLock(true);
	private Integer counter = 0;

	public Integer increment() {
		try {
			lock.lock();
			counter++;
			// to simulate lock, added delay
			delay();
		} finally {
			lock.unlock();
		}
		return counter;
	}

	public Integer decrement() {
		try {
			lock.lock();
			--counter;
			delay();
		} finally {
			lock.unlock();
		}
		return counter;
	}

	private void delay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
