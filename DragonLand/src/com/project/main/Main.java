package com.project.main;

import java.io.*;
import java.util.*;

import com.project.admin.LoginAdmin;
import com.project.data.*;

/**
 * Main 클래스입니다.
 * @author 
 */
public class Main {
	private static Scanner scan;
	private static LoginAdmin lg;
	static {
		scan = new Scanner(System.in);
		lg=new LoginAdmin();
	}
	
	/**
	 * 메뉴를 반복합니다.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println("Dragon Land"); //임시

		System.out.printf("🎈오늘 용용랜드는 %s합니다.🎈%n%n", getState());
		
		boolean loop = true;
		while(loop) {
			menu();
			System.out.print("👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				//용용랜드 정보
			}else if(sel.equals("2")){	
				lg.login();
			}else if(sel.equals("3")){	
				//회원가입
			}else if(sel.equals("4")){	
				//ID,PW찾기
			}else if(sel.equals("5")){	
				//종료
				loop = false;
			}else {
				System.out.println("다시 입력해주세요.");
				pause();
			}
		}
	}

	/**
	 * 놀이공원의 밀집도를 문자열로 반환합니다.
	 * @return
	 */
	private static String getState() {
		try {
			//티켓예매정보.txt 파일 참조
			BufferedReader reader = new BufferedReader(new FileReader(Path.ticketReservation));
			
			//오늘 날짜 YYYYMMDD 형태로 String 변수에 저장
			Calendar c = Calendar.getInstance();
			String today = String.format("%tF", c).replace("-", "");
			
			//혼잡도 비교를 위한 변수
			int total = 0;

			//파일 한 줄씩 읽으며 오늘 날짜와 예매일이 일치하면 total에 인원수 추가
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				if(temp[1].equals(today)) {
					total += Integer.parseInt(temp[2]);
					total += Integer.parseInt(temp[3]);
					total += Integer.parseInt(temp[4]);
				}
			}
			reader.close();
			//500을 기준으로 혼잡도 return
			return total < 500 ? "쾌적" : "혼잡";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 메뉴를 출력합니다.
	 */
	private static void menu() {
		System.out.println("1. 용용랜드 정보");
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
