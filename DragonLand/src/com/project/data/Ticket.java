package com.project.data;

public class Ticket {
	private String num;
	private String date;
	private int adult;
	private int teen;
	private int kid;
	private String cardNum;
	private String payment;
	private String userNum;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getTeen() {
		return teen;
	}
	public void setTeen(int teen) {
		this.teen = teen;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public Ticket(String num, String date, int adult, int teen, int kid, String cardNum, String payment,
			String userNum) {
		this.num = num;
		this.date = date;
		this.adult = adult;
		this.teen = teen;
		this.kid = kid;
		this.cardNum = cardNum;
		this.payment = payment;
		this.userNum = userNum;
	}
	public Ticket() {
		this("","",0,0,0,"","","");
	}
	
}
