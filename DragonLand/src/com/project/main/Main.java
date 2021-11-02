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
	private static Calendar c;
	private static ArrayList<TicketReservation> list;
	
	private static LoginAdmin lg;
	private static LandInfo landinfo;
	
	static {
		scan = new Scanner(System.in);
		c = Calendar.getInstance();
		lg=new LoginAdmin();
		landinfo = new LandInfo();
	}
	
	/**
	 * 메뉴를 반복합니다.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		
		try {
			//System.out.println("\t\t\t\t\t\t\t\t\t\tDragon Land"); //임시
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.printf("\t\t\t\t\t\t\t\t\t🎈오늘 용용랜드는 %s합니다.🎈%n%n", getState());
			//System.out.println("\t\t\t\t\t================================================================================================");
			boolean loop = true;
			while(loop) {
				menu();
				System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
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
					System.out.println("\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
					pause();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("\t\t\t\t\t\t\t\t\t잘못된 입력입니다.");
		}
	}

	/**
	 * 놀이공원의 밀집도를 문자열로 반환합니다.
	 * @return
	 */
	public static String getState() throws Exception{
		String today = String.format("%tF", c).replace("-", "");
		
		list = Load.loadTicketReservation();
		list.stream()
			.filter(r -> r.getDate().equals(today))
			.forEach(r -> total += Integer.parseInt(r.getAdultCount())
									+ Integer.parseInt(r.getYouthCount())
									+ Integer.parseInt(r.getKidCount()));
		
		
		try {
			//티켓예매정보.txt 파일 참조
			BufferedReader reader = new BufferedReader(new FileReader(Path.ticketReservation));
			
			//오늘 날짜 YYYYMMDD 형태로 String 변수에 저장
			
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
		System.out.println("\t\t\t\t\t\t\t\t\t1. 용용랜드 정보");
		System.out.println("\t\t\t\t\t\t\t\t\t2. 로그인");
		System.out.println("\t\t\t\t\t\t\t\t\t3. 회원가입");
		System.out.println("\t\t\t\t\t\t\t\t\t4. ID/PW 찾기");
		System.out.println("\t\t\t\t\t\t\t\t\t5. 종료");
	}
	
	/**
	 * 엔터를 누르기 전까지 정지합니다.
	 */
	private static void pause() {
		System.out.println("\t\t\t\t\t\t\t\t(엔터를 누르면 메뉴로 이동합니다.)");
		scan.nextLine();
	}
}