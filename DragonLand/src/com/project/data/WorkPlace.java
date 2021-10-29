package com.project.data;

public class WorkPlace {
	private String locate;

	public WorkPlace(String locate) {
		this.locate = locate;
	}

	public String getLocate() {
		return locate;
	}

	@Override
	public String toString() {
		return "WorkPlace [locate=" + locate + "]";
	}
}
