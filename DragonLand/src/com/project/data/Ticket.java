package com.project.data;

public class Ticket {
	private String userType; // 성인,청소년,어린이
	private String price; //가격
	private String note; //비고

	public Ticket(String userType, String price, String note) {

		this.userType = userType;
		this.price = price;
		this.note = note;
	}

	public Ticket() {
		this("", "", "");
	}

	public String getUserType() {
		return userType;
	}

	public String getPrice() {
		return price;
	}

	public String getNote() {
		return note;
	}


}
