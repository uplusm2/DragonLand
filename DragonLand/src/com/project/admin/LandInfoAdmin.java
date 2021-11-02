package com.project.admin;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.data.Attraction;
import com.project.main.Load;
import com.project.main.Save;

public class LandInfoAdmin {

	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 관리자 > 놀이공원 정보 관리 메뉴를 보여줍니다.
	 * @throws Exception
	 */
	public void menu() throws Exception {
	
		AttractionOnOff onOff = new AttractionOnOff();
		AttractionWaitTime aWaitTime = new AttractionWaitTime();
		ParadeAdmin paradeAdmin = new ParadeAdmin();
		
		while(true) {
			head("놀이공원 정보 관리");
			System.out.println("\t\t\t\t\t\t\t\t\t1. 어트랙션 ON/OFF 관리");
			System.out.println("\t\t\t\t\t\t\t\t\t2. 어트랙션 대기열 관리");
			System.out.println("\t\t\t\t\t\t\t\t\t3. 퍼레이드 정보 관리");
			System.out.println("\t\t\t\t\t\t\t\t\tB. 뒤로 가기");
			System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
			String sel = sc.nextLine();
			System.out.println();
			
			if(sel.equals("1")) onOff.showAttractionOnOff();
			else if(sel.equals("2")) aWaitTime.showAttractionWaitTime();
			else if(sel.equals("3")) paradeAdmin.showParadeInfo();
			else if(sel.equalsIgnoreCase("B")) break;
			else System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
		}
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
	
	
}
