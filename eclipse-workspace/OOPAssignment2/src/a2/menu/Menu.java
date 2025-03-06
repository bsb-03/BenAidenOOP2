package a2.menu;
import a2.middleearthcharacter.*;
import a2.middleearthcouncil.*;
import java.util.Objects;
import java.util.Scanner;
// GITHUB - https://github.com/bsb-03/BenAidenOOP2
/**
 * Menu class - Menu-driven interface which allows the user to interact with the character array. The user may 
 * add, delete, update, execute attacks, and view all characters within the array.
 */
public class Menu {
	/**
	 * newCharMenu method to prompt the user for information about the character object they wish to create and subsequently
	 * add to the character array. The user must input a character name, race, HP value, and a power value. Duplicate character
	 * names are not allowed, nor are negative values within the HP and power fields. The user must enter a valid race and the
	 * character name cannot be blank.
	 * @param s - Scanner parameter
	 */
	public static void newCharMenu(Scanner s) {
		// fields to be populated by user input
		String uName = null, uRace = null;
		double uHealth = 0, uPower = 0.0;
		boolean flag = false;
		// prompt the user for a character name and check if it is null or a duplicate.
		while(!flag) {
			System.out.println("Enter your character's name: ");
			uName = s.nextLine();
			if(uName != null && !Objects.equals(uName, "") && MiddleEarthCouncil.getCharacterManager().getCharacter(uName) == null) {
				flag = true;
			}
			else {
				System.out.println("Please enter a valid, non-duplicate name.");
			}
		}
		flag = false;
		// prompt the user to enter a race for the character, and throw an error if an invalid race is entered.
		while(!flag) {
			System.out.println("Enter your character's race (Elf, Dwarf, Human, Orc, Wizard): ");
			uRace = s.nextLine();
			System.out.println(uRace);
			if(Objects.equals(uRace, "Elf") || Objects.equals(uRace, "Dwarf") || Objects.equals(uRace, "Human") || Objects.equals(uRace, "Orc") || Objects.equals(uRace, "Wizard")) {
				flag = true;
			}
			else {
				System.out.println("Please enter a valid race.");
			}
		}
		flag = false;
		// prompt the user to enter a health value, which must be positive
		while(!flag) {
			System.out.println("Enter your character's health: ");
			try {
				uHealth = Double.parseDouble(s.nextLine());
			}
			catch (NumberFormatException ex) {
				System.out.println(uHealth + " is not a valid value!");
				continue;
			}	
			if(uHealth < 0.0) {
				System.out.println("Please enter a positive number.");
			}
			else {
				flag = true;
			}
		}
		flag = false;
		//prompt the user to enter a power value, which must be positive
		while(!flag) {
			System.out.println("Enter your character's power: ");
			try {
				uPower = Double.parseDouble(s.nextLine());
			}
			catch (NumberFormatException ex) {
				System.out.println(uPower + " is not a valid value!");
				continue;
			}
			
			if(uPower < 0.0) {
				System.out.println("Please enter a positive number.");
			}
			else {
				flag = true;
			}
		}
		// switch case to create a new character object depending on the race chosen
		switch(uRace) {
			case "Elf":
				Elf newElf = new Elf();
				newElf.setName(uName);
				newElf.setPower(uPower);
				newElf.setHealth(uHealth);
				
				(MiddleEarthCouncil.getCharacterManager()).addCharacter(newElf);
				break;
			case "Dwarf":
				Dwarf newDwarf = new Dwarf();
				newDwarf.setName(uName);
				newDwarf.setPower(uPower);
				newDwarf.setHealth(uHealth);
				
				(MiddleEarthCouncil.getCharacterManager()).addCharacter(newDwarf);
				break;
			case "Human":
				Human newHum = new Human();
				newHum.setName(uName);
				newHum.setPower(uPower);
				newHum.setHealth(uHealth);
				
				(MiddleEarthCouncil.getCharacterManager()).addCharacter(newHum);
				break;
			case "Orc":
				Orc newOrc = new Orc();
				newOrc.setName(uName);
				newOrc.setPower(uPower);
				newOrc.setHealth(uHealth);
				
				(MiddleEarthCouncil.getCharacterManager()).addCharacter(newOrc);
				break;
			case "Wizard":
				Wizard newWiz = new Wizard();
				newWiz.setName(uName);
				newWiz.setPower(uPower);
				newWiz.setHealth(uHealth);
				
				(MiddleEarthCouncil.getCharacterManager()).addCharacter(newWiz);
				break;
		}
	}
	/**
	 * viewChars method to display all characters within the characters array. Calls the displayAllCharacters() method
	 * from the CharacterManager class.
	 * @param s - Scanner parameter
	 */
	public static void viewChars(Scanner s) {
		(MiddleEarthCouncil.getCharacterManager()).displayAllCharacters();
		System.out.println("Enter anything to continue:");
		s.nextLine();
	}
	
	/**
	 * updateChar method to update character objects within the character array. This method will prompt the user to enter a 
	 * character name, which will then be passed to the getCharacter() method from the CharacterManager class. If a matching 
	 * character is found within the array, the user is then prompted to enter a valid name, HP value, and power value. Those 
	 * values will then be set to populate the respective fields within the character object.
	 * @param s - Scanner parameter
	 */
	public static void updateChar(Scanner s) {
		MiddleEarthCharacter charToUpdate = null;
		String uInput;
		String uName = null;
		Double uHealth = null, uPower = null;
		boolean flag = false;
		while(!flag) {
			// get the name of the character to update and check if it really exists
			System.out.println("What is the name of the character you want to update?:");
			uInput = s.nextLine();
			charToUpdate = MiddleEarthCouncil.getCharacterManager().getCharacter(uInput);
			if(charToUpdate != null) {
				flag = true;
			}
			else {
				System.out.println("This character does not exist!");
			}
		}
		flag = false;
		// set the new name and check for errors/duplicates
		while(!flag) {
			System.out.println("What would you like the new name to be?");
			uName = s.nextLine();
			if(uName != null && !Objects.equals(uName, "") && MiddleEarthCouncil.getCharacterManager().getCharacter(uName) == null) {
				flag = true;
			}
			else {
				System.out.println("Please enter a valid, non-duplicate name.");
			}
		}
		flag = false;
		// set the new health and make sure it is a positive value
		while(!flag) {
			System.out.println("What would you like the new health to be?: ");
			try {
				uHealth = Double.parseDouble(s.nextLine());
			}
			catch (NumberFormatException ex) {
				System.out.println(uHealth + " is not a valid value!");
				continue;
			}
			if(uHealth < 0.0) {
				System.out.println("Please enter a positive number.");
			}
			else {
				flag = true;
			}
		}
		flag = false;
		// set the new power and make sure it is a positive value
		while(!flag) {
			System.out.println("What would you like the new power to be?");
			try {
				uPower = Double.parseDouble(s.nextLine());
			}
			catch (NumberFormatException ex) {
				System.out.println(uPower + " is not a valid value!");
				continue;
			}
			if(uPower < 0.0) {
				System.out.println("Please enter a positive number.");
			}
			else {
				flag = true;
			}
		}
		flag = false;
		//call updateCharacter() method and pass user input as parameters
		MiddleEarthCouncil.getCharacterManager().updateCharacter(charToUpdate, uName, uHealth, uPower);
	}
	
	/**
	 * deleteChar method to delete a character object within the character array. The method will prompt the user
	 * for a character name which will then be passed to the getCharacter() method. If a matching character is found, it
	 * will be deleted.
	 * @param s - Scanner parameter
	 */
	public static void deleteChar(Scanner s) {
		MiddleEarthCharacter charToUpdate = null;
		String uInput;
		boolean flag = false;
		while(!flag) {
			System.out.println("What is the name of the character you want to delete?:");
			uInput = s.nextLine();
			charToUpdate = MiddleEarthCouncil.getCharacterManager().getCharacter(uInput);
			if(charToUpdate != null) {
				flag = true;
			}
			else {
				System.out.println("This character does not exist!");
			}
		}
		
		MiddleEarthCouncil.getCharacterManager().deleteCharacter(charToUpdate);
	}
	
	/**
	 * execAttackActions method to execute attack actions between character objects. The method will prompt the user for 
	 * a character name to attack with, then a character name to defend with. If both characters are valid, then the
	 * attack will be attempted, and the output will depend on whether or not it was successful.
	 * @param s - Scanner parameter
	 */
	public static void execAttackActions(Scanner s) {
		MiddleEarthCharacter charToAttack = null;
		String uInput;
		boolean flag = false;
		while(!flag) {
			System.out.println("What is the name of the character you want to attack with?:");
			uInput = s.nextLine();
			charToAttack = MiddleEarthCouncil.getCharacterManager().getCharacter(uInput);
			if(charToAttack != null) {
				flag = true;
			}
			else {
				System.out.println("This character does not exist!");
			}
		}
		
		MiddleEarthCharacter charToDefend = null;
		flag = false;
		while(!flag) {
			System.out.println("What is the name of the character you want to defend?:");
			uInput = s.nextLine();
			charToDefend = MiddleEarthCouncil.getCharacterManager().getCharacter(uInput);
			if(charToDefend != null) {
				flag = true;
			}
			else {
				System.out.println("This character does not exist!");
			}
		}
		
		if(!(charToAttack.attack(charToDefend))) {
			System.out.println("The attack was ineffective!");
		}
		
		else {
			System.out.println("The attack was successful!");
		}
	}
	
	/**
	 * printMenu method to print initial menu prompts upon running the program. The user will be prompted to add a new
	 * character, update a character, delete a character, execute attack actions, or exit the program. 
	 */
	public static void printMenu() {
		System.out.println("---MENU---\n");
		
		System.out.println(	"1. Add new character\n"
							+ "2. View all characters\n"
							+ "3. Update a character\n"
							+ "4. Delete a character\n"
							+ "5. Execute all attack actions\n"
							+ "6. Exit");
	}
	
	/**
	 * main method to run the printMenu() function until the user exits the program.
	 * @param args
	 */
	public static void main(String[] args) {
		boolean exitFlag = false;
		int userChoice = 0;
		Scanner scanner = new Scanner(System.in);
		
		MiddleEarthCouncil.getInstance(); // init council
		
		while(!exitFlag) {
			printMenu();
			
			System.out.println(">>> ");
			try {
				userChoice = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException ex) {
				System.out.println(userChoice + " is not a valid choice!");
				continue;
			}
			switch(userChoice) {
				case 1: 
					newCharMenu(scanner);
					break;
				case 2:
					viewChars(scanner);
					break;
				case 3:
					updateChar(scanner);
					break;
				case 4:
					deleteChar(scanner);
					break;
				case 5:
					execAttackActions(scanner);
					break;
				case 6:
					exitFlag = true;
					break;
			}
		}
		
		scanner.close();
	}
}
