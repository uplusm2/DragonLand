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
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(String adultCount) {
		this.adultCount = adultCount;
	}
	public String getYouthCount() {
		return youthCount;
	}
	public void setYouthCount(String youthCount) {
		this.youthCount = youthCount;
	}
	public String getKidCount() {
		return kidCount;
	}
	public void setKidCount(String kidCount) {
		this.kidCount = kidCount;
	}
	public String getAdultPrice() {
		return adultPrice;
	}
	public void setAdultPrice(String adultPrice) {
		this.adultPrice = adultPrice;
	}
	public String getYouthPrice() {
		return youthPrice;
	}
	public void setYouthPrice(String youthPrice) {
		this.youthPrice = youthPrice;
	}
	public String getKidPrice() {
		return kidPrice;
	}
	public void setKidPrice(String kidPrice) {
		this.kidPrice = kidPrice;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
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
