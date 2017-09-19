package com.exchanger;

import java.util.concurrent.Exchanger;

public class User2 implements Runnable {
	private Exchanger<String> dataSharing;

	public User2(Exchanger<String> dataSharing) {
		this.dataSharing = dataSharing;
	}

	@Override
	public void run() {
		int msg = 0;
		while (true) {
			try {
				String incomingMsg = dataSharing.exchange(Thread.currentThread().getName() + (--msg));
				System.out.println(Thread.currentThread().getName() + ": got msg:" + incomingMsg);
				sleep();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
