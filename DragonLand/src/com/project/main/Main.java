package com.project.main;

import java.io.*;
import java.util.*;

import com.project.admin.*;
import com.project.data.*;
import com.project.findUser.*;
import com.project.join.*;
import com.project.landinfo.*;
import com.project.login.*;

/**
 * Main 클래스입니다.
 * @author 
 */
public class Main {
	private static int total;
	
	private static Scanner scan;
	private static LoginAdmin lg;
	private static LandInfo landinfo;
	private static ArrayList<TicketReservation> list;
	private static Calendar c;
	
	static {
		scan = new Scanner(System.in);
		lg = new LoginAdmin();
		landinfo = new LandInfo();
		c = Calendar.getInstance();
	}
	
	/**
	 * 메뉴를 반복합니다.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		boolean loop = true;
		while(loop) {
			menu();
			System.out.print("👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				//LandInfo.menu();
				landinfo.menu();
			}else if(sel.equals("2")){	
				login.login();
			}else if(sel.equals("3")){	
				join.Join();
			}else if(sel.equals("4")){	
				FindUser.findeUser();
			}else if(sel.equals("5")){	
				loop = false;
			}else {
				System.out.println("다시 입력해주세요.");
				pause();
			}
		}
	}

	/**
	 * 놀이공원의 혼잡도를 계산해 문자열로 반환합니다.
	 * @return 혼잡도
	 * @throws Exception 
	 */
	public static String getState() throws Exception {
		String today = String.format("%tF", c).replace("-", "");
		
		list = Load.loadTicketReservation();
		list.stream()
			.filter(r -> r.getDate().equals(today))
			.forEach(r -> total += Integer.parseInt(r.getAdultCount())
									+ Integer.parseInt(r.getYouthCount())
									+ Integer.parseInt(r.getKidCount()));
		
		return total < 500 ? "쾌적" : "혼잡";
	}

	/**
	 * 메뉴를 출력합니다.
	 * @throws Exception 
	 */
	private static void menu() throws Exception {
		System.out.println("\t\t\t\t\t\tDragon Land"); //임시
		System.out.printf("\t\t\t\t\t\t🎈오늘 용용랜드는 %s합니다.🎈%n%n", getState());

		System.out.println("\t\t\t\t1. 용용랜드 정보");
		System.out.println("2. 로그인");
		System.out.println("3. 회원가입");
		System.out.println("4. ID/PW 찾기");
		System.out.println("5. 종료");
	}
	
	/**
	 * 엔터를 누르기 전까지 정지합니다.
	 */
	private static void pause() {
		System.out.println("(엔터를 누르면 메뉴로 이동합니다.)");
		scan.nextLine();
	}
}
