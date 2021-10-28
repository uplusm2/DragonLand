package com.project.data;

public class Ticket {
	private String userType;
	private String ticketPrice;
	private String note;

	public Ticket(String userType, String ticketPrice, String note) {

		this.userType = userType;
		this.ticketPrice = ticketPrice;
		this.note = note;
	}

	public Ticket() {
		this("", "", "");
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
