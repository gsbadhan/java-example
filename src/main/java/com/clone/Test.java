package com.clone;

public class Test {

	// test: shallow copy
	@org.junit.Test
	public void testShallowCopyClone() throws CloneNotSupportedException {
		Employee employeeOriginal = new Employee(101, "johan");
		System.out.println("original employee:" + employeeOriginal);

		// make clone of new copy of original employee
		Employee employeeShallow = (Employee) employeeOriginal.clone();
		System.out.println("shallow employee:" + employeeShallow);

		System.out.println("is employee's hascode different:" + (employeeOriginal != employeeShallow));

	}

	// test:deep copy
	@org.junit.Test
	public void testDeepCopyClone() throws CloneNotSupportedException {
		Student studentOriginal = new Student(1, "tom");
		System.out.println("original student:" + studentOriginal);

		//deep copy of student
		Student studentShallow = (Student) studentOriginal.clone();
		System.out.println("shallow student:" + studentShallow);
		
		System.out.println("is student's hascode same:" + (studentOriginal == studentShallow));
	}

}
