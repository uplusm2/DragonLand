package com.project.landinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

import com.project.data.Attraction;
import com.project.data.Location;
import com.project.main.Load;

/**
 * AttractionInfo 클래스입니다.
 * 용용랜드 정보 > 어트랙션 정보 메뉴 화면으로 '이달의 어트랙션 순위'와 '어트랙션 정보'를 타입별로 보여줍니다.
 * @author 써니
 *
 */
public class AttractionInfo {
	
	public enum Type {
		가족, 게임, 공포, 관람, 스릴, 어린이, 연인
	}

	private static Scanner sc = new Scanner(System.in);
	private static int page;
	private static int endPage;
	private static ArrayList<Attraction> attractions;
	private static List<Attraction> list;
	
	static {
		try {
			attractions = Load.loadAttraction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 용용랜드 정보 > 어트랙션 정보 메뉴를 보여줍니다.
	 * @throws Exception
	 */
	public void menu() throws Exception {
		while(true) {
			showAttractionRank();
			
			head("어트랙션 정보");
			System.out.println("\t\t\t\t\t\t\t\t\t   나에게 맞는 어트랙션을 찾아보세요.");
			System.out.printf("\t\t\t\t\t\t\t\t1.%s\t2.%s\t\t3.%s\t\t4.%s\n", "전체보기", Type.가족, Type.게임, Type.공포);
			System.out.printf("\t\t\t\t\t\t\t\t5.%s\t\t6.%s\t\t7.%s\t8.%s\n", Type.관람, Type.스릴, Type.어린이, Type.연인);

			System.out.println("\t\t\t\t\t\t\t\tB. 뒤로 가기");
			System.out.print("\t\t\t\t\t\t\t\t👉 ");
			String sel = sc.nextLine();
			System.out.println();

			if(sel.equals("1")) showAttractionList();
			else if(sel.equals("2")) showAttractionList(Type.가족);
			else if(sel.equals("3")) showAttractionList(Type.게임);
			else if(sel.equals("4")) showAttractionList(Type.공포);
			else if(sel.equals("5")) showAttractionList(Type.관람);
			else if(sel.equals("6")) showAttractionList(Type.스릴);
			else if(sel.equals("7")) showAttractionList(Type.어린이);
			else if(sel.equals("8")) showAttractionList(Type.연인);
			else if(sel.equalsIgnoreCase("B")) break;
			else System.out.println("\t\t\t\t\t\t\t\t다시 입력해주세요.");
			System.out.println();
		}
	}
	
	/**
	 * 이달의 어트랙션 순위를 보여줍니다(1~5위)
	 * @throws Exception
	 */
	public void showAttractionRank() throws Exception {
		ArrayList<Attraction> attractions = Load.loadAttraction();
		
		head("이달의 어트랙션 순위");
		attractions.sort((o1, o2) -> Integer.parseInt(o2.getVote()) - Integer.parseInt(o1.getVote()));

		for(int i = 0; i < 5; i++)
			System.out.printf("\t\t\t\t\t\t\t\t\t\t%d위 %s\n", i+1, attractions.get(i).getName());
		System.out.println();
	}
	
	/**
	 * 전체 어트랙션 목록을 만들고 보여줍니다.
	 * @throws Exception
	 */
	public void showAttractionList() throws Exception {
		page = 0;
		list = attractions.stream().collect(Collectors.toList());
		
		Type type = null;
		showList(page, type);
		pageExplore(type);
	}
	
	/**
	 * 선택한 분류의 어트랙션 목록을 만들고 보여줍니다.
	 * @param type
	 * @throws Exception
	 */
	public void showAttractionList(Type type) throws Exception {
		page = 0;
		list = attractions.stream()
				.filter(attraction -> attraction.getAttractionType().equals(type.toString()))
				.collect(Collectors.toList());
		
		showList(page, type);
		pageExplore(type);
	}
	
	/**
	 * 선택한 분류의 어트랙션 목록을 1페이지씩 보여줍니다.
	 * @param page 보여줄 페이지 넘버
	 * @param type 어트랙션 분류
	 */
	public void showList(int page, Type type) {
		endPage = (list.size()/10 != 0 && list.size()%10 == 0) ? list.size()/10 : list.size()/10+1;		
		
		if(type == null) head("전체 어트랙션 정보");
		else head(String.format("%s 어트랙션 정보", type));
		
		System.out.println("\t\t\t\t\t[번호]\t\t[이름]\t\t\t[분류]\t[탑승인원]\t[운행시간]\t[위치]");
		for(int i = page*10; i < (page != endPage-1 ? page*10+10 : list.size()); i++) {
			System.out.printf("\t\t\t\t\t%4d\t\t%-15s\t%3s\t\t%5s\t\t%s\t%s\n"

					, i+1
					, list.get(i).getName()
					, list.get(i).getAttractionType()
					, list.get(i).getCapacity()
					, list.get(i).getRunTime()
					, getLocate(list.get(i).getLocateSeq())
			);
		}
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t< 이전페이지\t\t\t\t     %d / %d\t\t\t\t   다음 페이지 >\n", page+1, endPage);
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println();
	}
	
	/**
	 * 현재 페이지의 헤더를 출력합니다.
	 * @param title 현재 페이지의 헤더 제목
	 */
	public void head(String title) {
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t\t\t\t\t\t[%s]\r\n", title);
		System.out.println("\t\t\t\t\t================================================================================================");
	}

	/**
	 * 여러 페이지가 있는 화면에서 페이지를 넘겨 볼 수 있게 사용자 입력을 받고 탐색합니다.
	 * @param type
	 * @throws Exception
	 */
	public void pageExplore(Type type) throws Exception {
		while(true) {
			System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로 가기");
			System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
			String sel = sc.nextLine();
			System.out.println();
			
			if(sel.equals("<")) {
				if(page == 0) {
					System.out.println("\t\t\t\t\t\t\t\t\t\t첫 페이지입니다.");
					pause();
					showList(page, type);
				}
				else showList(--page, type);
			}
			else if(sel.equals(">")) {
				if(page == endPage-1) {
					System.out.println("\t\t\t\t\t\t\t\t\t\t마지막 페이지입니다.");
					pause();
					showList(page, type);
				}
				else showList(++page, type);
			}	
			else if(sel.equalsIgnoreCase("B")) return;
			else System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
			System.out.println();
		}
	}
	
	/**
	 * 사용자 입력으로 Enter를 받으면 목록으로 돌아가는 pause 기능의 메소드
	 */
	public void pause() {
		System.out.println("\t\t\t\t\t\t\t\t\t(엔터를 누르면 목록으로 돌아갑니다.)");
		sc.nextLine();
	}
	
	/**
	 * 놀이공원 위치 번호를 받아, 놀이공원 위치를 반환합니다.
	 * @param locateNum 놀이공원 위치 번호
	 * @return
	 */
	public String getLocate(String locateNum) {
		try {
			ArrayList<Location> location = Load.loadLocation();
			for(int i = 0; i < location.size(); i++) {
				if(location.get(i).getSeq().equals(locateNum))
					return location.get(i).getLocate();
			}
		} 
		catch (Exception e) {e.printStackTrace();}
		
		return "위치를 찾을 수 없습니다.";
	}
	
	
}
