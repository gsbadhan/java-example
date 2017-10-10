package com.functionalinterface;

@FunctionalInterface
public interface TriArgsFunction<A, B, C, R> {
	R apply(A a, B b, C c);
}
