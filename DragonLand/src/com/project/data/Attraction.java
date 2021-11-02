package com.project.data;

/**
 * Attraction 클래스입니다. 
 * 어트랙션의 정보를 담습니다.
 * @author 써니
 *
 */
public class Attraction {
	private String seq;
	private String name;
	private String attractionType;
	private String capacity;
	private String runTime;
	private String locateSeq;
	private String waitTime;
	private String vote;
	private String on;

	/**
	 * Attraction 클래스의 기본 생성자입니다.
	 */
	public Attraction() {
		this("", "", "", "", "", "", "", "", "");
	}
	
	/**
	 * Attraction 클래스 생성자입니다.
	 * @param seq 어트랙션 고유번호
	 * @param name 어트랙션 이름
	 * @param attractionType 어트랙션 타입
	 * @param capacity 어트랙션 수용인원
	 * @param runTime 어트랙션 운영시간
	 * @param locateSeq 어트랙션 위치번호
	 * @param waitTime 어트랙션 대기시간
	 * @param vote 어트랙션 추천수
	 * @param on 어트랙션 운영여부
	 */
	public Attraction(String seq, String name, String attractionType, String capacity, String runTime, String locateSeq, String waitTime, String vote, String on) {
		this.seq = seq;
		this.name = name;
		this.attractionType = attractionType;
		this.capacity = capacity;
		this.runTime = runTime;
		this.locateSeq = locateSeq;
		this.waitTime = waitTime;
		this.vote = vote;
		this.on = on;
	}

	/**
	 * 어트랙션의 고유번호를 반환합니다.
	 * @return
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * 어트랙션의 이름을 반환합니다.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 어트랙션의 타입을 반환합니다.
	 * @return
	 */
	public String getAttractionType() {
		return attractionType;
	}
	
	/**
	 * 어트랙션의 수용인원을 반환합니다.
	 * @return
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * 어트랙션의 운영시간을 반환합니다.
	 * @return
	 */
	public String getRunTime() {
		return runTime;
	}

	/**
	 * 어트랙션의 위치번호를 반환합니다.
	 * @return
	 */
	public String getLocateSeq() {
		return locateSeq;
	}

	/**
	 * 어트랙션의 대기시간을 반환합니다.
	 * @return
	 */
	public String getWaitTime() {
		return waitTime;
	}

	/**
	 * 어트랙션의 추천수를 반환합니다.
	 * @return
	 */
	public String getVote() {
		return vote;
	}

	/**
	 * 어트랙션의 운영여부를 반환합니다.
	 * @return 
	 */
	public String getOn() {
		return on;
	}

	/**
	 * 어트랙션의 이름을 변경합니다.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 어트랙션의 대기시간을 변경합니다.
	 * @param waitTime
	 */
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	
	/**
	 * 어트랙션의 추천수를 변경합니다.
	 * @param vote
	 */
	public void setVote(String vote) {
		this.vote = vote;
	}
	
	/**
	 * 어트랙션의 운영여부를 변경합니다.
	 * @param on
	 */
	public void setOn(String on) {
		this.on = on;
	}
	
	/**
	 * 어트랙션 객체 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "[seq=" + seq + ", name=" + name + ", attractionType=" + attractionType + ", capacity="
				+ capacity + ", runTime=" + runTime + ", locateSeq=" + locateSeq + ", waitTime=" + waitTime + ", vote="
				+ vote + ", on=" + on + "]";
	}

}
