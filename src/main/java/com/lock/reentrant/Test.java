package com.lock.reentrant;

public class Test {

	@org.junit.Test
	public void testLockOnObject() {
		
		RepositoryAccess repositoryAccess = new RepositoryAccess();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(repositoryAccess.increment());
			}
		});
		t1.setName("t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(repositoryAccess.decrement());
			}
		});
		t2.setName("t2");

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(repositoryAccess.increment());
			}
		});
		t3.setName("t3");

		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(repositoryAccess.decrement());
			}
		});
		t4.setName("t4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		// to avoid stop JVM's main thread
		try {
			Thread.currentThread().join(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
