package com.project.main;

import java.io.*;
import java.util.*;

import com.project.data.*;

public class Save {
	public static BufferedWriter writer;

	public static void saveAttractionReservation(ArrayList<AttractionReservation> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.attractionReservation));

		for (AttractionReservation attractionreservation : list) {
			String line = String.format("%s■%s■%s■%s■%s■%s"
									, attractionreservation.getSeq()
									, attractionreservation.getAttractionNum()
									, attractionreservation.getDate()
									, attractionreservation.getHour()
									, attractionreservation.getCount()
									, attractionreservation.getUserNum());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}

	public static void saveDailySales(ArrayList<DailySales> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.dailySales));

		for (DailySales dailysales : list) {
			String line = String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s"
									, dailysales.getDate()
									, dailysales.getAdultCount()
									, dailysales.getYouthCount()
									, dailysales.getKidCount()
									, dailysales.getAdultPrice()
									, dailysales.getYouthPrice()
									, dailysales.getKidPrice()
									, dailysales.getTotalCount()
									, dailysales.getTotalPrice());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	
	public static void saveMonthlySales(ArrayList<MonthlySales> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.monthlySales));

		for (MonthlySales monthlysales : list) {
			String line = String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s"
									, monthlysales.getDate()
									, monthlysales.getAdultCount()
									, monthlysales.getYouthCount()
									, monthlysales.getKidCount()
									, monthlysales.getAdultPrice()
									, monthlysales.getYouthPrice()
									, monthlysales.getKidPrice()
									, monthlysales.getTotalCount()
									, monthlysales.getTotalPrice());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	
	public static void saveParade(ArrayList<Parade> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.monthlySales));

		for (Parade parade : list) {
			String line = String.format("%s■%s■%s■%s■%s"
									, parade.getTitle()
									, parade.getStartDate()
									, parade.getEndData()
									, parade.getContent()
									, parade.getLocate());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	   
	public static void saveStaff(ArrayList<Staff> list) throws Exception{
		for(Staff staff : list) {
			writer = new BufferedWriter(new FileWriter(Path.staff));
			String line = String.format("%s■%s■%s■%s■%s■%s"
									, staff.getSeq()
									, staff.getName()
									, staff.getAge()
									, staff.getAddress()
									, staff.getPhoneNum()
									, staff.getWorkPlace());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	
	public static void saveTicketReservation(ArrayList<TicketReservation> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.ticketReservation));

		for (TicketReservation ticketreservation : list) {
			String line = String.format("%s■%s■%s■%s■%s■%s■%s■%s"
									, ticketreservation.getSeq()
									, ticketreservation.getDate()
									, ticketreservation.getAdultCount()
									, ticketreservation.getYouthCount()
									, ticketreservation.getKidCount()
									, ticketreservation.getCardNum()
									, ticketreservation.getPrice()
									, ticketreservation.getUserNum());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	
	public static void saveUser(ArrayList<User> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.user));

		for (User user : list) {
			String line = String.format("%s■%s■%s■%s■%s■%s■%s■%s"
									, user.getSeq()
									, user.getId()
									, user.getPw()
									, user.getName()
									, user.getJumin()
									, user.getPhoneNum()
									, user.getId()
									, user.getVote());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	
	public static void saveUserVoice(ArrayList<UserVoice> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.userVoice));

		for (UserVoice userVoice : list) {
			String line = String.format("%s■%s■%s"
									, userVoice.getSeq()
									, userVoice.getDate()
									, userVoice.getContent());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}

}
