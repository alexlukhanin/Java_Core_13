/**
 * The homework on "Java Core" Course in LOGOS IT Academy
 * Lesson 13
 * 
 * *
 */

package ua.lviv.lgs.hw13;

/**
 * *
 * Console application with exception
 * @author alexl
 * 
 * @version 1.0
 *
 */

public class InputMenuString {
	/*This class checks menu input from user and assigns value of string, when it's correct*/
	boolean flag = false;
	private String string;
	Menu2 menu2 = new Menu2();

	public InputMenuString(String string) {
		super();
		
		if ((string.hashCode() >= 49 && string.hashCode() <= 57) || string.equals("q") || string.equals("menu") ) {
			this.string = string;
			flag = true;
			
			
		} else {
			
			try {
				throw new WrongInputConsoleParametersException("Wrong choise, try again[1-9]...");
			} catch (WrongInputConsoleParametersException e) {
				System.out.println(e.getMessage());
				menu2.printMenu();
				flag = false;
			}
			
		}
		
	}

	public String getString() {
		return string;
	}

	
	
	
	
}
