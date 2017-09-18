package com.lock.condition;

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
				System.out.println(repositoryAccess.increment());
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
				System.out.println(repositoryAccess.increment());
			}
		});
		t4.setName("t4");

		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(repositoryAccess.decrement());
			}
		});
		t5.setName("t5");

		Thread t6 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(repositoryAccess.decrement());
			}
		});
		t6.setName("t6");

		Thread t7 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(repositoryAccess.decrement());
			}
		});
		t7.setName("t7");

		Thread t8 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(repositoryAccess.decrement());
			}
		});
		t8.setName("t8");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();

		// to avoid stop JVM's main thread
		try {
			Thread.currentThread().join(20 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
