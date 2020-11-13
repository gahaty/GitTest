package com.citec.entities;

public class Vaccination {
	
	private String date;
	private String cause;
	private String valid;
	
	public Vaccination() {}
	
	public Vaccination(String date, String cause, String valid) {	
		this.date = date;
		this.cause = cause;
		this.valid = valid;
	}
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "\nbeadas datuma: " + date + "\tok: " + cause + "\tervenyesseg: " + valid;
	}
}
