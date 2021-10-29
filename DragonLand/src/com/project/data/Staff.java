package com.project.data;

public class Staff {
	private String seq;
	private String name;
	private String age;
	private String address;
	private String phoneNum;
	private String place;
	
	public Staff() {
		this("","","","","","");
	}

	public Staff(String seq, String name, String age, String address, String phoneNum, String place) {
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNum = phoneNum;
		this.place = place;
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
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
}
