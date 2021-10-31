package com.project.admin;

import java.util.Scanner;



public class LoginAdmin {
	private static Scanner scan;
	private static AdminMenu am;
	static {
		scan = new Scanner(System.in);
		am = new AdminMenu();
	}
	public static void login() throws Exception {
		
		boolean loop = true;
		
		while(loop) {
			menu();
			System.out.print("👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				
			}else if(sel.equals("2")){	
				
			}else if(sel.equals("3")){	
				//회원가입
			}else if(sel.equals("4")){	
				//ID,PW찾기
			}else if(sel.equals("5")){	
				//종료
				loop = false;
			}else if(sel.equals("6")) {
				am.statistic();
			}
		}
	}
	
	private static void menu() {
		System.out.println("1. 회원관리");
		System.out.println("2. 직원관리");
		System.out.println("3. 어트랙션 관리");
		System.out.println("4. 어트랙션 정보");
		System.out.println("5. 티켓 예매 현황");
		System.out.println("6. 놀이공원 통계");
		System.out.println("B. 뒤로가기");
		
	}
}
