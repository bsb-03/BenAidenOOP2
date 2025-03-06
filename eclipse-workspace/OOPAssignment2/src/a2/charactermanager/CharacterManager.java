package a2.charactermanager;
import java.util.Objects;

import a2.middleearthcharacter.*;

public class CharacterManager {
	MiddleEarthCharacter[] characters = new MiddleEarthCharacter[10];
	int size = 0;
	
	/**
	 * addCharacter method to add character objects to the array of characters.
	 * @param c - character object to be added to the array
	 * @return true if successful
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(characters.length == size) {
			MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[size*2];
			for(int i=0;i<size;i++) {
				newCharacters[i] = characters[i];
			}
			newCharacters[size] = c;
			characters = newCharacters;
			size++;
			return true;
		}
		characters[size] = c;
		size++;
		return true;
	}
	
	/**
	 * getCharacter method - searches the array for a character (by name) and returns 
	 * the matching character object from the array, if found.
	 * @param name - name of the character object to search for within the array
	 * @return - the character object if it is found, null if it is not
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i=0;i<size;i++) {
			if(Objects.equals(characters[i].getName(), name)) {
				MiddleEarthCharacter character = characters[i];
				return character;
			}
		}
		return null;
	}

	/**
	 * updateCharacter method - Searches for a character object in the array of characters. If a matching
	 * character object is found, then it has the name, health, and power attributes modified.
	 * @param character - character object to search for within the array
	 * @param name - new name for the character object
	 * @param health - new health value for the character object
	 * @param power - new power value for the character object
	 * @return - return true if attribute update is successful, false if not
	 */
	public boolean updateCharacter (MiddleEarthCharacter character, String name, double health, double power) {
		for(int i=0;i<size;i++) {
			if(characters[i] == character) {
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * deleteCharacter method - searches the character array for a matching character object.
	 * If it is found, the character object is then overwritten by the following character object
	 * by position within the array. This process is repeated until the end of the array is found,
	 * where then the duplicate character object is overwritten with null.
	 * @param character - The character object to search for and subsequently delete.
	 * @return - true if deletion is successful, false if unsuccessful
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		for(int i=0;i<size;i++) {
			if(characters[i] == character) {
				for(int x=i;x<size-1;x++) {
					characters[x] = characters[x+1];
				}
				characters[size] = null;
				size--;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * displayAllCharacter method - iterates through the characters array and displays the information from each character
	 * object that is populating the array.
	 */
	public void displayAllCharacters() {
		try {
			for(int i = 0; i < size; i++) {
				characters[i].displayInfo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
