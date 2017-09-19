package com.exchanger;

import java.util.concurrent.Exchanger;

public class Test {

	@org.junit.Test
	public void testDataSharing() {
		Exchanger<String> dataShare = new Exchanger<>();

		Thread t1 = new Thread(new User1(dataShare));
		t1.setName("userA");
		Thread t2 = new Thread(new User2(dataShare));
		t2.setName("userB");

		t1.start();
		t2.start();

		// avoid to stop JVM's main thread
		delay();
	}

	private static void delay() {
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
