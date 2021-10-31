package com.project.admin;

import java.util.Scanner;



public class AdminMenu {

	private static Scanner scan;
	private static MonthlyStatistic monthly;
	private static DailyStatistic daily;
	private static Research research;
	static {
		scan = new Scanner(System.in);
		monthly =  new MonthlyStatistic();
		daily = new DailyStatistic();
		research = new Research();
	}
	
	public void statistic() throws Exception {
		boolean loop = true;
		
		while(loop) {
			menu();
			System.out.print("👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				monthly.statistic();
			}else if(sel.equals("2")){	
				daily.statistic();
			}else if(sel.equals("3")){	
				research.menu();
			}else {	
				loop = false;
			}	
		}
	}

	public void menu() {
		System.out.println("1. 당월 이용자현황");
		System.out.println("2. 전체 이용자현황");
		System.out.println("3. 설문 조사");
		System.out.println("B. 뒤로가기");
		
		
	}
}
