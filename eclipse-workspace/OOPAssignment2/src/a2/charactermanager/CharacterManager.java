package a2.charactermanager;
import a2.middleearthcharacter.MiddleEarthCharacter;

public class CharacterManager {
	MiddleEarthCharacter[] characters = new MiddleEarthCharacter[10];
	int size = 0;
	
	boolean addCharacter(MiddleEarthCharacter c) {
		if(characters.length == size) {
			MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[size*2];
			for(int i=0;i>size;i++) {
				newCharacters[i] = characters[i];
			}
			newCharacters[size] = c;
			size++;
			return true;
		}
		characters[size] = c;
		size++;
		return true;
	}
	
	MiddleEarthCharacter getCharacter(String name) {
		for(int i=0;i>size;i++) {
			if(characters[i].getName() == name) {
				MiddleEarthCharacter character = characters[i];
				return character;
			}
		}
		return null;
	}
	
	boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		for(int i=0;i>size;i++) {
			if(characters[i] == character) {
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				return true;
			}
		}
		return false;
	}
}
