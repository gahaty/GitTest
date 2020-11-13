package com.citec.entities;

import java.util.ArrayList;
import java.util.List;

public class Owner {

	private String id;
	private String name;
	private String email; // nem kotelezo
	private String telNum1;
	private String telNum2; // nem kotelezo
	private List<Pet> petList = new ArrayList<>();

	public Owner(String id, String name, String email, String telNum1, String telNum2) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telNum1 = telNum1;
		this.telNum2 = telNum2;
	}

	public Owner(String id, String name, String telNum1) {
		this.id = id;
		this.name = name;
		this.telNum1 = telNum1;
	}

	public Owner() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNum1() {
		return telNum1;
	}

	public void setTelNum1(String telNum1) {
		this.telNum1 = telNum1;
	}

	public String getTelNum2() {
		return telNum2;
	}

	public void setTelNum2(String telNum2) {
		this.telNum2 = telNum2;
	}

	public List<Pet> getPetList() {
		return petList;
	}

	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}
	
	final String arrayToString() {
		String result = "";
		for (int i = 0; i < this.petList.size(); i++) {
			result += petList.get(i);
		}
		return result;
	}

	@Override
	public String toString() {
		return "\n\nGazdi:\nazonosito: " + id + "\tnev: " + name + "\te-mail: " + email + "\ttelefon 1.: " + telNum1 + "\ttelefon 2.: " + telNum2 + "\nKisallatai: " + arrayToString();
	}
	

}