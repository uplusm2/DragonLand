package com.project.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.project.data.DailySales;
import com.project.data.MonthlySales;
import com.project.data.Path;
import com.project.main.Load;
import com.project.main.Save;

/**
 * 월별 통계 클래스 입니다.
 * @author 김재형
 *
 */
public class MonthlyStatistic {
	

	private static Scanner scan;
	private static int start;
	private static int end;
	private static int num;
	private static ArrayList<MonthlySales> list;
	private static ArrayList<DailySales> list2;
	
	static {
		scan = new Scanner(System.in);
		start =0;
		end=10;
		num=1;
	}
	
	public static void statistic() throws Exception {
	
			list();
	
	}
	
	/**
	 * 매월 이용자 현황을 보여주는 메소드 입니다.
	 * @throws Exception
	 */
	public static void list() throws Exception {
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.println("\t\t\t\t\t\t\t\t\t\t[전체 이용자 현황]");
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t\t\t\t[날짜]\t[총인원] [성인]\t[청소년]  [어린이]   [총매출]\r\n");
		
		addMonth();
		
		list=Load.loadMonthlySales();
		
		for(int i=start;i<end&&i<list.size();i++) {
			
			
			System.out.printf("\t\t\t\t\t\t\t\t%s\t %,6d\t  %,5d\t  %,5d\t   %,5d    %,11d\r\n",list.get(list.size()-1-i).getDate(),Integer.parseInt(list.get(list.size()-1-i).getTotalCount()),
					Integer.parseInt(list.get(list.size()-1-i).getAdultCount()),Integer.parseInt(list.get(list.size()-1-i).getYouthCount())
					,Integer.parseInt(list.get(list.size()-1-i).getKidCount()),Integer.parseInt(list.get(list.size()-1-i).getTotalPrice()));
			
			
			
		}
		System.out.println("\t\t\t\t\t================================================================================================");
		System.out.printf("\t\t\t\t\t< 이전페이지                                    %d/%d                                다음 페이지 >\n",num,(list.size()-1)/10+1);
		System.out.println("\t\t\t\t\t================================================================================================");
		
		System.out.println("\t\t\t\t\t\t\t\t\t\tB.뒤로가기");
		System.out.print("\t\t\t\t\t\t\t\t\t\t👉");
		String index = scan.nextLine();
		if(index.equals(">")){
			start+=10;
			end+=10;
			num++;
			
			list();
		}else if(index.equals("<")) {
			if(start>=10) {
				start-=10;
				end-=10;
				num--;
				list();
			}else {
				System.out.println("\t\t\t\t\t\t\t\t\t\t뒤로 갈곳이 없습니다.");
				list();
			}
				
		}else if(index.equals("b")||index.equals("B")) {
			AdminMenu.statistic();
			
		}else {
			System.out.println("\t\t\t\t\t\t\t\t\t\t다시 입력해주세요.");
			list();
		}
		
	
		
		
	}
	
	/**
	 * 이번달 데이터를 일별매출정보에서 끌어오는 메소드 입니다.
	 * @throws Exception
	 * @throws IOException
	 */

	public static void addMonth() throws Exception, IOException {
		list2=Load.loadDailySales();
		Calendar c2 = Calendar.getInstance();
		int adultnum =0;
		int youthnum =0;
		int kidnum =0;
		int adulttotal=0;
		int youthtotal=0;
		int kidtotal=0;
		int total=0;
		for(int i=list2.size()-1;i>list2.size()-c2.get(Calendar.DATE)-1;i--) {
			if(Integer.parseInt((list2.get(i).getDate().substring(4,6)))==(c2.get(Calendar.MONTH)+1)){
				adultnum+=Integer.parseInt(list2.get(i).getAdultCount());
				youthnum+=Integer.parseInt(list2.get(i).getYouthCount());
				kidnum+=Integer.parseInt(list2.get(i).getKidCount());
				adulttotal+=Integer.parseInt(list2.get(i).getAdultPrice());
				youthtotal+=Integer.parseInt(list2.get(i).getYouthPrice());
				kidtotal+=Integer.parseInt(list2.get(i).getKidPrice());
				total+=Integer.parseInt(list2.get(i).getTotalPrice());
			}
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.monthlySales,true));
		
		String line2 = String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s"
				, "202111"
				, adultnum
				, youthnum
				, kidnum
				, adulttotal
				, youthtotal
				, kidtotal
				, adultnum+youthnum+kidnum
				, total);
		writer.write(line2);
		writer.newLine();
		writer.close();
		
		list = Load.loadMonthlySales();
		if((list.get(list.size()-1).getDate().equals(list.get(list.size()-2).getDate()))) {
			list.remove(list.size()-1);
		}
		
		Save.saveMonthlySales(list);
		
	}
	
	

}
