package com.project.landinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.*;

import com.project.data.Attraction;
import com.project.data.Location;
import com.project.main.Load;

enum Type{
	가족, 게임, 공포, 관람, 스릴, 어린이, 연인
}

public class AttractionInfo {

	public static Scanner sc = new Scanner(System.in);
	public static int page;
	public static int endPage;
	public static ArrayList<Attraction> attractions;
	public static List<Attraction> list;
	
	static {
		try {
			attractions = Load.loadAttraction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void menu() throws Exception {
		while(true) {
			showAttractionRank();
			
			head("어트랙션 정보");
			System.out.println("나에게 맞는 어트랙션을 찾아보세요.");
			System.out.printf("1.%s  2.%s\t   3.%s  4.%s\n", "전체보기", Type.가족, Type.게임, Type.공포);
			System.out.printf("5.%s\t  6.%s   7.%s 8.%s", Type.관람, Type.스릴, Type.어린이, Type.연인);
			System.out.println();

			System.out.println("B. 뒤로 가기");
			System.out.print("👉 ");
			String sel = sc.nextLine();

			if(sel.equals("1")) showAttractionList();
			else if(sel.equals("2")) showAttractionList(Type.가족);
			else if(sel.equals("3")) showAttractionList(Type.게임);
			else if(sel.equals("4")) showAttractionList(Type.공포);
			else if(sel.equals("5")) showAttractionList(Type.관람);
			else if(sel.equals("6")) showAttractionList(Type.스릴);
			else if(sel.equals("7")) showAttractionList(Type.어린이);
			else if(sel.equals("8")) showAttractionList(Type.연인);
			else if(sel.equalsIgnoreCase("B")) break;
			else System.out.println("다시 입력해주세요.");
		}
	}
	
	
	public void showAttractionRank() throws Exception {
		ArrayList<Attraction> attractions = Load.loadAttraction();
		
		head("이달의 어트랙션 순위");
		attractions.sort((o1, o2) -> Integer.parseInt(o2.getVote()) - Integer.parseInt(o1.getVote()));

		for(int i = 0; i < 5; i++)
			System.out.printf("%d위 %s\n", i+1, attractions.get(i).getName());
		System.out.println();
	}
	
	public void showAttractionList() throws Exception {
		head("전체 어트랙션 정보");
		page = 0;
		list = attractions.stream().collect(Collectors.toList());
		
		showList(page);
		pageExplore();
	}
	
	public void showAttractionList(Type type) throws Exception {
		head(String.format("%s 어트랙션 정보", type));
		page = 0;
		list = attractions.stream()
				.filter(attraction -> attraction.getAttractionType().equals(type.toString()))
				.collect(Collectors.toList());
		
		showList(page);
		pageExplore();
	}
	
	public void showList(int page) {
		endPage = (list.size()/10 != 0 && list.size()%10 == 0) ? list.size()/10 : list.size()/10+1;		
		
		System.out.println("[번호]\t\t[이름]\t\t[분류]\t\t[탑승인원]\t\t[운행시간]\t\t[위치]");
		for(int i = page*10; i < (page != endPage-1 ? page*10+10 : list.size()); i++) {
			System.out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n"
					, i+1
					, list.get(i).getName()
					, list.get(i).getAttractionType()
					, list.get(i).getCapacity()
					, list.get(i).getRunTime()
					, getLocate(list.get(i).getLocateSeq())
			);
		}
		System.out.printf("%d / %d\n", page+1, endPage);
		System.out.println();
	}
	
	
	public void head(String title) {
		System.out.println("================================");
		System.out.printf("[%s]\r\n", title);
		System.out.println("================================");
	}
	
	public void pageExplore() {
		while(true) {
			System.out.println("< 이전 페이지 | 다음 페이지 > ");
			System.out.println("B. 뒤로 가기");
			System.out.print("👉 ");
			String sel = sc.nextLine();
			
			if(sel.equals("<")) {
				if(page == 0) System.out.println("첫 페이지입니다.");
				else showList(--page);
			}
			else if(sel.equals(">")) {
				if(page == endPage-1) System.out.println("마지막 페이지입니다.");
				else showList(++page);
			}
			else if(sel.equalsIgnoreCase("B")) return;
			else System.out.println("다시 입력해주세요.");
			System.out.println();
		}
	}
	
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
