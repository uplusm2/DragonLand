	package com.test.user;

	import java.io.*;

	import java.util.*;
	import java.util.regex.Pattern;

	import com.project.data.*;
	import com.project.main.Load;


	public class UserPage {

			private static Scanner scan;
			private static ArrayList<User> list;
			private static ArrayList<User> nowuser;
			private static ArrayList<TicketReservation> ticketr;
			private static ArrayList<TicketReservation> nowuserticket;
			
			static {
				scan = new Scanner(System.in);
			}
			
		public static void main(String[] args) throws Exception {
			
			System.out.println("=======================");
			System.out.println("	[회원 메뉴]");
			System.out.println("=======================");
				
			list = Load.loadUser();
			ticketr = Load.loadTicketReservation();
			nowuser = new ArrayList<User>();
			nowuserticket = new ArrayList<TicketReservation>();
				
			//로그인한 유저의 정보를 nowuser 배열에 저장
			for (int i=0; i<list.size(); i++) {
				if (list.get(i).getId().equals("xkid5841")) {
					nowuser.add(list.get(i));
				}
			}		
			
			//로그인한 유저의 티켓정보를 nowuserticket 배열에 저장
			for (int i=0; i<ticketr.size(); i++) {
				if (ticketr.get(i).getUserNum().equals(nowuser.get(0).getSeq())) {
					nowuserticket.add(ticketr.get(i));
				}
			}
			
			for (int i=0; i<ticketr.size(); i++) {
				if (ticketr.get(i).getUserNum().equals(nowuser.get(0).getSeq())) {
					nowuserticket.add(ticketr.get(i));
				}
			}
			
			boolean loop = true;
			while(loop) {
				menu();
				System.out.print("👉 ");
				String sel = scan.nextLine();
				System.out.println();
				
				if(sel.equals("1")) {		
					mypage();
					
				}else if(sel.equals("2")){	
					ticketreservation();
					
				}else if(sel.equals("3")){	
					attractionreservation();
					
				}else if(sel.equals("4")){	
					usersurvey();
					
				}else if(sel.equals("B")||sel.equals("b")){									
					loop = false;
					
				}else{
					System.out.println("다시 입력해주세요.");
					
				}
			}
			
		}
		
		private static void menu() {
				
			System.out.printf("%s님 환영합니다!\r\n", nowuser.get(0).getName());
			System.out.println("1. My Page");
			System.out.println("2. 티켓 예매");
			System.out.println("3. 놀이기구 예약");
			System.out.println("4. 설문 조사");
			System.out.println("B. 뒤로 가기");
		}
		
		private static void usersurvey() {
			
		}

		private static void attractionreservation() {
			
		}

		private static void ticketreservation() {
			
		}
		
		private static void mypage() throws Exception {
			
			System.out.println("=======================");
			System.out.println("	[회원 메뉴]");
			System.out.println("=======================");
			
			System.out.println("1. 개인 정보 확인");
			System.out.println("2. 티켓 예매 정보 확인");
			System.out.println("3. 놀이기구 예약 정보 확인");
			System.out.println("B. 뒤로가기");
			
			boolean loop = true;
			while(loop) {

				System.out.print("👉 ");
				String sel = scan.nextLine();
				System.out.println();
				
				if(sel.equals("1")) {		
					userinfo();
					
				}else if(sel.equals("2")){	
					ticketreserveinfo();
					
				}else if(sel.equals("3")){	
					attractionreserveinfo();
					
				}else if(sel.equals("B")||sel.equals("b")){									
					loop = false;
					
				}else {
					System.out.println("다시 입력해주세요.");
					
				}
			}
			
		}
		
		private static void userinfo() throws Exception {
			
			System.out.println("=======================");
			System.out.println("	[개인정보 확인]");
			System.out.println("=======================");
			
			System.out.println("1. 개인 정보 조회 및 수정");
			System.out.println("2. 회원 탈퇴");
			System.out.println("B. 뒤로가기");
			
			boolean loop = true;
			while(loop) {

				System.out.print("👉 ");
				String sel = scan.nextLine();
				System.out.println();
				
				if(sel.equals("1")) {		
					userinfocheck();
					
				}else if(sel.equals("2")){	
					withdrawclub();
					
				}else if(sel.equals("B")||sel.equals("b")){									
					loop = false;
					
				}else {
					System.out.println("다시 입력해주세요.");
					
				}
			}
			
		}
		
	private static void attractionreserveinfo() {
		
		//해야함
		
	}
	

	private static void ticketreserveinfo() throws Exception {
		
		System.out.println("=======================");
		System.out.println("	[예매 티켓]");
		System.out.println("=======================");
		
		
		
		if(!nowuser.isEmpty()) {
			
			for (int i=0; i<nowuserticket.size(); i++) {
				System.out.println("[번호]\t[날짜]\t\t\t[매수]\t\t\t[금액]");
				System.out.printf("%d\t%s\t[성인 %s매/청소년 %s매/유아 %s매]\t%s\r\n"
														  , i+1
														  ,	nowuserticket.get(i).getDate().substring(0,4) + "-" + 
															nowuserticket.get(i).getDate().substring(4,6) + "-" + 
														    nowuserticket.get(i).getDate().substring(6,8)
														  ,	nowuserticket.get(i).getAdultCount()
														  ,	nowuserticket.get(i).getYouthCount()
														  ,	nowuserticket.get(i).getKidCount()
														  ,	nowuserticket.get(i).getPrice());
				
			}
		
			System.out.println();
			
			System.out.println("1. 예매 취소");
			System.out.println("B. 뒤로 가기");
			
			String input = scan.nextLine();
			if(input.equals("1")) {
				
				System.out.println("=======================");
				System.out.println("	[예매 티켓]");
				System.out.println("=======================");
				
				for (int i=0; i<nowuserticket.size(); i++) {
					System.out.println("[번호]\t[날짜]\t\t\t[매수]\t\t\t[금액]");
					System.out.printf("%d\t%s\t[성인 %s매/청소년 %s매/유아 %s매]\t%s\r\n"
															  , i+1
															  ,	nowuserticket.get(i).getDate().substring(0,4) + "-" + 
																nowuserticket.get(i).getDate().substring(4,6) + "-" + 
															    nowuserticket.get(i).getDate().substring(6,8)
															  ,	nowuserticket.get(i).getAdultCount()
															  ,	nowuserticket.get(i).getYouthCount()
															  ,	nowuserticket.get(i).getKidCount()
															  ,	nowuserticket.get(i).getPrice());
					
				}
					
				System.out.println("취소할 티켓 번호를 입력해주세요.");
				String input2 = scan.nextLine();
				int a = Integer.parseInt(input2);
				
				if (a <= nowuserticket.size()) {
					
					
					System.out.println("예매가 취소되었습니다.");
					userinfo();
				} else {
					System.out.println("올바른 번호가 아닙니다.");
					ticketreserveinfo();
				}
				
			} else if (input.equalsIgnoreCase("B")) {
				userinfo();
			} else {
				System.out.println("올바른 값을 입력해주세요.");
				
			}
				
		} else {
			System.out.println("티켓 예매 정보가 없습니다.");
			
			System.out.println("엔터를 누르면 My Page 화면으로 돌아갑니다.");			
			scan.nextLine();
			mypage();
		}
			
			
			
		
	}
		
	private static void userinfocheck() throws Exception {
		
		System.out.println("=======================");
		System.out.println("	[개인 정보 조회]");
		System.out.println("=======================");
				
		System.out.println();
		
		System.out.printf("%s 고객님의 가입 정보입니다.\r\n", nowuser.get(0).getName());
		System.out.printf("ID : %s\r\n", nowuser.get(0).getId());
		System.out.printf("PW : %s\r\n", nowuser.get(0).getPw());
		System.out.printf("이름 : %s\r\n", nowuser.get(0).getName());
		System.out.printf("핸드폰 번호 : %s\r\n", nowuser.get(0).getPhoneNum().substring(0, 3) + "-" 
												+ nowuser.get(0).getPhoneNum().substring(3, 7) + "-"
												+ nowuser.get(0).getPhoneNum().substring(7, 11));																						
		System.out.printf("주소 : %s\r\n", nowuser.get(0).getAddress());
		
		System.out.println();
		System.out.println("1. PW 수정하기");
		System.out.println("2. 핸드폰번호 수정하기");
		System.out.println("B. 뒤로가기");
		
		boolean loop = true;
		while(loop) {

			System.out.print("👉 ");
			String sel = scan.nextLine();
			System.out.println();
			
			if(sel.equals("1")) {		
				pwfix();
				
			}else if(sel.equals("2")){	
				phonenumfix();
				
			}else if(sel.equalsIgnoreCase("B")){									
				loop = false;
				
			}else {
				System.out.println("다시 입력해주세요.");
				
			}
		}
		
	}
		

	private static void pwfix() throws Exception {
		
		final String pattern = "^[A-Za-z[0-9]]{4,12}$"; // 영문, 숫자

		
		System.out.println("=======================");
		System.out.println("	[비밀번호 수정]");
		System.out.println("=======================");
		
		System.out.println("새로운 PW(4~12자리 영문 또는 숫자 조합)를 입력해 주세요.");
		String input = scan.nextLine();
		
		boolean match = Pattern.matches(pattern,input);
		
		if(match == true) {
			
			System.out.println("(비밀번호 재 확인) 입력하신 비밀번호를 다시 입력해주세요.");
			String input2 = scan.nextLine();
			if(input.equals(input2)) {
				System.out.println("비밀번호 변경이 완료되었습니다.");
				nowuser.get(0).setPw(input2);
				userinfocheck();
			} else {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
				pwfix();
			}
			
		} else if (input.equalsIgnoreCase("B")) {
			userinfocheck();
		} else {
			System.out.println("4~12자리 영문 또는 숫자 조합을 입력해 주세요.");
			pwfix();
		}
		
	}

	private static void phonenumfix() throws Exception {
		
		System.out.println("=======================");
		System.out.println("	[핸드폰번호 수정]");
		System.out.println("=======================");
		
		final String pattern = "^[0-9]{11}$"; // 영문, 숫자
		
		System.out.println("수정하실 핸드폰번호('-' 없이 11자리 숫자)를 입력해주세요.");
		String input = scan.nextLine();
		boolean match = Pattern.matches(pattern,input);
		
		if(match == true) {
			System.out.println("핸드폰번호 수정이 완료되었습니다.");
			nowuser.get(0).setPhoneNum(input);
			userinfocheck();
		} else {
			System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			phonenumfix();
			
		}
		
		
	}

		private static void withdrawclub() throws Exception {
		
				System.out.println("=======================");
				System.out.println("	[회원 탈퇴]");
				System.out.println("=======================");
		
				System.out.println("회원 탈퇴를 진행합니다.");
				System.out.println("회원 비밀번호를 입력해주세요.");
				String input = scan.nextLine();
		
				if (input.equals(nowuser.get(0).getPw())) {
						System.out.println("회원 탈퇴시에는 사용자의 모든 정보가 삭제됩니다.");
						System.out.println("정말로 탈퇴에 동의하시겠습니까? (Y/N)");
						String input2 = scan.nextLine();
					if (input2.equalsIgnoreCase("Y")) {
							//탈퇴처리해야함
							System.out.println("회원 탈퇴가 정상적으로 처리되었습니다. 이용해 주셔서 감사합니다.");
							System.out.println("엔터를 누르면 개인정보 확인 창으로 이동합니다.");
							scan.nextLine();
							userinfo();
					} else if (input2.equalsIgnoreCase("N")) {
							System.out.println("회원 탈퇴에 동의하지 않으셨습니다.");
							System.out.println("엔터를 누르면 개인정보 확인 창으로 이동합니다.");			
							scan.nextLine();
							userinfo();
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						System.out.println("엔터를 누르면 개인정보 확인 창으로 이동합니다.");			
						scan.nextLine();
			
						userinfo();
					}
		
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						System.out.println("엔터를 누르면 개인정보 확인 창으로 이동합니다.");			
						scan.nextLine();
			
						userinfo();
					}
		
		}
		
	}//UserPage


	

