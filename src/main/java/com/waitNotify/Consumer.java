package com.waitNotify;

public class Consumer implements Runnable {
	private Basket basket;

	public Consumer(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		int counter = 5;
		while (counter > 0) {
			try {
				int item = basket.get();
				System.out.println(Thread.currentThread().getName() + ":get:" + item);
				--counter;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
