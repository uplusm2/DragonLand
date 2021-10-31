package user;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import com.project.data.*;
import com.project.main.Load;


public class UserPage {

		private static Scanner scan;
		private static ArrayList<User> list;
		private static ArrayList<User> nowuser;
		
		static {
			scan = new Scanner(System.in);
		}
		
	public static void main(String[] args) throws Exception {
		
		System.out.println("=======================");
		System.out.println("	[회원 메뉴]");
		System.out.println("=======================");
			
		list = Load.loadUser();
			
		nowuser = new ArrayList<User>();
			
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals("aglb2907")) {
				nowuser.add(list.get(i));
			}
		}
			
		System.out.println(list);		
			
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
				
			}else {
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

private static void ticketreserveinfo() {
	
	System.out.println("=======================");
	System.out.println("	[예매 티켓]");
	System.out.println("=======================");
	
	if(예매 목록이 있으면) {
		//예매 목록을 날짜순으로 출력
		
		System.out.println("1. 예매 취소");
		System.out.println("B. 뒤로 가기");
		
		String input = scan.nextLine();
		if(input.equals("1")) {
			
			System.out.println("=======================");
			System.out.println("	[예매 티켓]");
			System.out.println("=======================");
			
			//예매 목록 출력 해야함
			System.out.println("취소할 티켓 번호를 입력해주세요.");
			String input2 = scan.nextLine();
			
			if (input2.equals(예매 목록 번호)) {
				//취소시켜야됨
			}
			
		} else if (input.equals("B") || input.equals("b")) {
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
	
	
	// User 데이터를 끌어와서 작성해야함
	System.out.printf("%s 고객님의 가입 정보입니다.\r\n", nowuser.get(0).getName());
	System.out.printf("ID : %s\r\n", nowuser.get(0).getId());
	System.out.printf("PW : %s\r\n", nowuser.get(0).getPw());
	System.out.printf("이름 : %s\r\n", nowuser.get(0).getName());
	System.out.printf("핸드폰 번호 : %s\r\n", nowuser.get(0).getPhoneNum());
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
			
		}else if(sel.equals("B")||sel.equals("b")){									
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
			//실제 data에 추가해야 함
			userinfocheck();
		} else {
			System.out.println("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
			pwfix();			
		}
		
	} else if (input.equals("B") || input.equals("b")) {
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
		//실제 회원정보 수정 필요
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
				if (input2.equals("Y") || input2.equals("y")) {
						//탈퇴처리해야함
						System.out.println("회원 탈퇴가 정상적으로 처리되었습니다. 이용해 주셔서 감사합니다.");
						//메인화면으로 이동해야함
				} else if (input2.equals("N") || input2.equals("n")) {
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
	
	}
	
	}
	
}//UserPage

