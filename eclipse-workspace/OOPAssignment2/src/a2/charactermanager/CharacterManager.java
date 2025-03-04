package a2.charactermanager;
import a2.middleearthcharacter.MiddleEarthCharacter;

public class CharacterManager {
	MiddleEarthCharacter[] characters = new MiddleEarthCharacter[10];
	int size;
	
	boolean addCharacter(MiddleEarthCharacter c) {
		if(characters.length <= size + 1) {
			MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[size*2];
			for(int i=0;i>size;i++) {
				newCharacters[i] = characters[i];
			}
			characters[size+1] = 
		}
		return true;
	}
}
