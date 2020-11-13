package com.citec.repository;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citec.entities.Owner;
import com.citec.entities.Pet;
import com.citec.entities.Vaccination;

public class Repository {

	Scanner sc = new Scanner(System.in);

	private List<Owner> owner = new ArrayList<>();
	private List<Pet> pet = new ArrayList<>();

	public void newOwnerAdd() {

		String id = "";

		do {
			System.out.println("Kerem a gazdi azonositot!");
			id = sc.nextLine();
		} while (id.equals(""));

		String name = "";

		do {
			System.out.println("Kerem a gazdi nevet!");
			name = sc.nextLine();
		} while (name.equals(""));

		System.out.println("Kerem a gazdi e-mail cimet!");
		String email = sc.nextLine();

		String telNum1 = "";
		do {
			System.out.println("Kerem a gazdi telefonszamat1!");
			telNum1 = sc.nextLine();
		} while (name.equals(""));

		System.out.println("Kerem a gazdi telefonszamat2!");
		String telNum2 = sc.nextLine();

		Owner o = new Owner(id, name, email, telNum1, telNum2);
		owner.add(o);

		Pet p = petData();
		pet.add(p);

		// List<Owner> result = owner.stream().map(s ->
		// s.getPetList().add(p)).collect(Collectors.toList());

		owner.get(owner.size() - 1).getPetList().add(p);
		owner.forEach(System.out::print);
	}

	public void puppyForOwner() {

		System.out.println("Kerem a gazdi azonositot!");
		String ownerIdCheck = sc.nextLine();

		List<Owner> resultList = owner.stream().filter(f -> f.getId().equals(ownerIdCheck))
				.collect(Collectors.toList());

		if (resultList.isEmpty()) {
			System.out.println("Nincs ilyen allat a rendszerben");
		} else {
			Pet p = petData();
			pet.add(p);

			int i = 0;
			for (i = 0; i < owner.size(); i++) {
				if (ownerIdCheck.equals(owner.get(i).getId())) {
					i++;
					break;
				}
			}
			owner.get(i - 1).getPetList().add(p);
			owner.forEach(System.out::print);
		}
	}

	private Pet petData() {

		String name = "";
		do {
			System.out.println("Kerem a kisallat nevet!");
			name = sc.nextLine();
		} while (name.equals(""));

		String breed = "";
		do {
			System.out.println("Milyen fajta?");
			breed = sc.nextLine();
		} while (breed.equals(""));

		String type = "";
		do {
			System.out.println("Milyen allat?");
			type = sc.nextLine();
		} while (type.equals(""));

		String color = "";
		do {
			System.out.println("Milyen szinu");
			color = sc.nextLine();
		} while (color.equals(""));

		String date = "";
		do {
			System.out.println("Kerem a szuletesi datumat!");
			date = sc.nextLine();
		} while (date.equals(""));

		String weight = "";
		do {
			System.out.println("Kerem a sulyat!");
			weight = sc.nextLine();
		} while (weight.equals(""));

		String chipNum = "";
		do {
			System.out.println("Kerem a CHIP szamat!");
			chipNum = sc.nextLine();
		} while (chipNum.equals(""));

		Pet p = new Pet(name, breed, type, color, date, weight, chipNum);
		return p;
	}

	public void findByOwner() {

		System.out.println("Azonosito: ");
		String ownerIdCheck = sc.nextLine();
		System.out.println("Gazdi neve: ");
		String ownerNameCheck = sc.nextLine();
		System.out.println("Gazdi e-mail cime: ");
		String ownerEmailCheck = sc.nextLine();

		String a = ownerIdCheck;
		String b = ownerNameCheck;
		String c = ownerEmailCheck;

		List<Owner> resultList = owner.stream()
				.filter(f -> a.equals(f.getId()) || (b.equals(f.getName()) && c.equals(f.getName())))
				.collect(Collectors.toList());

		if (!resultList.isEmpty()) {
			resultList.forEach(System.out::print);
		} else {
			System.out.println("Nincs ilyen allat a rendszerben");
		}
	}

	public void findByPet() {
		System.out.println("Kérem a chip szamot!");
		String petChipIdCheck = sc.next();

		List<Pet> resultList = pet.stream().filter(f -> petChipIdCheck.equals(f.getChipNum()))
				.collect(Collectors.toList());

		if (!resultList.isEmpty()) {
			resultList.forEach(System.out::print);

		} else {
			System.out.println("Nincs ilyen allat a rendszerben");
		}
	}

	public void vacc() {
		System.out.println("Kérem a chip szamot!");
		String petChipIdCheck = sc.next();

		List<Pet> resultList = pet.stream().filter(f -> petChipIdCheck.equals(f.getChipNum()))
				.collect(Collectors.toList());

		if (!resultList.isEmpty()) {
			System.out.println("Kérem a datumot!");
			String date = sc.next();
			System.out.println("Milyen oltast kap?");
			String cause = sc.next();
			System.out.println("Meddig ervenyes?");
			String valid = sc.next();

			Vaccination vacc = new Vaccination(date, cause, valid);

			int i = 0;
			for (i = 0; i < pet.size(); i++) {
				if (petChipIdCheck.equals(pet.get(i).getChipNum())) {
					i++;
					break;
				}
			}
			System.out.println("i: " + i);

			pet.get(i - 1).getVaccinationList().add(vacc);
			pet.forEach(System.out::print);

		} else {
			System.out.println("Nincs ilyen allat a rendszerben");
		}

	}

	public void vaccList() {
		System.out.println("Kérem a chip szamot!");
		String petChipIdCheck = sc.next();

		List<Pet> resultList = pet.stream().filter(f -> petChipIdCheck.equals(f.getChipNum()))
				.collect(Collectors.toList());

		if (!resultList.isEmpty()) {
			resultList.forEach(l -> l.getVaccinationList().forEach(System.out::print));
		} else {
			System.out.println("Nincs ilyen allat a rendszerben");
		}
	}

	public void export() {
		StringBuilder strData = new StringBuilder();

		owner.forEach(s -> {
			strData.append(s);
		});

		String str = strData.toString();
		String fileName = "./data.csv";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(str);
			fw.close();
			System.out.println("adatok mentve: ./data.csv");

		} catch (Exception e) {
			System.out.println("Hiba a fájl írása közben");
		}
	}

	public void exportToExcel() throws IOException {

		String[] headerOwner = { "azonosito", "nev", "email", "telefon 1", "telefon 2", "", "" };
		String[] headerPet = { "nev", "fajta", "tipus", "szin", "datum", "suly", "chipszam" };
		String[] headerVacc = { "beadas datuma", "ok", "ervenyesseg", "", "", "", "" };

		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("dataExport");

		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 13);
		headerFont.setColor(IndexedColors.WHITE.getIndex());

		CellStyle headerCellStyleOwner = wb.createCellStyle();
		headerCellStyleOwner.setFont(headerFont);
		headerCellStyleOwner.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerCellStyleOwner.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());

		CellStyle headerCellStylePet = wb.createCellStyle();
		headerCellStylePet.setFont(headerFont);
		headerCellStylePet.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerCellStylePet.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

		int rowNum = 0;
		Row row = sheet.createRow(rowNum);
		Cell cell;

		for (int j = 0; j < owner.size(); j++) {
			// Gazdi fejléc:
			for (int i = 0; i < headerOwner.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(headerOwner[i]);
				cell.setCellStyle(headerCellStyleOwner);
			}
			row = sheet.createRow(++rowNum);
			// Gazdi adatai:
			row.createCell(0).setCellValue(owner.get(j).getId());
			row.createCell(1).setCellValue(owner.get(j).getName());
			row.createCell(2).setCellValue(owner.get(j).getEmail());
			row.createCell(3).setCellValue(owner.get(j).getTelNum1());
			row.createCell(4).setCellValue(owner.get(j).getTelNum2());

			row = sheet.createRow(++rowNum);

			for (int k = 0; k < owner.get(j).getPetList().size(); k++) {
				// Állatok fejléce:
				for (int i = 0; i < headerPet.length; i++) {
					cell = row.createCell(i);
					cell.setCellValue(headerPet[i]);
					cell.setCellStyle(headerCellStylePet);
				}
				row = sheet.createRow(++rowNum);
				// Állatok adatai:
				row.createCell(0).setCellValue(owner.get(j).getPetList().get(k).getName());
				row.createCell(1).setCellValue(owner.get(j).getPetList().get(k).getBreed());
				row.createCell(2).setCellValue(owner.get(j).getPetList().get(k).getType());
				row.createCell(3).setCellValue(owner.get(j).getPetList().get(k).getColor());
				row.createCell(4).setCellValue(owner.get(j).getPetList().get(k).getDate());
				row.createCell(5).setCellValue(owner.get(j).getPetList().get(k).getWeight());
				row.createCell(6).setCellValue(owner.get(j).getPetList().get(k).getChipNum());

				row = sheet.createRow(++rowNum);

				for (int l = 0; l < owner.get(j).getPetList().get(k).getVaccinationList().size(); l++) {
					// Oltások fejléce
					if (l == 0) {
						for (int i = 0; i < headerVacc.length; i++) {
							cell = row.createCell(i);
							cell.setCellValue(headerVacc[i]);
							cell.setCellStyle(headerCellStylePet);
						}
						row = sheet.createRow(++rowNum);
					}
					// Oltások adatai:
					row.createCell(0)
							.setCellValue(owner.get(j).getPetList().get(k).getVaccinationList().get(l).getCause());
					row.createCell(1)
							.setCellValue(owner.get(j).getPetList().get(k).getVaccinationList().get(l).getDate());
					row.createCell(2)
							.setCellValue(owner.get(j).getPetList().get(k).getVaccinationList().get(l).getValid());
					row = sheet.createRow(++rowNum);
				}
			}
			row = sheet.createRow(rowNum += 2);
		}

		for (int i = 0; i < headerOwner.length; i++) {
			sheet.autoSizeColumn(i);
		}

		try {
			FileOutputStream fos = new FileOutputStream("DataExport.xlsx");
			wb.write(fos);
			fos.close();
			wb.close();
			System.out.println("adatok mentve: ./dataExport.xlsx");
		}

		catch (Exception e) {
			System.out.println("Hiba a fájl írása közben");
		}
	}
}
