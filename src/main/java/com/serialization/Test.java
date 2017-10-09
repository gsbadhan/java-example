package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Test {

	@org.junit.Test
	public void testWrite() throws FileNotFoundException, IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.dat"));
		Student student = new Student();
		student.setId(101);
		student.setName("tom");
		// should not save, because its `static` field
		student.setCollege("London college");
		// should not save, because its `transient` field
		student.setAddress("street 106,London");
		//student.setDob(new DOB(12, 05, 1956));
		outputStream.writeObject(student);
		outputStream.flush();
		outputStream.close();
	}

	@org.junit.Test
	public void testRead() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student.dat"));
		Student student = (Student) inputStream.readObject();
		inputStream.close();
		System.out.println(student);
	}
}
