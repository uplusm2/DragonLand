package com.project.data;

public class Voice {
	
	private String seq;
	private String date;
	private String content;
	
	
	public Voice(String seq, String date, String content) {
		super();
		this.seq = seq;
		this.date = date;
		this.content = content;
	}


	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Voice() {
		this("", "", "");
	}

}
