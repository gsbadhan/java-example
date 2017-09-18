package com.waitNotify;

public class Test {

	@org.junit.Test
	public void testWaitNotify() {
		// data bucket
		Basket basket = new Basket();

		// one producer thread
		Thread t = new Thread(new Producer(basket));
		t.setName("producer");
		t.start();

		// two consumer threads
		Thread t1 = new Thread(new Consumer(basket));
		t1.setName("consumer");
		t1.start();


	}
}
