package com.project.data;

public class Staff {
	private String seq;
	private String name;
	private String age;
	private String address;
	private String phoneNum;
	private String workPlace;
	
	public Staff() {
		this("","","","","","");
	}
	
	public Staff(String seq, String name, String age, String address, String phoneNum, String workPlace) {
		super();
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNum = phoneNum;
		this.workPlace = workPlace;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	@Override
	public String toString() {
		return "Staff [seq=" + seq + ", name=" + name + ", age=" + age + ", address=" + address + ", phoneNum="
				+ phoneNum + ", workPlace=" + workPlace + "]";
	}

}