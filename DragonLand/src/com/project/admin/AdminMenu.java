package com.project.admin;

import java.util.Scanner;


/**
 * 관리자가 통계를 관리할 수 있는 클래스 입니다.
 * @author 김재형
 *
 */
public class AdminMenu {

	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}
	/**
	 * 놀이공원 통계메뉴 들어가는 메소드
	 * @throws Exception
	 */
	public static void statistic() throws Exception {
		boolean loop = true;
		
		while(loop) {
			menu();
			System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				DailyStatistic.statistic();
				
			}else if(sel.equals("2")){	
				MonthlyStatistic.statistic();
				
			}else if(sel.equals("3")){	
				
				Research.menu();
			}else if(sel.equalsIgnoreCase("B")) {	
				LoginAdmin.login();
			}else {
				System.out.println("다시 키를 입력해주세요.");
				statistic();
			}
		}
	}
	
	/**
	 * 메뉴를 보여주는 메소드
	 */
	public static void menu() {
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[놀이공원 통계]");
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t1. 당월 이용자현황");
		System.out.println("\t\t\t\t\t\t\t\t\t\t2. 전체 이용자현황");
		System.out.println("\t\t\t\t\t\t\t\t\t\t3. 설문 조사");
		System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로가기");
		
		
	}
}
