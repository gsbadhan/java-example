package com.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestStream {

	@Test
	public void testDistinct() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(101, "tom", "engg", new Date(), 3000));

		List<Employee> distinct = employees.stream().distinct().collect(Collectors.toList());
		System.out.println(distinct);
	}

	@Test
	public void testSorting() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));

		List<Employee> sorted = employees.stream()
				.sorted((Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toList());
		System.out.println(sorted);
	}

	@Test
	public void testToMap() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));

		Map<Long, Object> data = employees.stream().collect(Collectors.toMap(Employee::getId, e -> e.getName()));
		System.out.println(data);
	}
}
