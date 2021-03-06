/**
 * The homework on "Java Core" Course in LOGOS IT Academy
 * Lesson 13
 * 
 * *
 */
package ua.lviv.lgs.hw13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author alexl
 *
 */

/** Singleton class Parliament declaration */
public class Parliament {
	/* Singleton pattern realisation */
	private static Parliament instance;

	private Parliament() {
	};

	public static Parliament getInstance() {
		if (instance == null) {
			instance = new Parliament();
		}
		return instance;
	}

	/* list of fractions */

	List<Fraction> list = new ArrayList<Fraction>();

	/* Methods declaration block: ==================== */

	/** the additional private method to check input of fraction from console */
	private Fraction checkInputFraction(String string) {
		Fraction fractionReturn = new Fraction(null);
		System.out.println(string);
		showAllFractions();
		boolean flag = false;

		while (true) {

			/* input from user */
			Scanner sc = new Scanner(System.in);
			String fractionName = "";
			if (sc.hasNext()) {
				fractionName = sc.next();
			}

			if (list.size() > 0) {

				Iterator<Fraction> iterator = list.iterator();
				while (iterator.hasNext()) {
					Fraction fraction = (Fraction) iterator.next();
					if (fraction.getName().toString().equalsIgnoreCase(fractionName)) {

						fractionReturn = fraction;
						flag = true;

					}

				}

			} else if (list.size() == 0) {
				System.out.println("There are no fractions at all yet...");
				break;
			} else {
				/* just in case :) */
				System.out.println("Number of fractions can not be negative, there is some error in here...");
				break;
			}

			if (!flag) {
				System.out.println("There is not the fraction with the name You input, try again");
			} else {
				break;
			}
		}

		return fractionReturn;

	}

	/* addFraction method adds new fraction to Parliament */
	public void addFraction() {

		System.out.println("Please, input the name of new fraction:");
		Scanner sc = new Scanner(System.in);
		String fractionName = "";
		if (sc.hasNext()) {
			fractionName = sc.next();
		}

		Fraction fraction = new Fraction(fractionName);

		list.add(fraction);
		System.out.println("Fraction " + fraction.toString() + " added to Parliament");
	}

	/*
	 * deleteFraction() asks user to choose name of fraction from the list (that it
	 * prints) and then checks input from user. If name is incorrect, user have to
	 * try until he/she will input correct one. To print the list of fractions it
	 * uses method showAllFractions()
	 */
	public void deleteFraction() {

		System.out.println("Please, input the name of fraction to delete(choose from the list):");
		showAllFractions();
		boolean flag = false;

		while (true) {

			/* input from user */
			Scanner sc = new Scanner(System.in);
			String fractionName = "";
			if (sc.hasNext()) {
				fractionName = sc.next();
			}

			if (list.size() > 0) {

				Iterator<Fraction> iterator = list.iterator();
				while (iterator.hasNext()) {
					Fraction fraction = (Fraction) iterator.next();
					if (fraction.getName().toString().equalsIgnoreCase(fractionName)) {
						System.out.println("Fraction " + fraction.getName().toString() + 
								" has been deleted" + " from Parliament.");
						iterator.remove();
						flag = true;
					}
				}
			} else if (list.size() == 0) {
				System.out.println("There are no fractions at all yet...");
				break;
			} else {
				/* just in case :) */
				System.out.println("Number of fractions can not be negative, there is some error in here...");
				break;
			}

			if (!flag) {
				System.out.println("There is not the fraction with the name You input, try again");
			} else {
				break;
			}

		}

	}

	/* just list names of all fractions */
	public void showAllFractions() {

		Iterator<Fraction> iterator = list.iterator();
		while (iterator.hasNext()) {
			Fraction fraction = (Fraction) iterator.next();
			System.out.println("[" + fraction.getName().toString() + "]");

		}
	}

	public void showFraction() {

		Fraction fraction = checkInputFraction("Please choose fraction name to show all fraction");

		System.out.println("Fraction " + fraction.getName().toString() + ":");
		System.out.println(fraction.toString());

	}

	public void addDeputyToFraction() {

		Fraction fraction = checkInputFraction("Please choose fraction name (from list below) to add deputy in");
		fraction.addDeputy();

	}

	public void deleteDeputyFromFraction() {

		Fraction fraction = checkInputFraction("Please choose fraction name (from list below) to delete deputy from");
		fraction.deleteDeputy();
	}

	public void showAllBribersInFraction() {

		Fraction fraction = checkInputFraction(
				"Please choose fraction name (from list below) to show all bribers in it");
		fraction.showAllBribers();
	}

	public void showMostBriberInFraction() {

		Fraction fraction = checkInputFraction(
				"Please choose fraction name (from list below) to show most briber in it");
		fraction.showMostBriber();
	}

	public void showAllDeputiesInFraction() {

		Fraction fraction = checkInputFraction(
				"Please choose fraction name (from list below) to show all deputies in it");
		fraction.showAllDeputies();
	}

	public void clearFraction() {

		Fraction fraction = checkInputFraction("Please choose fraction name (from list below) to clear");
		fraction.clearFraction();
	}

}
