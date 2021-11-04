package com.project.data;

/**
 * AttractionReservation 클래스입니다.
 * 어트랙션 예약 정보가 들어있습니다.
 * @author songj
 *
 */
public class AttractionReservation {
	private String seq;
	private String attractionNum;
	private String date;
	private String hour;
	private String count;
	private String userNum;
	
	/**
	 * AttractionReservation 클래스 생성자입니다.
	 * @param seq 예약번호
	 * @param attractionNum 어트랙션 번호
	 * @param date 날짜
	 * @param hour 시간
	 * @param count 예약인원
	 * @param userNum 회원번호
	 */
	public AttractionReservation(String seq, String attractionNum, String date, String hour, String count,
			String userNum) {
		this.seq = seq;
		this.attractionNum = attractionNum;
		this.date = date;
		this.hour = hour;
		this.count = count;
		this.userNum = userNum;
	}
	
	/**
	 * 예약번호를 반환합니다.
	 * @return
	 */
	public String getSeq() {
		return seq;
	}
	/**
	 * 예약번호를 변경합니다.
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * 어트랙션 번호를 반환합니다.
	 * @return
	 */
	public String getAttractionNum() {
		return attractionNum;
	}
	/**
	 * 어트랙션 번호를 변경합니다.
	 * @param attractionNum
	 */
	public void setAttractionNum(String attractionNum) {
		this.attractionNum = attractionNum;
	}
	
	/**
	 * 날짜를 반환합니다.
	 * @return
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 날짜를 변경합니다.
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * 시간을 반환합니다.
	 * @return
	 */
	public String getHour() {
		return hour;
	}
	/**
	 * 시간을 변경합니다.
	 * @param hour
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	/**
	 * 예약 인원수를 반환합니다.
	 * @return
	 */
	public String getCount() {
		return count;
	}
	/**
	 * 예약 인원수를 변경합니다.
	 * @param count
	 */
	public void setCount(String count) {
		this.count = count;
	}
	
	/**
	 * 회원 번호를 반환합니다.
	 * @return
	 */
	
	public String getUserNum() {
		return userNum;
	}
	/**
	 * 유저번호를 변경합니다.
	 * @param userNum
	 */
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	
	/**
	 * 어트랙션 예약정보 객체를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "[seq=" + seq + ", attractionNum=" + attractionNum + ", date=" + date + ", hour="
				+ hour + ", count=" + count + ", userNum=" + userNum + "]";
	}
	
}
