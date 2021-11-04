package com.project.data;

/**
 * 월별판매정보 클래스
 * @author 김재형
 *
 */
public class MonthlySales {
	//정보날짜(YYYYMM)■성인매수■청소년매수■어린이매수■성인금액■청소년금액■어린이금액■총인원■총금액

	private String date;
	private String adultCount;
	private String youthCount;
	private String kidCount;
	private String adultPrice;
	private String youthPrice;
	private String kidPrice;
	private String totalCount;
	private String totalPrice;
	
	/**
	 * 월별매출정보 생성자
	 */
	public MonthlySales() {
		this("", "", "", "", "", "", "", "", "");
	}
	
	/**
	 * 월별매출정보 생성자
	 * @param date
	 * @param adultCount
	 * @param youthCount
	 * @param kidCount
	 * @param adultPrice
	 * @param youthPrice
	 * @param kidPrice
	 * @param totalCount
	 * @param totalPrice
	 */
	public MonthlySales(String date, String adultCount, String youthCount, String kidCount, String adultPrice,
			String youthPrice, String kidPrice, String totalCount, String totalPrice) {
		
		this.date = date;
		this.adultCount = adultCount;
		this.youthCount = youthCount;
		this.kidCount = kidCount;
		this.adultPrice = adultPrice;
		this.youthPrice = youthPrice;
		this.kidPrice = kidPrice;
		this.totalCount = totalCount;
		this.totalPrice = totalPrice;
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
	 * 어른 수를 반환합니다.
	 * @return
	 */
	public String getAdultCount() {
		return adultCount;
	}
	
	/**
	 * 어른 수를 설정합니다.
	 * @param adultCount
	 */
	public void setAdultCount(String adultCount) {
		this.adultCount = adultCount;
	}
	
	/**
	 * 청소년 수를 반환합니다.
	 * @return
	 */
	public String getYouthCount() {
		return youthCount;
	}
	
	/**
	 * 청소년 수를 설정합니다.
	 * @param youthCount
	 */
	public void setYouthCount(String youthCount) {
		this.youthCount = youthCount;
	}
	
	/**
	 * 어린이 수를 반환합니다.
	 * @return
	 */
	public String getKidCount() {
		return kidCount;
	}
	
	/**
	 * 어린이 수를 설정합니다.
	 * @param kidCount
	 */
	public void setKidCount(String kidCount) {
		this.kidCount = kidCount;
	}
	
	/**
	 * 어른 총 금액을 반환합니다.
	 * @return
	 */
	public String getAdultPrice() {
		return adultPrice;
	}
	
	/**
	 * 어른 총 금액을 설정합니다.
	 * @param adultPrice
	 */
	public void setAdultPrice(String adultPrice) {
		this.adultPrice = adultPrice;
	}
	
	/**
	 * 청소년 총 금액을 반환합니다.
	 * @return
	 */
	public String getYouthPrice() {
		return youthPrice;
	}
	
	/**
	 * 청소년 총 금액을 설정합니다.
	 * @param youthPrice
	 */
	public void setYouthPrice(String youthPrice) {
		this.youthPrice = youthPrice;
	}
	
	/**
	 * 어린이 총 금액을 반환합니다.
	 * @return
	 */
	public String getKidPrice() {
		return kidPrice;
	}
	
	/**
	 * 어린이 총 금액을 설정합니다.
	 * @param kidPrice
	 */
	public void setKidPrice(String kidPrice) {
		this.kidPrice = kidPrice;
	}
	
	/**
	 * 총 인원수를 반환합니다.
	 * @return
	 */
	public String getTotalCount() {
		return totalCount;
	}
	
	/**
	 * 총 인원수를 설정합니다.
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * 총 금액을 반환합니다.
	 * @return
	 */
	public String getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * 총 금액을 설정합니다.
	 * @param totalPrice
	 */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * 월별매출정보 객체의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "MonthlySales [date=" + date + ", adultCount=" + adultCount + ", youthCount=" + youthCount
				+ ", kidCount=" + kidCount + ", adultPrice=" + adultPrice + ", youthPrice=" + youthPrice + ", kidPrice="
				+ kidPrice + ", totalCount=" + totalCount + ", totalPrice=" + totalPrice + "]";
	}
	
}
