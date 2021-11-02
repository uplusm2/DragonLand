package com.project.login;

import java.io.*;
import java.util.*;

import com.project.admin.LoginAdmin;
import com.project.data.*;
import com.project.main.Load;
import com.project.main.Main;


/**
 * 로그인 클래스입니다.
 * @author 김성연 
 *
 */
public class login {

	private static ArrayList<User> list;

	
	/**
	 * 로그인 출력 메인 메소드입니다.
	 *
	 *
	 * @throws Exception 예외처리
	 */
	public static void main(String[] args) throws Exception {

		login();

	}

	/**
	 * 로그인 메소드입니다.
	 * 
	 * @throws Exception 
	 */
	public static void login() throws Exception {

//		System.out.println("Dragon Land"); //임시
//		System.out.printf("🎈오늘 용용랜드는 %s합니다.🎈%n%n", Main.getState());
		Scanner login = new Scanner(System.in);
		String loginId;
		String loginPw;

		// 로그인 메뉴

		System.out.println("====================================================================================");
		System.out.println("\t\t\t\t      [로그인]");
		System.out.println("====================================================================================");
		System.out.println("\t\t\t      (b를 누르면 뒤로 이동합니다.)");

		System.out.print("\t\t\t\t  아이디: ");
		loginId = login.nextLine();
		

	
		System.out.print("\t\t\t\t  비밀번호: ");
		loginPw = login.nextLine();
		
		
		if (loginId.equalsIgnoreCase("b")) {
			Main.main(null); //뒤로가기(메인메뉴)
		}
		
		if (loginId.equalsIgnoreCase("b")) {
			Main.main(null); //뒤로가기(메인메뉴)
		}
		
		// 관리자 로그인
		if(loginId.equals("admin") && loginPw.equals("1234")) {
			LoginAdmin.login();
		}
		
		int loginCheck = userLoginCheck(login, loginId, loginPw);

	
		if (loginCheck == 1) {

		
			// 로그인 확인 후 메뉴 출력
			Main.main(null); // 회원 페이지 이동 

			// 2번 비밀번호 틀림
		} else if (loginCheck == 2) {

			// 아이디 O 비밀번호 X
			System.out.println("\t\t\t\t  비밀번호가 틀렸습니다.");

			System.out.print("\t\t\t\t  다시 로그인 하시겠습니까?(y/n) : ");
			String relogin = login.nextLine();

			if (relogin.equals("y")) {

				System.out.println("\t\t\t\t  다시 시작합니다.");
				login();
			} else if (relogin.equals("n")) {
				Main.main(null);
			}

			// 3번. 아이디 틀림
		} else if (loginCheck == 3) {

			// 아이디 X 비밀번호 O
			System.out.println("\t\t\t\t  아이디가 틀렸습니다.");

			System.out.print("\t\t\t\t  다시 로그인 하시겠습니까?(y/n) : ");
			String relogin = login.nextLine();

			if (relogin.equals("y")) {

				System.out.println("\t\t\t\t  다시 시작합니다.");
				login();
			} else if (relogin.equals("n")) {
				Main.main(null);
			}

			// 4번. 아이디 비밀번호 모두 틀림
		} else if (loginCheck == 4) {

			// 아이디 X 비밀번호 X
			System.out.println("\t\t\t\t  아이디와 비밀번호 모두 틀렸습니다.");

			System.out.print("\t\t\t\t  다시 로그인 하시겠습니까?(y/n) : ");
			String relogin = login.nextLine();

			if (relogin.equals("y")) {

				System.out.println("\t\t\t\t  다시 시작합니다.");
				login();
			} else if (relogin.equals("n")) {
				Main.main(null);
			}
			
			
		} 
		else {
			System.out.println("\t\t\t\t  로그인 오류");

			System.out.print("\t\t\t\t  다시 로그인 하시겠습니까?(y/n) : ");
			String relogin = login.nextLine();

			if (relogin.equals("y")) {

				System.out.println("\t\t\t\t  다시 시작합니다.");
				login();
			} else if (relogin.equals("n")) {
				Main.main(null);
			}
		}
		
	
	}

	
	/**
	 * 로그인 유효성검사 메소드입니다
	 * @param login 스캐너
	 * @param loginId 사용자가 입력한 ID값
	 * @param loginPw 사용자가 입력한 PW값
	 * @return 
	 * @throws Exception
	 */
	
	
	public static Integer userLoginCheck(Scanner login, String loginId, String loginPw) throws Exception {

		// 유저 데이터 파일 불러오기
		list = Load.loadUser();

		// 체크 기본값 false 설정;
		boolean loginIdCheck = false;
		boolean loginPWCheck = false;

		// 입력한 ID/PW 와 데이터 ID/PW 비교
		// 같으면 true , 다르면 false

		for (User s : list) {

			if (s.getId().equals(loginId)) {
				loginIdCheck = true;
			}

			if (s.getPw().equals(loginPw)) {
				loginPWCheck = true;

			}

			
		} 

		// 로그인 확인 -> 서버로 맞는지 확인
		if (loginIdCheck && loginPWCheck) {
			return 1; // 로그인 성공
		} else if (loginIdCheck && !loginPWCheck) {
			return 2; // 비밀번호 틀림
		} else if (!loginIdCheck && loginPWCheck) {
			return 3; // 아이디 틀림
		} else if (!loginIdCheck && !loginPWCheck) {
			return 4; // 둘 다 틀림
		} else {
			return 0; // 로그인 오류
		}

		// 체크 기본값 false 설정;

	
	}

	
}
