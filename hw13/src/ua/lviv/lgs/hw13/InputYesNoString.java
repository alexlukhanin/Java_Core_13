/**
 * The homework on "Java Core" Course in LOGOS IT Academy
 * Lesson 09 - Exceptions, Java code convention
 * part 01 - based on lesson 08's homework
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

public class InputYesNoString {
	/*This class checks  input from user and assigns value of string, when it's correct*/
	boolean flag = false;
	private String string;
	

	public InputYesNoString(String string) {
		super();
		
		if ( string.equals("N")|| string.equals("y") || string.equals("Y") || string.equals("n") ) {
			this.string = string;
			flag = true;
			
			
		} else {
			
			try {
				throw new WrongInputConsoleParametersException("Wrong parameter, try again...");
			} catch (WrongInputConsoleParametersException e) {
				System.out.println(e.getMessage());
				flag = false;
			}
			
		}
		
	}

	public String getString() {
		return string;
	}

	
	
	
	
}
