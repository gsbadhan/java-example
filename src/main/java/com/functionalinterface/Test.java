package com.functionalinterface;

public class Test {

	@org.junit.Test
	public void testBiArgsFunction() {
		BiArgsFunction<Integer, Integer, Integer> function = (a, b) -> a + b;
		System.out.println(function.apply(11, 22));
	}

	@org.junit.Test
	public void testTriArgsFunction() {
		TriArgsFunction<String, String, String, String> function = (a, b, c) -> a + b + c;
		System.out.println(function.apply("hii ", " i am", " good !!"));
	}
	
}
