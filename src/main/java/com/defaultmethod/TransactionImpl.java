package com.defaultmethod;

public class TransactionImpl implements InterfaceA, InterfaceB {

	@Override
	public Object getWriteTrx() {
		// write any logic
		System.out.println("getting write trx..");
		return new Object();
	}

	/*
	 * to support inheritance ambiguity i.e. same default method in multiple
	 * interfaces. we should follow below approach
	 */
	public void init() {
		InterfaceA.super.init();
		InterfaceB.super.init();
	}

	@Override
	public void dispose() {
		// write any logic
		System.out.println("dispose..");
	}

}
