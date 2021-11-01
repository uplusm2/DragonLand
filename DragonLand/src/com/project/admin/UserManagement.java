package com.project.admin;

import java.io.*;
import java.util.*;

import com.project.data.*;
import com.project.main.*;

/**
 * UserManagement 클래스입니다.
 * 관리자가 회원을 조회/검색/삭제합니다.
 * @author 이유미
 */
public class UserManagement {
	private static Scanner scan;
	private static int page;
	private static String sel;
	private static ArrayList<User> list;
	static {
		scan = new Scanner(System.in);
	}
	
	/**
	 * main 메소드 입니다.
	 * 반복해서 menu를 보여줍니다.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		boolean loop = true;
		while(loop) {
			list = Load.loadUser();
			menu();
			select();
			
			if(sel.equals("1")) {		
				//회원 검색
				search();
			}else if(sel.equals("2")){	
				//회원 삭제
				delete();
			}else if(sel.equalsIgnoreCase("B")){	
				//TODO 뒤로 가기
				loop = false;
			}else if(sel.equals("<")){	
				//이전 페이지
				if(page != 0) {
					page--;
				} else {
					System.out.println("\t\t이전 페이지가 없습니다.");
					pause();
				}
			}else if(sel.equals(">")){	
				//다음 페이지
				if(page != list.size()/10) {
					page++;
				} else {
					System.out.println("\t\t다음 페이지가 없습니다.");
					pause();
				}
			}else {
				System.out.println("\t\t다시 입력해주세요.");
				pause();
			}
		}
	}//main
	
	/**
	 * 회원을 삭제합니다.
	 * @throws Exception
	 */
	private static void delete() throws Exception {
		head("회원 삭제");
		
		System.out.println("\t\t삭제할 회원의 번호를 입력하세요.");
		select();
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.user));
		
		String line = null;
		String txt = "";
		boolean flag = false;
		int num = 0;
		
		while ((line = reader.readLine()) != null) {
			if(sel.equalsIgnoreCase(line.split("■")[0])) {//입력과 일치하는 직원번호를 발견하면 삭제 여부 물어봄.
				flag = true;
				System.out.println("\t\t정말 삭제하시겠습니까? (Y/N)");
				select();
				
				if(sel.equalsIgnoreCase("N")) {
					System.out.println("\t\t삭제를 취소합니다.");
					pause();
					return;
				} else if(!sel.equalsIgnoreCase("Y")) {
					System.out.println("\t\t다시 입력해주세요.");
					select();
				}
				
			}else {
				num++;
				txt += line.replace(line.substring(0, line.indexOf("■"))
									, String.format("U%04d", num)) + "\r\n";
			}
		}
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.user));
		writer.write(txt);
		writer.close();
		
		if(flag) {
			System.out.println("\t\t삭제가 완료되었습니다.");
		} else {
			System.out.println("\t\t잘못된 번호입니다.");
		}
		pause();
	}//delete

	/**
	 * 회원을 검색합니다.
	 * @throws Exception
	 */
	private static void search() throws Exception {
		head("회원 검색");
		System.out.println("\t\t검색할 회원의 이름을 입력하세요.");
		select();
		
		boolean flag = false;
		for(User u : list) {
			if(u.getName().equalsIgnoreCase(sel)) {
				//TODO 고유번호, 이름 순이 낫지 않을까요?
				System.out.printf("[%4s]\t  [%s]\t    [%s]    [%s]   [%s]\t    [%s]\t\t    [%s]%n"
						,"고유번호","ID","PW","이름","주민등록번호","핸드폰 번호","주소");
				System.out.printf(" %-6s %-9s %-9s %-4s %-15s %-15s %-25s%n"
						, u.getSeq()
						, u.getId()
						, u.getPw()
						, u.getName()
						, u.getJumin().substring(0,6) + "-"
								+ u.getJumin().substring(6)
						, u.getPhoneNum().substring(0,3) + "-" 
								+ u.getPhoneNum().substring(3,7) + "-" 
								+ u.getPhoneNum().substring(7)
								, u.getAddress());
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("\t\t존재하지 않는 회원입니다.");
		}
		
		pause();
	}//search
	
	/**
	 * 입력을 받아 sel 변수에 저장합니다.
	 */
	private static void select() {
		System.out.print("\t\t👉 ");
		sel = scan.nextLine();
		System.out.println();
	}//select

	/**
	 * 회원을 조회합니다.2
	 * @throws Exception
	 */
	private static void list() throws Exception {
		System.out.printf("[%4s]\t  [%s]\t    [%s]    [%s]   [%s]\t    [%s]\t\t    [%s]%n"
						,"고유번호","ID","PW","이름","주민등록번호","핸드폰 번호","주소");
		for(int i=page*10; i<page*10+10&&i<list.size(); i++) {
			System.out.printf(" %-6s %-9s %-9s %-4s %-15s %-15s %-25s%n"
							, list.get(i).getSeq()
							, list.get(i).getId()
							, list.get(i).getPw()
							, list.get(i).getName()
							, list.get(i).getJumin().substring(0,6) + "-"
									+ list.get(i).getJumin().substring(6)
							, list.get(i).getPhoneNum().substring(0,3) + "-" 
									+ list.get(i).getPhoneNum().substring(3,7) + "-" 
									+ list.get(i).getPhoneNum().substring(7)
							, list.get(i).getAddress());
		}
		
		System.out.println("====================================================================================");
		System.out.printf("< 이전 페이지 \t\t\t\t%d/%d\t\t\t\t 다음 페이지 >%n", page+1, list.size()/10+1);
		System.out.println("====================================================================================");
	}//list
	
	/**
	 * 엔터를 누르기 전까지 화면 이동을 멈춥니다.
	 */
	private static void pause() {
		System.out.println();
		System.out.println("\t\t(엔터를 누르면 메뉴로 이동합니다.)");
		scan.nextLine();
	}//pause
	
	/**
	 * 헤더를 출력합니다.
	 * @param title 
	 */
	private static void head(String title){
		System.out.println("====================================================================================");
		System.out.printf("\t\t\t\t[%s]%n", title);
		System.out.println("====================================================================================\n");
	}
	
	/**
	 * 메뉴를 보여줍니다.
	 * @throws Exception
	 */
	private static void menu() throws Exception {
		head("회원 관리");
		list();
		
		System.out.print("\t\t1. 회원 검색");
		System.out.println("\t\t\t2. 회원 삭제");
		System.out.println("\t\tB. 뒤로 가기");
	}//menu
}