package com.project.admin;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.data.Attraction;
import com.project.main.Load;
import com.project.main.Save;

/**
 * 어트랙션 운행여부를 관리하는 클래스입니다.
 * @author 써니
 *
 */
public class AttractionOnOff {
	
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
	 * 어트랙션 ON/OFF 관리 페이지를 보여주고 입력을 받아 수정합니다.
	 * @throws Exception
	 */
	public void showAttractionOnOff() throws Exception {
		page = 0;
		while(true) {
			head("어트랙션 ON/OFF 관리");
			showList(page);
			System.out.println();
			
			System.out.println("\t\t\t\t\t\t\t\t\tON/OFF 관리할 어트랙션 번호 입력");
			System.out.println("\t\t\t\t\t\t\t\t\t(전체 ON시 : ON, 전체 OFF시 : OFF)");
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
			else if(sel.equalsIgnoreCase("ON") || sel.equalsIgnoreCase("OFF")) 
				changeAllOnOff(sel);
			else if(Integer.parseInt(sel) > 0 && Integer.parseInt(sel) <= attractions.size()) 
				changeOnOff(sel);
			else {
				System.out.println("\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
				pause();
			}
			System.out.println();
		}
	}
	
	/**
	 * ON/OFF할 어트랙션 목록을 1페이지씩 보여줍니다.
	 * @param page 보여줄 페이지 넘버
	 * @throws Exception
	 */
	public void showList(int page) throws Exception {
		attractions = Load.loadAttraction();
		
		endPage = (attractions.size()/10 != 0 && attractions.size()%10 == 0) ? attractions.size()/10 : attractions.size()/10+1;		
		
		System.out.println("\t\t\t\t\t\t\t[번호]\t\t\t[어트랙션 목록]\t\t\t[운행 여부]");
		for(int i = page*10; i < (page != endPage-1 ? page*10+10 : attractions.size()); i++) {
			System.out.printf("\t\t\t\t\t\t\t%4d\t\t\t%-13s\t\t%7s\n"
					, i+1
					, attractions.get(i).getName()
					, attractions.get(i).getOn().equals("T") ? "ON" : "OFF"
			);
		}
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t< 이전페이지\t\t\t\t     %d / %d\t\t\t\t   다음 페이지 >\n", page+1, endPage);
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println();
	}
	
	/**
	 * 입력 받은 번호의 어트랙션을 ON/OFF 합니다.
	 * @param number ON/OFF할 어트랙션의 번호
	 * @throws Exception
	 */
	public void changeOnOff(String number) throws Exception {
		attractions = Load.loadAttraction();
		
		int index = Integer.parseInt(number) - 1;
		boolean state = attractions.get(index).getOn().equals("T") ? true : false;
		
		System.out.printf("\t\t\t\t\t\t\t\t\t입력하신 [%s]를 %s 하시겠습니까?(Y/N)\n"
				, attractions.get(index).getName(), state ? "OFF" : "ON" );
			
		while(true) {
			System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
			String sel = sc.nextLine();
			System.out.println();
			
			if(sel.equalsIgnoreCase("Y")) {
				attractions.get(index).setOn(!state ? "T" : "F");
				System.out.printf("\t\t\t\t\t\t\t\t\t[%s]를 %s 하였습니다.\n", attractions.get(index).getName(), !state ? "ON" : "OFF");
				
				Save.saveAttraction(attractions);
				pause();
				break;
			}
			else if(sel.equalsIgnoreCase("N")) {
				System.out.println("\t\t\t\t\t\t\t\t\t변경을 취소합니다.");
				pause();
				break;
			}
			else System.out.println("\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
		}
	}
	
	/**
	 * 모든 어트랙션을 ON/OFF 합니다.
	 * @param ON or OFF
	 * @throws Exception
	 */
	public void changeAllOnOff(String change) throws Exception {
		ArrayList<Attraction> attractions = Load.loadAttraction();
		
		if(change.equalsIgnoreCase("ON"))
			attractions.stream().forEach(attraction -> attraction.setOn("T"));
		else if(change.equalsIgnoreCase("OFF"))
			attractions.stream().forEach(attraction -> attraction.setOn("F"));
		
		System.out.printf("\t\t\t\t\t\t\t\t\t전체 어트랙션을 %s 하였습니다.\n", change.equalsIgnoreCase("ON") ? "ON" : "OFF");
		Save.saveAttraction(attractions);
		pause();
	}

	private void head(String title) {
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t\t\t\t\t\t[%s]\r\n", title);
		System.out.println("\t\t\t\t\t================================================================================================");
	}
	
	private void pause() {
		System.out.println("\t\t\t\t\t\t\t\t\t(엔터를 누르면 목록으로 돌아갑니다.)");
		sc.nextLine();
	}
	

}
