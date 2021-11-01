package com.project.data;

/**
 * 고객의 소리 클래스
 * @author 김재형
 *
 */
public class UserVoice {
	
	private String seq;
	private String date;
	private String content;
	
	/**
	 * 고객의 소리 생성자
	 * @param seq
	 * @param date
	 * @param content
	 */
	public UserVoice(String seq, String date, String content) {
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

	
	/**
	 * 기본 생성자
	 */
	public UserVoice() {
		this("", "", "");
	}

	/**
	 * 고객의 소리 객체의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "UserVoice [seq=" + seq + ", date=" + date + ", content=" + content + "]";
	}
	
	

}
