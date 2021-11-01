package com.project.admin;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.data.Location;
import com.project.data.Parade;
import com.project.main.Load;
import com.project.main.Save;

public class ParadeAdmin {
	
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Parade> paradeInfo;
	
	static {
		try {
			paradeInfo = Load.loadParade();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 관리자 화면 > 퍼레이드 정보 관리 페이지를 보여주고 입력을 받아 수정합니다.
	 * @throws Exception
	 */
	public void showParadeInfo() throws Exception {
		while(true) {
			head("퍼레이드 정보 관리");
			showParade();
			System.out.println("1. 퍼레이드 이름 수정");
			System.out.println("2. 퍼레이드 날짜 수정");
			System.out.println("3. 퍼레이드 정보 수정");
			System.out.println("B. 뒤로 가기");
			System.out.print("👉 ");
			String sel = sc.nextLine();
			System.out.println();
			
			if(sel.equals("1")) changeTitle();
			else if(sel.equals("2")) changeDate();
			else if(sel.equals("3")) changeContent();
			else if(sel.equalsIgnoreCase("B")) break;
			else {
				System.out.println("다시 입력해주세요.");
				pause();
			}
		}
	}

	/**
	 * 퍼레이드 정보를 보여줍니다.
	 * @throws Exception
	 */
	public void showParade() throws Exception {
		paradeInfo = Load.loadParade();
		
		paradeInfo.stream().forEach(parade -> {
			System.out.println(parade.getTitle());
			System.out.printf("(%s.%s.%s ~ %s.%s.%s)\n"
					, parade.getStartDate().substring(0, 4)
					, parade.getStartDate().substring(4, 6)
					, parade.getStartDate().substring(6)
					, parade.getEndData().substring(0, 4)
					, parade.getEndData().substring(4, 6)
					, parade.getEndData().substring(6)
			);
			System.out.println(parade.getContent());
			System.out.printf("장소 : %s\r\n\n", getLocate(parade.getLocate()));
			
			System.out.println("[회차]\t[시간]");
			for(int i = 0; i < parade.getTime().size(); i++)
				System.out.printf("%s\t%s\r\n", (i+1)+"회" , parade.getTime().get(i));
			System.out.println();	
		});
	}
	
	/**
	 * 퍼레이드 이름을 수정합니다.
	 * @throws Exception
	 */
	private void changeTitle() throws Exception {
		head("퍼레이드 이름 수정");
		System.out.println("퍼레이드 이름 수정");
		System.out.print("👉 ");
		String title = sc.nextLine();
		System.out.println();
		
		paradeInfo.stream().forEach(parade -> parade.setTitle(title));
		Save.saveParade(paradeInfo);
		
		System.out.println("퍼레이드 이름이 수정 되었습니다.");
		System.out.println();
		
		pause();
	}
	
	/**
	 * 퍼레이드 날짜를 수정합니다.
	 * @throws Exception
	 */
	private void changeDate() throws Exception {
		head("퍼레이드 날짜 수정");
		System.out.println("퍼레이드 날짜 수정(YYYYMMDD)");
		
		while(true) {
			System.out.print("시작일 👉 ");
			String startDate = sc.nextLine();
			
			if(startDate.length() != 8) {
				System.out.println();
				System.out.println("올바른 형식으로 입력 바랍니다.");
			}
			else {
				paradeInfo.stream().forEach(parade -> parade.setStartDate(startDate));
				break;
			}
		}
		
		while(true) {
			System.out.print("종료일 👉 ");
			String endDate = sc.nextLine();
			
			if(endDate.length() != 8) {
				System.out.println();
				System.out.println("올바른 형식으로 입력 바랍니다.");
			}
			else {
				paradeInfo.stream().forEach(parade -> parade.setStartDate(endDate));
				break;
			}
		}
		System.out.println();
			
		Save.saveParade(paradeInfo);
		
		System.out.println("퍼레이드 날짜가 수정 되었습니다.");
		System.out.println();
		
		pause();
	}
	
	/**
	 * 퍼레이드 내용을 수정합니다.
	 * @throws Exception
	 */
	private void changeContent() throws Exception {
		head("퍼레이드 내용 수정");
		System.out.println("퍼레이드 내용 수정");
		System.out.print("👉 ");
		String content = sc.nextLine();
		System.out.println();
		
		paradeInfo.stream().forEach(parade -> parade.setContent(content));
		Save.saveParade(paradeInfo);
		
		System.out.println("퍼레이드 내용이 수정 되었습니다.");
		System.out.println();
		
		pause();
	}

	
	/**
	 * 현재 페이지의 헤더를 출력합니다.
	 * @param title 현재 페이지의 헤더 제목
	 */
	public void head(String title) {
		System.out.println("================================");
		System.out.printf("[%s]\r\n", title);
		System.out.println("================================");
	}
	
	/**
	 * 사용자 입력으로 Enter를 받으면 목록으로 돌아가는 pause 기능의 메소드
	 */
	public void pause() {
		System.out.println("(엔터를 누르면 목록으로 돌아갑니다.)");
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
