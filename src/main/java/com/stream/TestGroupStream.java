package com.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestGroupStream {

	@Test
	public void testCountGroupByDept() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));
		employees.add(new Employee(103, "sam", "it", new Date(), 2500));
		employees.add(new Employee(105, "himan", "test", new Date(), 1600));
		employees.add(new Employee(106, "jack", "test", new Date(), 1700));

		Map<String, Long> deptWiseCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
		System.out.println("count dept wise:" + deptWiseCount);
	}

	@Test
	public void testGroupByMaxSalary() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));
		employees.add(new Employee(103, "sam", "it", new Date(), 2500));
		employees.add(new Employee(105, "himan", "test", new Date(), 1600));
		employees.add(new Employee(106, "jack", "test", new Date(), 1700));

		Map<String, Optional<Employee>> maxSalaryDeptWise = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.maxBy((Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary()))));

		System.out.println(maxSalaryDeptWise);
	}

	@Test
	public void testMinMaxSalary() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));
		employees.add(new Employee(103, "sam", "it", new Date(), 2500));
		employees.add(new Employee(105, "himan", "test", new Date(), 1600));
		employees.add(new Employee(106, "jack", "test", new Date(), 1700));
		employees.add(new Employee(106, "steve", "manager", new Date(), 7800));

		Optional<Employee> maxSalaryEmp = employees.stream()
				.collect(Collectors.maxBy((Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary())));
		System.out.println("max salary:" + maxSalaryEmp);

		Optional<Employee> minSalaryEmp = employees.stream()
				.collect(Collectors.maxBy((Employee e1, Employee e2) -> e2.getSalary().compareTo(e1.getSalary())));
		System.out.println("min salary:" + minSalaryEmp);

	}

	@Test
	public void testAvgSalaryDeptWise() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));
		employees.add(new Employee(103, "sam", "it", new Date(), 2500));
		employees.add(new Employee(105, "himan", "test", new Date(), 1600));
		employees.add(new Employee(106, "jack", "test", new Date(), 1700));
		employees.add(new Employee(106, "steve", "manager", new Date(), 7800));

		Map<String, Double> avgSalaryDeptWise = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("avg salary dept wise:" + avgSalaryDeptWise);

	}
	
	@Test
	public void testTotalCostDeptWise() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));
		employees.add(new Employee(103, "sam", "it", new Date(), 2500));
		employees.add(new Employee(105, "himan", "test", new Date(), 1600));
		employees.add(new Employee(106, "jack", "test", new Date(), 1700));
		employees.add(new Employee(106, "steve", "manager", new Date(), 7800));

		Map<String, Double> sumSalaryDeptWise = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.summingDouble(Employee::getSalary)));
		System.out.println("sum salary dept wise:" + sumSalaryDeptWise);

	}
	
	@Test
	public void testSummarizeDeptCost() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "john", "it", new Date(), 1000));
		employees.add(new Employee(102, "tom", "engg", new Date(), 3000));
		employees.add(new Employee(103, "sam", "it", new Date(), 2500));
		employees.add(new Employee(105, "himan", "test", new Date(), 1600));
		employees.add(new Employee(106, "jack", "test", new Date(), 1700));
		employees.add(new Employee(106, "steve", "manager", new Date(), 7800));

		Map<String, DoubleSummaryStatistics> summarizeSalaryDeptWise = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.summarizingDouble(Employee::getSalary)));
		System.out.println("summarize salary dept wise:" + summarizeSalaryDeptWise);

	}

}
