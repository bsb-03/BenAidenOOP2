package a2.middleearthcouncil;
import a2.charactermanager.*;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	private static CharacterManager manager;
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null)
			instance = new MiddleEarthCouncil();
		return instance;
	}
	
	public MiddleEarthCouncil() {
		manager = new CharacterManager();
	}
	
	public static CharacterManager getCharacterManager() {
		return manager;
	}
}
