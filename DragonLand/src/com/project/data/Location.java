package com.project.data;

/**
 * Locate 클래스입니다.
 * 놀이공원 시설 위치 정보를 담습니다.
 * @author 써니
 *
 */
public class Location {
	private String seq;
	private String locate;
	
	/**
	 * Locate 클래스 생성자 입니다.
	 * @param seq 위치 정보 고유번호
	 * @param locate 위치 이름
	 */
	public Location(String seq, String locate) {
		this.seq = seq;
		this.locate = locate;
	}
	
	/**
	 * 위치 정보의 고유번호를 반환합니다.
	 * @return
	 */
	public String getSeq() {
		return seq;
	}
	
	/**
	 * 위치 정보의 이름을 반환힙니다.
	 * @return
	 */
	public String getLocate() {
		return locate;
	}

	/**
	 * Locate 객체 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "Location [seq=" + seq + ", locate=" + locate + "]";
	}
	
}
