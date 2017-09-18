package com.waitNotify;

public class Producer implements Runnable {
	private Basket basket;

	public Producer(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		int counter = 1;
		while (counter <= 5) {
			try {
				basket.put(counter);
				System.out.println(Thread.currentThread().getName() + ":put:" + counter);
				++counter;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
