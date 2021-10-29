package com.project.data;

public class AttractionReservation {

	
	private String code;
	private String mtDate;
	private String date;
	private String hour;
	private String ReserveNums;
	private String mNum;
	
	public AttractionReservation(String code, String mtDate, String date, String hour, String ReserveNums, String mNum) {
		this.code = code;
		this.mtDate = mtDate;
		this.date = date;
		this.hour = hour;
		this.ReserveNums = ReserveNums;
		this.mNum = mNum;
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMtDate() {
		return mtDate;
	}

	public void setMtDate(String mtDate) {
		this.mtDate = mtDate;
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

	public String getReserveNums() {
		return ReserveNums;
	}

	public void setReserveNums(String reserveNums) {
		ReserveNums = reserveNums;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	@Override
	public String toString() {
		return String.format("[code=%s, mtDate=%s, date=%s, hour=%s, ReserveNums=%s, mNum=%s]",
				code, mtDate, date, hour, ReserveNums, mNum);
	}

	
	
}
