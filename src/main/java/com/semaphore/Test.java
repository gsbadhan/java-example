package com.semaphore;

public class Test {

	@org.junit.Test
	public void testWriteLock() {
		DataRepository repository = new DataRepository();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					repository.writeData(11);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.setName("t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					repository.writeData(12);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t2.setName("t2");

		t1.start();
		t2.start();

		// to avoid stop JVM's main thread
		try {
			Thread.currentThread().join(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
