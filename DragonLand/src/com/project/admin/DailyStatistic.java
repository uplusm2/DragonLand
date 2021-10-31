package com.project.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.project.data.DailySales;
import com.project.data.MonthlySales;
import com.project.main.Load;

public class DailyStatistic {
	
	private static Calendar c1;
	private static int year;
	private static int month;
	private static Load ld;
	private static MonthlySales mms;
	private static AdminMenu am;
	private static Scanner scan;
	private static DailySales ds;
	private static String input;
	
	
	
	static {
		c1= Calendar.getInstance();
		year=0;
		month=0;
		am=new AdminMenu();
		mms = new MonthlySales();
		scan = new Scanner(System.in);
		ds = new DailySales();
		input=null;
	}
	
	public void statistic() throws Exception {
		//System.out.println(ld.loadMonthlySales().get(41));
		
				
		
		
		menu();
		
		
		
		
		
		
	}
	
	private void menu() throws Exception {
		mms=(MonthlySales) ld.loadMonthlySales().get(ld.loadMonthlySales().size()-1);
		
		
		year=c1.get(Calendar.YEAR);
		month=c1.get(Calendar.MONTH)+1;
		
		System.out.println("============================");
		System.out.printf("        [%d월 현황]\n",month);
		System.out.printf("     인원: %,d명\n",Integer.parseInt(mms.getTotalCount()));
		System.out.printf("     매출: %,d원\n",Integer.parseInt(mms.getTotalPrice()));
		System.out.println("============================");
		output(year,month);
		System.out.println("상세 확인할 날짜를 입력하세요.(YYMMDD)");
		System.out.println("B.뒤로가기");
		System.out.print("👉");
		input=scan.nextLine();
		
		if(input.equals("B")||input.equals("b")) {
			am.statistic();
		}
		
		for (int i=0;;i++) {
			ds=(DailySales) ld.loadDailySales().get(ld.loadDailySales().size()-40+i);
			if(input.equals(ds.getDate().substring(2, 8))) {
				System.out.println("      인원  매출");
				System.out.printf("성인: %s명   %,d원\n",ds.getAdultCount(),Integer.parseInt(ds.getAdultPrice()));
				System.out.printf("청소년: %s명   %,d원\n",ds.getYouthCount(),Integer.parseInt(ds.getYouthPrice()));
				System.out.printf("어린이: %s명   %,d원\n",ds.getKidCount(),Integer.parseInt(ds.getKidPrice()));
				
				break;
			}
		}
		System.out.println("다시 검색하고 싶으면 엔터를 누르세요.");
		String re = scan.nextLine();
		menu();
		
	}

	private static void output(int year, int month) {
		
		int lastDay = 0; 		//해당월의 마지막 일
		int day_of_week = 0; 	//해당월 1일의 요일
		
		lastDay = getLastDay(year, month);
		day_of_week = getDayOfWeek(year, month);
		
		//달력 형식으로 출력하기
		System.out.println();
		System.out.println("====================================================");
		System.out.printf("                     %d년 %d월\n", year, month);
		System.out.println("====================================================");
		System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
		
		
		//1일이 무슨 요일 > 탭의 갯수
		for (int i=0; i<day_of_week; i++) {
			System.out.print("\t");
		}
		
		
		//날짜 출력
		for (int i=1; i<=lastDay; i++) {
			System.out.printf("%3d\t", i);
			
			//토요일 > 개행
			//if (i % 7 == 4) {
			if ((i + day_of_week) % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		
	}
	
	private static int getDayOfWeek(int year, int month) {
		
		int date = 1;
		
		int totalDays = 0;
		
		for (int i=1; i<year; i++) {
			if (isLeafYear(i)) {
				totalDays += 366;			
			} else {
				totalDays += 365;
			}
		}
		
		for (int i=1; i<month; i++) {
			totalDays += getLastDay(year, i);
		}
		
		totalDays += date; //totalDays++;
		
		return totalDays % 7;
	}

	private static int getLastDay(int year, int month) {
		
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				return 31; //+break 포함
			case 4: case 6: case 9: case 11:
				return 30;
			case 2:
				return isLeafYear(year) ? 29 : 28;
		}
		
		return 0;
	}
	
	
	private static boolean isLeafYear(int year) {
		
		if (year % 4 == 0) {
			if (year % 100 != 0) {
				return true;
			} else {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		
	}
}
