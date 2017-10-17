package com.defaultmethod;

public interface InterfaceB {

	default void init() {
		System.out.println("initialize context-B..");
	}

	void dispose();
	
}
