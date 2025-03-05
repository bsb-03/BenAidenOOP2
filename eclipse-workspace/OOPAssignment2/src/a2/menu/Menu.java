package a2.menu;
import a2.charactermanager.*;
import a2.middleearthcharacter.*;
import a2.middleearthcouncil.*;
import java.util.Scanner;

public class Menu {
	
	public static void printMenu() {
		System.out.println("---MENU---\n");
		
		System.out.println(	"1. Add new character\n"
							+ "2. View all characters\n"
							+ "3. Update a character\n"
							+ "4. Delete a character\n"
							+ "5. Execute all attack actions\n"
							+ "6. Exit");
	}

	public static void main(String[] args) {
		boolean exitFlag = false;
		int userChoice = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(!exitFlag) {
			printMenu();
			
			System.out.println(">>> ");
			userChoice = Integer.parseInt(scanner.nextLine());
			
			if(userChoice == 6) {
				exitFlag = true;
			}
		}
	}
}
