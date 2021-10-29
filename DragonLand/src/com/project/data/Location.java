package com.project.data;

public class Location {
	private String seq;
	private String locate;
	
	public Location(String seq, String locate) {
		this.seq = seq;
		this.locate = locate;
	}
	
	public String getSeq() {
		return seq;
	}
	public String getLocate() {
		return locate;
	}

	@Override
	public String toString() {
		return "Location [seq=" + seq + ", locate=" + locate + "]";
	}
	
}
