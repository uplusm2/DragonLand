package com.project.data;

public class Attraction {
	private String code;
	private String name;
	private String type;
	private String capacity;
	private String runTime;
	private String location;
	private String vote;
	private String on;
	
	public Attraction(String code, String name, String type, String capacity, String runTime, String location, String vote, String on) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.capacity = capacity;
		this.runTime = runTime;
		this.location = location;
		this.vote = vote;
		this.on = on;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getCapacity() {
		return capacity;
	}

	public String getRunTime() {
		return runTime;
	}

	public String getLocation() {
		return location;
	}

	public String getVote() {
		return vote;
	}

	public String getOn() {
		return on;
	}
}