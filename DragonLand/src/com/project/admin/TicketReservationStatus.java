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
		
		
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[당일 티켓 예매자 목록]");
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t회원번호     아이디      이름     주민번호         핸드폰번호        매수");
		
		
		
		for (int i = start; i < end&&i<index.size() ; i++) {  
			System.out.printf("\t\t\t\t\t%s\n",index.get(i));
		}
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t< 이전 페이지                              %d/%d                              다음 페이지 >\n",num,(index.size())/10+1);
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\tB.뒤로가기");
		System.out.print("\t\t\t\t\t\t\t\t\t\t👉");
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
				System.out.println("\t\t\t\t\t\t\t\t\t\t뒤로 갈곳이 없습니다.");
				status(index);
			}
				
		}else if(index2.equals("b")||index2.equals("B")) {
			LoginAdmin.login();
			
		}else {
			System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
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
						//address = userList.get(j).getAddress();
						seq= userList.get(j).getSeq();
						adcount=reservationList.get(i).getAdultCount();
						youthCount = reservationList.get(i).getYouthCount();
						kidCount = reservationList.get(i).getKidCount();
//						info = seq.substring(1,5)+"    "+id + "    " + name + "  " + jumin + "  " + phoneNum + "    " + address+"  성인"+adcount
//								+" 청소년"+youthCount+" 어린이"+kidCount;
						info = String.format(" %s       %8s   %s   %s    %s-%s-%s     성인%s 청소년%s 아이%s",seq,id,name,jumin,
								phoneNum.substring(0,3),phoneNum.substring(3,7),phoneNum.substring(7),adcount,youthCount,kidCount);
						index.add(info);
					}
				}

			}
		}
		
		return index;
		
		
	}

}
