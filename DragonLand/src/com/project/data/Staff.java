package com.project.data;
/**
 * Staff 클래스입니다.
 * 직원 정보를 저장합니다.
 * @author 이유미
 */
public class Staff {
	private String seq;
	private String name;
	private String age;
	private String address;
	private String phoneNum;
	private String workPlace;
	
	/**
	 * 기본 생성자입니다. 공백을 가집니다.
	 */
	public Staff() {
		this("","","","","","");
	}
	
	/**
	 * 생성자입니다. 원하는 값으로 객체를 생성합니다.
	 * @param seq 직원 번호
	 * @param name 이름
	 * @param age 나이
	 * @param address 주소
	 * @param phoneNum 연락처
	 * @param workPlace 근무지
	 */
	public Staff(String seq, String name, String age, String address, String phoneNum, String workPlace) {
		super();
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNum = phoneNum;
		this.workPlace = workPlace;
	}

	/**
	 * 직원의 번호를 가져옵니다.
	 * @return 직원 번호
	 */
	public String getSeq() {
		return seq;
	}
	
	/**
	 * 직원의 번호를 설정합니다.
	 * @param seq 직원 번호
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * 직원의 이름을 가져옵니다.
	 * @return 이름
	 */
	public String getName() {
		return name;
	}

	/**
	 * 직원의 이름을 설정합니다.
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 직원의 나이를 가져옵니다.
	 * @return 직원의 나이
	 */
	public String getAge() {
		return age;
	}

	/**
	 * 직원의 나이를 설정합니다.
	 * @param age 직원의 나이
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 직원의 주소를 가져옵니다.
	 * @return 직원의 주소
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 직원의 주소를 설정합니다.
	 * @param address 직원의 주소
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 직원의 연락처를 가져옵니다.
	 * @return 직원의 연락처
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * 직원의 연락처를 설정합니다.
	 * @param phoneNum 직원의 연락처
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * 직원의 근무지를 가져옵니다.
	 * @return 근무지
	 */
	public String getWorkPlace() {
		return workPlace;
	}

	/**
	 * 직원의 근무지를 설정합니다.
	 * @param workPlace 직원의 근무지
	 */
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	/**
	 * 직원의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "Staff [seq=" + seq + ", name=" + name + ", age=" + age + ", address=" + address + ", phoneNum="
				+ phoneNum + ", workPlace=" + workPlace + "]";
	}
}