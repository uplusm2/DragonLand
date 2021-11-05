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
	private static boolean flag;
	private static String sel;
	
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
		try {
			if(!flag) ascii();
			boolean loop = true;
			
			while(loop) {
				total = 0;
				menu();
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
					System.out.println();
					ascii();
					System.out.println("\t\t\t\t\t\t\t\t\t안녕히가세요~~");
					System.out.println("\t\t\t\t\t\t\t\t\t다음에 또 놀러오세요~!");
					scan.nextLine();
					scan.nextLine();
					scan.nextLine();
					loop=false;
				}else {
					System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
					pause();
				}
			}
		} catch (Exception e) {
			main(args);
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
	 * 엔터를 누르기 전까지 정지합니다.
	 */
	private static void pause() {
		System.out.println("\t\t\t\t\t\t\t\t\t(엔터를 누르면 메뉴로 이동합니다.)");
		scan.nextLine();
	}
	
	/**
	 * 메뉴를 출력합니다.
	 * @throws Exception 
	 */
	private static void menu() throws Exception {
		System.out.printf("%n\t\t\t\t\t\t      ,                          (`-.                                        \r\n"
							+ "\t\t\t\t\t\t                                  \\  `                                       \r\n"
							+ "\t\t\t\t\t\t     /)         ,   '--.           \\    `                                    \r\n"
							+ "\t\t\t\t\t\t    //     , '          \\/          \\   `   `                                \r\n"
							+ "\t\t\t\t\t\t   //    ,'              ./         /\\    \\>- `   ,----------.               \r\n"
							+ "\t\t\t\t\t\t  ( \\  ,'    .-.-._        /      ,' /\\    \\   . `            `.             \r\n"
							+ "\t\t\t\t\t\t   \\ \\'     /.--. .)       ./   ,'  /  \\     .      `           `.           \r\n"
							+ "\t\t\t\t\t\t    \\     -{/    \\ .)        / /   / ,' \\       `     `-----.     \\          \r\n"
							+ "\t\t\t\t\t\t    <\\      )     ).:)       ./   /,' ,' \\        `.  /\\)    `.    \\         \r\n"
							+ "\t\t\t\t\t\t     >^,  //     /..:)       /   //--'    \\         `(         )    )        \r\n"
							+ "\t\t\t\t\t\t      | ,'/     /. .:)      /   (/         \\          \\       /    /         \r\n"
							+ "\t\t\t\t\t\t      ( |(_    (...::)     (                \\       .-.\\     /   ,'          \r\n"
							+ "\t\t\t\t\t\t      (O| /     \\:.::)                      /\\    ,'   \\)   /  ,'            \r\n"
							+ "\t\t\t\t\t\t       \\|/      /`.:::)                   ,/  \\  /         (  /              \r\n"
							+ "\t\t\t\t\t\t               /  /`,.:)                ,'/    )/           \\ \\              \r\n"
							+ "\t\t\t\t\t\t             ,' ,'.'  `:>-._._________,<;'    (/            (,'              \r\n"
							+ "\t\t\t\t\t\t           ,'  /  |     `^-^--^--^-^-^-'                                     \r\n"
							+ "\t\t\t\t\t\t .--------'   /   |                                                          \r\n"
							+ "\t\t\t\t\t\t(       .----'    |                                                          \r\n");
				System.out.printf("\t\t\t\t\t\t \\ <`.  \\         |         🎈오늘 용용랜드는 %s합니다.🎈     \r\n", getState());
				System.out.print("\t\t\t\t\t\t  \\ \\ `. \\        |                    \r\n"
									+ "\t\t\t\t\t\t   \\ \\  `.`.      |          \t1. 용용랜드 정보                                                \r\n"
									+ "\t\t\t\t\t\t    \\ \\   `.`.    |          \t2. 로그인  \r\n"
									+  "\t\t\t\t\t\t     \\ \\    `.`.  |         \t3. 회원가입                                                \r\n"
									+ "\t\t\t\t\t\t      \\ \\     `.`.|          \t4. ID/PW 찾기                                                    \r\n"
									+ "\t\t\t\t\t\t       \\ \\      `.`.         \t5. 종료                                                \r\n"
									+ "\t\t\t\t\t\t        \\ \\     ,^-'         \t👉 ");
				sel = scan.nextLine();
				System.out.println("\t\t\t\t\t\t         \\ \\    |                                                            \r\n"
									+ "\t\t\t\t\t\t          `.`.  |                                                       \r\n"
									+ "\t\t\t\t\t\t             .`.|>                                                            \r\n"
									+ "\t\t\t\t\t\t              `._>");
	}
	
	private static void ascii() throws Exception {
		System.out.printf("\t\t\t\t\t\t\t                                   .''.       \r\n"
							+ "\t\t\t\t\t\t\t       .''.      .        *''*    :_\\/_:     . \r\n"
							+ "\t\t\t\t\t\t\t      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\r\n"
							+ "\t\t\t\t\t\t\t  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\r\n"
							+ "\t\t\t\t\t\t\t :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\r\n"
							+ "\t\t\t\t\t\t\t : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\r\n"
							+ "\t\t\t\t\t\t\t  '..'  ':::'     * /\\ *     .'/.\\'.   '\r\n"
							+ "\t\t\t\t\t\t\t      *            *..*         :\r\n"
							+ "\t\t\t\t\t\t\t\t     *\r\n"
							+ "\t\t\t\t\t\t\t        *\r\n"
				);
		
		System.out.printf("\t\t\t\t\t\t\t                           o                    \r\n"
							+ "\t\t\t\t\t\t\t                       _---|         _ _ _ _ _ \r\n"
							+ "\t\t\t\t\t\t\t                    o   ---|     o   ]-I-I-I-[ \r\n"
							+ "\t\t\t\t\t\t\t   _ _ _ _ _ _  _---|      | _---|    \\ ` ' / \r\n"
							+ "\t\t\t\t\t\t\t   ]-I-I-I-I-[   ---|      |  ---|    |.   | \r\n"
							+ "\t\t\t\t\t\t\t    \\ `   '_/       |     / \\    |    | /^\\| \r\n"
							+ "\t\t\t\t\t\t\t     [*]  __|       ^    / ^ \\   ^    | |*|| \r\n"
							+ "\t\t\t\t\t\t\t     |__   ,|      / \\  /    `\\ / \\   | ===| \r\n"
							+ "\t\t\t\t\t\t\t  ___| ___ ,|__   /    /=_=_=_=\\   \\  |,  _|\r\n"
							+ "\t\t\t\t\t\t\t  I_I__I_I__I_I  (====(_________)___|_|____|____\r\n"
							+ "\t\t\t\t\t\t\t  \\-\\--|-|--/-/  |     I  [ ]__I I_I__|____I_I_| \r\n"
							+ "\t\t\t\t\t\t\t   |[]      '|   | []  |`__  . [  \\-\\--|-|--/-/  \r\n"
							+ "\t\t\t\t\t\t\t   |.   | |' |___|_____I___|___I___|---------| \r\n"
							+ "\t\t\t\t\t\t\t  / \\| []   .|_|-|_|-|-|_|-|_|-|_|-| []   [] | \r\n"
							+ "\t\t\t\t\t\t\t <===>  |   .|-=-=-=-=-=-=-=-=-=-=-|   |    / \\  \r\n"
							+ "\t\t\t\t\t\t\t ] []|`   [] ||.|.|.|.|.|.|.|.|.|.||-      <===> \r\n"
							+ "\t\t\t\t\t\t\t ] []| ` |   |/////////\\\\\\\\\\\\\\\\\\\\.||__.  | |[] [ \r\n"
							+ "\t\t\t\t\t\t\t <===>     ' ||||| |   |   | ||||.||  []   <===>\r\n"
							+ "\t\t\t\t\t\t\t  \\T/  | |-- ||||| | O | O | ||||.|| . |'   \\T/ \r\n"
							+ "\t\t\t\t\t\t\t   |      . _||||| |   |   | ||||.|| |     | |\r\n"
							+ "\t\t\t\t\t\t\t../|' v . | .|||||/____|____\\|||| /|. . | . ./\r\n"
							+ "\t\t\t\t\t\t\t.|//\\............/...........\\........../../\\\\\\\n"
							);
		
		System.out.println("\t\t\t\t\t\t______                                        _                        _ \r\n"
							+ "\t\t\t\t\t\t|  _  \\                                      | |                      | |\r\n"
							+ "\t\t\t\t\t\t| | | | _ __   __ _   __ _   ___   _ __      | |      __ _  _ __    __| |\r\n"
							+ "\t\t\t\t\t\t| | | || '__| / _` | / _` | / _ \\ | '_ \\     | |     / _` || '_ \\  / _` |\r\n"
							+ "\t\t\t\t\t\t| |/ / | |   | (_| || (_| || (_) || | | |    | |____| (_| || | | || (_| |\r\n"
							+ "\t\t\t\t\t\t|___/  |_|    \\__,_| \\__, | \\___/ |_| |_|    \\_____/ \\__,_||_| |_| \\__,_|\r\n"
							+ "\t\t\t\t\t\t                      __/ |                                              \r\n"
							+ "\t\t\t\t\t\t                     |___/                                 ");
		
		scan.nextLine();
		flag = true;
	}
	
}
