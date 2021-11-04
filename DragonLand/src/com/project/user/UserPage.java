
package com.project.user;

import java.io.*;

import java.util.*;
import java.util.regex.Pattern;

import com.project.data.*;
import com.project.login.login;
import com.project.main.Load;
import com.project.main.Save;
import com.project.user.*;

/**
 * 유저 페이지 클래스입니다.
 * @author songj
 *
 */

	public class UserPage {

			private static Scanner scan;
			private static ArrayList<User> list;
			static ArrayList<User> nowuser;
			private static ArrayList<TicketReservation> ticketr;
			private static ArrayList<TicketReservation> nowuserticket;
			private static ArrayList<TicketReservation> nowusertickettoday;
			private static ArrayList<AttractionReservation> attractionr;
			private static ArrayList<AttractionReservation> nowuserattraction;
			private static ArrayList<Attraction> attraction;
			private static UserAttractionReservation userattractionreservation;
			static {
				scan = new Scanner(System.in);
				userattractionreservation = new UserAttractionReservation();
			}

		/**
		 * 로그인 후 나오는 유저페이지입니다.
		 * @throws Exception
		 */
		public static void userpage() throws Exception {
				
			
			
			boolean loop = true;
			while(loop) {
				list = Load.loadUser();
				ticketr = Load.loadTicketReservation();
				attractionr = Load.loadAttractionReservation();
				nowuser = new ArrayList<User>();
				nowuserticket = new ArrayList<TicketReservation>();
				nowusertickettoday = new ArrayList<TicketReservation>();
				nowuserattraction = new ArrayList<AttractionReservation>();
				attraction = Load.loadAttraction();
				
				//로그인한 유저의 정보를 nowuser 배열에 저장
				for (int i=0; i<list.size(); i++) {
					if (list.get(i).getId().equals(login.loginId)) {
						nowuser.add(list.get(i));
					}
				}		
				
				//로그인한 유저의 티켓정보를 nowuserticket 배열에 저장
				for (int i=0; i<ticketr.size(); i++) {
					if (ticketr.get(i).getUserNum().equals(nowuser.get(0).getSeq())) {
						nowuserticket.add(ticketr.get(i));
					}
				}
				
				//로그인한 유저의 티켓정보를 nowattraction 배열에 저장
				for (int i=0; i<attractionr.size(); i++) {
					if (attractionr.get(i).getUserNum().equals(nowuser.get(0).getSeq())) {
						nowuserattraction.add(attractionr.get(i));
					}
				}
				
				//로그인한 유저의 오늘티켓정보를 nowusertickettoday 배열에 저장
				for (int i=0; i<ticketr.size(); i++) {
					if (ticketr.get(i).getUserNum().equals(nowuser.get(0).getSeq()) && isToday(ticketr.get(i).getDate())) {
						
						nowusertickettoday.add(ticketr.get(i));
							
					}
				}
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t[회원 메뉴]");
			System.out.println("\t\t\t\t\t================================================================================================");
				menu();
				System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
				String sel = scan.nextLine();
				System.out.println();
				
				if(sel.equals("1")) {		
					mypage();
					
				}else if(sel.equals("2")){	
					UserTicketReservation.reserve();
					
				}else if(sel.equals("3")){	
					if(!nowusertickettoday.isEmpty()) {
						userattractionreservation.menu();																		
						}else{
							
							System.out.println("\t\t\t\t\t\t\t\t금일 예약 티켓이 없습니다.");
							System.out.println("\t\t\t\t\t\t\t\t어트랙션 예약은 당일 티켓이 있어야만 가능합니다.");
							
							System.out.println("");
							System.out.println("\t\t\t\t\t\t\t\t\t엔터를 누르시면 유저 페이지로 돌아갑니다.");
							scan.nextLine();
							
						}
					
				}else if(sel.equals("4")){	
					Survey.SurveyMain();
					
				}else if(sel.equalsIgnoreCase("B")){									
					login.login();
					
				}else{
					System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
					
				}
			}
			
		}
		/**
		 * 로그인 시 메뉴창
		 */
		public static void menu() {
				
			System.out.printf("\t\t\t\t\t\t\t\t\t\t%s님 환영합니다!\r\n", nowuser.get(0).getName());
			System.out.println("\t\t\t\t\t\t\t\t\t\t1. My Page");
			System.out.println("\t\t\t\t\t\t\t\t\t\t2. 티켓 예매");
			System.out.println("\t\t\t\t\t\t\t\t\t\t3. 어트랙션 예약");
			System.out.println("\t\t\t\t\t\t\t\t\t\t4. 설문 조사");
			System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로 가기");
		}
		

		/**
		 * MyPage 화면 개인의 신상정보 및 티켓, 놀이기구 예약 정보를 확인할 수 있다.
		 * @throws Exception
		 */
		public static void mypage() throws Exception {
			
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t[My Page]");
			System.out.println("\t\t\t\t\t================================================================================================");

			System.out.println("\t\t\t\t\t\t\t\t\t\t1. 개인 정보 확인");
			System.out.println("\t\t\t\t\t\t\t\t\t\t2. 티켓 예매 정보 확인");
			System.out.println("\t\t\t\t\t\t\t\t\t\t3. 어트랙션 예약 정보 확인");
			System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로가기");
			
			boolean loop = true;
			while(loop) {

				System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
				String sel = scan.nextLine();
				System.out.println();
				
				if(sel.equals("1")) {		
					userinfo();
					
				}else if(sel.equals("2")){	
					ticketreserveinfo();
					
				}else if(sel.equals("3")){	
					attractionreserveinfo();
					
				}else if(sel.equalsIgnoreCase("B")){									
					userpage();
					
				}else {
					System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
					
				}
			}
			
		}
		
		/**
		 * 개인정보 확인 화면
		 * @throws Exception
		 */
		public static void userinfo() throws Exception {
			
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t[개인정보 확인]");
			System.out.println("\t\t\t\t\t================================================================================================");
			
			System.out.println("\t\t\t\t\t\t\t\t\t\t1. 개인 정보 조회 및 수정");
			System.out.println("\t\t\t\t\t\t\t\t\t\t2. 회원 탈퇴");
			System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로가기");
			
			boolean loop = true;
			while(loop) {

				System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
				String sel = scan.nextLine();
				System.out.println();
				
				if(sel.equals("1")) {		
					userinfocheck();
					
				}else if(sel.equals("2")){	
					withdrawclub();
					
				}else if(sel.equalsIgnoreCase("B")){									
					mypage();
					
				}else {
					System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
					
				}
			}
			
		}
	
	/**
	 * 어트랙션 예매 정보, 조회 및 취소를 할 수 있다.
	 * @throws Exception 
	 */
		public static String attractionName;
		public static void attractionreserveinfo() throws Exception {
		
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t[예약 어트랙션]");
			System.out.println("\t\t\t\t\t================================================================================================");
		
			if(!nowuserattraction.isEmpty()) {
			System.out.println("\t\t\t\t\t\t\t\t[번호]      [날짜]      [시간]  [놀이기구]  [예약 인원]");			
			for (int i=0; i<nowuserattraction.size(); i++) {
				String seq = nowuserattraction.get(i).getAttractionNum();
				attraction.stream()
						  .filter(a -> seq.equals(a.getSeq()))
						  .forEach(a -> attractionName = a.getName());
				System.out.printf("\t\t\t\t\t\t\t\t  %d       %s    %s:00      %s           %s\r\n"
														  , i+1
														  ,	nowuserattraction.get(i).getDate().substring(0,4) + "-" + 
															nowuserattraction.get(i).getDate().substring(4,6) + "-" + 
														    nowuserattraction.get(i).getDate().substring(6,8)
														  ,	nowuserattraction.get(i).getHour()
														  ,	attractionName
														  ,	nowuserattraction.get(i).getCount());
				
			}
		
			System.out.println();
			
			System.out.println("\t\t\t\t\t\t\t\t\t\t1. 예약 취소");
			System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로 가기");
			
			System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
			String input = scan.nextLine();
			if(input.equals("1")) {
				
				System.out.println("\t\t\t\t\t================================================================================================");
				System.out.println("\t\t\t\t\t\t\t\t\t\t[예약 어트랙션]");
				System.out.println("\t\t\t\t\t================================================================================================");
				System.out.println("\t\t\t\t\t\t\t\t[번호]      [날짜]      [시간]  [놀이기구]  [예약 인원]");			
				for (int i=0; i<nowuserattraction.size(); i++) {

					System.out.printf("\t\t\t\t\t\t\t\t  %d       %s    %s:00      %s           %s\r\n"
															  , i+1
															  ,	nowuserattraction.get(i).getDate().substring(0,4) + "-" + 
																nowuserattraction.get(i).getDate().substring(4,6) + "-" + 
															    nowuserattraction.get(i).getDate().substring(6,8)
															  ,	nowuserattraction.get(i).getHour()
															  ,	nowuserattraction.get(i).getAttractionNum()
															  ,	nowuserattraction.get(i).getCount());
					
				}	
				System.out.println();
				System.out.println("\t\t\t\t\t\t\t\t\t취소할 예약 번호를 입력해주세요.");
				System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
				String input2 = scan.nextLine();
				
				int a = Integer.parseInt(input2);
				
				if (a <= nowuserattraction.size()) {
					
					String seq = nowuserattraction.get(a-1).getSeq();
		             userattractionreservationdelete(seq);
		            
					System.out.println("\t\t\t\t\t\t\t\t\t예약이 취소되었습니다.");
					userpage();
				} else {
					System.out.println("\t\t\t\t\t\t\t\t\t올바른 번호가 아닙니다.");
					attractionreserveinfo();
				}
				
			} else if (input.equalsIgnoreCase("B")) {
				userpage();
			} else {
				System.out.println("\t\t\t\t\t\t\t\t\t올바른 값을 입력해주세요.");
				attractionreserveinfo();
			}
				
		} else {
			System.out.println("\t\t\t\t\t\t\t\t\t어트랙션 예약 정보가 없습니다.");
			
			System.out.println("\t\t\t\t\t\t\t\t\t엔터를 누르면 My Page 화면으로 돌아갑니다.");			
			scan.nextLine();
			mypage();
		}
		
	}
	
	/**
	 * 티켓 예매정보, 조회 및 취소를 할 수 있다.
	 * @throws Exception
	 */
		public static void ticketreserveinfo() throws Exception {
		
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t[예매 티켓]");
			System.out.println("\t\t\t\t\t================================================================================================");
		
		if(!nowuserticket.isEmpty()) {
			
			System.out.println("\t\t\t\t\t\t\t[번호]\t\t  [날짜]\t\t  [매수]\t\t[금액]");
			for (int i=0; i<nowuserticket.size(); i++) {
				System.out.printf("\t\t\t\t\t\t\t%3d\t\t%s\t성인 %s매/청소년 %s매/유아 %s매\t%,d\r\n"
														  , i+1
														  ,	nowuserticket.get(i).getDate().substring(0,4) + "-" + 
															nowuserticket.get(i).getDate().substring(4,6) + "-" + 
														    nowuserticket.get(i).getDate().substring(6,8)
														  ,	nowuserticket.get(i).getAdultCount()
														  ,	nowuserticket.get(i).getYouthCount()
														  ,	nowuserticket.get(i).getKidCount()
														  ,	Integer.parseInt(nowuserticket.get(i).getPrice()));
				
			}
		
			System.out.println();
			
			System.out.println("\t\t\t\t\t\t\t\t\t\t1. 예매 취소");
			System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로 가기");
			System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
			
			String input = scan.nextLine();
			if(input.equals("1")) {
				
				System.out.println("\t\t\t\t\t================================================================================================");
				System.out.println("\t\t\t\t\t\t\t\t\t\t[예매 티켓]");
				System.out.println("\t\t\t\t\t================================================================================================");
				
				System.out.println("\t\t\t\t\t\t\t[번호]\t\t  [날짜]\t\t  [매수]\t\t[금액]");
				for (int i=0; i<nowuserticket.size(); i++) {
					System.out.printf("\t\t\t\t\t\t\t%3d\t\t%s\t성인 %s매/청소년 %s매/유아 %s매\t%,d\r\n"
															  , i+1
															  ,	nowuserticket.get(i).getDate().substring(0,4) + "-" + 
																nowuserticket.get(i).getDate().substring(4,6) + "-" + 
															    nowuserticket.get(i).getDate().substring(6,8)
															  ,	nowuserticket.get(i).getAdultCount()
															  ,	nowuserticket.get(i).getYouthCount()
															  ,	nowuserticket.get(i).getKidCount()
															  ,	Integer.parseInt(nowuserticket.get(i).getPrice()));
					
				}
				System.out.println();
				System.out.println("\t\t\t\t\t\t\t\t\t취소할 티켓 번호를 입력해주세요.");
				System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
				String input2 = scan.nextLine();
				int a = Integer.parseInt(input2);
				
				if (a <= nowuserticket.size() && a > 0) {
		               String seq = nowuserticket.get(a-1).getSeq();
		               userticketreservationdelete(seq);
		               System.out.println("\t\t\t\t\t\t\t\t\t예매가 취소되었습니다.");
		               userpage();
		            } else {
		               System.out.println("\t\t\t\t\t\t\t\t\t올바른 번호가 아닙니다.");
		               ticketreserveinfo();
		            }
				
			} else if (input.equalsIgnoreCase("B")) {
				userpage();
			} else {
				System.out.println("\t\t\t\t\t\t\t\t\t올바른 값을 입력해주세요.");
				ticketreserveinfo();
			}
				
		} else {
			System.out.println("\t\t\t\t\t\t\t\t\t티켓 예매 정보가 없습니다.");
			
			System.out.println("\t\t\t\t\t\t\t\t\t엔터를 누르면 My Page 화면으로 돌아갑니다.");			
			scan.nextLine();
			mypage();
		}
			
		
	}
		
	/**
	 * 개인정보 조회 화면, 조회 및 수정을 할 수 있다.
	 * @throws Exception
	 */
		public static void userinfocheck() throws Exception {
		
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t[개인정보 조회]");
			System.out.println("\t\t\t\t\t================================================================================================");
				
		System.out.println();
		
		System.out.printf("\t\t\t\t\t\t\t\t\t%s 고객님의 가입 정보입니다.\r\n", nowuser.get(0).getName());
		System.out.printf("\t\t\t\t\t\t\t\t\tID : %s\r\n", nowuser.get(0).getId());
		System.out.printf("\t\t\t\t\t\t\t\t\tPW : %s\r\n", nowuser.get(0).getPw());
		System.out.printf("\t\t\t\t\t\t\t\t\t이름 : %s\r\n", nowuser.get(0).getName());
		System.out.printf("\t\t\t\t\t\t\t\t\t핸드폰 번호 : %s\r\n", nowuser.get(0).getPhoneNum().substring(0, 3) + "-" 
												+ nowuser.get(0).getPhoneNum().substring(3, 7) + "-"
												+ nowuser.get(0).getPhoneNum().substring(7, 11));																						
		System.out.printf("\t\t\t\t\t\t\t\t\t주소 : %s\r\n", nowuser.get(0).getAddress());
		
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\t\t1. PW 수정하기");
		System.out.println("\t\t\t\t\t\t\t\t\t\t2. 핸드폰번호 수정하기");
		System.out.println("\t\t\t\t\t\t\t\t\t\tB. 뒤로가기");
		
		boolean loop = true;
		while(loop) {

			System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				pwfix();
				
			}else if(sel.equals("2")){	
				phonenumfix();
				
			}else if(sel.equalsIgnoreCase("B")){									
				userinfo();
				
			}else {
				System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
				
			}
		}
		
	}
		
	/**
	 * 비밀번호 수정 화면
	 * @throws Exception
	 */
		public static void pwfix() throws Exception {
		
		final String pattern = "^[A-Za-z[0-9]]{4,12}$"; // 영문, 숫자

		
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[비밀번호 수정]");
		System.out.println("\t\t\t\t\t================================================================================================");
		
		System.out.println("\t\t\t\t\t\t\t\t새로운 PW(4~12자리 영문 또는 숫자 조합)를 입력해 주세요.");
		System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
		String input = scan.nextLine();
		
		boolean match = Pattern.matches(pattern,input);
		
		if(match == true) {
			
			System.out.println("\t\t\t\t\t\t\t\t(비밀번호 재 확인) 입력하신 비밀번호를 다시 입력해주세요.");
			System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
			String input2 = scan.nextLine();
			if(input.equals(input2)) {
				System.out.println("\t\t\t\t\t\t\t\t\t비밀번호 변경이 완료되었습니다.");
				nowuser.get(0).setPw(input2);
				Save.saveUser(list);
				userinfocheck();
			} else {
				System.out.println("\t\t\t\t\t\t\t\t비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
				pwfix();
			}
			
		} else if (input.equalsIgnoreCase("B")) {
			userinfocheck();
		} else {
			System.out.println("\t\t\t\t\t\t\t\t4~12자리 영문 또는 숫자 조합을 입력해 주세요.");
			pwfix();
		}
		
	}
	
	/**
	 * 핸드폰번호 수정 화면
	 * @throws Exception
	 */
		public static void phonenumfix() throws Exception {
		
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t[핸드폰번호 수정]");
			System.out.println("\t\t\t\t\t================================================================================================");
		
		final String pattern = "^[0-9]{11}$"; // 영문, 숫자
		
		System.out.println("\t\t\t\t\t\t\t\t\t수정하실 핸드폰번호('-' 없이 11자리 숫자)를 입력해주세요.");
		System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
		String input = scan.nextLine();
		boolean match = Pattern.matches(pattern,input);
		
		if(match == true) {
			System.out.println("\t\t\t\t\t\t\t\t\t핸드폰번호 수정이 완료되었습니다.");
			nowuser.get(0).setPhoneNum(input);
			Save.saveUser(list);
			userinfocheck();
		} else {
			System.out.println("\t\t\t\t\t\t\t\t\t잘못된 입력입니다. 다시 시도해주세요.");
			phonenumfix();
			
		}
		
		
	}
	
	/**
	 * 회원 탈퇴 화면
	 * @throws Exception
	 */
		public static void withdrawclub() throws Exception {
		
			System.out.println("\t\t\t\t\t================================================================================================");
			System.out.println("\t\t\t\t\t\t\t\t\t\t[회원 탈퇴]");
			System.out.println("\t\t\t\t\t================================================================================================");
		
				System.out.println("\t\t\t\t\t\t\t\t\t회원 탈퇴를 진행합니다.");
				System.out.println("\t\t\t\t\t\t\t\t\t회원 비밀번호를 입력해주세요.");
				System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
				String input = scan.nextLine();
				
				System.out.print("");
		
				if (input.equals(nowuser.get(0).getPw())) {
						System.out.println("\t\t\t\t\t\t\t\t\t회원 탈퇴시에는 사용자의 모든 정보가 삭제됩니다.");
						System.out.println("\t\t\t\t\t\t\t\t\t정말로 탈퇴에 동의하시겠습니까? (Y/N)");
						System.out.print("\t\t\t\t\t\t\t\t\t👉 ");
						String input2 = scan.nextLine();
						System.out.print("");
					
					if (input2.equalsIgnoreCase("Y")) {
							userdelete();
							System.out.println("\t\t\t\t\t\t\t\t\t회원 탈퇴가 정상적으로 처리되었습니다. 이용해 주셔서 감사합니다.");
							System.out.println("\t\t\t\t\t\t\t\t\t엔터를 누르면 로그인 창으로 이동합니다.");
							scan.nextLine();
							login.login();
					} else if (input2.equalsIgnoreCase("N")) {
							System.out.println("\t\t\t\t\t\t\t\t\t회원 탈퇴에 동의하지 않으셨습니다.");
							System.out.println("\t\t\t\t\t\t\t\t\t엔터를 누르면 개인정보 확인 창으로 이동합니다.");			
							scan.nextLine();
							userinfo();
					} else {
						System.out.println("\t\t\t\t\t\t\t\t\t비밀번호가 일치하지 않습니다.");
						System.out.println("\t\t\t\t\t\t\t\t\t엔터를 누르면 개인정보 확인 창으로 이동합니다.");			
						scan.nextLine();
			
						userinfo();
					}
		
					} else {
						System.out.println("\t\t\t\t\t\t\t\t\t비밀번호가 일치하지 않습니다.");
						System.out.println("\t\t\t\t\t\t\t\t\t엔터를 누르면 개인정보 확인 창으로 이동합니다.");			
						scan.nextLine();
			
						userinfo();
					}
		
		}
		
		/**
		 * 회원 탈퇴, 현재 회원의 정보를 삭제합니다.
		 * @throws Exception
		 */		
		public static void userdelete() throws Exception {
			
			BufferedReader reader = new BufferedReader(new FileReader(Path.user));
			
			String txt = "";
			String line = null;
			
			while ((line = reader.readLine()) != null){
				
				if (!nowuser.get(0).getSeq().equals(line.split("■")[0])) {
					txt += line + "\r\n";					
				}
			}
			
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.user));
			
			writer.write(txt);
			
			writer.close();
			
			

		}
		
		/**
		 * 유저가 예매한 티켓을 취소하는 기능
		 * @param seq
		 * @throws Exception
		 */
		
		public static void userticketreservationdelete(String seq) throws Exception {
			
			BufferedReader reader = new BufferedReader(new FileReader(Path.ticketReservation));
			
			String txt = "";
			String line = null;
			
			while ((line = reader.readLine()) != null){
	            
	            if (!(nowuser.get(0).getSeq().equals(line.split("■")[7])
	                  &&seq.equals(line.split("■")[0]) )) {
	               txt += line + "\r\n";               
	            }
	         }
			
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.ticketReservation));
			
			writer.write(txt);
			
			writer.close();

		}
		
		/**
		 * 유저가 예약한 어트랙션을 취소하는 기능
		 * @param seq
		 * @throws Exception
		 */
		public static void userattractionreservationdelete(String seq) throws Exception {
			
			BufferedReader reader = new BufferedReader(new FileReader(Path.attractionReservation));
			
			String txt = "";
			String line = null;
			
			while ((line = reader.readLine()) != null){
				
	            if (!(nowuser.get(0).getSeq().equals(line.split("■")[5])
		                  &&seq.equals(line.split("■")[0]) )) {
		               txt += line + "\r\n";               
		            }
			}
			
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.attractionReservation));
			
			writer.write(txt);
			
			writer.close();
			
			Save.saveUser(list);

		}
		
		/**
		 * 오늘 날짜를 반환하는 메소드
		 * @param isToday
		 * @throws Exception
		 */
		public static boolean isToday(String date) {
			Calendar now = Calendar.getInstance();
			boolean today = true;
			
			if(!date.substring(0, 4).equals(now.get(Calendar.YEAR) + "")) today = false;
			if(!date.substring(4, 6).equals(now.get(Calendar.MONTH) + 1 +"")) today = false;
			if(!date.substring(6, 8).equals(now.get(Calendar.DATE) < 10 ? "0"+now.get(Calendar.DATE) : now.get(Calendar.DATE)+""))
				today = false;
			
			return today;
		}
		
		
	}//UserPage
