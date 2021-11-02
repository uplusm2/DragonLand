package com.project.user;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.project.admin.AdminMenu;
import com.project.data.*;
import com.project.main.*;

/**
 * 고객의 소리 클래스입니다.
 * @author 김성연 
 *
 */

public class Survey {
	private static Scanner scan;
	private static int page;
	private static String vote;

	private static ArrayList<UserVoice> list;
	private static ArrayList<Attraction> attraction;
	
	static {
		scan = new Scanner(System.in);
		
	}


	public static void main(String[] args) throws Exception {
		SurveyMain();
	}

	/**
	 * 설문조사 메인 페이지입니다
	 * 선택하여 원하는 곳으로 들어갑니다.
	 *
	 * @throws Exception the exception
	 */
	public static void SurveyMain() throws Exception {
		boolean loop = true;

		
		
		AdminMenu admin = new AdminMenu();
		String survey;

		System.out.println("====================================================================================");
		System.out.println("\t\t\t\t [설문조사]");
		System.out.println("====================================================================================");
		while (loop) {
			menu();
			System.out.print("\t\t\t    👉 ");
		System.out.println("\t\t\t\t\t====================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[설문조사]");
		System.out.println("\t\t\t\t\t====================================================================================");
		while (loop) {
			menu();
			System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
			survey = scan.nextLine();
			System.out.println();

			if (survey.equals("1")) {
				attractionVote(); // 어트랙션 추천
			} else if (survey.equals("2")) {
				userVoice(); // 고객의 소리
			} else if (survey.equalsIgnoreCase("b")) {
				admin.menu(); // 관리자 메뉴로
			} else {
				loop = false;
			}
		}
	}
	
	/**
	 * 고객의 소리 메소드입니다
	 * 
	 * @throws Exception 
	 */	

	public static void userVoice() throws Exception {

		list = Load.loadUserVoice();
		
		System.out.println("====================================================================================");
		System.out.println("\t\t\t    [고객의 소리]");
		System.out.println("====================================================================================");
		System.out.println("\t\t      고객님의 의견을 자유롭게 들려주세요");
		System.out.println("\t\t        (b를 누르면 뒤로 이동합니다.)");
		System.out.println("\t\t\t\t\t====================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[고객의 소리]");
		System.out.println("\t\t\t\t\t====================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t고객님의 의견을 자유롭게 들려주세요");
		System.out.println("\t\t\t\t\t\t\t\t\t(b를 누르면 뒤로 이동합니다.)");
		System.out.println();

		System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
		String content = scan.nextLine();
		System.out.println("====================================================================================");
		System.out.println("====================================================================================");
		if(content.equalsIgnoreCase("B")) {
			SurveyMain();
		}
		System.out.println("\t\t\t\t\t====================================================================================");
		System.out.println("\t\t\t\t\t====================================================================================");
		System.out.println();

		String seq = String.format("W%04d", list.size() + 1);

		LocalDateTime now = LocalDateTime.now();
		String date = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		UserVoice uv = new UserVoice(seq, date, content);
		list.add(uv);
		Save.saveUserVoice(list);// 저장

		System.out.println("\t\t\t  소중한 의견 감사합니다");
		System.out.println("\t\t\t\t\t\t\t\t\t 고객님의 소중한 의견 감사합니다");
		pause();

	}

	
	/**
	 * 어트랙션 추천 메소드입니다
	 * 
	 * @throws Exception 
	 */	
	public static void attractionVote() throws Exception {
		
		
		
		// 입력 받는부분
		boolean loop = true;
	
		
		
		while(loop) {
	
			System.out.println("\t\t\t\t\t====================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t[이 달의 어트랙션 순위]");
			System.out.println("\t\t\t\t\t====================================================================================\n");
			
			voteList();
			
			System.out.println("====================================================================================");
			System.out.printf("< 이전 페이지 \t\t\t\t%d/%d\t\t\t\t 다음 페이지 >%n", page+1, attraction.size()/10+1);
			System.out.println("====================================================================================");
			System.out.println("\t\t\t\t      B.뒤로가기");
			System.out.print("\t\t\t\t      👉 ");
			System.out.println("\t\t\t\t\t====================================================================================");
			System.out.printf("\t\t\t\t\t< 이전 페이지 \t\t\t\t%d/%d\t\t\t\t 다음 페이지 >%n", page+1, attraction.size()/10+1);
			System.out.println("\t\t\t\t\t====================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\tB.뒤로가기");
			System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
			vote = scan.nextLine();
			
			

			
			
		
		if (vote.equalsIgnoreCase("B")) {
			// 뒤로 가기
			SurveyMain();
		} else if (vote.equals("<")) {
			// 이전 페이지
			if (page != 0) {
				
				page--;
			} else {
				System.out.println("이전 페이지가 없습니다.");
				voteList();
			}
		} else if (vote.equals(">")) {
			// 다음 페이지

			page++;
		} else {
			System.out.println("다시 입력해주세요.");
			
		}
	
		
		
		}
		
	
	}

	
	/**
	 * 투표수 리스트 정렬 메소드입니다
	 *
	 * @throws Exception the exception
	 */
	public static void voteList() throws Exception {
		
		attraction = Load.loadAttraction();
		
		
		// 투표수로 정렬
		attraction.sort(new Comparator<Attraction>() {

			/**
			 * 투표수 정렬 
			 */
			@Override
			public int compare(Attraction o1, Attraction o2) {
				return Integer.parseInt(o2.getVote()) - Integer.parseInt(o1.getVote());
			}
			
		});
		
		
		
		System.out.printf("%s\t\t\t%s\t\t\t%s%n"
		System.out.printf("\t\t\t\t\t\t%s\t\t\t%s\t\t\t%s%n"
				,"순위","이름","득표수");
		for(int i=page*10; i< page*10+10 && i< attraction.size(); i++) {		
			

			System.out.printf("%s위\t\t\t%s\t\t\t%s표\n"
			System.out.printf("\t\t\t\t\t\t%s위\t\t\t%s\t\t\t%s표\n"
					,i+1
					,attraction.get(i).getName()
					,attraction.get(i).getVote());
			
			if(page >= attraction.size()/10+1) {
				
			}
		}
		
	
		
	}
	
	public static void menu() {
		System.out.println();
		System.out.println("\t\t\t    1. 이달의 어트랙션 추천");
		System.out.println();
		System.out.println("\t\t\t    2. 고객의 소리");
		System.out.println();
		System.out.println("\t\t\t    B. 뒤로가기");
		System.out.println("\t\t\t\t\t\t\t\t\t1. 이달의 어트랙션 추천");
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\t2. 고객의 소리");
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\tB. 뒤로가기");

	}

	public static void pause() throws Exception {
		System.out.println();
		System.out.println("\t\t      (엔터를 누르면 메뉴로 이동합니다.)");
		System.out.println("\t\t\t\t\t\t\t\t\t(엔터를 누르면 메뉴로 이동합니다.)");
		scan.nextLine();
		Main.main(null);
	}
	
}
	

