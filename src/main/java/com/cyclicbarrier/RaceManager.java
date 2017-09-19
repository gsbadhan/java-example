package com.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class RaceManager {
	private RaceManager() {
	}

	public static void startRace(int runners) {
		CyclicBarrier raceBarrier = new CyclicBarrier(runners);
		for (int i = 1; i <= runners; i++) {
			Thread t = new Thread(new Runner(raceBarrier));
			t.setName("runner-" + i);
			t.start();
		}

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
