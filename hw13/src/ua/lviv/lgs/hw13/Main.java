/**
 * The homework on "Java Core" Course in LOGOS IT Academy
 * Lesson 13
 * 
 * *
 */


package ua.lviv.lgs.hw13;

/**
 * * Console application with exception
 * 
 * @author alexl
 * 
 * @version 1.0
 *
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();
		Menu2 menu2 = new Menu2();
		String menuString;
		Scanner sc;
		menu.printMenu();
		menu2.printMenu();

		while (true) {
			
			/* checking of menuString from the user */
			sc = new Scanner(System.in);
			InputMenuString inputMenuString = new InputMenuString(sc.next().toLowerCase());

			menuString = inputMenuString.getString();

			if (inputMenuString.flag) {
				switch (menuString) {
				case "1": {
					Parliament.getInstance().addFraction();
					break;

				}

				case "2": {
					Parliament.getInstance().deleteFraction();
					break;

				}

				case "3": {
					Parliament.getInstance().showAllFractions();
					break;

				}

				case "4": {
					Parliament.getInstance().clearFraction();
					break;

				}

				case "5": {
					Parliament.getInstance().showFraction();
					break;

				}

				case "6": {
					Parliament.getInstance().addDeputyToFraction();
					break;

				}

				case "7": {
					Parliament.getInstance().deleteDeputyFromFraction();
					break;

				}

				case "8": {
					Parliament.getInstance().showAllBribersInFraction();
					break;

				}

				case "9": {
					Parliament.getInstance().showMostBriberInFraction();
					break;

				}

				case "menu": {

					menu.printMenu();
					break;
				}


				case "q": {

					System.out.println("Exit application... Good buy!");
					System.exit(0);
					sc.close();
				}

				}
				menu2.printMenu();
			}
		}

	}

}
