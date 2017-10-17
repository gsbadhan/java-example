package com.defaultmethod;

import org.junit.Test;

public class TestDefaultMethod {

	@Test
	public void test() {
		TransactionImpl impl = new TransactionImpl();
		impl.init();
		impl.getWriteTrx();
		impl.getReadOnlyTrx();
		impl.getReadTrx();
		impl.dispose();
	}
}
