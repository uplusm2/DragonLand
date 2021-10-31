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


public class Research {
	
	private static AdminMenu adminmenu;
	private static Load load;
	
	private static int start;
	private static int end;
	private static ArrayList<Attraction> list;
	private static UserVoice uservoice;
	private static Scanner scan;
	private static int num;
	
	static {
		adminmenu = new AdminMenu();
		load = new Load();
		start =0;
		end=10;
		list = new ArrayList<Attraction>();
		uservoice = new UserVoice();
		scan = new Scanner(System.in);
		num=1;
		
	}
	public static void menu() throws Exception {
		System.out.println("1. 이달의 어트랙션 순위");
		System.out.println("2. 고객의 소리");
		System.out.println("B. 뒤로가기");
		System.out.println("👉");
		
		Scanner scan = new Scanner(System.in);
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
			System.out.println("다시 눌러주세요");
			menu();
		}
	
	}
	
	
	private static void voice() throws Exception {
		System.out.println("============================");
		System.out.println("      [고객의 소리]");
		System.out.println("============================");
		
		for(int i=start;i<end;i++) {
			uservoice = (UserVoice) load.loadUserVoice().get(i);
				
			System.out.printf("%d. [%s/%s/%s] %s\n",i+1,uservoice.getDate().subSequence(2, 4),uservoice.getDate().substring(4,6)
					,uservoice.getDate().substring(6),uservoice.getContent());
		}
		
		System.out.printf("          %d/1000\n",num);
		System.out.println("<.이전 페이지   다음 페이지.>");
		System.out.println("B.뒤로가기");
		System.out.print("👉");
		String index = scan.nextLine();
		if(index.equals(">")){
			start+=10;
			end+=10;
			num++;
			voice();
		}else if(index.equals("<")) {
			if(start>=10) {
				start-=10;
				end-=10;
				num--;
				voice();
			}else {
				System.out.println("뒤로 갈곳이 없습니다.");
				voice();
			}
				
		}else if(index.equals("b")||index.equals("B")) {
			menu();
			
		}
		
		
		
	}
	private static void ranking(ArrayList<Attraction> list2) throws Exception {
		System.out.println("============================");
		System.out.println("   [이달의 어트랙션 순위]");
		System.out.println("============================");
		
				
		//sortList();
		
		
		
		
		
		for(int i=start;i<end;i++) {
						
			System.out.printf("%d. %s %s표\n",i+1,list2.get(i).getName(),list2.get(i).getVote());
//			if(end>list.size()) {
//				break;
//			}
		}
		
		System.out.printf("          %d/1000\n",num);
		System.out.println("<.이전 페이지   다음 페이지.>");
		System.out.println("B.뒤로가기");
		System.out.print("👉");
		String index = scan.nextLine();
		
		
		if(index.equals(">")){
			start+=10;
			end+=10;
			num++;
			ranking(list2);
		}else if(index.equals("<")) {
			if(start>=10) {
				start-=10;
				end-=10;
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
