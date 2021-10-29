package com.project.data;

public class Attraction {
	private String seq;
	private String name;
	private String attractionType;
	private String capacity;
	private String runTime;
	private String locateSeq;
	private String waitTime;
	private String vote;
	private String on;
	
	public Attraction(String seq, String name, String attractionType, String capacity, String runTime, String locateSeq, String waitTime, String vote, String on) {
		this.seq = seq;
		this.name = name;
		this.attractionType = attractionType;
		this.capacity = capacity;
		this.runTime = runTime;
		this.locateSeq = locateSeq;
		this.waitTime = waitTime;
		this.vote = vote;
		this.on = on;
	}
	
	public String getSeq() {
		return seq;
	}

	public String getName() {
		return name;
	}

	public String getAttractionType() {
		return attractionType;
	}

	public String getCapacity() {
		return capacity;
	}

	public String getRunTime() {
		return runTime;
	}

	public String getLocateSeq() {
		return locateSeq;
	}

	public String getWaitTime() {
		return waitTime;
	}

	public String getVote() {
		return vote;
	}

	public String getOn() {
		return on;
	}

	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	
	@Override
	public String toString() {
		return "[seq=" + seq + ", name=" + name + ", attractionType=" + attractionType + ", capacity="
				+ capacity + ", runTime=" + runTime + ", locateSeq=" + locateSeq + ", waitTime=" + waitTime + ", vote="
				+ vote + ", on=" + on + "]";
	}
}
