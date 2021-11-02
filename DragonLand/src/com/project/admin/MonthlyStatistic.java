package com.project.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.*;
import com.project.data.MonthlySales;
import com.project.main.Load;

/**
 * 월별 통계 클래스 입니다.
 * @author 김재형
 *
 */
public class MonthlyStatistic {
	

	private static Scanner scan;
	private static int start;
	private static int end;
	private static int num;
	private static Load ld;
	private static MonthlySales mms;
	private static AdminMenu am;
	
	static {
		scan = new Scanner(System.in);
		start =0;
		end=10;
		num=1;
		am=new AdminMenu();
		mms = new MonthlySales();
		
	}
	
	public static void statistic() throws Exception {
		
			
			
		
		
		
			list();
			
			
		
		
		
	}
	
	/**
	 * 매월 이용자 현황을 보여주는 메소드 입니다.
	 * @throws Exception
	 */
	public static void list() throws Exception {
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[전체 이용자 현황]");
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t[날짜]\t[총인원] [성인]\t[청소년]  [어린이]  [총매출]\r\n");
		
		
		
		
		for(int i=start;i<end&&i<ld.loadMonthlySales().size();i++) {
			mms=(MonthlySales) ld.loadMonthlySales().get(i);
			
		
			
			System.out.printf("\t\t\t\t\t%s\t %s\t  %,d\t  %,d\t   %,d\t   %,d\r\n",mms.getDate(),Integer.parseInt(mms.getTotalCount()),
					Integer.parseInt(mms.getAdultCount()),Integer.parseInt(mms.getYouthCount()),Integer.parseInt(mms.getKidCount()),Integer.parseInt(mms.getTotalPrice()));
			
			
			
		}
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t< 이전페이지                                      %d/%d                                       다음 페이지 >\n",num,(ld.loadMonthlySales().size()-1)/10+1);
		System.out.println("\t\t\t\t\t================================================================================================");
		
		System.out.println("\t\t\t\t\t\t\t\t\t\tB.뒤로가기");
		System.out.print("\t\t\t\t\t\t\t\t\t\t👉");
		String index = scan.nextLine();
		if(index.equals(">")){
			start+=10;
			end+=10;
			num++;
			
			list();
		}else if(index.equals("<")) {
			if(start>=10) {
				start-=10;
				end-=10;
				num--;
				list();
			}else {
				System.out.println("\t\t\t\t\t\t\t\t\t\t뒤로 갈곳이 없습니다.");
				list();
			}
				
		}else if(index.equals("b")||index.equals("B")) {
			am.statistic();
			
		}else {
			System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
			list();
		}
		
	
		
		
	}
	
	

}
