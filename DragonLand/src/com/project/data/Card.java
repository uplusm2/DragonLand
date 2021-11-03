package com.project.data;

/**
 * 카드 정보 클래스입니다
 * @author 김성연
 *
 */
public class Card {
	private String seq;
	private String name;
	private String discount;

	/**
	 * 기본 생성자. 공백을가집니다.
	 */
	public Card() {
		this("", "", "");
	}

	/**
	 * 생성자입니다
	 * @param seq 카드 번호 
	 * @param name 카드 이름
	 * @param discount 카드 할인율
	 */
	public Card(String seq, String name, String discount) {
		super();
		this.seq = seq;
		this.name = name;
		this.discount = discount;
	}

	/**
	 * @return seq 카드 번호
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @return name 카드 이름
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return discount 카드 할인율
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * 카드 번호를 문자열로 바꿔줍니다.
	 */
	@Override
	public String toString() {
		return "Card [seq=" + seq + ", name=" + name + ", discount=" + discount + "]";
	}
	
}
