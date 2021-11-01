package com.project.data;

/**
 * UserVoice 클래스입니다.
 * 고객의 소리 정보를 저장합니다. 
 * @author 이유미
 */
public class UserVoice {
	
	private String seq;
	private String date;
	private String content;

	/**
	 * 기본 생성자입니다. 공백을 가집니다.
	 */
	public UserVoice() {
		this("", "", "");
	}
	
	/**
	 * 생성자입니다. 
	 * 원하는 값으로 객체를 생성합니다. 
	 * @param seq 고객의 소리 번호
	 * @param date 날짜
	 * @param content 내용
	 */
	public UserVoice(String seq, String date, String content) {
		this.seq = seq;
		this.date = date;
		this.content = content;
	}

	/**
	 * 순번을 가져옵니다.
	 * @return 번호
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * 순번을 설정합니다.
	 * @param seq 번호
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * 날짜를 가져옵니다.
	 * @return 날짜
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 날짜를 설정합니다.
	 * @param date 날짜
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 내용을 가져옵니다.
	 * @return 내용
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 내용을 설정합니다.
	 * @param content 내용
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 회원의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "UserVoice [seq=" + seq + ", date=" + date + ", content=" + content + "]";
	}
	
}
