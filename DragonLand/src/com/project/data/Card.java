package com.project.data;

public class Card {
	private String seq;
	private String name;
	private String discount;

	public Card() {
		this("", "", "");
	}

	public Card(String seq, String name, String discount) {
		super();
		this.seq = seq;
		this.name = name;
		this.discount = discount;
	}

	public String getSeq() {
		return seq;
	}

	public String getName() {
		return name;
	}

	public String getDiscount() {
		return discount;
	}
}
