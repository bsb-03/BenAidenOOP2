package a2.middleearthcouncil;
import a2.charactermanager.*;

class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	
	private CharacterManager manager;
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null)
			instance = new MiddleEarthCouncil();
		return instance;
	}
	
	public MiddleEarthCouncil() {
		manager = new CharacterManager();
	}
	
	public CharacterManager getCharacterManager() {
		return this.manager;
	}
}
