package com.citec.entities;

import java.util.ArrayList;
import java.util.List;

public class Pet {

	private String name;
	private String breed;
	private String type;
	private String color;
	private String date;
	private String weight;
	private String chipNum;
	private List<Vaccination> vaccinationList = new ArrayList<>();
	
	public Pet() {}
	
	public Pet(String name, String breed, String type, String color, String date, String weight, String chipNum) {

		this.name = name;
		this.breed = breed;
		this.type = type;
		this.color = color;
		this.date = date;
		this.weight = weight;
		this.chipNum = chipNum;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getChipNum() {
		return chipNum;
	}

	public void setChipNum(String chipNum) {
		this.chipNum = chipNum;
	}

	public List<Vaccination> getVaccinationList() {
		return vaccinationList;
	}

	public void setVaccinationList(List<Vaccination> vaccinationList) {
		this.vaccinationList = vaccinationList;
	}

	final String arrayToString() {
		String result = "";
		for (int i = 0; i < this.vaccinationList.size(); i++) {
			result += vaccinationList.get(i);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "\nnev: " + name + "\tfajta: " + breed + "\ttipus: " + type + "\tszin: " + color + "\tdatum: " + date + "\tsuly: " + weight + " kg"
				+ "\tchipszam: " + chipNum + "\nOltasi lista: " + arrayToString();
	}
}
