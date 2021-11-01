package com.project.landinfo;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.data.Card;
import com.project.data.Facility;
import com.project.data.Location;
import com.project.data.Parade;
import com.project.data.Ticket;
import com.project.main.Load;

public class LandInfo {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 용용랜드 정보 메뉴를 보여줍니다.
	 * @throws Exception
	 */
	public void menu() throws Exception {
		AttractionInfo attractionInfo = new AttractionInfo();
		
		while(true) {
			head("용용랜드 정보");
			System.out.println("1. 어트랙션 정보");
			System.out.println("2. 퍼레이드 정보");
			System.out.println("3. 편의시설 정보");
			System.out.println("4. 티켓요금 정보");
			System.out.println("B. 뒤로 가기");
			System.out.print("👉 ");
			String sel = sc.nextLine();
			System.out.println();
			
			if(sel.equals("1")) attractionInfo.menu();
			else if(sel.equals("2")) showParadeInfo();
			else if(sel.equals("3")) showFacilityInfo();
			else if(sel.equals("4")) showTickMoneyInfo();
			else if(sel.equalsIgnoreCase("B")) break;
			else System.out.println("다시 입력해주세요.");
			System.out.println();
		}
		
	}
	
	/**
	 * 퍼레이드 정보를 보여줍니다.
	 * @throws Exception
	 */
	public void showParadeInfo() throws Exception {
		ArrayList<Parade> paradeInfo = Load.loadParade();
		
		head("퍼레이드 정보");
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
		
		pageBack();
	}
	
	/**
	 * 편의시설 정보를 보여줍니다.
	 * @throws Exception
	 */
	public void showFacilityInfo() throws Exception {
		ArrayList<Facility> list = Load.loadFacility();
		
		head("편의시설 정보");
		
		/* 음식점 */
		System.out.println("[음식점]");
		System.out.println("[번호]\t[이름]\t\t[이용시간]\t[위치]");
		list.stream()
			.filter(facility -> facility.getType().equals("음식점"))
			.forEach(facility -> {
				System.out.printf("%s\t%s\t\t%s\t%s\t\r\n"
						, facility.getSeq()
						, facility.getName()
						, facility.getTime()
						, getLocate(facility.getLocateNum())
				);
			});
		System.out.println();
		
		/* 물품 보관함 */
		System.out.println("[물품보관함]");
		System.out.println("[번호]\t[이름]\t\t[이용시간]\t[위치]");
		list.stream()
			.filter(facility -> facility.getType().equals("물품보관함"))
			.forEach(facility -> {
				System.out.printf("%s\t%s\t%s\t%s\t\r\n"
						, facility.getSeq()
						, facility.getName()
						, facility.getTime()
						, getLocate(facility.getLocateNum())
				);
			});
		System.out.println();
		
		/* 의료실 */
		System.out.println("[의료실]");
		System.out.println("[번호]\t[이름]\t\t[이용시간]\t[위치]");
		list.stream()
			.filter(facility -> facility.getType().equals("의료실"))
			.forEach(facility -> {
				System.out.printf("%s\t%s\t\t%s\t%s\t\r\n"
						, facility.getSeq()
						, facility.getName()
						, facility.getTime()
						, getLocate(facility.getLocateNum())
				);
			});
		System.out.println();
		
		pageBack();
	}
	
	/**
	 * 티켓요금과 할인카드 정보를 보여줍니다.
	 * @throws Exception
	 */
	public void showTickMoneyInfo() throws Exception {
		ArrayList<Ticket> ticketInfo = Load.loadTicket();
		ArrayList<Card> cardInfo = Load.loadCard();
		
		head("티켓요금");
		
		/* 티켓 요금 */ 
		System.out.println("[종류]\t[금액]\t[비고]");

		ticketInfo.stream().forEach(ticket -> {
			System.out.printf("%s\t%s\t%s\t\r\n"
					, ticket.getUserType()
					, ticket.getPrice() + "원"
					, ticket.getNote()
			);
		});
		System.out.println();
		
		/* 할인 카드 정보 */
		System.out.println("*[제휴카드]");
		cardInfo.stream().forEach(card -> {
				System.out.printf("%s카드 : %.0f%% 할인\n"
						, card.getName()
						,(1 - Double.parseDouble(card.getDiscount()))*100
				);
			}
		);
		System.out.println();
		
		pageBack();
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
	 * 사용자 입력으로 'B'를 받으면 이전 메뉴로 돌아가는 기능의 메소드
	 */
	public void pageBack() {
		while(true) {
			System.out.println("B. 뒤로 가기");
			System.out.print("👉 ");
			String sel = sc.nextLine();
			System.out.println();
			
			if(sel.equalsIgnoreCase("B")) break;
			else System.out.println("다시 입력해주세요.");
			System.out.println();
		}
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
