package com.project.data;

public class Facility {

	private String seq;
	private String type;
	private String name;
	private String time;
	private String locateNum;
	
	public Facility(String seq, String type, String name, String time, String locateNum) {
		this.seq = seq;
		this.type = type;
		this.name = name;
		this.time = time;
		this.locateNum = locateNum;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocateNum() {
		return locateNum;
	}
	public void setLocateNum(String locateNum) {
		this.locateNum = locateNum;
	}
	@Override
	public String toString() {
		return "Facility [seq=" + seq + ", type=" + type + ", name=" + name + ", time=" + time + ", locateNum="
				+ locateNum + "]";
	}
	
}