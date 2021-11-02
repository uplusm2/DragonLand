package com.project.admin;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.data.Attraction;
import com.project.main.Load;
import com.project.main.Save;

public class AttractionWaitTime {
	
	private static Scanner sc = new Scanner(System.in);
	private static int page;
	private static int endPage;
	private static ArrayList<Attraction> attractions;
	
	static {
		try {
			attractions = Load.loadAttraction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 관리자 화면 > 어트랙션 대기열 관리 페이지를 보여주고 입력을 받아 수정합니다.
	 * @throws Exception
	 */
	public void showAttractionWaitTime() throws Exception {
		page = 0;
		while(true) {
			head("어트랙션 대기열 관리");
			showList(page);
			System.out.println();
			
			System.out.println("\t\t\t\t\t\t\t\t\t대기열을 수정할 어트랙션을 입력해주세요.");
			System.out.println("\t\t\t\t\t\t\t\t\tB. 뒤로 가기");
			System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
			String sel = sc.nextLine();
			System.out.println();
			
			if(sel.equals("<")) {
				if(page == 0) {
					System.out.println("\t\t\t\t\t\t\t\t\t첫 페이지입니다.");
					pause();
				}
				else page--;
			}
			else if(sel.equals(">")) {
				if(page == endPage-1) {
					System.out.println("\t\t\t\t\t\t\t\t\t마지막 페이지입니다.");
					pause();
				}
				else page++;
			}
			else if(sel.equalsIgnoreCase("B")) return;
			else if(sel.compareTo("0") > 0 && sel.compareTo(attractions.size()+"") < 1) 
				changeWaitTime(sel);
			else {
				System.out.println("\t\t\t\t\t\t\t\t\t올바른 번호를 입력해주세요.");
				pause();
			}
			System.out.println();
		}
	}
	
	/**
	 * 어트랙션 대기열을 1페이지씩 보여줍니다.
	 * @param page 보여줄 페이지 넘버
	 * @throws Exception
	 */
	public void showList(int page) throws Exception {
		attractions = Load.loadAttraction();
		
		endPage = (attractions.size()/10 != 0 && attractions.size()%10 == 0) ? attractions.size()/10 : attractions.size()/10+1;		
		
		System.out.println("\t\t\t\t\t\t\t[번호]\t\t\t[어트랙션 목록]\t\t\t[대기시간]");
		for(int i = page*10; i < (page != endPage-1 ? page*10+10 : attractions.size()); i++) {
			System.out.printf("\t\t\t\t\t\t\t%4d\t\t\t%s\t\t\t%7s\n"
					, i+1
					, attractions.get(i).getName()
					, attractions.get(i).getWaitTime() + "분"
			);
		}
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t< 이전페이지\t\t\t\t     %d / %d\t\t\t\t   다음 페이지 >\n", page+1, endPage);
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println();
	}
	
	/**
	 * 대기시간을 수정할 어트랙션의 번호를 받아 대기시간을 수정합니다.
	 * @param number 대기시간을 수정할 어트랙션 번호
	 * @throws Exception
	 */
	public void changeWaitTime(String number) throws Exception {
		
		int index = Integer.parseInt(number) - 1;
		
		while(true) {
			System.out.println("\t\t\t\t\t\t\t\t\t선택한 어트랙션의 대기 시간을 입력해주세요.");
			System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
			String time = sc.nextLine();
			System.out.println();
			
			if(checkTime(time)) {
				attractions.get(index).setWaitTime(time);
				
				System.out.printf("\t\t\t\t\t\t\t\t\t[%s]의 대기시간을 [%s분]으로 수정하였습니다.\n"
						, attractions.get(index).getName(), time);
				
				Save.saveAttraction(attractions);
				pause();
				break;
			}
			else {
				System.out.println("\t\t\t\t\t\t\t\t\t최대 120분까지 입력 가능합니다.");
				System.out.println("\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
				System.out.println();
			}
		
		}
		
	}
	
	/**
	 * 입력 받은 수정 대기시간이 올바른 값인지 확인합니다.
	 * @param time 수정할 대기시간
	 * @return
	 */
	public boolean checkTime(String time) {
		boolean flag = true;

		// Check 1. integer
		for(int i = 0; i < time.length(); i++)
			if(!Character.isDigit(time.charAt(i))) 
				flag = false;
		
		// Check 2. time range
		if(flag) {
			int minute = Integer.parseInt(time);
			if(minute < 0 || minute > 120) flag = false;
		}
		
		return flag;
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
	 * 사용자 입력으로 Enter를 받으면 목록으로 돌아가는 pause 기능의 메소드
	 */
	public void pause() {
		System.out.println("\t\t\t\t\t\t\t\t\t(엔터를 누르면 목록으로 돌아갑니다.)");
		sc.nextLine();
	}
	

}
