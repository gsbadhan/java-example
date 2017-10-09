package com.serialization;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 7002480190160964432L;

	private int id;
	private String name;
	private static String college = "Cambridge college";
	private transient String address;
	//should be serialize
	private DOB dob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		Student.college = college;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DOB getDob() {
		return dob;
	}

	public void setDob(DOB dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ",college=" + college + ",address=" + address + ",dob=" + dob
				+ "]";
	}

}
