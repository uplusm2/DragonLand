package com.project.main;

import java.io.*;
import java.util.*;

import com.project.data.*;

/**
 * Load 클래스입니다.
 * 파일의 정보를 ArrayList로 반환합니다.
 * @author 
 */
public class Load {
	public static BufferedReader reader;

	/**
	 * 어트랙션정보 파일의 내용을 반환합니다.
	 * @return 어트랙션 정보
	 * @throws Exception
	 */
	public static ArrayList loadAttraction() throws Exception {
		reader = new BufferedReader(new FileReader(Path.attraction));
		ArrayList<Attraction> list = new ArrayList<Attraction>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new Attraction(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6], tmp[7], tmp[8]));
		}
		reader.close();
		return list;
	}
	
	/**
	 * 어트랙션예약정보 파일의 내용을 반환합니다.
	 * @return 어트랙션 예약정보
	 * @throws Exception
	 */
	public static ArrayList loadAttractionReservation() throws Exception {
		reader = new BufferedReader(new FileReader(Path.attractionReservation));
		ArrayList<AttractionReservation> list = new ArrayList<AttractionReservation>();
		
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new AttractionReservation(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]));
		}
		reader.close();
		return list;
	}
	
	/**
	 * 카드정보 파일의 내용을 반환합니다.
	 * @return 카드정보
	 * @throws Exception
	 */
	public static ArrayList loadCard() throws Exception {
		reader = new BufferedReader(new FileReader(Path.card));
		ArrayList<Card> list = new ArrayList<Card>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new Card(tmp[0], tmp[1], tmp[2]));
		}
		reader.close();
		return list;
	}

	/**
	 * 편의시설정보 파일의 내용을 반환합니다.
	 * @return 편의시설정보
	 * @throws Exception
	 */
	public static ArrayList loadFacility() throws Exception {
		reader = new BufferedReader(new FileReader(Path.facility));
		ArrayList<Facility> list = new ArrayList<Facility>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new Facility(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]));
		}
		reader.close();
		return list;
	}
	
	/**
	 * 놀이공원 시설 위치 파일의 내용을 반환합니다.
	 * @return 시설 위치
	 * @throws Exception
	 */
	public static ArrayList loadLocation() throws Exception {
		reader = new BufferedReader(new FileReader(Path.location));
		ArrayList<Location> list = new ArrayList<Location>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new Location(tmp[0], tmp[1]));
		}
		reader.close();
		return list;
	}

	/**
	 * 일별매출정보 파일의 내용을 반환합니다.
	 * @return 일별 매출 정보
	 * @throws Exception
	 */
	public static ArrayList loadDailySales() throws Exception {
		reader = new BufferedReader(new FileReader(Path.dailySales));
		ArrayList<DailySales> list = new ArrayList<DailySales>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new DailySales(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6], tmp[7], tmp[8]));
		}
		reader.close();
		return list;
	}

	/**
	 * 월별매출정보 파일의 내용을 반환합니다.
	 * @return 월별 매출 정보
	 * @throws Exception
	 */
	public static ArrayList loadMonthlySales() throws Exception {
		reader = new BufferedReader(new FileReader(Path.monthlySales));
		ArrayList<MonthlySales> list = new ArrayList<MonthlySales>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new MonthlySales(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6], tmp[7], tmp[8]));
		}
		reader.close();
		return list;
	}
	
	/**
	 * 퍼레이드정보 파일의 내용을 반환합니다.
	 * @return 퍼레이드정보
	 * @throws Exception
	 */
	public static ArrayList loadParade() throws Exception {
		reader = new BufferedReader(new FileReader(Path.parade));
		ArrayList<Parade> list = new ArrayList<Parade>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new Parade(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]));
		}
		reader.close();
		return list;
	}

	/**
	 * 직원정보 파일의 내용을 반환합니다.
	 * @return 직원 정보
	 * @throws Exception
	 */
	public static ArrayList loadStaff() throws Exception {
		reader = new BufferedReader(new FileReader(Path.staff));
		ArrayList<Staff> list = new ArrayList<Staff>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new Staff(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]));
		}
		reader.close();
		return list;
	}
	
	/**
	 * 티켓정보 파일의 내용을 반환합니다.
	 * @return 티켓 정보
	 * @throws Exception
	 */
	public static ArrayList loadTicket() throws Exception {
		reader = new BufferedReader(new FileReader(Path.ticket));
		ArrayList<Ticket> list = new ArrayList<Ticket>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new Ticket(tmp[0], tmp[1], tmp[2]));
		}
		reader.close();
		return list;
	}
	
	/**
	 * 티켓예매정보 파일의 내용을 반환합니다.
	 * @return 티켓예매정보
	 * @throws Exception
	 */
	public static ArrayList loadTicketReservation() throws Exception {
		reader = new BufferedReader(new FileReader(Path.ticketReservation));
		ArrayList<TicketReservation> list = new ArrayList<TicketReservation>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new TicketReservation(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6], tmp[7]));
		}
		reader.close();
		return list;
	}
	
	/**
	 * 회원정보 파일의 내용을 반환합니다.
	 * @return 회원 정보
	 * @throws Exception
	 */
	public static ArrayList loadUser() throws Exception {
		reader = new BufferedReader(new FileReader(Path.user));
		ArrayList<User> list = new ArrayList<User>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("■");
			list.add(new User(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6],
					Boolean.parseBoolean(temp[7])));
		}
		reader.close();
		return list;
	}
	
	/**
	 * 고객의소리 파일의 내용을 반환합니다
	 * @return 고객의 소리
	 * @throws Exception
	 */
	public static ArrayList loadUserVoice() throws Exception {
		reader = new BufferedReader(new FileReader(Path.userVoice));
		ArrayList<UserVoice> list = new ArrayList<UserVoice>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new UserVoice(tmp[0], tmp[1], tmp[2]));
			
		}
		reader.close();
		return list;
	}

	/**
	 * 직원근무지 파일의 내용을 반환합니다.
	 * @return 직원 근무지
	 * @throws Exception
	 */
	public static ArrayList loadWorkPlace() throws Exception {
		reader = new BufferedReader(new FileReader(Path.workPlace));
		ArrayList<WorkPlace> list = new ArrayList<WorkPlace>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] tmp = line.split("■");
			list.add(new WorkPlace(tmp[0]));
		}
		reader.close();
		return list;
	}
}
