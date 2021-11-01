package com.project.data;

/**
 * User 클래스입니다.
 * 회원 정보를 저장합니다.
 * @author 이유미
 */
public class User {
	private String seq;
	private String id;
	private String pw;
	private String name;
	private String jumin;
	private String phoneNum;
	private String address;
	private Boolean vote;

	/**
	 * 기본 생성자입니다. 공백을 가집니다.
	 */
	public User() {
		this("","","","","","","",false);
	}
	
	/**
	 * 생성자입니다. 
	 * 원하는 값으로 객체를 생성합니다.
	 * @param seq 회원 번호
	 * @param id 아이디
	 * @param pw 비밀번호
	 * @param name 이름
	 * @param jumin 주민등록번호
	 * @param phoneNum 연락처
	 * @param address 주소
	 * @param vote 투표 여부
	 */
	public User(String seq, String id, String pw, String name, String jumin, String phoneNum, String address,
			Boolean vote) {
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.jumin = jumin;
		this.phoneNum = phoneNum;
		this.address = address;
		this.vote = vote;
	}

	/**
	 * 회원의 번호를 가져옵니다.
	 * @return 회원 번호
	 */
	public String getSeq() {
		return seq;
	}
	
	/**
	 * 회원의 번호를 설정합니다.
	 * @param seq 회원 번호
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * 회원의 아이디를 가져옵니다.
	 * @return 아이디
	 */
	public String getId() {
		return id;
	}

	/**
	 * 회원의 아이디를 설정합니다.
	 * @param id 회원의 아이디
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 회원의 비밀번호를 가져옵니다.
	 * @return 회원의 비밀번호
	 */
	public String getPw() {
		return pw;
	}

	/**
	 * 회원의 비밀번호를 설정합니다.
	 * @param pw 회원의 비밀번호
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}

	/**
	 * 회원의 이름을 가져옵니다.
	 * @return 회원의 이름
	 */
	public String getName() {
		return name;
	}

	/**
	 * 회원의 이름을 설정합니다.
	 * @param name 회원의 이름
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 회원의 주민등록번호를 가져옵니다.
	 * @return 주민등록번호
	 */
	public String getJumin() {
		return jumin;
	}

	/**
	 * 회원의 주민등록번호를 설정합니다.
	 * @param jumin 주민등록번호
	 */
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	/**
	 * 회원의 연락처를 가져옵니다.
	 * @return 회원 연락처
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * 회원의 연락처를 설정합니다.
	 * @param phoneNum 회원 연락처
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * 회원의 주소를 가져옵니다.
	 * @return 회원 주소
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 회원의 주소를 설정합니다.
	 * @param address 회원 주소
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 회원의 투표 여부를 가져옵니다.
	 * @return 투표 여부
	 */
	public Boolean getVote() {
		return vote;
	}

	/**
	 * 회원의 투표 여부를 설정합니다.
	 * @param vote 투표 여부
	 */
	public void setVote(Boolean vote) {
		this.vote = vote;
	}

	/**
	 * 회원의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "User [seq=" + seq + ", id=" + id + ", pw=" + pw + ", name=" + name + ", jumin=" + jumin + ", phoneNum="
				+ phoneNum + ", address=" + address + ", vote=" + vote + "]";
	}
}
