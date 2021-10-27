package com.project.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class TicketReservation {

	private static Scanner scan;
	private static ArrayList<Ticket> list;
	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Ticket>(1500);
	}
	void load() {
		try {
			String path = "C:\\Users\\u_011\\git\\DragonLand\\DragonLand\\data";
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				Ticket t = new Ticket();
				t.setNum(temp[0]);
				t.setDate(temp[1]);
				t.setAdult(Integer.parseInt(temp[2]));
				t.setTeen(Integer.parseInt(temp[3]));
				t.setKid(Integer.parseInt(temp[4]));
				t.setCardNum(temp[5]);
				t.setPayment(temp[6]);
				t.setUserNum(temp[7]);
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void list() throws Exception {
		
		for(Ticket t : list) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%s\t%s\t%s%n"
								, t.getNum()
								, t.getDate()
								, t.getAdult()
								, t.getTeen()
								, t.getKid()
								, t.getCardNum()
								, t.getPayment()
								, t.getUserNum());
		}
		
	}
}
