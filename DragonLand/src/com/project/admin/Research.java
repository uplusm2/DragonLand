package com.project.admin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import com.project.data.Attraction;
import com.project.data.Path;
import com.project.data.UserVoice;
import com.project.main.Load;

/**
 * 설문조사 클래스 입니다.
 * @author 김재형
 *
 */
public class Research {
	
	private static AdminMenu adminmenu;
	private static int startRanking;
	private static int endRanking;
	private static int startVoice;
	private static int endVoice;
	private static ArrayList<Attraction> list;
	private static ArrayList<UserVoice> list2;
	private static Scanner scan;
	private static int num;
	
	static {
		adminmenu = new AdminMenu();
		startRanking =0;
		endRanking=10;
		startVoice=0;
		endVoice=10;
		list = new ArrayList<Attraction>();
		scan = new Scanner(System.in);
		num=1;
		
	}
	
	/**
	 * 메인 메소드
	 * 1.이달의 어트랙션
	 * 2.고객의소리
	 * @throws Exception
	 */
	public static void menu() throws Exception {
		System.out.println("1. 이달의 어트랙션 순위");
		System.out.println("2. 고객의 소리");
		System.out.println("B. 뒤로가기");
		System.out.println("👉");
		
		String input = scan.nextLine();
		if(input.equals("1")) {
			BufferedReader reader = new BufferedReader(new FileReader(Path.attraction));
			
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] tmp = line.split("■");
				Attraction ayy = new Attraction();
				ayy.setVote(tmp[7]);
				ayy.setName(tmp[1]);
				list.add(ayy);
			}
			reader.close();
			
			list.sort(new Comparator<Attraction>() {
				
				@Override
				public int compare(Attraction o1, Attraction o2) {
				
					return Integer.parseInt(o2.getVote())-Integer.parseInt(o1.getVote());
				}
			});
			ranking(list);
		}else if (input.equals("2")){
			voice();
		}else if (input.equals("B")||input.equals("b")) {
			adminmenu.statistic();
		}else {
			System.out.println("알맞은 키를 눌러주세요");
			menu();
		}
	
	}
	
	/**
	 * 고객의 소리를 보여줍니다.
	 * @throws Exception
	 */
	public static void voice() throws Exception {
		
		System.out.println("============================");
		System.out.println("      [고객의 소리]");
		System.out.println("============================");
		
		for(int i=startVoice;i<endVoice;i++) {
			list2 = Load.loadUserVoice();
			
			System.out.printf("%d. [%s/%s/%s] %s\n",i+1,list2.get(i).getDate().substring(2, 4),list2.get(i).getDate().substring(4,6)
					,list2.get(i).getDate().substring(6),list2.get(i).getContent());
			
		}
		
		System.out.printf("          %d/1000\n",num);
		System.out.println("<.이전 페이지   다음 페이지.>");
		System.out.println("B.뒤로가기");
		System.out.print("👉");
		String index = scan.nextLine();
		if(index.equals(">")){
			startVoice+=10;
			endVoice+=10;
			num++;
			voice();
		}else if(index.equals("<")) {
			if(startVoice>=10) {
				startVoice-=10;
				endVoice-=10;
				num--;
				voice();
			}else {
				System.out.println("뒤로 갈곳이 없습니다.");
				voice();
			}
				
		}else if(index.equals("b")||index.equals("B")) {
			menu();
			
		}else {
			System.out.println("다시 입력해주세요.");
			voice();
		}
		
		
		
	}
	/**
	 * 어트랙션 순위를 나타냅니다.
	 * @param list2
	 * @throws Exception
	 */
	public static void ranking(ArrayList<Attraction> list2) throws Exception {
		System.out.println("============================");
		System.out.println("   [이달의 어트랙션 순위]");
		System.out.println("============================");
		
				
		
		
		
		
		
		
		for(int i=startRanking;i<endRanking;i++) {
						
			System.out.printf("%d. %s %s표\n",i+1,list2.get(i).getName(),list2.get(i).getVote());

		}
		
		System.out.printf("          %d/%d\n",num,list2.size());
		System.out.println("<.이전 페이지   다음 페이지.>");
		System.out.println("B.뒤로가기");
		System.out.print("👉");
		String index = scan.nextLine();
		
		
		if(index.equals(">")){
			startRanking+=10;
			endRanking+=10;
			num++;
			ranking(list2);
		}else if(index.equals("<")) {
			if(startRanking>=10) {
				startRanking-=10;
				endRanking-=10;
				num--;
				ranking(list2);
			}else {
				System.out.println("뒤로 갈곳이 없습니다.");
				ranking(list2);
			}
				
		}else if(index.equals("b")||index.equals("B")) {
			menu();
			
		}else {
			System.out.println("제대로 된 키를 입력해주세요.");
			
		}
		
	}



	
	
}
