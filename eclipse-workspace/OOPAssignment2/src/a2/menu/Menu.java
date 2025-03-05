package a2.menu;
import a2.charactermanager.*;
import a2.middleearthcharacter.*;
import a2.middleearthcouncil.*;
import java.util.Scanner;

public class Menu {
	public static void newCharMenu(Scanner s) {
		String uName, uRace;
		double uHealth, uPower;
		
		System.out.println("Enter your character's name: ");
		uName = s.nextLine();
		
		System.out.println("Enter your character's race (Elf, Dwarf, Human, Orc, Wizard): ");
		uRace = s.nextLine();
		
		System.out.println("Enter your character's health: ");
		uHealth = Double.parseDouble(s.nextLine());
		
		System.out.println("Enter your character's power: ");
		uPower = Double.parseDouble(s.nextLine());
		
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
					//viewChars();
					break;
				case 3:
					//updateChar();
					break;
				case 4:
					//deleteChar();
					break;
				case 5:
					//execAttackActions();
					break;
				case 6:
					exitFlag = true;
					break
			}
		}
	}
}
