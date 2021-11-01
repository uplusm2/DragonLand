package com.project.data;

/**
 * Facility 클래스입니다. 
 * 편의시설 정보를 담습니다.
 * @author 써니
 *
 */
public class Facility {
	
	private String seq;
	private String type;
	private String name;
	private String time;
	private String locateNum;
	
	/**
	 * Facility 클래스의 생성자입니다.
	 * @param seq 편의시설 고유번호
	 * @param type 편의시설 타입
	 * @param name 편의시설 이름
	 * @param time 편의시설 운영시간
	 * @param locateNum 편의시설 위치번호
	 */
	public Facility(String seq, String type, String name, String time, String locateNum) {
		this.seq = seq;
		this.type = type;
		this.name = name;
		this.time = time;
		this.locateNum = locateNum;
	}
	
	/**
	 * 편의시설의 고유번호를 반환합니다.
	 * @return
	 */
	public String getSeq() {
		return seq;
	}
	
	/**
	 * 편의시설의 타입을 반환합니다.
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 편의시설의 이름을 반환합니다.
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 편의시설의 운영시간을 반환합니다.
	 * @return
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * 편의시설의 위치번호를 반환합니다.
	 * @return
	 */
	public String getLocateNum() {
		return locateNum;
	}
	
	/**
	 * 편의시설 객체 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "Facility [seq=" + seq + ", type=" + type + ", name=" + name + ", time=" + time + ", locateNum="
				+ locateNum + "]";
	}
	
}