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
 * * Console application with exception
 * 
 * @author alexl
 * 
 * @version 1.0
 *
 */


public class Fraction {

	private final int MIN_DEPUTY_AGE = 25;
	
	private String name;
	private List<Deputy> list = new ArrayList<Deputy>();

	/* the constructor that construct class Fraction only by its name */
	public Fraction(String name) {
		super();
		this.name = name;
	}

	/*
	 * this constructor makes possibility to add a list of deputies during
	 * construction of the class Fraction
	 */
	public Fraction(String name, List<Deputy> list) {
		super();
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Deputy> getList() {
		return list;
	}

	public void setList(List<Deputy> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Fraction [name=" + name + ", list=" + list + "]";
	}

	/* Declarations of methods: */

	/* AddDeputy declaration ...================================================ */
	public void addDeputy() {
		String familyName = "";
		String firstName = "";
		int age = 0;
		boolean isBriber = false; // default value, we hope for better
		int amountOfBribe = 0; // default amount = 0
		int weight = 0;
		int height = 0;

		Scanner sc; // creation of console scanner
		System.out.println("Adding the new deputy in the fraction...");
		System.out.println("Add first name:");
		sc = new Scanner(System.in); // input from user

		if (sc.hasNext()) {
			firstName = sc.next();
		}

		System.out.println("Add family name:");
		sc = new Scanner(System.in); // input from user

		if (sc.hasNext()) {
			familyName = sc.next();
		}

		/* Add age block ------------------------------------------------------ */
		while (true) {
			System.out.println("Add age (integer value >= " + MIN_DEPUTY_AGE + " ):");
			sc = new Scanner(System.in); // input from user
			int number;
			if (sc.hasNextInt()) {
				number = sc.nextInt();

				if (number >= MIN_DEPUTY_AGE) {
					age = number;
					break;
				} else {
					try {
						throw new WrongInputConsoleParametersException("Value must be correct(age), try again...");
					} catch (WrongInputConsoleParametersException e) {
						System.out.println(e.getMessage());
					}
				}

			} else {
				try {
					throw new WrongInputConsoleParametersException("Input integer value, try again...");
				} catch (WrongInputConsoleParametersException e) {
					System.out.println(e.getMessage());
				}
			}
			//sc.close(); // close the terminal/console session
		}

		/* Add weight block ----------------------------------------------- */

		while (true) {
			System.out.println("Add weight (integer value >0):");
			sc = new Scanner(System.in); // input from user
			int number;
			if (sc.hasNextInt()) {
				number = sc.nextInt();

				if (number > 0) {
					weight = number;
					break;
				} else {
					try {
						throw new WrongInputConsoleParametersException("Value must be >0, try again...");
					} catch (WrongInputConsoleParametersException e) {
						System.out.println(e.getMessage());
					}
				}

			} else {
				try {
					throw new WrongInputConsoleParametersException("Input integer value, try again...");
				} catch (WrongInputConsoleParametersException e) {
					System.out.println(e.getMessage());
				}
			}
			//sc.close(); // close the terminal/console session
		}

		/* Add height block -------------------------------------------------- */

		while (true) {
			System.out.println("Add height (integer value >0):");
			sc = new Scanner(System.in); // input from user
			int number;
			if (sc.hasNextInt()) {
				number = sc.nextInt();

				if (number > 0) {
					height = number;
					break;
				} else {
					try {
						throw new WrongInputConsoleParametersException("Value must be >0, try again...");
					} catch (WrongInputConsoleParametersException e) {
						System.out.println(e.getMessage());
					}
				}

			} else {
				try {
					throw new WrongInputConsoleParametersException("Input integer value, try again...");
				} catch (WrongInputConsoleParametersException e) {
					System.out.println(e.getMessage());
				}
			}
			//sc.close(); // close the terminal/console session
		}

		/* Add "isBriber" block ------------------------------------------------ */
		String string;

		while (true) {
			System.out.println("Is the deputy a briber? (y/n):");
			sc = new Scanner(System.in); // input from user
			if (sc.hasNext()) {
				InputYesNoString inputYesNoString = new InputYesNoString(sc.next().toLowerCase());
				string = inputYesNoString.getString();

				if (inputYesNoString.flag) {
					if (string.equals("y")) {
						isBriber = true;
					} else {
						isBriber = false;
					}
					break;
				}

			}
		}

		/* deputy creation and initialization */
		Deputy deputy = new Deputy(weight, height, familyName, firstName, age, isBriber);
		list.add(deputy);

		/* -------------- */
		list.get(list.size() - 1).giveBribe();

	}

	/*
	 * deleteDeputy() declaration block ============================================
	 */

	@SuppressWarnings("resource")
	public void deleteDeputy() {
		String familyName = "";
		String firstName = "";
		Scanner sc;
		System.out.println("Delete the deputy...");

		while (true) {
			System.out.println("Input the first name of deputy:");
			sc = new Scanner(System.in);

			if (sc.hasNext()) {
				firstName = sc.next();
				break;
			}

		}

		while (true) {
			System.out.println("Input the family name of deputy:");
			sc = new Scanner(System.in);

			if (sc.hasNext()) {
				familyName = sc.next();

				break;
			}

		}

		Iterator<Deputy> iterator = list.iterator();

		while (iterator.hasNext()) {
			Deputy deputy = (Deputy) iterator.next();

			if (deputy.getFirstName().equalsIgnoreCase(firstName)
					&& deputy.getFamilyName().equalsIgnoreCase(familyName)) {
				System.out.println(deputy.toString() + " was deleted");
				iterator.remove();
			}

		}

	}

	/*
	 * showAllBribers() declaration
	 * ==================================================
	 */

	public void showAllBribers() {
		System.out.println("List of all bribers in the fraction:");
		Iterator<Deputy> iterator = list.iterator();

		while (iterator.hasNext()) {
			Deputy deputy = (Deputy) iterator.next();

			if (deputy.isBriber()) {
				System.out.println(deputy);
			}

		}
	}

	/* showMostBriber() declaration ======================================= */

	public void showMostBriber() {

		System.out.println("Most briber in the fraction is ... ");
		Iterator<Deputy> iterator = list.iterator();
		int temp = 0;
		int index = 0;
		int max = 0; // index of max amount

		while (iterator.hasNext()) {
			Deputy deputy = (Deputy) iterator.next();

			if (deputy.getAmountOfBribe() > temp) {
				temp = deputy.getAmountOfBribe();
				max = index;
			}
			index++;
		}

		System.out.println(list.get(max).toString());

	}

	/* showAllDeputies() declaration =================================== */
	public void showAllDeputies() {
		System.out.println("List of all deputies in the fraction:");
		Iterator<Deputy> iterator = list.iterator();

		while (iterator.hasNext()) {
			Deputy deputy = (Deputy) iterator.next();

			System.out.println(deputy);

		}
	}

	/* clearFraction() declaration =================================== */
	public void clearFraction() {
		list.clear();
	}

}
