package com.project.main;

import java.io.*;
import java.util.*;

import com.project.admin.*;
import com.project.data.*;
import com.project.findUser.*;
import com.project.join.*;
import com.project.landinfo.*;
import com.project.login.*;

/**
 * Main 클래스입니다.
 * @author 
 */
public class Main {
	private static int total;
	
	private static Scanner scan;
	private static Calendar c;
	private static ArrayList<TicketReservation> list;
	
	private static LoginAdmin lg;
	private static LandInfo landinfo;
	
	static {
		scan = new Scanner(System.in);
		c = Calendar.getInstance();
		lg=new LoginAdmin();
		landinfo = new LandInfo();
	}
	
	/**
	 * 메뉴를 반복합니다.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		
		
		System.out.printf(
				"                                   .''.       \r\n"
				+ "       .''.      .        *''*    :_\\/_:     . \r\n"
				+ "      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\r\n"
				+ "  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\r\n"
				+ " :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\r\n"
				+ " : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\r\n"
				+ "  '..'  ':::'     * /\\ *     .'/.\\'.   '\r\n"
				+ "      *            *..*         :\r\n"
				+ "jgs     *\r\n"
				+ "        *"
				);
		
		System.out.printf(
				"                           o                    \r\n"
				+ "                       _---|         _ _ _ _ _ \r\n"
				+ "                    o   ---|     o   ]-I-I-I-[ \r\n"
				+ "   _ _ _ _ _ _  _---|      | _---|    \\ ` ' / \r\n"
				+ "   ]-I-I-I-I-[   ---|      |  ---|    |.   | \r\n"
				+ "    \\ `   '_/       |     / \\    |    | /^\\| \r\n"
				+ "     [*]  __|       ^    / ^ \\   ^    | |*|| \r\n"
				+ "     |__   ,|      / \\  /    `\\ / \\   | ===| \r\n"
				+ "  ___| ___ ,|__   /    /=_=_=_=\\   \\  |,  _|\r\n"
				+ "  I_I__I_I__I_I  (====(_________)___|_|____|____\r\n"
				+ "  \\-\\--|-|--/-/  |     I  [ ]__I I_I__|____I_I_| \r\n"
				+ "   |[]      '|   | []  |`__  . [  \\-\\--|-|--/-/  \r\n"
				+ "   |.   | |' |___|_____I___|___I___|---------| \r\n"
				+ "  / \\| []   .|_|-|_|-|-|_|-|_|-|_|-| []   [] | \r\n"
				+ " <===>  |   .|-=-=-=-=-=-=-=-=-=-=-|   |    / \\  \r\n"
				+ " ] []|`   [] ||.|.|.|.|.|.|.|.|.|.||-      <===> \r\n"
				+ " ] []| ` |   |/////////\\\\\\\\\\\\\\\\\\\\.||__.  | |[] [ \r\n"
				+ " <===>     ' ||||| |   |   | ||||.||  []   <===>\r\n"
				+ "  \\T/  | |-- ||||| | O | O | ||||.|| . |'   \\T/ \r\n"
				+ "   |      . _||||| |   |   | ||||.|| |     | |\r\n"
				+ "../|' v . | .|||||/____|____\\|||| /|. . | . ./\r\n"
				+ ".|//\\............/...........\\........../../\\\\\\\n"
				);
		
		
		try {
			//System.out.println("\t\t\t\t\t\t\t\t\t\tDragon Land"); //임시
			//System.out.println("\t\t\t\t\t================================================================================================");
			
			//System.out.println("\t\t\t\t\t================================================================================================");
			boolean loop = true;
			while(loop) {
				total = 0;
				System.out.printf("\t\t\t\t\t\t\t\t\t🎈오늘 용용랜드는 %s합니다.🎈%n%n", getState());
				menu();
				System.out.print("\t\t\t\t\t\t\t\t\t\t👉 ");
				String sel = scan.nextLine();
				System.out.println();
				
				if(sel.equals("1")) {		
					//LandInfo.menu();
					landinfo.menu();
				}else if(sel.equals("2")){	
					login.login();
				}else if(sel.equals("3")){	
					join.Join();
				}else if(sel.equals("4")){	
					FindUser.findeUser();
				}else if(sel.equals("5")){	
					System.out.println("\t\t\t\t\t\t\t\t\t\t안녕히가세요~~ 다음에 또 놀러오세요~!");
					break;
				}else {
					System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
					pause();
				}
			}
		} catch (Exception e) {
			main(args);
			//e.printStackTrace();
			//System.out.println("\t\t\t\t\t\t\t\t\t잘못된 입력입니다.");
		}
	}

	/**
	 * 놀이공원의 밀집도를 문자열로 반환합니다.
	 * @return
	 */
	public static String getState() throws Exception{
		String today = String.format("%tF", c).replace("-", "");
		
		list = Load.loadTicketReservation();
		list.stream()
			.filter(r -> r.getDate().equals(today))
			.forEach(r -> total += Integer.parseInt(r.getAdultCount())
									+ Integer.parseInt(r.getYouthCount())
									+ Integer.parseInt(r.getKidCount()));
		
			return total < 500 ? "쾌적" : "혼잡";
	}

	/**
	 * 메뉴를 출력합니다.
	 */
	private static void menu() {
		System.out.println("\t\t\t\t\t\t\t\t\t\t1. 용용랜드 정보");
		System.out.println("\t\t\t\t\t\t\t\t\t\t2. 로그인");
		System.out.println("\t\t\t\t\t\t\t\t\t\t3. 회원가입");
		System.out.println("\t\t\t\t\t\t\t\t\t\t4. ID/PW 찾기");
		System.out.println("\t\t\t\t\t\t\t\t\t\t5. 종료");
	}
	
	/**
	 * 엔터를 누르기 전까지 정지합니다.
	 */
	private static void pause() {
		System.out.println("\t\t\t\t\t\t\t\t\t(엔터를 누르면 메뉴로 이동합니다.)");
		scan.nextLine();
	}
}
