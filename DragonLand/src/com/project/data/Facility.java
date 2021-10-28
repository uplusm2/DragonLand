package com.project.data;

public class Facility {

	private String code;
	private String type;
	private String name;
	private String time;
	private String locateCode;
	
	public Facility(String code, String type, String name, String time, String locateCode) {
		this.code = code;
		this.type = type;
		this.name = name;
		this.time = time;
		this.locateCode = locateCode;
	}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public String getLocateCode() {
		return locateCode;
	}
	
}
