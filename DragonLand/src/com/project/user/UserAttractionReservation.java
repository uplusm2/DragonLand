package com.project.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.project.data.Attraction;
import com.project.data.AttractionReservation;
import com.project.data.TicketReservation;
import com.project.data.User;
import com.project.landinfo.AttractionInfo.Type;
import com.project.login.login;
import com.project.main.Load;
import com.project.main.Save;

public class UserAttractionReservation {
	
	private static Scanner sc = new Scanner(System.in);
	private static int page;
	private static int endPage;
	private static ArrayList<User> users;
	private static ArrayList<String> availdTime;
	private static ArrayList<Attraction> attractions;
	private static ArrayList<AttractionReservation> reserveList;
	private static List<Attraction> list;
	
	/* ---- variable for reservation ---- */
	private static String inputTimeNum;
	private static String selectTime ;
	private static Attraction selectAttraction;
	private static int totalReserve;
	private static String capacity;
	private static int remainSeat;
	/* ---------------------------------- */
	
	static {
		try {
			attractions = Load.loadAttraction();
			users = Load.loadUser();
			reserveList = Load.loadAttractionReservation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 어트랙션 예약을 위한 메뉴를 보여줍니다.
	 * @throws Exception
	 */
	public void menu() throws Exception {
		while(true) {
			head("어트랙션 예약");
			System.out.printf("\t\t\t\t\t\t\t\t1.%s\t2.%s\t\t3.%s\t\t4.%s\n", "전체보기", Type.가족, Type.게임, Type.공포);
			System.out.printf("\t\t\t\t\t\t\t\t5.%s\t\t6.%s\t\t7.%s\t8.%s\n", Type.관람, Type.스릴, Type.어린이, Type.연인);

			System.out.println("\t\t\t\t\t\t\t\tB. 뒤로 가기");
			System.out.print("\t\t\t\t\t\t\t\t👉 ");
			String sel = sc.nextLine();
			System.out.println();

			if(sel.equals("1")) showAttractionList(null);
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
	 * 선택한 분류의 어트랙션 목록을 만들고 보여줍니다.
	 * @param type
	 * @throws Exception
	 */
	public void showAttractionList(Type type) throws Exception {
		// 어트랙션 리스트 생성
		if(type == null) 
			list = attractions.stream().collect(Collectors.toList()); //전체
		else 
			list = attractions.stream() // 선택한 타입
					.filter(attraction -> attraction.getAttractionType().equals(type.toString()))
					.collect(Collectors.toList());
		
		// 페이지 탐색 && 예약할 어트랙션 번호 선택
		page = 0;
		while(true) {
			showList(page, type);
			System.out.println();
			
			System.out.println("\t\t\t\t\t\t\t\t\t예약할 어트랙션 번호를 입력하세요.");
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
			else if(Integer.parseInt(sel) > 0 && Integer.parseInt(sel) <= list.size() )
				selectTime(sel);
			else {
				System.out.println("\t\t\t\t\t\t\t\t\t올바른 번호를 입력해주세요.");
				pause();
			}
			System.out.println();
		}
		
	}
	
	
	/**
	 * 어트랙션 예약을 위한 시간대 선택 및 예약
	 * @param number
	 * @throws Exception
	 */
	private void selectTime(String number) throws Exception {
		
		// 예약 시간 선택
		while(true) {
			showTimeTable(number);
			
			System.out.println("\t\t\t\t\t\t\t\t\t예약할 시간을 선택해주세요.");
			System.out.println("\t\t\t\t\t\t\t\t\tB. 뒤로 가기");
			System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
			inputTimeNum = sc.nextLine();
			System.out.println();
			
			if(inputTimeNum.equalsIgnoreCase("B")) break;
			
			else if(Integer.parseInt(inputTimeNum) > 0 && Integer.parseInt(inputTimeNum) <= availdTime.size()) {
				// 예약 로직
				// 1. 이미 내 예약 상황에 해당 날짜, 해당 시간에 예약이 있을 경우 error
				// 2. 만약 선택한 번호의 reserveCnt가 다 차있으면 error
				// 3. 예약인원이 잔여석 초과시 error
				// 4. 예약인원이 내가 예매한 인원보다 많으면 error
				
				selectTime = availdTime.get(Integer.parseInt(inputTimeNum)-1);
				totalReserve = getReserveCnt(selectTime, selectAttraction.getSeq());
				capacity = selectAttraction.getCapacity();
				remainSeat = Integer.parseInt(capacity) - totalReserve;
				
				if(isExistTime(selectTime)) {
					System.out.println("\t\t\t\t\t\t\t\t\t이미 해당 시간에 예약 정보가 존재합니다.");
					pause();
				}
				
				else if(remainSeat == 0) {
					System.out.println("\t\t\t\t\t\t\t\t\t예약 인원이 꽉 차 예약이 불가합니다.");
					pause();
				}
				else 
					reserve();
			}
			else {
				System.out.println("\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
				pause();
			}
			
			System.out.println();
		}
		
	}
	
	
	public void reserve() throws Exception {
		while(true) {
			System.out.printf("\t\t\t\t\t\t\t\t\t예약 인원을 선택해주세요.\n");
			System.out.printf("\t\t\t\t\t\t\t\t\t(가능한 인원 수 : %s명)\n", getMyTicketReserveCnt());
			System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
			String inputReserveCnt = sc.nextLine();
			System.out.println();
			
			if(inputReserveCnt.equalsIgnoreCase("B")) break;
			
			if(inputReserveCnt.equals("0")) {
				System.out.println("\t\t\t\t\t\t\t\t\t예약은 1명 이상 가능합니다.");
				pause();
				break;
			}
			else if(Integer.parseInt(inputReserveCnt) > remainSeat) {
				System.out.println("\t\t\t\t\t\t\t\t\t예약 가능한 자리를 초과하였습니다.");
				pause();
				break;
			}
			else if(Integer.parseInt(inputReserveCnt) > getMyTicketReserveCnt()) {
				System.out.println("\t\t\t\t\t\t\t\t\t예약 가능한 인원 수 보다 많습니다.");
				pause();
				break;
			}
			else {
				// 어트랙션 예약정보 생성
				AttractionReservation r = new AttractionReservation(
							getReserveSeq(selectTime, selectAttraction.getSeq())
							, selectAttraction.getSeq()
							, getToday()
							, selectTime
							, inputReserveCnt
							, getUserSeq());
				
				//SAVE 로직
				reserveList.add(r);
				Save.saveAttractionReservation(reserveList);
				
				System.out.println("\t\t\t\t\t\t\t\t\t예약이 완료되었습니다.");
				pause();
				break;
			}
		}
	}
	
	/**
	 * 예약 가능한 시간 목록을 보여줍니다.
	 * @param number 선택한 어트랙션 번호
	 * @throws Exception
	 */
	public void showTimeTable(String number) throws Exception {
		availdTime = getAvalidTime();
		selectAttraction = list.get(Integer.parseInt(number) - 1);
		
		head(String.format("%s 예약", selectAttraction.getName()));
		System.out.println("\t\t\t\t\t\t\t[번호]\t\t\t[예약 가능 시간]\t\t[예약 현황]");
		
		for(int i = 0; i < availdTime.size(); i++) {
			System.out.printf("\t\t\t\t\t\t\t%4d\t\t\t%10s\t\t\t  %d / %s\n"
					, i+1
					, availdTime.get(i) + ":00"
					, getReserveCnt(availdTime.get(i), selectAttraction.getSeq())
					, selectAttraction.getCapacity());
		}
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println();
	}
	
	/**
	 * 유저의 당일 티켓 예매 인원을 반환하는 메소드
	 * @return
	 * @throws Exception
	 */
	public int getMyTicketReserveCnt() throws Exception {
		ArrayList<TicketReservation> ticketList = Load.loadTicketReservation();
		
		int ticketHuman = 0;
		for(TicketReservation ticket : ticketList) {
			if(isToday(ticket.getDate()) && ticket.getUserNum().equals(getUserSeq()))
				ticketHuman = Integer.parseInt(ticket.getAdultCount())
						+ Integer.parseInt(ticket.getYouthCount())
						+ Integer.parseInt(ticket.getKidCount());
		}
		return ticketHuman;
	}
	
	/**
	 * 유저의 유저번호를 반환하는 메소드
	 * @return
	 * @throws Exception
	 */
	public String getUserSeq() throws Exception {
		for(User user : users) {
			if(user.getId().equals(login.loginId))
				return user.getSeq();
		}
		return null;
	}
	
	/**
	 * YYYYMMDD 형식의 오늘 날짜를 반환하는 메소드
	 * @return
	 */
	public String getToday() {
		Calendar now = Calendar.getInstance();
		String today = "" + now.get(Calendar.YEAR)
						+ (now.get(Calendar.MONTH) + 1)
						+ (now.get(Calendar.DATE) < 10 ? "0"+now.get(Calendar.DATE) : now.get(Calendar.DATE));
		return today;
	}
	
	/**
	 * 인자로 넘어온 날짜가 오늘인지 확인하는 메소드
	 * @param date 날짜
	 * @return
	 */
	public boolean isToday(String date) {
		Calendar now = Calendar.getInstance();
		boolean today = true;
		
		if(!date.substring(0, 4).equals(now.get(Calendar.YEAR) + "")) today = false;
		if(!date.substring(4, 6).equals(now.get(Calendar.MONTH) + 1 +"")) today = false;
		if(!date.substring(6, 8).equals(now.get(Calendar.DATE) < 10 ? "0"+now.get(Calendar.DATE) : now.get(Calendar.DATE)+""))
			today = false;
		
		return today;
	}
	
	/**
	 * 어트랙션 예약 번호를 생성하여 반환하는 메소드
	 * @param selectTime
	 * @param attractionSeq
	 * @return
	 * @throws Exception
	 */
	public String getReserveSeq(String selectTime, String attractionSeq) throws Exception {
		
		// 예약순번 생성
		int iOrder = getLastOrder(selectTime, attractionSeq);
		String sOrder = "";
		
		if(iOrder < 10) sOrder = "00"+ iOrder;
		else if(iOrder < 100) sOrder = "0"+ iOrder;
		else sOrder = iOrder + "";
		
		// 예약번호 생성
		String reserveSeq = "R" + getToday().substring(2) + selectTime + sOrder;
		
		return reserveSeq;
	}
	
	/**
	 * 선택한 어트랙션의 예약 희망 시간 마지막 예약 순번을 반환하는 메소드
	 * @param selectHour
	 * @param selectAttraction
	 * @return
	 * @throws Exception
	 */
	public int getLastOrder(String selectHour, String selectAttraction) throws Exception {
		reserveList = Load.loadAttractionReservation();
		
		int lastOrder = 1;
		for(AttractionReservation list : reserveList) {
			if(isToday(list.getDate())
					&& list.getHour().equals(selectHour) 
					&& list.getAttractionNum().equals(selectAttraction))
				lastOrder++;
		}
		return lastOrder;
	}

	/**
	 * 선택한 타입의 어트랙션 대기열을 1페이지씩 보여줍니다.
	 * @param page 보여줄 페이지 넘버
	 * @throws Exception
	 */
	public void showList(int page, Type type) throws Exception {
		//attractions = Load.loadAttraction();
		
		if(type == null) head("전체 어트랙션 예약");
		else head(String.format("%s 어트랙션 예약", type));
		
		System.out.println("\t\t\t\t\t\t\t[번호]\t\t\t[어트랙션 목록]\t\t\t[대기시간]");
		for(int i = page*10; i < page*10+10 && i< list.size(); i++) {
			System.out.printf("\t\t\t\t\t\t\t%4d\t\t\t%-13s\t\t%7s\n"
					, i+1
					, list.get(i).getName()
					, list.get(i).getWaitTime() + "분"
			);
		}
		
		endPage = (list.size()/10 != 0 && list.size()%10 == 0) ? list.size()/10 : list.size()/10+1;		
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t< 이전페이지\t\t\t\t     %d / %d\t\t\t\t   다음 페이지 >\n", page+1, endPage);
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println();
	}
	
	/**
	 * 예약 가능한 어트랙션 시간 리스트를 반환하는 메소드
	 * @return
	 */
	public ArrayList getAvalidTime() {
		// 현재시간 추출
		Calendar now = Calendar.getInstance();
		ArrayList<String> list = new ArrayList();
		int availdHour = now.get(Calendar.HOUR_OF_DAY) + 1;
		
		// 예약 가능한 시간 리스트 생성
		for(int i = availdHour; i < 22; i++)
			list.add(i < 10 ? "0"+i : ""+i);
		
		return list;
	}
	
	
	/**
	 * 선택한 어트랙션의 예약 희망 시간 기예약자 인원을 반환하는 메소드
	 * @param selectHour
	 * @param selectAttraction
	 * @return
	 * @throws Exception
	 */
	public int getReserveCnt(String selectHour, String selectAttraction) throws Exception {
		reserveList = Load.loadAttractionReservation();
		
		int totalReserve = 0;
		for(AttractionReservation list : reserveList) {
			if(isToday(list.getDate())
					&& list.getHour().equals(selectHour) 
					&& list.getAttractionNum().equals(selectAttraction))
				totalReserve += Integer.parseInt(list.getCount());
		}
		return totalReserve;
	}
	

	
	/**
	 * 유저가 선택한 시간대에 다른 예약 어트랙션이 있는지 확인하는 메소드
	 * @param selectHour
	 * @return
	 * @throws Exception
	 */
	public boolean isExistTime(String selectHour) throws Exception {
		reserveList = Load.loadAttractionReservation();
		
		boolean existTime = false;
		for(AttractionReservation list : reserveList) {
			if(isToday(list.getDate())
					&& list.getHour().equals(selectHour) 
					&& list.getUserNum().equals(getUserSeq()))
				existTime = true;
		}
		return existTime;
	}
	
	
	public void head(String title) {
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t\t\t\t\t\t[%s]\r\n", title);
		System.out.println("\t\t\t\t\t================================================================================================");
	}
	
	
	public void pause() {
		System.out.println("\t\t\t\t\t\t\t\t\t(엔터를 누르면 목록으로 돌아갑니다.)");
		sc.nextLine();
	}
	
}