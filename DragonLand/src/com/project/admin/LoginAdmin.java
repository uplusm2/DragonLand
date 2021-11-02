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
	private static LandInfoAdmin lda;
	static {
		scan = new Scanner(System.in);
		am = new AdminMenu();
		lda = new LandInfoAdmin();
	}
	public static void login() throws Exception {
		
		boolean loop = true;
		
		while(loop) {
			menu();
			
			System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				UserManagement.main(null);
			}else if(sel.equals("2")){	
				//직원관리
				Employee.main(null);
			}else if(sel.equals("3")){	
				//어트랙션 관리
				lda.menu();
			}else if(sel.equals("4")){	
				
				//티켓 예매 현황
				TicketReservationStatus.status(TicketReservationStatus.makeList());
				
			}else if(sel.equals("5")){	
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
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[관리자 메뉴]");
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t관리자님 환영합니다!");
		
		System.out.println("\t\t\t\t\t\t\t\t\t\t1. 회원관리");
		System.out.println("\t\t\t\t\t\t\t\t\t\t2. 직원관리");
		System.out.println("\t\t\t\t\t\t\t\t\t\t3. 놀이공원 정보 관리");
		System.out.println("\t\t\t\t\t\t\t\t\t\t4. 티켓 예매 현황");
		System.out.println("\t\t\t\t\t\t\t\t\t\t5. 놀이공원 통계");
		System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로가기");
		
	}
}
