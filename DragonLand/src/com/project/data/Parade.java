package com.project.data;

import java.util.ArrayList;

/**
 * Parade 클래스입니다.
 * 퍼레이드 정보를 담습니다.
 * @author 써니
 *
 */
public class Parade {
	private String title;
	private String startDate;
	private String endData;
	private String content;
	private String locate;
	private ArrayList<String> time;
	
	/**
	 * Parade 클래스 생성자입니다.
	 * @param title 퍼레이드 이름
	 * @param startDate 퍼레이드 시작일자
	 * @param endData 퍼레이드 종료일자
	 * @param content 퍼레이드 내용
	 * @param locate 퍼레이드 장소
	 */
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
	
	/**
	 * 퍼레이드 이름을 반환합니다.
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 퍼레이드 이름을 변경합니다.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 퍼레이드 시작일자를 반환합니다.
	 * @return
	 */
	public String getStartDate() {
		return startDate;
	}
	
	/**
	 * 퍼레이드 시작일자를 변경합니다.
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * 퍼레이드 종료일자를 반환합니다.
	 * @return
	 */
	public String getEndData() {
		return endData;
	}
	
	/**
	 * 퍼레이드 종료일자를 변경합니다.
	 * @param endData
	 */
	public void setEndData(String endData) {
		this.endData = endData;
	}
	
	/**
	 * 퍼레이드 내용을 반환합니다.
	 * @return
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 퍼레이드 내용을 변경합니다.
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 퍼레이드 장소를 반환합니다.
	 * @return
	 */
	public String getLocate() {
		return locate;
	}
	
	/**
	 * 퍼레이드 장소를 변경합니다.
	 * @param locate
	 */
	public void setLocate(String locate) {
		this.locate = locate;
	}
	
	/**
	 * 퍼레이드 시간 배열을 반환합니다.
	 * @return
	 */
	public ArrayList<String> getTime() {
		return time;
	}

	/**
	 * Parade 객체 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "[title=" + title + ", startDate=" + startDate + ", endData=" + endData + ", content=" + content
				+ ", locate=" + locate + ", time=" + time + "]";
	}
}
