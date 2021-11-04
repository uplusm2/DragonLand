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
	 * 회원가입 메소드입니다
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

		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[회원가입]");
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t(b를 누르면 뒤로 이동합니다.)");

		while (check) {
			System.out.print("\t\t\t\t\t\t\t\t\t아이디(4자~12자):  ");
			
			id = join.nextLine();
			if (id.equalsIgnoreCase("B")) { 
				System.out.println();
				Main.main(null); //뒤로가기(메인메뉴)
			}
			if (idCheck(id)) {
				continue;
			}
		
	
			break;
		}

		while (check) {
			System.out.print("\t\t\t\t\t\t\t\t\t비밀번호: ");
			pw = join.nextLine();
			if (pwCheck(pw)) {
				continue;
			}
		
			break;
		}

		while (check) {
			System.out.print("\t\t\t\t\t\t\t\t\t비밀번호 확인: ");
			pwCheck = join.nextLine();
			if (pwSameCheck(pwCheck, pw)) {
				continue;
			}

			break;
		}
		while (check) {
			System.out.print("\t\t\t\t\t\t\t\t\t이름: ");
			name = join.nextLine();
			if (nameCheck(name)) {
				continue;
			}

			break;
		}

		while (check) {
			System.out.print("\t\t\t\t\t\t\t\t\t주민등록번호(-없이 13자리를 입력해주세요): ");
			jumin = join.nextLine();
			if (juminCheck(jumin)) {
				continue;
			}

			break;
		}
		while (check) {
			System.out.print("\t\t\t\t\t\t\t\t\t주소: ");
			address = join.nextLine();
			if (addressCheck(address)) {
				continue;
			}

			break;
		}

		while (check) {
			System.out.print("\t\t\t\t\t\t\t\t\t전화번호: ");
			phoneNum = join.nextLine();
			if (phoneCheck(phoneNum)) {
				continue;
			}

			break;
		}

		list = Load.loadUser();
		User lastSeq = list.get((list.size()-1));

		String seq = String.format("U%03d", Integer.parseInt(lastSeq.getSeq().substring(1))+1);

		User u = new User(seq, id, pw, name, jumin, phoneNum, address, false);
		list.add(u);
		Save.saveUser(list);// 저장

		System.out.println();
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t회원가입이 완료되었습니다!");
		System.out.println("\t\t\t\t\t\t\t\t\t엔터를 누르시면 메인메뉴로 이동합니다.");
		System.out.println("\t\t\t\t\t================================================================================================");
		
		pause();
		
	}

	
	/**
	 * 아이디 유효성검사 메소드입니다
	 * @param id 아이디
	 * @throws Exception 
	 */	
	public static boolean idCheck(String id) throws Exception {

		list = Load.loadUser();

		// 중복 유효성 검사
		// 기존 아이디와 같은 아이디를 입력하면 msg
		for (User user : list) {
			if (user.getId().equals(id)) {
				System.out.println("\t\t\t\t\t\t\t\t\t중복된 아이디 입니다.");
				return true;
			}
		}

		// 아이디 글자 수 제한
		// 4~12글자 제한
		if (id.length() < 4 || id.length() > 12) {
			System.out.println("\t\t\t\t\t\t\t\t\t아이디는 4 ~ 12자로 입력해주세요.");
			// 다시 입력받기
			return true;
		}

		return false;

	}

	/**
	 * 비밀번호 유효성검사 메소드입니다
	 * @param pw 비밀번호
	 * @throws Exception 
	 */	
	
	
	public static boolean pwCheck(String pw) {

		// 4~12글자 제한
		if (pw.length() < 4 || pw.length() > 12) {
			System.out.println("\t\t\t\t\t\t\t\t\t비밀번호는 4 ~ 12자리로 입력해주세요.");

			return true;
		}

		return false;
	}

	
	/**
	 * 비밀번호확인 메소드입니다
	 * @param pwCheck 확인받을 비밀번호
	 * @param pw 비밀번호
	 * @throws Exception 
	 */	
	public static boolean pwSameCheck(String pwCheck, String pw) {

		// 4~12글자 제한
		if (!pwCheck.equals(pw)) {
			System.out.println("\t\t\t\t\t\t\t\t\t입력하신 비밀번호와 다릅니다.");

			return true;
		}

		return false;
	}

	/**
	 * 이름 유효성검사 메소드입니다
	 * @param name 이름
	 * @return 정규식 한글검사
	 * @throws Exception 
	 */	
	public static boolean nameCheck(String name) {

		// 이름 한글 유효성 검사
		// 이름이 한글이면 true 반환 아니면 false
		boolean n = !Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);

		if (n == true) {
			System.out.println("\t\t\t\t\t\t\t\t\t이름은 한글로만 입력해주세요");
		}

		return n;

	}

	/**
	 * 주민등록번호 유효성검사 메소드입니다
	 * @param jumin 주민등록번호
	 * @throws Exception 
	 */	


	public static boolean juminCheck(String jumin) throws Exception {
		
		list = Load.loadUser();
		
		for (User user : list) {
			if (user.getJumin().equals(jumin)) {
				System.out.println("\t\t\t\t\t\t\t\t\t중복된 주민등록번호 입니다.");
				return true;
			}
		}

		int[] juminNum = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };

		int check = 0;
		for (int i = 0; i < 12; i++) {

			check += (jumin.charAt(i) - '0') * juminNum[i];

		}

		int nmg = check % 11;
		int result = 11 - nmg;

		if (result == jumin.charAt(12) - '0') {
			if (jumin.length() > 13) {
				System.out.println("\t\t\t\t\t\t\t\t\t주민번호는 13자 이내로 입력해주세요");

				return true;
			}
			return false;

		} else {
			System.out.println("\t\t\t\t\t\t\t\t\t올바르지않는 주민등록번호입니다");
			return true;
		}

	}

	/**
	 * 핸드폰번호 유효성검사 메소드입니다
	 * @param phoneNum 핸드폰번호
	 * @throws Exception 
	 */	
	public static boolean phoneCheck(String phoneNum) {

		// 전화번호 숫자 유효성 검사
		// 숫자만 입력되면 true 아니면 false
		boolean n = !Pattern.matches("^[0-9]*$", phoneNum);

		return n;

	}

	/**
	 * 주소 유효성검사 메소드입니다
	 * @param address 주소
	 * @throws Exception 
	 */	
	public static boolean addressCheck(String address) {

		// 30자 이내
		if (address.length() > 31) {
			System.out.println("\t\t\t\t\t\t\t\t\t주소는 30자 이내로 입력해주세요");

			return true;
		}

		return false;
	}
	
	public static void pause() throws Exception {
		Scanner join = new Scanner(System.in);
		System.out.println();
		join.nextLine();
		Main.main(null);
	}

}
