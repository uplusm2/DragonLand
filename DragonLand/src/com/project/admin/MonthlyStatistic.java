package com.project.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.*;
import com.project.data.MonthlySales;
import com.project.main.Load;


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

	public static void list() throws Exception {
		System.out.println("=====================");
		System.out.println(" [전체 이용자 현황]");
		System.out.println("=====================");
		System.out.printf("[날짜]\t[총인원] [성인]\t[청소년]  [어린이]  [총매출]\r\n");
		
		
		
		
		for(int i=start;i<end;i++) {
			mms=(MonthlySales) ld.loadMonthlySales().get(i);
			
		//	System.out.println(mms.getAdultCount());
			
			System.out.printf("%s\t %s\t  %s\t  %s\t   %s\t   %s\r\n",mms.getDate(),mms.getTotalCount(),
					mms.getAdultCount(),mms.getYouthCount(),mms.getKidCount(),mms.getTotalPrice());
			//System.out.println(String.format("%s",list.get(i)));
			//System.out.print("%s%s");
			
			
		}
		System.out.printf("          %d/1000\n",num);
		System.out.println("<.이전 페이지   다음 페이지.>");
		System.out.println("B.뒤로가기");
		System.out.print("👉");
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
				System.out.println("뒤로 갈곳이 없습니다.");
				list();
			}
				
		}else if(index.equals("b")||index.equals("B")) {
			am.statistic();
			
		}else {
			System.out.println("다시 입력해주세요.");
			list();
		}
		
	
		
		
	}
	
	

}
