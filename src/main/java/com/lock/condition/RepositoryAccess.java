package com.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//only one thread can take lock on increment/decrement methods per instance
public class RepositoryAccess {

	private ReentrantLock lock = new ReentrantLock(true);
	private Condition increment = lock.newCondition();
	private Condition decrement = lock.newCondition();

	private Integer counter = 0;
	private final int THRESHOLD = 2;

	public Integer increment() {
		try {
			lock.lock();
			while (counter >= THRESHOLD) {
				System.out.println(Thread.currentThread().getName() + ":INCR:threshold wait:" + counter);
				increment.await();
			}

			counter++;
			decrement.signalAll();

			// to simulate lock, added delay
			delay();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return counter;
	}

	public Integer decrement() {
		try {
			lock.lock();
			while (counter <= -THRESHOLD) {
				System.out.println(Thread.currentThread().getName() + ":DECR:threshold wait:" + counter);
				decrement.await();
			}

			--counter;
			increment.signalAll();

			delay();
		} catch (Exception e) {
			e.printStackTrace();
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
