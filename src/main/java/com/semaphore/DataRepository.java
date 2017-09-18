package com.semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class DataRepository {
	// only one thread can take lock at a time
	private Semaphore writeAccessLock = new Semaphore(1, true);

	private Queue<Integer> queue = new LinkedList<>();

	public boolean writeData(int data) throws InterruptedException {
		writeAccessLock.acquire();
		System.out.println(Thread.currentThread().getName() + ": got write-lock");
		queue.add(data);
		// 2 second delay to simulate lock
		Thread.sleep(2000);
		writeAccessLock.release();
		System.out.println(Thread.currentThread().getName() + ": released write-lock");
		return true;
	}
}
