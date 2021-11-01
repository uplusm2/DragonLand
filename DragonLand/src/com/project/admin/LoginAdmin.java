package com.project.admin;

import java.util.Scanner;

import com.project.main.Main;


/**
 * admin으로 로그인 했을 때 나오는 클래스 입니다.
 * @author 김재형
 *
 */
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
				//회원관리
			}else if(sel.equals("2")){	
				//직원관리
				Employee.main(null);
			}else if(sel.equals("3")){	
				//어트랙션 관리
				
			}else if(sel.equals("4")){	
				//어트랙션 정보
			}else if(sel.equals("5")){	
				//티켓 예매 현황
				TicketReservationStatus.status(TicketReservationStatus.makeList());
				
			}else if(sel.equals("6")) {
				//놀이공원 통계
				am.statistic();
			}else if(sel.equals("b")||sel.equals("B")) {
				Main.main(null);
			}
		}
	}
	/**
	 * 관리자 메뉴
	 */
	public static void menu() {
		System.out.println("=======================");
		System.out.println("     [관리자 메뉴]");
		System.out.println("=======================");
		System.out.println("  관리자님 환영합니다!");
		
		System.out.println("1. 회원관리");
		System.out.println("2. 직원관리");
		System.out.println("3. 어트랙션 관리");
		System.out.println("4. 어트랙션 정보");
		System.out.println("5. 티켓 예매 현황");
		System.out.println("6. 놀이공원 통계");
		System.out.println("B. 뒤로가기");
		
	}
}
