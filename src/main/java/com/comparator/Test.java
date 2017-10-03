package com.comparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	@org.junit.Test
	public void testCompare() {
		// unsorted list of employees
		List<Employee> unSortedEmployees = new ArrayList<>();
		unSortedEmployees.add(new Employee(181, "wolks", "IT"));
		unSortedEmployees.add(new Employee(101, "lilly", "IT"));
		unSortedEmployees.add(new Employee(150, "aray", "IT"));

		// sort by Name
		unSortedEmployees.sort(new NameComparator());
		Iterator<Employee> itr = unSortedEmployees.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("----");
		// sort by ID
		unSortedEmployees.sort(new IdComparator());
		itr = unSortedEmployees.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
