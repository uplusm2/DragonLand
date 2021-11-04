package com.project.main;

import java.io.*;
import java.util.*;

import com.project.data.*;

/**
 * Save 클래스입니다.
 * ArrayList를 해당 파일에 저장합니다.
 * @author 
 */
public class Save {
	public static BufferedWriter writer;

	/**
	 * 어트랙션 정보를 저장합니다.
	 * @param list 어트랙션
	 * @throws Exception
	 */
	public static void saveAttraction(ArrayList<Attraction> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.attraction));

		for (Attraction attraction : list) {
			String line = String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s"
									, attraction.getSeq()
									, attraction.getName()
									, attraction.getAttractionType()
									, attraction.getCapacity()
									, attraction.getRunTime()
									, attraction.getLocateSeq()
									, attraction.getWaitTime()
									, attraction.getVote()
									, attraction.getOn());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	

	/**
	 * 어트랙션 예약 정보를 저장합니다.
	 * @param list 어트랙션예약
	 * @throws Exception
	 */

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

	/**
	 * 일별 매출 정보를 저장합니다.
	 * @param list 일별 매출
	 * @throws Exception
	 */
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
	
	/**
	 * 월별 매출 정보를 저장합니다.
	 * @param list 월별 매출
	 * @throws Exception
	 */
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
	
	/**
	 * 퍼레이드 정보를 저장합니다.
	 * @param list 퍼레이드
	 * @throws Exception
	 */
	public static void saveParade(ArrayList<Parade> list) throws Exception {
		writer = new BufferedWriter(new FileWriter(Path.parade));

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
	   
	/**
	 * 직원 정보를 저장합니다.
	 * @param list 직원
	 * @throws Exception
	 */
	public static void saveStaff(ArrayList<Staff> list) throws Exception{
		writer = new BufferedWriter(new FileWriter(Path.staff));
		
		for(Staff staff : list) {
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
	
	/**
	 * 티켓 예약 정보를 저장합니다.
	 * @param list 티켓 예약 정보
	 * @throws Exception
	 */
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
	
	/**
	 * 회원 정보를 저장합니다.
	 * @param list 회원 정보
	 * @throws Exception
	 */
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
									, user.getAddress()
									, user.getVote());
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}
	
	/**
	 * 고객의 소리 정보를 저장합니다.
	 * @param list 고객의 소리 정보
	 * @throws Exception
	 */
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
