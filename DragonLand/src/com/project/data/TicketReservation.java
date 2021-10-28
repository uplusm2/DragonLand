package com.project.data;

public class TicketReservation {
	private String mtNum;
	private String mtDate;
	private String adultCount;
	private String youthCount;
	private String kidCount;
	private String cardNum;
	private String mtPrice;
	private String mNum;

	public TicketReservation() {
		this("", "", "", "", "", "","","");
	}

	
	public TicketReservation(String mtNum, String mtDate, String adultCount, String youthCount, String kidCount,
			String cardNum, String mtPrice, String mNum) {
		
		this.mtNum = mtNum;
		this.mtDate = mtDate;
		this.adultCount = adultCount;
		this.youthCount = youthCount;
		this.kidCount = kidCount;
		this.cardNum = cardNum;
		this.mtPrice = mtPrice;
		this.mNum = mNum;
	}


	@Override
	public String toString() {
		return String.format(
				"[mtNum=%s, mtDate=%s, adultCount=%s, youthCount=%s, kidCount=%s, cardNum=%s, mtPrice=%s, mNum=%s]",
				mtNum, mtDate, adultCount, youthCount, kidCount, cardNum, mtPrice, mNum);
	}


	public String getMtNum() {
		return mtNum;
	}

	public void setMtNum(String mtNum) {
		this.mtNum = mtNum;
	}

	public String getMtDate() {
		return mtDate;
	}

	public void setMtDate(String mtDate) {
		this.mtDate = mtDate;
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

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getMtPrice() {
		return mtPrice;
	}

	public void setMtPrice(String mtPrice) {
		this.mtPrice = mtPrice;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}


	
}
