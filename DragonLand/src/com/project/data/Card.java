package com.project.data;

public class Card {
	private String cardNum;
	private String cardName;
	private String cardDiscount;

	public Card() {
		this("", "", "");
	}
	
	public Card(String cardNum, String cardName, String cardDiscount) {

		this.cardNum = cardNum;
		this.cardName = cardName;
		this.cardDiscount = cardDiscount;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardDiscount() {
		return cardDiscount;
	}

	public void setCardDiscount(String cardDiscount) {
		this.cardDiscount = cardDiscount;
	}

}
