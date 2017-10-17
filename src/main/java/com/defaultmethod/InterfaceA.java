package com.defaultmethod;

public interface InterfaceA {

	default void init() {
		System.out.println("initialize context-A..");
	}

	default Object getReadTrx() {
		// write any logic
		System.out.println("getting read trx..");
		return new Object();
	}

	default Object getReadOnlyTrx() {
		// write any logic
		System.out.println("getting read-only trx..");
		return new Object();
	}

	Object getWriteTrx();
}
