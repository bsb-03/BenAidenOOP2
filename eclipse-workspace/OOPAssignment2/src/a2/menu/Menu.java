package a2.menu;
import a2.charactermanager.*;
import a2.middleearthcharacter.*;
import a2.middleearthcouncil.*;

public class Menu {

	public static void main(String[] args) {
		System.out.println("---TESTING---");
		
		CharacterManager manager = new CharacterManager();
		
		Elf myElf = new Elf();
		myElf.setHealth(1000);
		myElf.setPower(20);
		myElf.setName("Elfo");
		
		Dwarf myDwarf = new Dwarf();
		myDwarf.setHealth(1500);
		myDwarf.setPower(15);
		myDwarf.setName("Dwarfo");
		
		//myElf.displayInfo();
		
		manager.addCharacter(myElf);
		manager.addCharacter(myDwarf);
		
		manager.displayAllCharacters();
	}
}
