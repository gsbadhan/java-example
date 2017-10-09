package com.clone;

public class Student implements Cloneable {
	private Integer id;
	private String name;

	public Student() {
	}

	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ",hashCode=" + this.hashCode() + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return this;
	}

}
