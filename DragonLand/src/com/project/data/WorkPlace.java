package com.project.data;

/**
 * WorkPlace 클래스입니다.
 * 직원 근무지 정보를 담습니다.
 * @author 써니
 *
 */
public class WorkPlace {
	private String locate;

	/**
	 * WorkPlace 클래스 생성자입니다.
	 * @param locate 근무지 이름
	 */
	public WorkPlace(String locate) {
		this.locate = locate;
	}

	/**
	 * 근무지를 반환힙니다.
	 * @return
	 */
	public String getLocate() {
		return locate;
	}

	/**
	 * WorkPlace 객체 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return "WorkPlace [locate=" + locate + "]";
	}
}
