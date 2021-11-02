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
	
	public static void statistic() throws Exception {
		boolean loop = true;
		
		while(loop) {
			menu();
			System.out.print("                              👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				MonthlyStatistic.statistic();
			}else if(sel.equals("2")){	
				
				DailyStatistic.statistic();
			}else if(sel.equals("3")){	
				
				Research.menu();
			}else {	
				loop = false;
			}	
		}
	}

	public static void menu() {
		System.out.println("1. 당월 이용자현황");
		System.out.println("2. 전체 이용자현황");
		System.out.println("3. 설문 조사");
		System.out.println("B. 뒤로가기");
		
		
	}
}
