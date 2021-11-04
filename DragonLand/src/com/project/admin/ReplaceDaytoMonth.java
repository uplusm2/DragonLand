package com.project.admin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import com.project.data.DailySales;
import com.project.data.MonthlySales;
import com.project.data.Path;
import com.project.main.Load;



/**
 * 일별 매출을 월별 매출로 바꿔주는 클래스 입니다.
 * @author 김재형
 *
 */
public class ReplaceDaytoMonth {
	
	private static ArrayList<DailySales> list1;
	private static int addmonth;

	
	static {
		list1 = new ArrayList<DailySales>();
		addmonth=0;

		
	}
	
	/**
	 * 실행하는 메인
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		replace();
	}
	
	/**
	 * 교체해주는 메소드 입니다.
	 * @throws Exception
	 */
	public static void replace() throws Exception {
		
		list1 = Load.loadDailySales();
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		int start =0;
				
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.monthlySales,true));
		
		String line="";	
		c1.set(2018, 4, 1);
		int sub = (int)((c2.getTimeInMillis()-c1.getTimeInMillis())/1000/3600/24/30);
		System.out.println(sub);
		for(int j=0;j<sub+1;j++) {
			int adulttotal=0;
			int youthtotal=0;
			int kidtotal=0;
			int adultprice=0;
			int youthprice=0;
			int kidprice=0;
			int total=0;
			int price=0;
			c1.set(2018, 4+addmonth, 1);
			c2.set(2018, 4+addmonth, c1.getActualMaximum(Calendar.DATE));
			
			String snum = String.format("%d%02d%02d",c1.get(Calendar.YEAR),c1.get(Calendar.MONTH)+1,c1.get(Calendar.DATE));
			String fnum = String.format("%d%02d%02d",c2.get(Calendar.YEAR),c2.get(Calendar.MONTH)+1,c2.get(Calendar.DATE));
			
			int s = Integer.parseInt(snum);
			int f = Integer.parseInt(fnum);
			
			for(int i=0; i<list1.size();i++) {
				start=Integer.parseInt(list1.get(i).getDate().substring(0,8));
				if(start>=s&&start<=f) {
					adulttotal+=Integer.parseInt(list1.get(i).getAdultCount());
					youthtotal+=Integer.parseInt(list1.get(i).getYouthCount());
					kidtotal+=Integer.parseInt(list1.get(i).getKidCount());
					adultprice+=Integer.parseInt(list1.get(i).getAdultPrice());
					youthprice+=Integer.parseInt(list1.get(i).getYouthPrice());
					kidprice+=Integer.parseInt(list1.get(i).getKidPrice());
					total+=Integer.parseInt(list1.get(i).getTotalCount());
					price+=Integer.parseInt(list1.get(i).getTotalPrice());
				
				}
			}System.out.println(f);
			addmonth++;
			line=String.format("%d%02d■%d■%d■%d■%d■%d■%d■%d■%d\n",c1.get(Calendar.YEAR),c1.get(Calendar.MONTH)+1,
					adulttotal,youthtotal,kidtotal,adultprice,youthprice,kidprice,total,price
					);
			writer.write(line);
			

		}
		
		writer.close();
		System.out.println("완료");
		
		
		
		
		
		
	}
}
