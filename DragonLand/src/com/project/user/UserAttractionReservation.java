package com.project.user;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.login.login;
import com.project.admin.*;
import com.project.data.Attraction;
import com.project.main.*;

public class UserAttractionReservation {
	
	private static Scanner scan;
	private static int page;
	private static int endPage;
	private static ArrayList<Attraction> attractions;

	
	static {
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println("===========================================================================================================================================================================");
		System.out.println("								[어트랙션 예약]");
		System.out.println("===========================================================================================================================================================================");

		
		System.out.println("\t\t\t\t\t\t\t1. 전체\t2. 스릴\t3. 호러");
		System.out.println("\t\t\t\t\t\t\t4. 연인\t5. 낭만\t6. 어린이");
		System.out.println("\t\t\t\t\t\t\tB. 뒤로가기");
		
		boolean loop = true;
		while(loop) {

			System.out.print("\t\t\t\t\t\t\t\t👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				//전체 어트랙션
				total();
				
			}else if(sel.equals("2")){	
				//스릴 어트랙션
				//thrill();
				
			}else if(sel.equals("3")){	
				//호러 어트랙션
				//horor();
				
			}else if(sel.equals("4")){	
				//연인 어트랙션
				//couple();
				
			}else if(sel.equals("5")){	
				//낭만 어트랙션
				//nangman();
				
			}else if(sel.equals("6")){	
				//어린이 어트랙션
				//child();
				
			}else if(sel.equalsIgnoreCase("B")){									
				//유저 페이지로 되돌아가기
				
			}else{
				System.out.println("\t\t\t\t\t\t\t\t다시 입력해주세요.");
				
			}
		}
		
		
		
	}

	private static void total() throws Exception {

		showAttractionWaitTime();
		
	}
	
	public static void showAttractionWaitTime() throws Exception {
		page = 0;
		while(true) {
			
			showList(page);
			System.out.println("< 이전 페이지 | 다음 페이지 > ");
			System.out.println("B. 뒤로 가기");
			System.out.println();
			
			System.out.println("예약할 어트랙션 번호를 입력해주세요.");
			System.out.print("👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("<")) {
				if(page == 0) {
					System.out.println("첫 페이지입니다.");
					
				}
				else page--;
			}
			else if(sel.equals(">")) {
				if(page == endPage-1) {
					System.out.println("마지막 페이지입니다.");
					
				}
				else page++;
			}
			else if(sel.equalsIgnoreCase("B")) return;

			else {
				System.out.println("올바른 번호를 입력해주세요.");
				total();
			}
			System.out.println();
		}
	}

	public static void showList(int page) throws Exception {
		attractions = Load.loadAttraction();
		
		endPage = (attractions.size()/10 != 0 && attractions.size()%10 == 0) ? attractions.size()/10 : attractions.size()/10+1;		
		
		System.out.println("[번호]\t\t[어트랙션 목록]\t\t[대기시간]");
		for(int i = page*10; i < (page != endPage-1 ? page*10+10 : attractions.size()); i++) {
			System.out.printf("%d\t\t%s\t\t%s\n"
					, i+1
					, attractions.get(i).getName()
					, attractions.get(i).getWaitTime() + "분"
			);
		}
		System.out.printf("%d / %d\n", page+1, endPage);
		System.out.println();
	}
	
	
	
}
