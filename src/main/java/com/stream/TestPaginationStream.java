package com.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestPaginationStream {

	@Test
	public void testPagination() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));
		employees.add(new Employee(103, "sam", "it", new Date(), 2500));
		employees.add(new Employee(105, "himan", "test", new Date(), 1600));
		employees.add(new Employee(106, "jack", "test", new Date(), 1700));

		List<Employee> list = employees.stream().skip(0).limit(1).collect(Collectors.toList());
		System.out.println(list);
		
		list = employees.stream().skip(3).limit(2).collect(Collectors.toList());
		System.out.println(list);
		
	}

}
