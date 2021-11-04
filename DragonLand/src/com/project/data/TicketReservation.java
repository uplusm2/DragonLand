package com.project.data;

/**
 * 티켓예매 클래스
 * @author 김재형
 *
 */
public class TicketReservation {
	private String seq; // 티켓예약번호
	private String date; // 예약한 날짜
	private String adultCount; // 성인매수
	private String youthCount; // 청소년매수
	private String kidCount; // 어린이매수
	private String cardNum; // 카드선택 유형번호
	private String price; // 티켓 가격
	private String userNum; // 회원번호 -> get만 생성
	
	/**
	 * 티켓예매 기본 생성자
	 */
	public TicketReservation() {
		this("", "", "", "", "", "", "", "");
	}
	
	/**
	 * 티켓예매 생성자
	 * @param seq
	 * @param date
	 * @param adultCount
	 * @param youthCount
	 * @param kidCount
	 * @param cardNum
	 * @param price
	 * @param userNum
	 */
	public TicketReservation(String seq, String date, String adultCount, String youthCount, String kidCount,
			String cardNum, String price, String userNum) {
		super();
		this.seq = seq;
		this.date = date;
		this.adultCount = adultCount;
		this.youthCount = youthCount;
		this.kidCount = kidCount;
		this.cardNum = cardNum;
		this.price = price;
		this.userNum = userNum;
	}


	
	/**
	 * 티켓번호를 반환합니다.
	 * @return
	 */
	public String getSeq() {
		return seq;
	}
	
	/**
	 * 티켓번호를 설정합니다.
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * 날짜를 반환합니다.
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 날짜를 설정합니다.
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * 총 어른 수를 반환합니다.
	 * @return
	 */
	public String getAdultCount() {
		return adultCount;
	}
	
	/**
	 * 총 어른 수를 설정합니다.
	 * @param adultCount
	 */
	public void setAdultCount(String adultCount) {
		this.adultCount = adultCount;
	}
	
	/**
	 * 총 청소년 수를 반환합니다.
	 * @return
	 */
	public String getYouthCount() {
		return youthCount;
	}
	
	/**
	 * 총 청소년 수를 설정합니다.
	 * @param youthCount
	 */
	public void setYouthCount(String youthCount) {
		this.youthCount = youthCount;
	}
	
	/**
	 * 총 어린이 수를 반환합니다.
	 * @return
	 */
	public String getKidCount() {
		return kidCount;
	}
	
	/**
	 * 총 어린이 수를 설정합니다.
	 * @param kidCount
	 */
	public void setKidCount(String kidCount) {
		this.kidCount = kidCount;
	}
	
	/**
	 * 카드 넘버를 반환합니다.
	 * @return
	 */
	public String getCardNum() {
		return cardNum;
	}
	
	/**
	 * 카드 넘버를 설정합니다.
	 * @param cardNum
	 */
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	/**
	 * 가격을 반환합니다.
	 * @return
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * 가격을 설정합니다.
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * 회원번호를 반환합니다.
	 * @return
	 */
	public String getUserNum() {
		return userNum;
	}
	
	/**
	 * 티켓예매 객체의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return String.format(
				"[seq=%s, date=%s, adultCount=%s, youthCount=%s, kidCount=%s, cardNum=%s, price=%s, userNum=%s]",
				seq, date, adultCount, youthCount, kidCount, cardNum, price, userNum);
	}

	

}
