package com.waitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class Basket {
	private Queue<Integer> data = new LinkedList<>();

	public synchronized void put(Integer item) throws InterruptedException {
		if (data.isEmpty()) {
			data.add(item);
			notifyAll();
		} else {
			wait();
		}
	}

	public synchronized Integer get() throws InterruptedException {
		Integer item = null;
		if (data.isEmpty()) {
			wait();
		} else {
			item = data.poll();
			notifyAll();
		}
		return item;
	}
}
