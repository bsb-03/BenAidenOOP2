package a2.menu;
import a2.charactermanager.*;
import a2.middleearthcharacter.*;
import a2.middleearthcouncil.*;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
	public static void newCharMenu(Scanner s) {
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
			uHealth = Double.parseDouble(s.nextLine());
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
			uPower = Double.parseDouble(s.nextLine());
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
	
	public static void viewChars(Scanner s) {
		(MiddleEarthCouncil.getCharacterManager()).displayAllCharacters();
		System.out.println("Enter anything to continue:");
		s.nextLine();
	}

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
			uHealth = Double.parseDouble(s.nextLine());
			if(uHealth < 0.0) {
				System.out.println("Please enter a positive number.");
			}
			else {
				flag = true;
			}
		}
		flag = false;
		
		while(!flag) {
			System.out.println("What would you like the new power to be?");
			uPower = Double.parseDouble(s.nextLine());
			if(uPower < 0.0) {
				System.out.println("Please enter a positive number.");
			}
			else {
				flag = true;
			}
		}
		flag = false;
		
		MiddleEarthCouncil.getCharacterManager().updateCharacter(charToUpdate, uName, uHealth, uPower);
	}
	
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
		
		MiddleEarthCouncil.getInstance(); // init council
		
		while(!exitFlag) {
			printMenu();
			
			System.out.println(">>> ");
			userChoice = Integer.parseInt(scanner.nextLine());
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
					//execAttackActions();
					break;
				case 6:
					exitFlag = true;
					break;
			}
		}
		
		scanner.close();
	}
}
