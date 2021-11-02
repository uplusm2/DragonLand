package com.project.data;

/**
 * 티켓 요금 정보 클래스입니다.
 * @author 김성연
 *
 */
public class Ticket {
	private String userType; // 성인,청소년,어린이
	private String price; //가격
	private String note; //비고

	/**
	 * 티켓 요금 정보 생성자입니다
	 * @param userType 회원의 성인/청소년/아이 정보
	 * @param price 티켓 요금
	 * @param note 티켓 비고
	 */
	public Ticket(String userType, String price, String note) {

		this.userType = userType;
		this.price = price;
		this.note = note;
	}
	/**
	 * 기본 생성자입니다. 
	 */
	public Ticket() {
		this("", "", "");
	}

	/**
	 * @return userType 회원의 나이대
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @return price 티켓 요금
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @return note 티켓 비고
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 문자열 반환
	 */
	@Override
	public String toString() {
		return "Ticket [userType=" + userType + ", price=" + price + ", note=" + note + "]";
	}
	
}
