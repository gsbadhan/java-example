package com.functionalinterface;

@FunctionalInterface
public interface BiArgsFunction<A, B, R> {
	R apply(A a, B b);
}
