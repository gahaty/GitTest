package com.citec;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.citec.repository.Repository;

public class Main {

	public static void main(String[] args) throws Exception {

		final Repository repo = new Repository();

		Scanner sc = null;
		int statusMain = 0;
		int statusSub1 = -1;
		int statusSub2 = -1;
		int statusSub3 = -1;

		while (statusMain != 5) {
			sc = new Scanner(System.in);
			System.out.println("\n\n################### MENU #####################");
			System.out.println("1. Kisallat felvitele");
			System.out.println("2. Kereses");
			System.out.println("3. Oltas");
			System.out.println("4. Export");
			System.out.println("5. Kilepes");
			try {
			statusMain = sc.nextInt();

			} catch (InputMismatchException e) {
				System.err.println("Nem jó karaktert adtál meg! (1. - 5.)");
				continue;
			}
			
			switch (statusMain) {

			case 1:
				System.out.println("############# KISALLAT FELVITELE ###############");
				System.out.println("1. Meglevo gazdahoz");
				System.out.println("2. Uj gazdival");
				sc = new Scanner(System.in);
				try {
				statusSub1 = sc.nextInt();
				switch (statusSub1) {
				case 1:
					repo.puppyForOwner();
					break;
				case 2:
					repo.newOwnerAdd();
					break;
				}
				statusSub1 = -1;
				break;
				} catch (InputMismatchException e) {
					System.err.println("Nem jó karaktert adtál meg! (1. - 2.)");
					continue;
				}
			case 2:
				System.out.println("################### KERESES #####################");
				System.out.println("1. Gazdi alapjan");
				System.out.println("2. Kisallat alapjan");

				sc = new Scanner(System.in);
				try {
				statusSub2 = sc.nextInt();
				switch (statusSub2) {
				case 1:
					repo.findByOwner();
					break;
				case 2:
					repo.findByPet();
					break;
				}
				statusSub2 = -1;
				break;
				} catch (InputMismatchException e) {
					System.err.println("Nem jó karaktert adtál meg! (1. - 2.)");
					continue;
				}
			case 3:
				System.out.println("################### OLTAS #####################");
				System.out.println("1. Uj oltas beadasa");
				System.out.println("2. Kisallat oltasainak listazasa");

				sc = new Scanner(System.in);
				try {
				statusSub3 = sc.nextInt();
				switch (statusSub3) {
				case 1:
					repo.vacc();
					break;
				case 2:
					repo.vaccList();
					break;
				}
				statusSub3 = -1;
				break;
				} catch (InputMismatchException e) {
					System.err.println("Nem jó karaktert adtál meg! (1. - 2.)");
					continue;
				}
			case 4:
				repo.export();
				repo.exportToExcel();
				break;
			case 5:
				System.out.println("Program vege.");
				break;
			}
		}
	}
}
