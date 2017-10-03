package com.comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class Test {

	@org.junit.Test
	public void testCompare() {
		// tree-set use employee's comparable method for sorting
		TreeSet<Employee> sortedSetById = new TreeSet<>();
		sortedSetById.add(new Employee(181, "wolks", "IT"));
		sortedSetById.add(new Employee(101, "lilly", "IT"));
		sortedSetById.add(new Employee(150, "aray", "IT"));

		Iterator<Employee> itr = sortedSetById.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
