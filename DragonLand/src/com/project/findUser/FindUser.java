package com.project.findUser;

import java.io.*;
import java.util.*;

import com.project.data.*;
import com.project.main.Load;
import com.project.main.Main;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.data.User;
import com.project.login.login;
/**
 * ID/PW 찾는 클래스입니다. 
 * @author 김성연
 *
 */

public class FindUser {

	
	
	private static ArrayList<User> list;

	public static void main(String[] args) throws Exception {

		findeUser();

	}

	
	
	/**
	 * 회원 아이디를 찾는 메소드입니다
	 * @throws Exception
	 */
	
	public static void findeUser() throws Exception {

//		System.out.println("Dragon Land"); //임시
//		System.out.printf("🎈오늘 용용랜드는 %s합니다.🎈%n%n", Main.getState());
		Scanner find = new Scanner(System.in);
		String findName;
		String findJumin;

		// 로그인 메뉴

		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[ID/PW 찾기]");
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t   (b를 누르면 뒤로 이동합니다.)");

		System.out.print("\t\t\t\t\t\t\t\t\t\t이름: ");
		findName = find.nextLine();
		if (findName.equalsIgnoreCase("b")) {
			Main.main(null);
		}
		System.out.print("\t\t\t\t\t\t\t\t\t\t주민등록번호: ");
		findJumin = find.nextLine();
		if (findJumin.equalsIgnoreCase("b")) {
			Main.main(null);
		}

		int findCheck = findUserInfo(find, findName, findJumin);

		

		if (findCheck == 1) {

			
			list = Load.loadUser();
		
			
			
			for(User s : list) {
			
			
			if (s.getName().equals(findName) && s.getJumin().equals(findJumin)) {
			
			System.out.println("====================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t"+findName+"님의 아이디와 비밀번호입니다.");
			System.out.println("====================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t아이디 : " + s.getId());
			System.out.println("\t\t\t\t\t\t\t\t\t\t비밀번호 : " + s.getPw());
			System.out.println();
			break;
		
			}
				
			}
			
			// 찾고나서 로그인 or 메뉴 선택 
			System.out.println("\t\t\t\t\t\t\t\t\t\t1.로그인하러가기");
			System.out.println("\t\t\t\t\t\t\t\t\t\t2.메뉴");
			System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
			
			String choice = find.nextLine();
			
			if(choice.equals("1")) {
				login.login();
			} else if(choice.equals("2")) {
				Main.main(null);
			}
			
			

			
		
			// 4번. 아이디 비밀번호 모두 틀림
		} else if (findCheck == 2) {

			// 아이디 X 비밀번호 X
			System.out.println("\t\t\t\t\t\t\t\t\t\t이름과 주민등록번호가 틀렸습니다.");

			System.out.print("\t\t\t\t\t\t\t\t\t\t다시 찾으시겠습니까?(y/n) : ");
			String reFind = find.nextLine();

			if (reFind.equalsIgnoreCase("y")) {
				findeUser();
			} else if (reFind.equalsIgnoreCase("n")) {
				Main.main(null);
			}
		}
		// 아이디 비밀번호 찾기 오류
		else {
			System.out.println("\t\t\t\t\t\t\t\t\t\t유효한 값이 아닙니다.");

			System.out.print("\t\t\t\t\t\t\t\t\t\t다시 찾으시겠습니까?(y/n) : ");
			String reFind = find.nextLine();

			if (reFind.equalsIgnoreCase("y")) {
				findeUser();
			} else if (reFind.equalsIgnoreCase("n")) {
				Main.main(null);
			}
		}
	}
	

	/**
	 * ID/PW를 찾아 결과창을 보여주는 메소드입니다.
	 * @param find 스캐너
	 * @param findName 아이디
	 * @param findJumin 주민등록번호
	
	 * @return 아이디 비밀번호 유효성 검사 기본 false / 유효시 true
	 * @throws Exception
	 */

	
	
	public static Integer findUserInfo(Scanner find, String findName, String findJumin) throws Exception {

		list = Load.loadUser();

		// 체크 기본값 false 설정;
		boolean findCheck = false;
		

		// 입력한 ID/PW 와 데이터 ID/PW 비교
		// 같으면 true , 다르면 false

		for (User s : list) {

			if (s.getName().equals(findName) && s.getJumin().equals(findJumin)) {
				findCheck = true;
			}

			
		}

		// 로그인 확인 
		if (findCheck ) {
			return 1; // 이름과 주민번호 맞음
		} else if (!findCheck) {
			return 2; // 이름과 주민번호 틀림
		
		} else {
			return 0; // ID/P W찾기 오류
		}

	}

}
