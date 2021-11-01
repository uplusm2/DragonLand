package com.project.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.project.data.TicketReservation;
import com.project.data.User;
import com.project.main.Load;

/**
 * 티켓 예매자 목록 클래스
 * @author 김재형
 *
 */
public class TicketReservationStatus {
	
	private static Scanner scan;
	private static ArrayList<TicketReservation> reservationList;
	private static ArrayList<User> userList;
	private static int start;
	private static int end;
	private static int num;
	private static String name;
	private static String id;
	private static String jumin;
	private static String phoneNum;
	private static String address;
	private static String info ;
	private static String seq;
	private static String adcount;
	private static String youthCount;
	private static String kidCount;
	
	static {
		scan=new Scanner(System.in);
		reservationList = new ArrayList<TicketReservation>();
		userList = new ArrayList<User>();
		start=0;
		end=10;
		num=1;
		name = "";
		id = "";
		jumin = "";
		phoneNum = "";
		address = "";
		info = "";
	}
	
	
	
	/**
	 * 목록 메뉴화면 메소드
	 * @param index
	 * @throws Exception
	 */
	public static void status(ArrayList index) throws Exception {
		
		System.out.println("============================");
		System.out.println("  [당일 티켓 예매자 목록]");
		System.out.println("============================");
		System.out.println("회원번호  아이디     이름     주민번호       핸드폰번호   주소\t\t\t\t\t\t매수");
		
		
		
		
		
		
		for (int i = start; i < end&&i<index.size() ; i++) {  //index3.size()
			System.out.printf("%s\n",index.get(i));
		}
		
		System.out.printf("                                      %d/%d\n",num,(index.size())/10+1);
		System.out.println("<.이전 페이지   다음 페이지.>");
		System.out.println("B.뒤로가기");
		System.out.print("👉");
		String index2 = scan.nextLine();
		if(index2.equals(">")){
			
			start+=10;
			end+=10;
			num++;
			
			status(index);
		}else if(index2.equals("<")) {
			if(start>=10) {
				start-=10;
				end-=10;
				num--;
				status(index);
			}else {
				System.out.println("뒤로 갈곳이 없습니다.");
				status(index);
			}
				
		}else if(index2.equals("b")||index2.equals("B")) {
			LoginAdmin.login();
			
		}else {
			System.out.println("다시 입력해주세요.");
			status(index);
		}
		
	}



	/**
	 * 리스트 가져오기 클래스
	 * @return
	 * @throws Exception
	 */
	public static ArrayList makeList() throws Exception {
		
		reservationList = Load.loadTicketReservation();
		userList = Load.loadUser();
		ArrayList<String> index = new ArrayList<String>();
		Calendar c1 = Calendar.getInstance();
		c1.set(2021, 9, 20);
		String date = String.format("%d%02d%02d", c1.get(Calendar.YEAR), c1.get(Calendar.MONTH) + 1,
		c1.get(Calendar.DATE));
		
		for (int i = 0; i < reservationList.size() - 1; i++) {
			if (reservationList.get(i).getDate().equals(date)) {
				for (int j = 0; j < userList.size() - 1; j++) {
					if (reservationList.get(i).getUserNum().equals(userList.get(j).getSeq())) {
						name = userList.get(j).getName();
						id = userList.get(j).getId();
						jumin = userList.get(j).getJumin().substring(0, 6) + "-"
								+ userList.get(j).getJumin().substring(6);
						phoneNum = userList.get(j).getPhoneNum();
						address = userList.get(j).getAddress();
						seq= userList.get(j).getSeq();
						adcount=reservationList.get(i).getAdultCount();
						youthCount = reservationList.get(i).getYouthCount();
						kidCount = reservationList.get(i).getKidCount();
//						info = seq.substring(1,5)+"    "+id + "    " + name + "  " + jumin + "  " + phoneNum + "    " + address+"  성인"+adcount
//								+" 청소년"+youthCount+" 어린이"+kidCount;
						info = String.format("%s      %8s   %s   %s %s  %s       성인%s 청소년%s 아이%s",seq.substring(1,5),id,name,jumin,phoneNum,address,adcount,youthCount,kidCount);
						index.add(info);
					}
				}

			}
		}
		
		return index;
		
		
	}

}
