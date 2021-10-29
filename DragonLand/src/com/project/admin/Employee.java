package com.project.admin;

import java.io.*;
import java.util.*;

import com.project.data.*;
import com.project.main.*;

public class Employee {
	private static Scanner scan;
	private static int page;
	private static String sel;
	private static ArrayList<Staff> list;
	static {
		page = 0;
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws Exception {
		
		boolean loop = true;
		while(loop) {
			list = Load.loadStaff();
			menu();
			select();
			
			if(sel.equals("1")) {		
				//직원 검색
				search();
			}else if(sel.equals("2")){	
				//직원 추가
				add();
			}else if(sel.equals("3")){	
				//직원 근무지 배치 및 수정
				edit();
			}else if(sel.equals("4")){	
				//직원 삭제
				delete();
			}else if(sel.equals("B")){	
				//TODO 뒤로 가기
				loop = false;
			}else if(sel.equals("<")){	
				//이전 페이지
				if(page != 0) {
					page--;
				} else {
					System.out.println("이전 페이지가 없습니다.");
					pause();
				}
			}else if(sel.equals(">")){	
				//다음 페이지
				page++;
			}else {
				System.out.println("다시 입력해주세요.");
				pause();
			}
		}
	}//main
	
	private static void delete() throws Exception {
		System.out.println("====================================================================================");
		System.out.println("\t\t\t\t[직원 삭제]");
		System.out.println("====================================================================================\n");
		
		System.out.println("삭제할 직원의 번호를 입력하세요.");
		select();
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.staff));
		
		String line = null;
		String txt = "";
		boolean flag = false;
		int num = 0;
		
		while ((line = reader.readLine()) != null) {
			if(sel.equals(line.split("■")[0])) {//입력과 일치하는 직원번호를 발견하면 삭제 여부 물어봄.
				flag = true;
				System.out.println("정말 삭제하시겠습니까? (Y/N)");
				select();
				
				if(sel.equals("N")) {
					System.out.println("삭제를 취소합니다.");
					pause();
					return;
				}
			}else {
				num++;
				txt += line.replace(line.substring(0, line.indexOf("■"))
									, String.format("E%03d", num)) + "\r\n";
			}
		}
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.staff));
		writer.write(txt);
		writer.close();
		
		if(flag) {
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("잘못된 번호입니다.");
		}
		pause();
	}//delete

	private static void edit() throws Exception {
		System.out.println("====================================================================================");
		System.out.println("\t\t\t\t[직원 근무지 배치 및 수정]");
		System.out.println("====================================================================================\n");
		
		System.out.println("직원 번호를 입력하세요."); //뒤로가기?
		select();
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.staff));
		
		String line = null;
		String txt = "";
		boolean flag = false;
		
		while ((line = reader.readLine()) != null) {
			if(sel.equals(line.split("■")[0])) {//입력과 일치하는 직원번호를 발견하면 근무지를 입력 받음.
				System.out.println("새로운 근무지를 입력하세요");
				select();
				
				txt += line.replace(line.substring(line.lastIndexOf("■")+1), sel) + "\r\n";
				flag = true;
			}else {
				txt += line + "\r\n";
			}
		}
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.staff));
		writer.write(txt);
		writer.close();
		
		if(flag) {
			System.out.println("근무지 변경이 완료되었습니다.");
		} else {
			System.out.println("잘못된 번호입니다.");
		}
		
		pause();
	}//edit

	private static void add() throws Exception {
		System.out.println("====================================================================================");
		System.out.println("\t\t\t\t[직원 추가]");
		System.out.println("====================================================================================\n");
		
		System.out.print("이름:");
		String name = scan.nextLine();
		System.out.print("나이:");
		String age = scan.nextLine();
		System.out.print("주소:");
		String address = scan.nextLine();
		System.out.print("핸드폰 번호:");
		String phoneNum = scan.nextLine();
		System.out.print("근무지:");
		String workPlace = scan.nextLine();
		
		String seq = String.format("E%03d", list.size()+1);
		
		Staff s = new Staff(seq,name,age,address,phoneNum,workPlace);
		list.add(s);
		Save.saveStaff(list);//ArrayList를 파일에 저장
		
		System.out.println("직원이 추가되었습니다.");
		pause();
	}//add

	private static void search() {
		System.out.println("====================================================================================");
		System.out.println("\t\t\t\t[직원 검색]");
		System.out.println("====================================================================================\n");
		
		System.out.println("검색할 직원의 이름을 입력하세요.");
		select();
		
		
		list.stream()
			.filter(s -> s.getName().equals(sel))
			.forEach(s -> {
				System.out.printf("%s\t|%s\t|%s\t|%s\t\t\t\t|%s\t|%s%n"
						,"고유번호","이름","나이","주소","핸드폰 번호","근무지");
				System.out.printf("%s\t|%s\t|%s\t|%s\t\t|%s\t|%s%n"
								, s.getSeq()
								, s.getName()
								, s.getAge()
								, s.getAddress()
								, s.getPhoneNum()
								, s.getWorkPlace());
				pause();
				return;
			}); //검색한 직원이 존재하지 않을 경우는 어떻게 하면 좋을까?
		
		System.out.println("존재하지 않는 직원입니다.");
		pause();
	}//search

	private static void select() {
		System.out.print("👉 ");
		sel = scan.nextLine();
		System.out.println();
	}//select

	private static void list() throws Exception {
		System.out.printf("%s\t|%s\t|%s\t|%s\t\t\t\t|%s\t|%s%n"//"%-8s|%-8s|%-8s|%-25s|%-13s|%-8s%n"
						,"고유번호","이름","나이","주소","핸드폰 번호","근무지");
		for(int i=page*10; i<page*10+10; i++) {
			if(list.get(i).getSeq().equals("")) {
				break;
			}
			System.out.printf("%s\t|%s\t|%s\t|%s\t|%s\t|%s%n"
							, list.get(i).getSeq()
							, list.get(i).getName()
							, list.get(i).getAge()
							, list.get(i).getAddress()
							, list.get(i).getPhoneNum()
							, list.get(i).getWorkPlace());
		}
		
		System.out.printf("\t\t\t\t\t%d/%d%n", page+1, list.size()/10+1);
	}//list
	
	private static void pause() {
		System.out.println();
		System.out.println("(엔터를 누르면 메뉴로 이동합니다.)");
		scan.nextLine();
	}//pause
	
	private static void menu() throws Exception {
		System.out.println("====================================================================================");
		System.out.println("\t\t\t\t[직원 관리]");
		System.out.println("====================================================================================\n");
		list();
		
		System.out.println("< 이전 페이지 | 다음 페이지 > ");
		System.out.println("1. 직원 검색");
		System.out.println("2. 직원 추가");
		System.out.println("3. 직원 근무지 배치 및 수정");
		System.out.println("4. 직원 삭제");
		System.out.println("B. 뒤로 가기");
	}//menu
}
