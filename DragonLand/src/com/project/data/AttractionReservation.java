package com.project.data;

public class AttractionReservation {
	private String seq;
	private String attractionNum;
	private String date;
	private String hour;
	private String count;
	private String userNum;
	
	public AttractionReservation(String seq, String attractionNum, String date, String hour, String count,
			String userNum) {
		this.seq = seq;
		this.attractionNum = attractionNum;
		this.date = date;
		this.hour = hour;
		this.count = count;
		this.userNum = userNum;
	}
	
	public String getSeq() {
		return seq;
	}
	
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	public String getAttractionNum() {
		return attractionNum;
	}
	
	public void setAttractionNum(String attractionNum) {
		this.attractionNum = attractionNum;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public String getCount() {
		return count;
	}
	
	public void setCount(String count) {
		this.count = count;
	}
	
	public String getUserNum() {
		return userNum;
	}
	
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	
	@Override
	public String toString() {
		return "[seq=" + seq + ", attractionNum=" + attractionNum + ", date=" + date + ", hour="
				+ hour + ", count=" + count + ", userNum=" + userNum + "]";
	}
	
}