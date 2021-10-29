package com.project.data;

public class User {
	private String seq;
	private String id;
	private String pw;
	private String name;
	private String jumin;
	private String phoneNum;
	private String address;
	private Boolean vote;

	public User() {
		this("","","","","","","",false);
	}
	
	public User(String seq, String id, String pw, String name, String jumin, String phoneNum, String address,
			Boolean vote) {
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.jumin = jumin;
		this.phoneNum = phoneNum;
		this.address = address;
		this.vote = vote;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getVote() {
		return vote;
	}

	public void setVote(Boolean vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "User [seq=" + seq + ", id=" + id + ", pw=" + pw + ", name=" + name + ", jumin=" + jumin + ", phoneNum="
				+ phoneNum + ", address=" + address + ", vote=" + vote + "]";
	}
	
}
