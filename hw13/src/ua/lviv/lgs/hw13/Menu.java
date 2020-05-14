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

public class Menu {
	/* This class prints menu of the application to console */

	public Menu() {
		super();

	}

	public void printMenu() {
		System.out.println(
				"| -----------------------Menu------------------------|");
		System.out.println(
				"| Input 1 to add fraction                            |");
		System.out.println(
				"| Input 2 to delete chosen fraction                  |");
		System.out.println(
				"| Input 3 to show all fractions                      |");
		System.out.println(
				"| Input 4 to clear chosen fraction                   |");
		System.out.println(
				"| Input 5 to show chosen fraction                    |");
		System.out.println(
				"| Input 6 to add deputy to chosen fraction           |");
		System.out.println(
				"| Input 7 to delete deputy from chosen fraction      |");
		System.out.println(
				"| Input 8 to show all bribers in chosen fraction     |");
		System.out.println(
				"| Input 9 to show a most briber in chosen fraction   |");

	}

}
