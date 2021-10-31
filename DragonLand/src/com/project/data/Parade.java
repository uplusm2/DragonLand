package com.project.data;

import java.util.ArrayList;

public class Parade {
	private String title;
	private String startDate;
	private String endData;
	private String content;
	private String locate;
	private ArrayList<String> time;
	

	public Parade(String title, String startDate, String endData, String content, String locate) {
		this.title = title;
		this.startDate = startDate;
		this.endData = endData;
		this.content = content;
		this.locate = locate;
		time = new ArrayList<String>();
		time.add("13:00");
		time.add("14:00");
		time.add("15:00");
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndData() {
		return endData;
	}
	public void setEndData(String endData) {
		this.endData = endData;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	
	public ArrayList<String> getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "[title=" + title + ", startDate=" + startDate + ", endData=" + endData + ", content=" + content
				+ ", locate=" + locate + ", time=" + time + "]";
	}
}
