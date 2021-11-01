package com.project.join;

import java.util.Scanner;

import java.util.regex.Pattern;
import java.io.*;
import java.util.*;

import com.project.data.*;
import com.project.main.*;

/**
 * 회원가입 클래스입니다
 * @author 김성연
 *
 */
public class join {

	private static ArrayList<User> list;

	public static void main(String[] args) throws Exception {

		Join();

	}

	/**
	 * 예외처리
	 * @throws Exception 
	 */
	public static void Join() throws Exception {

//		System.out.println("Dragon Land"); //임시
//		System.out.printf("🎈오늘 용용랜드는 %s합니다.🎈%n%n", Main.getState());
		boolean check = true;
		Scanner join = new Scanner(System.in);
		String id = "";
		String pw = "";
		String pwCheck = "";
		String name = "";
		String jumin = "";
		String phoneNum = "";
		String address = "";

		// 로그인 메뉴

		System.out.println("              =============================");
		System.out.println("                         회원가입");
		System.out.println("              =============================\n");
		System.out.println("                  (b를 누르면 뒤로 이동합니다.)");

		while (check) {
			System.out.print("                    아이디(4자~12자):  ");

			id = join.nextLine();
			if (idCheck(id)) {
				continue;
			}

			break;
		}

		while (check) {
			System.out.print("                         비밀번호: ");
			pw = join.nextLine();
			if (pwCheck(pw)) {
				continue;
			}

			break;
		}

		while (check) {
			System.out.print("                         비밀번호 확인: ");
			pwCheck = join.nextLine();
			if (pwSameCheck(pwCheck, pw)) {
				continue;
			}

			break;
		}
		while (check) {
			System.out.print("                         이름: ");
			name = join.nextLine();
			if (nameCheck(name)) {
				continue;
			}

			break;
		}

		while (check) {
			System.out.print("               주민등록번호(-없이 13자리를 입력해주세요): ");
			jumin = join.nextLine();
			if (juminCheck(jumin)) {
				continue;
			}

			break;
		}
		while (check) {
			System.out.print("                         주소: ");
			address = join.nextLine();
			if (addressCheck(address)) {
				continue;
			}

			break;
		}

		while (check) {
			System.out.print("                         전화번호: ");
			phoneNum = join.nextLine();
			if (phoneCheck(phoneNum)) {
				continue;
			}

			break;
		}

		String seq = String.format("U%03d", list.size() + 1);

		User u = new User(seq, id, pw, name, jumin, phoneNum, address, false);
		list.add(u);
		Save.saveUser(list);// 저장

		System.out.println("					회원가입이 완료되었습니다!");
		System.out.println("                         엔터를 누르시면 메인메뉴로 이동합니다.");

	}

	public static boolean idCheck(String id) throws Exception {

		list = Load.loadUser();

		// 중복 유효성 검사
		// 기존 아이디와 같은 아이디를 입력하면 msg
		for (User user : list) {
			if (user.getId().equals(id)) {
				System.out.println("중복된 아이디 입니다.");
				return true;
			}
		}

		// 아이디 글자 수 제한
		// 4~12글자 제한
		if (id.length() < 4 || id.length() > 12) {
			System.out.println("아이디는 4 ~ 12자로 입력해주세요.");
			// 다시 입력받기
			return true;
		}

		return false;

	}

	// 비밀번호 유효성 검사
	public static boolean pwCheck(String pw) {

		// 4~12글자 제한
		if (pw.length() < 4 || pw.length() > 12) {
			System.out.println("비밀번호는 4 ~ 12자리로 입력해주세요.");

			return true;
		}

		return false;
	}

	public static boolean pwSameCheck(String pwCheck, String pw) {

		// 4~12글자 제한
		if (!pwCheck.equals(pw)) {
			System.out.println("입력하신 비밀번호와 다릅니다.");

			return true;
		}

		return false;
	}

	public static boolean nameCheck(String name) {

		// 이름 한글 유효성 검사
		// 이름이 한글이면 true 반환 아니면 false
		boolean n = !Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);

		if (n == true) {
			System.out.println("이름은 한글로만 입력해주세요");
		}

		return n;

	}

	// 주민번호 숫자 유효성 검사

	// ** juminNum배열의 길이와 입력값의 길이가 다르면 오류남 Ex) 주민번호 3151 4글자 입력시
	// ArrayIndexOutOfBoundsException오류 **

	public static boolean juminCheck(String jumin) {

		int[] juminNum = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };

		int check = 0;
		for (int i = 0; i < 12; i++) {

			check += (jumin.charAt(i) - '0') * juminNum[i];

		}

		int nmg = check % 11;
		int result = 11 - nmg;

		if (result == jumin.charAt(12) - '0') {
			if (jumin.length() > 13) {
				System.out.println("주민번호는 13자 이내로 입력해주세요");

				return true;
			}
			return false;

		} else {
			System.out.println("올바르지않는 주민등록번호입니다");
			return true;
		}

	}

	public static boolean phoneCheck(String phoneNum) {

		// 전화번호 숫자 유효성 검사
		// 숫자만 입력되면 true 아니면 false
		boolean n = !Pattern.matches("^[0-9]*$", phoneNum);

		return n;

	}

	// 주소 글자수 유효성검사
	public static boolean addressCheck(String address) {

		// 30자 이내
		if (address.length() > 31) {
			System.out.println("주소는 30자 이내로 입력해주세요");

			return true;
		}

		return false;
	}
}
