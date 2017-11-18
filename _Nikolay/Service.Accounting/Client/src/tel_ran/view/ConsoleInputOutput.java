package tel_ran.view;

import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput{
	
	private Scanner scanner = new Scanner(System.in);;
	
	public String getString(String prompt) {
		System.out.println(prompt);
		return scanner.nextLine();
	}
	
	public void put(Object object) {
		System.out.println(object);
	}
	
}
